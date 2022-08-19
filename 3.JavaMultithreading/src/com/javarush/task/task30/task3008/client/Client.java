package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;


public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        new Client().run();
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage (String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            System.out.println(connection.getRemoteSocketAddress()+"Ошибка отправки сообщения");
            clientConnected = false;
        }
    }


    public void run(){
        SocketThread socketThread =getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Произошла ошибка");
                return;
            }
        }

        if(clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while(clientConnected){
            String s = ConsoleHelper.readString();
            if(s.equals("exit")){
                return;
            } else if(shouldSendTextFromConsole())
                sendTextMessage(s);
        }
    }

    public class SocketThread extends Thread{

        protected  void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+ " присоединился к чату");
        }

        protected  void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+ " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake () throws IOException,ClassNotFoundException{
            while (true){
                Message m = connection.receive();

                if(m.getType() ==MessageType.NAME_REQUEST)
                    connection.send(new Message(MessageType.USER_NAME,getUserName()));
                else if(m.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException,ClassNotFoundException{
           while(true) {
               Message m = connection.receive();
               if (m.getType() == MessageType.TEXT)
                   processIncomingMessage(m.getData());
               else if (m.getType() == MessageType.USER_ADDED)
                   informAboutAddingNewUser(m.getData());
               else if (m.getType() == MessageType.USER_REMOVED)
                   informAboutDeletingNewUser(m.getData());
               else throw new IOException("Unexpected MessageType");
           }

        }

        public void run(){
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();

           try( Socket socket = new Socket(serverAddress,serverPort)) {
               connection = new Connection(socket);
               clientHandshake();
               clientMainLoop();
           }catch (IOException | ClassNotFoundException e){
               ConsoleHelper.writeMessage("Неизвестная ошибка");
               notifyConnectionStatusChanged(false);

            }

        }



    }
}
