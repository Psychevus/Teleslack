import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.util.List;


public abstract class BotListener implements Runnable {

    private static final int UPDATE_MESSAGE_LIMIT = 10;
    private static final int LONG_POLLING_TIMEOUT = 0; // in seconds

    protected TelegramBot bot;

    public BotListener(String botToken) {
        bot = TelegramBotAdapter.build(botToken);
    }

    @Override
    public void run() {
        int offset = 0;
        int maxUpdateId = 0;
        boolean alive = true;

        List<Update> updates;
        while (true) {
            if (!alive)
                break;

            try {
                GetUpdatesResponse updatesResponse = bot.getUpdates(offset, UPDATE_MESSAGE_LIMIT, LONG_POLLING_TIMEOUT);
                updates = updatesResponse.updates();
            } catch (Exception e) {
                System.out.println("Telegram getUpdates failed. we'll retry.");
                continue;
            }

            if (updates == null || updates.isEmpty()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    alive = false;
                }
                continue;
            }

            for (Update update : updates) {
                maxUpdateId = maxUpdateId >= update.updateId() ? maxUpdateId : update.updateId();

                CallbackQuery callbackQuery = update.callbackQuery();
                InlineQuery inlineQuery = update.inlineQuery();
                Message message = update.message();

                System.out.println("callbackQuery : {} " + callbackQuery);
                System.out.println("inlineQuery : {} " + inlineQuery);
                System.out.println("message : {} " + message);

                if (inlineQuery != null) { // inline bot mode
                    inlineQuery(inlineQuery);
                } else if (message != null) { // channel bot mode
                    message(message);
                } else if (callbackQuery != null) { // channel bot mode
                    callbackQuery(callbackQuery);
                }
            }

            offset = maxUpdateId + 1;
        }
    }

    abstract protected void inlineQuery(InlineQuery inlineQuery);

    abstract protected void message(Message message);

    abstract protected void callbackQuery(CallbackQuery callbackQuery);
}
