import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;

import java.io.IOException;

public class App {
    private static Thread listener;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Shutdown hook ran!");
                shutdown();
            }
        });

        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("");
//        try {
//            session.connect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        listener = new Thread(new MainBotListener(session));
        listener.start();


        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                shutdown();
                break;
            }
        }
    }

    private static void shutdown() {
        try {
            listener.interrupt();
            listener.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception : {} " + e);
        }
    }
}