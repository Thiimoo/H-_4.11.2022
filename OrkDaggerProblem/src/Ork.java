import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ork implements Runnable{

    private Fork leftFork;
    private Fork rightFork;
    private int number;

    private Table table;

    public Ork(Fork leftFork, Fork rightFork, int number, Table table) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.number = number;
        this.table = table;
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
        System.out.println("Ork "+ this.number+" is drinking for: "+number/100+" seconds");
        return number;
    }


    public int feasting()
    {
        Random random = ThreadLocalRandom.current();
        int number = 99 + random.nextInt(1001);
        this.table.setLend(this.leftFork.getNumber(),false);
        this.table.setLend(this.rightFork.getNumber(),false);
        System.out.println("Ork "+ this.number+" is feasting for: "+number/100+" seconds");
        this.leftFork = null;
        this.rightFork = null;
        return number;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(drinking());
                //now working
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.leftFork = table.grabLeftDagger(this);
            this.rightFork = table.grabRightDagger(this);
            try
            {
                if (!this.leftFork.equals(null))
                {
                    this.table.setLend(this.leftFork.getNumber(),true);
                    System.out.println("Ork "+this.number+" has left fork");
                }
            }
            catch (NullPointerException n)
            {
                System.out.println("Ork "+this.number+" has left fork not");
            }
        try{
            if (!this.rightFork.equals(null))
            {
                this.table.setLend(this.rightFork.getNumber(),true);
                System.out.println("Ork "+this.number+" has right fork");
            }
        }
        catch (NullPointerException nullPointerException)
        {
            System.out.println("Ork "+this.number+" has right fork not");
        }
        try{
            if (!this.rightFork.equals(null)&&!this.rightFork.equals(null))
            {
                Thread.sleep(feasting());
            }
        }
        catch (NullPointerException pointerException)
            {
                System.out.println("Ork "+this.number+" not feasting");
            } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }
    }
}
