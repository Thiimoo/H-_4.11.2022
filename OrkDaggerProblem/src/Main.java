import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        System.out.println("\n");
        System.out.println("Tischanordnung:");
        System.out.println("\n");
        System.out.println("               Heinrich");
        System.out.println("");
        System.out.println("                _____");
        System.out.println("Manfred        |     |        Martin");
        System.out.println("               |     |");
        System.out.println("               |_____|");
        System.out.println("");
        System.out.println("   Ragnarok                  Fridolin");
        System.out.println("\n");
        System.out.println("\n");
        List<Fork> forks = new ArrayList<>();
        forks.add(new Fork("Tafelgabel",0));
        forks.add(new Fork("Menügabel",1));
        forks.add(new Fork("Fischgabel",2));
        forks.add(new Fork("Dessertgabel",3));
        forks.add(new Fork("Kuchengabel",4));
        Table t = new Table(forks);
        Thread o0 = new Thread(new Ork(null,null,0,t,"Heinrich",lock));
        Thread o1 = new Thread(new Ork(null,null,1,t,"Martin",lock));
        Thread o2 = new Thread(new Ork(null,null,2,t,"Fridolin",lock));
        Thread o3 = new Thread(new Ork(null,null,3,t,"Ragnarok",lock));
        Thread o4 = new Thread(new Ork(null,null,4,t,"Manfred",lock));

        o0.start();
        o1.start();
        o2.start();
        o3.start();
        o4.start();
    }

}
