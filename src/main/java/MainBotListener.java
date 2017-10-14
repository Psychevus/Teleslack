import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Chat.Type;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.ullink.slack.simpleslackapi.SlackSession;
import keyboard.UsuallyKeyboard;
import send.SendObjects;

class MainBotListener extends BotListener {

    private static final String BOT_TOKEN = "";
    private SlackSession session;

    MainBotListener(SlackSession session) {
        super(BOT_TOKEN);
        this.session = session;
    }

    @Override
    protected void callbackQuery(CallbackQuery callbackQuery) {
        if (callbackQuery == null)
            return;

    }


    @Override
    protected void inlineQuery(InlineQuery inlineQuery) {
        if (inlineQuery == null)
            return;

    }

    @Override
    protected void message(Message message) {
        if (message == null)
            return;

        Chat chat = message.chat();
        if (chat.type() == Type.Private) { // Private
            if (message.text().equals("گزارش کار امروز")) {
                SendObjects.sendMessage(chat.id(), "گزارش کار حود را بنویسید", bot);
            } else {
                SendObjects.sendMessage(chat.id(), "یک گزینه را انتخاب کنید.", UsuallyKeyboard.replyKeyboardMarkup, bot);
                // Slack.startSlack(message.text(), message, session);
            }
        }
    }
}