package seminar.seminar2.g1052;

import java.util.Arrays;
import java.util.Date;

public class Casa extends Imobil{
    private int suprafataTeren;
    private String[] utilitați;

    public Casa() {
    }

    public Casa(int id, int suprafataUtila, int etaje, int nrCamere, String telefonP, Zona zona,
                double pret, Date dataP, int suprafataTeren, String[] utilitați) {
        super(id, suprafataUtila, etaje, nrCamere, telefonP, zona, pret, dataP);
        this.suprafataTeren = suprafataTeren;
        this.utilitați = utilitați;
    }

    public Casa(int id) {
        super(id);
    }

    public int getSuprafataTeren() {
        return suprafataTeren;
    }

    public void setSuprafataTeren(int suprafataTeren) {
        this.suprafataTeren = suprafataTeren;
    }

    public String[] getUtilitați() {
        return utilitați;
    }

    public void setUtilitați(String[] utilitați) {
        this.utilitați = utilitați;
    }

    @Override
    public String toString() {
        return super.toString()+"\n{" + suprafataTeren +"," + Arrays.toString(utilitați) + "} ";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Casa clona =(Casa) super.clone();
        clona.setDataP( (Date) getDataP().clone());
        clona.setUtilitați( Arrays.copyOf(utilitați,utilitați.length) );
        return clona;
    }
}
