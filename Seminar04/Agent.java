package seminar.seminar2.g1052;

import java.util.Arrays;

public class Agent implements Operatiuni {
    private long cnp;
    private String nume;
    private int[] imobile;

    public Agent() {
    }

    public Agent(long cnp, String nume, int[] imobile) {
        this.cnp = cnp;
        this.nume = nume;
        this.imobile = imobile;
    }

    public Agent(long cnp) {
        this.cnp = cnp;
    }

    public long getCnp() {
        return cnp;
    }

    public void setCnp(long cnp) {
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int[] getImobile() {
        return imobile;
    }

    public void setImobile(int[] imobile) {
        this.imobile = imobile;
    }

    @Override
    public String toString() {
        return "{" + cnp +"," + nume +"," + Arrays.toString(imobile) + '}';
    }

    @Override
    public int inregistrare(int id) {
        if(imobile==null){
            imobile = new int[1];
        } else {
            imobile = Arrays.copyOf(imobile,imobile.length+1);
        }
        imobile[imobile.length-1] = id;
        return imobile.length;
    }

}
