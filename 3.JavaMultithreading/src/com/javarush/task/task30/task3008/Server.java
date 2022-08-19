package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        int port = ConsoleHelper.readInt();

        try (ServerSocket socket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(socket.accept()).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> con :
                connectionMap.entrySet()) {
            try {
                con.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message response = connection.receive();

                if (response.getType() != MessageType.USER_NAME) {
                    ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + " данные не соответствуют имени");
                    continue;
                }

                String name = response.getData();
                if (name.isEmpty()) {
                    ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + " отправленное имя пустое");
                    continue;
                }

                if (connectionMap.containsKey(name)) {
                    ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + " данное имя уже имеет подключение к серверу");
                    continue;
                }

                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return name;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> connectionEntry :
                    connectionMap.entrySet()) {
                if (!connectionEntry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, connectionEntry.getKey()));
                }

            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while(true) {

                Message m = connection.receive();

                if(m.getType() != MessageType.TEXT){
                    ConsoleHelper.writeMessage("Ошибка, данное сообщение не является текстом");
                    continue;
                }
                if (m.getType().equals(MessageType.TEXT)) {
                    Message newMessage =new Message(MessageType.TEXT,userName+": "+m.getData());
                    sendBroadcastMessage(newMessage);
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + " установлено соединение");
            String userName = null;
            try( Connection connection = new Connection(socket)) {


               userName = serverHandshake(connection);

               sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));

               notifyUsers(connection,userName);
               serverMainLoop(connection,userName);


           }catch (IOException | ClassNotFoundException e){
               ConsoleHelper.writeMessage("Произошла ошибка установления соединения с клиентом");
           }

            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            }
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress()+" соединение закрыто");
        }
    }
}
