import java.util.ArrayList;
import java.util.List;

public class Table {

    List<Fork> forks = new ArrayList<>();

    public Table(List<Fork> forks) {
        this.forks = forks;
    }

    public Fork grabRightDagger(Ork ork)
    {
        if (ork.getNumber()== 4)
        {
            if (!forks.get(0).isIslend())
            {
                return forks.get(0);
            }
        }
        if (!forks.get(ork.getNumber() + 1).isIslend()) {
            return forks.get(ork.getNumber() + 1);
        }
        else {
            return null;
        }

    }

    public Fork grabLeftDagger(Ork ork)
    {
        if (!forks.get(ork.getNumber()).isIslend()) {
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
