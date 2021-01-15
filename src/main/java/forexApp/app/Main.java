package forexApp.app;

import forexApp.comunication.ComunicationChannel;
import forexApp.forexData.ForexData;
import forexApp.messages.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ComunicationChannel comunicationChannel;
        Scanner scan = new Scanner(System.in);
        PrintWriter logger = null;
        File file = getFile(scan);
        File log = new File("log:" + (LocalDate.now() + ".txt"));
        try {
            ForexData.load(file);
            log.createNewFile();
            logger = new PrintWriter(log);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        comunicationChannel = new ComunicationChannel();
        String answer;
        do {
            System.out.print("->");
            String request = scan.nextLine();
            Message message = new Message(request);
            answer = comunicationChannel.getResponse(message);
            System.out.println(answer);
            logger.println(request + "->" + answer);
        } while (!((answer.equals("exit")) || (answer.equals("quit"))));
        logger.close();
    }
    private static File getFile(Scanner scan) {
        String path;
        File file;
        do {
            System.out.print("enter file name : "); ///"DAT_MT_EURUSD_M1_202011.txt"
            path = scan.nextLine();
            file = new File(path);
        } while (!file.exists());
        return file;
    }
}
