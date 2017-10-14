package send;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.File;

/**
 * Created by Mojtaba on 7/18/2016.
 */
public class SendObjects {


    public static SendResponse sendDoc(String channel, File file, TelegramBot telegramBot, String caption) {
        return telegramBot.execute(new SendDocument(channel, file).caption(caption));
    }

    public static SendResponse sendDoc(String channel, File file, TelegramBot telegramBot) {
        return telegramBot.execute(new SendDocument(channel, file));
    }

    public static SendResponse sendDoc(String channel, byte[] bytes, TelegramBot telegramBot) {
        return telegramBot.execute(new SendDocument(channel, bytes));
    }

    public static SendResponse sendPhoto(String channel, File file, TelegramBot telegramBot, String caption) {
        return telegramBot.execute(new SendPhoto(channel, file).caption(caption));
    }

    public static SendResponse sendPhoto(String channel, File file, TelegramBot telegramBot) {
        return telegramBot.execute(new SendPhoto(channel, file));
    }

    public static SendResponse sendMessage(Object chatId, String message, Keyboard replyMarkup, TelegramBot telegramBot) {
        return telegramBot.execute(new SendMessage(chatId, message).parseMode(ParseMode.HTML).replyMarkup(replyMarkup));
    }

    public static SendResponse sendMessage(Object chatId, String message, TelegramBot telegramBot) {
        return telegramBot.execute(new SendMessage(chatId, message).parseMode(ParseMode.HTML));
    }
}
