package NetworkProgramming.ChatApplication;

import java.io.*;
import java.net.Socket;

public class UserThread extends Thread {
    private Socket socket;
    private ChatServer chatServer;
    private PrintWriter printWriter;

    public UserThread(Socket socket, ChatServer chatServer) {
        this.socket = socket;
        this.chatServer = chatServer;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            printWriter = new PrintWriter(output, true);

            printUsers();

            String userName = reader.readLine();
            chatServer.addUserName(userName);

            String serverMessage = "New user connected: " + userName;
            chatServer.broadcast(serverMessage, this);

            String clientMessage;

            do {
                clientMessage = reader.readLine();
                serverMessage = "[" + userName + "]: " + clientMessage;
                chatServer.broadcast(serverMessage, this);

            } while (!clientMessage.equals("bye"));

            chatServer.removeUser(userName, this);
            socket.close();

            serverMessage = userName + "has quited";
            chatServer.broadcast(serverMessage, this);

        } catch (IOException e) {
            System.out.println("Error in UserThread: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void printUsers() {
        if (chatServer.hasUsers()) {
            printWriter.println("Connected users: " + chatServer.getUserNames());
        }else {
            printWriter.println("No other users connected");
        }
    }

    void sendMessage(String message) {
        printWriter.println(message);

    }
}
