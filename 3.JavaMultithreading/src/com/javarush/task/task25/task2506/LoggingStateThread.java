package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;
    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        super.run();

       State state =  thread.getState();
       State newState;

        System.out.println(state);

        while(true){
            newState = thread.getState();
            if(newState.equals(State.TERMINATED)){
                System.out.println(newState);
                break;
            } else if(state!=newState){
                state = newState;

                System.out.println(newState);
            }
        }
    }
}
