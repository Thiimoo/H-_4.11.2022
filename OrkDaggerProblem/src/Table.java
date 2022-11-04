import java.util.ArrayList;
import java.util.List;

public class Table {

    List<Fork> forks = new ArrayList<>();

    public Table(List<Fork> forks) {
        this.forks = forks;
    }

    public Fork grabRightDagger(Ork ork)
    {
        if (ork.getNumber()== forks.size()-1)
        {
            if (!forks.get(0).isIslend())
            {
                forks.get(0).setIslend(true);
                return forks.get(0);
            }
            return null;
        }
        if (!forks.get(ork.getNumber() + 1).isIslend()) {
            forks.get(ork.getNumber() + 1).setIslend(true);
            return forks.get(ork.getNumber() + 1);
        }
        else {
            return null;
        }

    }

    public Fork grabLeftDagger(Ork ork)
    {
        if (!forks.get(ork.getNumber()).isIslend()) {
            forks.get(ork.getNumber()).setIslend(true);
            return forks.get(ork.getNumber());
        }
        else {
            return null;
        }
    }

    public void setLend(int number, boolean lend)
    {
        forks.get(number).setIslend(lend);
    }

}
