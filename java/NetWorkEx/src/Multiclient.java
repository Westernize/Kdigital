import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Multiclient {
    public static void main(String[] args) {
        Multiclient multiclient = new Multiclient();
        multiclient.start();
    }

    public void start() {
        Socket socket = null;
        BufferedReader in = null;
        try {
            socket = new Socket("localhost", 8000);
            System.out.println("[서버와 연결되었습니다.]");

            String name = "user" + (int)(Math.random() * 10);
            Thread sendThread = new SendThread(socket, name);
            sendThread.start();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputMsg;
            while ((inputMsg = in.readLine()) != null) {
                if (("[" + name + "님]이 나가셨습니다.").equals(inputMsg)) break;
                System.out.println("From: " + inputMsg);
            }
        } catch (IOException e) {
            System.out.println("[서버 접속실패]");
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("[서버 연결종료]");
        }
    }

    class SendThread extends Thread {
        Socket socket = null;
        String name;
        Scanner scanner = new Scanner(System.in);

        public SendThread(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println(name);
                out.flush();

                while (true) {
                    String outputMsg = scanner.nextLine();
                    out.println(outputMsg);
                    out.flush();
                    if ("나가기".equals(outputMsg) || "quit".equals(outputMsg)) break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
