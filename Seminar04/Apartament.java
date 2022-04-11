package seminar.seminar2.g1052;

import java.util.Arrays;
import java.util.Date;

public class Apartament extends Imobil {
    private int etaj;
    private String[] dotari;

    public Apartament() {
    }

    public Apartament(int id, int suprafataUtila, int etaje, int nrCamere, String telefonP,
                      Zona zona, double pret, Date dataP, int etaj, String[] dotari) throws Exception {
        super(id, suprafataUtila, etaje, nrCamere, telefonP, zona, pret, dataP);
        if(etaj>etaje){
            throw new Exception("Etaj invalid!");
        }
        this.etaj = etaj;
        this.dotari = dotari;
    }

    public Apartament(int id) {
        super(id);
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) throws Exception {
        if(etaj>getEtaje()){
            throw new Exception("Etaj invalid!");
        }
        this.etaj = etaj;
    }

    public String[] getDotari() {
        return dotari;
    }

    public void setDotari(String[] dotari) {
        this.dotari = dotari;
    }

    @Override
    public String toString() {
        return super.toString()+"\n{" + etaj +"," + Arrays.toString(dotari) + "} ";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Apartament clona = (Apartament) super.clone();
        clona.setDataP( (Date) getDataP().clone() );
        clona.setDotari( Arrays.copyOf(dotari,dotari.length));
        return clona;
    }
}
