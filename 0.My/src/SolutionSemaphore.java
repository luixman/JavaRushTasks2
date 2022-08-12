import java.util.concurrent.Semaphore;

public class SolutionSemaphore
{
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);

        new Philosopher(sem,"Сократ").start();
        new Philosopher(sem,"Платон").start();
        new Philosopher(sem,"Аристотель").start();
        new Philosopher(sem,"Фалес").start();
        new Philosopher(sem,"Пифагор").start();
    }
}

class Philosopher extends Thread {

    private Semaphore sem;

    // поел ли философ
    private boolean full = false;

    private String name;

    Philosopher(Semaphore sem, String name) {
        this.sem=sem;
        this.name=name;
    }

    public void run()
    {
        try
        {
            // если философ еще не ел
            if (!full) {
                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println (name + " садится за стол");

                // философ ест
                sleep(3000);
                full = true;

                System.out.println (name + " поел! Он выходит из-за стола");
                sem.release();

                // философ ушел, освободив место другим
                sleep(3000);
            }
        }
        catch(InterruptedException e) {
            System.out.println ("Что-то пошло не так!");
        }
    }
}
