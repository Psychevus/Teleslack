package keyboard;

import com.pengrad.telegrambot.model.request.*;

/**
 * Created by mzaferanloo on 5/9/16.
 */
public class UsuallyKeyboard {

    public static Keyboard replyKeyboardMarkup = new ReplyKeyboardMarkup(
            new String[]{"گزارش کار امروز"})
            .resizeKeyboard(true);


    static String getEmijoByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }
}
