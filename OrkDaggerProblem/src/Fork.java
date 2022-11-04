import java.util.concurrent.Semaphore;

public class Fork extends Semaphore {

    private String name;
    private int number;
    private boolean islend = false;

    public Fork(String name,int number) {
        super(3);
        this.name = name;
        this.number = number;
    }

    public void setIslend(boolean islend) {
        this.islend = islend;
    }

    public boolean isIslend() {
        return islend;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
