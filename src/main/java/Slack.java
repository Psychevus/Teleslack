
import com.pengrad.telegrambot.model.Message;
import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.SlackSession;

public class Slack {


    static void startSlack(String text, Message message,SlackSession session) {

//        sendMessageToAChannel(session, text, message);


    }



    private static void sendMessageToAChannel(SlackSession session, String text, Message message) {

        //get a channel
        if (message.from().username().equals("modrix")) {
            SlackChannel channel = session.findChannelByName("timesheetmojtaba");
            session.sendMessage(channel, text);

        } else if (message.from().username().equals("ZamzamPooya")) {
            SlackChannel channel = session.findChannelByName("timesheetzamzam");
            session.sendMessage(channel, text);

        } else if (message.from().username().equals("Pooria_picasso")) {
            SlackChannel channel = session.findChannelByName("timesheetpooria");
            session.sendMessage(channel, text);

        } else if (message.from().username().equals("Amir_Duzandeh")) {
            SlackChannel channel = session.findChannelByName("timesheetamirhosein");
            session.sendMessage(channel, text);

        } else if (message.from().username().equals("masoudmanson")) {
         //   SlackChannel channel = session.findChannelByName("timesheetmojtabaaa");

        } else if (message.from().username().equals("Shakoool")) {
         //   SlackChannel channel = session.findChannelByName("timesheetmojtabaaa");

        }
    }

}