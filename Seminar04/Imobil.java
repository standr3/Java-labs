package seminar.seminar2.g1052;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Imobil implements Comparable<Imobil>,Cloneable, Serializable {
    private int id,suprafataUtila,etaje,nrCamere;
    private String telefonP;
    private Zona zona;
    private double pret;
    private Date dataP;
    private long cnpAgent;

    public Imobil() {
    }

    public Imobil(int id, int suprafataUtila, int etaje, int nrCamere, String telefonP, Zona zona, double pret, Date dataP) {
        this.id = id;
        this.suprafataUtila = suprafataUtila;
        this.etaje = etaje;
        this.nrCamere = nrCamere;
        this.telefonP = telefonP;
        this.zona = zona;
        this.pret = pret;
        this.dataP = dataP;
    }

    public long getCnpAgent() {
        return cnpAgent;
    }

    public void setCnpAgent(long cnpAgent) {
        this.cnpAgent = cnpAgent;
    }

    public Imobil(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSuprafataUtila() {
        return suprafataUtila;
    }

    public void setSuprafataUtila(int suprafataUtila) {
        this.suprafataUtila = suprafataUtila;
    }

    public int getEtaje() {
        return etaje;
    }

    public void setEtaje(int etaje) {
        this.etaje = etaje;
    }

    public int getNrCamere() {
        return nrCamere;
    }

    public void setNrCamere(int nrCamere) {
        this.nrCamere = nrCamere;
    }

    public String getTelefonP() {
        return telefonP;
    }

    public void setTelefonP(String telefonP) {
        this.telefonP = telefonP;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public Date getDataP() {
        return dataP;
    }

    public void setDataP(Date dataP) {
        this.dataP = dataP;
    }

    @Override
    public String toString() {
        String sirData = dataP==null?"":Main.formatData.format(dataP);
        return "{"+id+","+suprafataUtila+","+etaje+","+nrCamere+","+telefonP+","+zona+","+pret+","+sirData+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Imobil imobil = (Imobil) o;
        return id == imobil.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Imobil o) {
        if (pret==o.pret){
            return 0;
        } else {
            if (pret<o.pret){
                return -1;
            } else {
                return 1;
            }
        }
    }
}
