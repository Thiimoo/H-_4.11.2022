import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) {
        List<Fork> forks = new ArrayList<>();
        forks.add(new Fork("fork0",0));
        forks.add(new Fork("fork1",1));
        forks.add(new Fork("fork2",2));
        forks.add(new Fork("fork3",3));
        forks.add(new Fork("fork4",4));
        Table t = new Table(forks);
        Thread o0 = new Thread(new Ork(null,null,0,t));
        Thread o1 = new Thread(new Ork(null,null,1,t));
        Thread o2 = new Thread(new Ork(null,null,2,t));
        Thread o3 = new Thread(new Ork(null,null,3,t));
        Thread o4 = new Thread(new Ork(null,null,4,t));

        o0.start();
        o1.start();
        o2.start();
        o3.start();
        o4.start();
    }

}
