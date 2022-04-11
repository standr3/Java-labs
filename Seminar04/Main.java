package seminar.seminar2.g1052;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static SimpleDateFormat formatData = new SimpleDateFormat("dd.MM.yyyy");

    private List<Apartament> apartamente = new ArrayList<>();
    private List<Agent> agenti = new ArrayList<>();

    public Main() {
    }

    public void citireApartamente(String numeFisier) throws Exception {
        try (BufferedReader in = new BufferedReader(new FileReader(numeFisier))) {
            apartamente.clear();
            agenti.clear();
            String linie;
            while ((linie = in.readLine()) != null) {
                Agent agent = new Agent();
                String[] t = linie.split(",");
                agent.setCnp(Long.parseLong(t[0].trim()));
                agent.setNume(t[1]);
                int n = Integer.parseInt(t[2].trim());
//                int[] id_uri = new int[n];
                for (int i = 0; i < n; i++) {
                    Apartament apartament = new Apartament();
                    t = in.readLine().split(",");
                    apartament.setId(Integer.parseInt(t[0].trim()));
                    agent.inregistrare(apartament.getId());
//                    id_uri[i] = apartament.getId();
                    apartament.setSuprafataUtila(Integer.parseInt(t[1].trim()));
                    apartament.setEtaje(Integer.parseInt(t[2]));
                    apartament.setNrCamere(Integer.parseInt(t[3]));
                    apartament.setTelefonP(t[4]);
                    apartament.setZona(Zona.valueOf(t[5].trim().toUpperCase()));
                    apartament.setPret(Double.parseDouble(t[6].trim()));
                    apartament.setDataP(formatData.parse(t[7].trim()));
                    apartament.setEtaj(Integer.parseInt(t[8].trim()));
                    apartament.setDotari(Arrays.copyOfRange(t, 9, t.length));
                    apartament.setCnpAgent(agent.getCnp());
                    apartamente.add(apartament);
                }
//                agent.setImobile(id_uri);
                agenti.add(agent);
            }
        }
    }

    public void printApartamente(String mesaj) {
        System.out.println(mesaj);
        for (Apartament apartament : apartamente) {
            System.out.println(apartament);
        }
    }

    public void salvareAgenti(String numeFisier) throws Exception{
        try(PrintWriter out = new PrintWriter(numeFisier)) {
//            cnp agent,nume agent,număr apartamente în portofoliu
            for (Agent agent:agenti){
                out.println(agent.getCnp()+","+
                        agent.getNume()+","+agent.getImobile().length);
            }
        }
    }

    public void salvare(String numeFisier) throws Exception{
        try(ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            for (Apartament apartament : apartamente) {
                out.writeObject(apartament);
            }
        }
    }

    public void restaurare(String numeFisier) throws Exception{
        try( FileInputStream in1 = new FileInputStream(numeFisier);
             ObjectInputStream in = new ObjectInputStream(in1)) {
            apartamente.clear();
            while (in1.available()!=0) {
                apartamente.add((Apartament) in.readObject());
            }
        }
    }

    public void salvareBinaraAgenti(String numeFisier) throws Exception{
        try(DataOutputStream out =
                    new DataOutputStream(new FileOutputStream(numeFisier))) {
            for (Agent agent:agenti){
                out.writeLong(agent.getCnp());
                out.writeUTF(agent.getNume());
                int[] imobile = agent.getImobile();
                out.writeInt(imobile.length);
                for (int i = 0; i < imobile.length; i++) {
                    out.writeInt(imobile[i]);
                }
            }
        }
    }

    public List<Apartament> getApartamente() {
        return apartamente;
    }

    public List<Agent> getAgenti() {
        return agenti;
    }


    public static void main(String[] args) {
        try {
            Apartament apartament1 = new Apartament(10, 100, 4, 4, "0745345123", Zona.AVIATIEI,
                    170000, formatData.parse("02.02.2022"), 1, new String[]{"Centrala proprie", "Parcare"});
//            System.out.println(apartament1);
            Apartament apartament2 = apartament1;
            Apartament apartament3 = new Apartament(10);
//            System.out.println(apartament1==apartament3);
//            System.out.println(apartament1.equals(apartament3));
//            System.out.println(apartament1.compareTo(apartament3));

            Apartament clona = (Apartament) apartament1.clone();
            clona.getDataP().setTime(new Date().getTime());
            clona.getDotari()[0] = "Alta dotare";
//            System.out.println("Obiect clonat:\n"+apartament1);
//            System.out.println("Obiect clona:\n"+clona);

            Main app = new Main();
            app.citireApartamente("apartamente.csv");
            app.printApartamente("Lista apartamente");

//            Sortare apartamente dupa pret
            List<Apartament> listaApartamente = app.getApartamente();
            Collections.sort(listaApartamente);
            app.printApartamente("Apartamentele soratate dupa pret:");

//            Sortare dupa data publicarii
            ComparatorData comparatorData = new ComparatorData();
            Collections.sort(listaApartamente,comparatorData);
            app.printApartamente("Apartamentele sortate dupa data:");

//            Sortare dupa telefon proprietar

            Comparator comparatorTelefon = new Comparator<Apartament>() {
                @Override
                public int compare(Apartament apartament, Apartament t1) {
                    return apartament.getTelefonP().compareTo(t1.getTelefonP());
                }
            };

            listaApartamente.sort(comparatorTelefon);
            app.printApartamente("Apartamentele listate dupa telefon proprietar:");
//            Salvare agenti
            app.salvareAgenti("agenti.csv");

//            Cautare dupa id apartament folosind indexOf (List)
            int id = 4;
            Apartament apartamentCautat = new Apartament(id);
            int k = listaApartamente.indexOf(apartamentCautat);
            if (k>=0){
                System.out.println("Apartament cautat:\n"+listaApartamente.get(k));
            } else {
                System.out.println("Nu am gasit apartamentul cu id-ul "+
                        apartamentCautat.getId());
            }
//            Cautare dupa pret folosind cautarea binara

            Collections.sort(listaApartamente);
            apartamentCautat.setPret(75000);
            k = Collections.binarySearch(listaApartamente,apartamentCautat);
            if (k>=0){
                System.out.println("Apartament cautat:\n"+listaApartamente.get(k));
            } else {
                System.out.println("Nu am gasit apartamentul cu " +
                        "pretul "+ apartamentCautat.getPret());
                System.out.println("Pozitie de insertie:"+(-k-1));

            }
//            Cautare dupa telefon proprietar
            listaApartamente.sort(comparatorTelefon);
            apartamentCautat.setTelefonP("0766567821");
            k = Collections.binarySearch(listaApartamente,apartamentCautat,comparatorTelefon);
            if (k>=0){
                System.out.println("Apartament cautat:\n"+listaApartamente.get(k));
            } else {
                System.out.println("Nu am gasit apartamentul cu " +
                        "telefon proprietar "+ apartamentCautat.getTelefonP());
                System.out.println("Pozitie de insertie:"+(-k-1));
            }
//  Salvare apartamente
            app.salvare("apartamente.dat");
//            Restaurare lista apartamente
            app.restaurare("apartamente.dat");
            app.printApartamente("Lista reastaurata:");

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
