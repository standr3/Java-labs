package seminar.seminar2.g1052;

import java.util.Comparator;

public class ComparatorData implements Comparator<Imobil> {
    @Override
    public int compare(Imobil imobil, Imobil t1) {
        return imobil.getDataP().compareTo(t1.getDataP());
    }
}
