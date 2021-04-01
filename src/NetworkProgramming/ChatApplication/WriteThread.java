package NetworkProgramming.ChatApplication;

import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteThread extends Thread {
    private PrintWriter printWriter;
    private Socket socket;
    private ChatClient client;

    public WriteThread(Socket socket, ChatClient client) {
        this.socket = socket;
        this.client = client;

        try{
            OutputStream output = socket.getOutputStream();
            printWriter = new PrintWriter(output, true);
        } catch (IOException e) {
            System.out.println("Error getting out stream: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run() {
        Console console = System.console();

        String userName = console.readLine("\n Enter your name: ");
        client.setUserName(userName);
        printWriter.println(userName);

        String text;

        do {
            text = console.readLine("[" + userName + "]:");
            printWriter.println(text);
        } while (!text.equals("bye"));

        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Error writing to server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
