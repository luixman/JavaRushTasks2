package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client{

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            String[] splitMessage =message.split(": ");
            if(splitMessage.length!=2 )
                return;
            String userName = splitMessage[0];
            String command = splitMessage[1];

            String format = null;
            Calendar calendar = Calendar.getInstance();

            switch (command){
                case "дата":
                    format= "d.MM.YYYY";
                    break;
                case "день":
                    format = "d";
                    break;
                case "месяц":
                    format = "MMMM";
                    break;
                case "год":
                    format = "YYYY";
                    break;
                case "время":
                    format = "H:mm:ss";
                    break;
                case "час":
                    format = "H";
                    break;
                case "минуты":
                    format = "m";
                    break;
                case "секунды":
                    format = "s";
                    break;
            }
            if(format!=null){
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat(format);
                String answer ="Информация для "+userName+": "+simpleDateFormat.format(new GregorianCalendar().getTime());
                sendTextMessage(answer);
            }

        }
    }

    @Override
    protected String getUserName() {
        return "date_bot_"+(int)(Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }


}
