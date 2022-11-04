import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class Ork implements Runnable{

    private Fork leftFork;
    private Fork rightFork;
    private int number;
    private ReentrantLock lock;
    private String name;

    private Table table;

    public Ork(Fork leftFork, Fork rightFork, int number, Table table, String name, ReentrantLock lock) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.number = number;
        this.table = table;
        this.name = name;
        this.lock = lock;
    }

    public Fork getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Fork leftFork) {
        this.leftFork = leftFork;
    }

    public Fork getRightFork() {
        return rightFork;
    }

    public void setRightFork(Fork rightFork) {
        this.rightFork = rightFork;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int drinking()
    {
        Random random = ThreadLocalRandom.current();
        int number = 99 + random.nextInt(1001);
        System.out.println(this.name+" is drinking for: "+number/100+" seconds");
        return number;
    }


    public int feasting()
    {
        Random random = ThreadLocalRandom.current();
        int number = 99 + random.nextInt(1001);
        System.out.println(this.name+" is feasting for: "+number/100+" seconds");
        return number;
    }


    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(drinking());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.lock.lock();
            this.leftFork = table.grabLeftDagger(this);
            this.rightFork = table.grabRightDagger(this);
            lock.unlock();
            if (this.leftFork != null)
            {
                System.out.println(this.name+" has left fork");
            }
            else {
                System.out.println(this.name+" has left fork not");
            }
            if (this.rightFork != null)
            {
                System.out.println(this.name+" has right fork");
            }
            else {
                System.out.println(this.name+" has right fork not");
            }
            if (this.leftFork!= null&&this.rightFork!=null)
            {
                try {
                    Thread.sleep(feasting());
                    this.table.setLend(this.leftFork.getNumber(),false);
                    this.table.setLend(this.rightFork.getNumber(),false);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                this.leftFork = null;
                this.rightFork = null;
            }
            else {
               
                System.out.println(this.name +" is not feasting");
            }


        }
    }
}
