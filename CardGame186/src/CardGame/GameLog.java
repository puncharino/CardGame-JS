package CardGame;

import java.io.*;

public class GameLog {

    private static StringBuilder sb = new StringBuilder();
    private static String gameEventLog;
    private static BufferedWriter bufferedWriter;

    static {

        try {
            File gameLog = new File("gameLog.txt");

            if (!gameLog.exists()) {
                gameLog.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(gameLog);
            bufferedWriter = new BufferedWriter(fileWriter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void terminate() {
        try {
            bufferedWriter.write(sb.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addEvent (String message, BlackJack.origin source, boolean userfacing) {

        String displayed = "[" + source + "] " + message + "\n";

        if (userfacing) {
            switch (source) {
                case DEALER:
                    System.err.print(displayed);
                    break;
                case PLAYER:
                    System.out.print(displayed);
                    break;
                case SYSTEM:
                    System.out.print(displayed.toUpperCase());
                    break;
            }
        }

        sb.append(displayed);
    }
}
