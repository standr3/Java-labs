package seminar.seminar2.g1058;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public Main() {
    }

    private List<Student> studenti = new ArrayList<>();

    public List<Student> getStudenti() {
        return studenti;
    }

    public void citire(String numeFisier) throws Exception {
        try (BufferedReader in = new BufferedReader(new FileReader(numeFisier))) {
            studenti.clear();
            String linie;
            while ((linie = in.readLine()) != null) {
                Student student = new Student();
                String[] t = linie.split(",");
                student.setCnp(Long.parseLong(t[0].trim()));
                student.setNume(t[1]);
                Adresa adresa = new Adresa();
                adresa.setLocalitate(t[2]);
                adresa.setStrada(t[3]);
                adresa.setNumar(t[4]);
                adresa.setCodPostal(Integer.parseInt(t[5].trim()));
                student.setAdresa(adresa);
                student.setGrupa(Integer.parseInt(t[6].trim()));
                student.setAnul(Integer.parseInt(t[7].trim()));
                t = in.readLine().split(",");
                int n = t.length / 2;
                int[] note = new int[n];
                Disciplina[] discipline = new Disciplina[n];
                for (int i = 0; i < n; i++) {
                    discipline[i] = Disciplina.valueOf(t[i * 2].trim().toUpperCase());
                    note[i] = Integer.parseInt(t[i * 2 + 1].trim());
                }
                student.setDiscipline(discipline);
                student.setNote(note);
                studenti.add(student);
            }
        }
    }

    public void print(String mesaj){
        System.out.println(mesaj);
        for (Student student:studenti){
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        try {
            Student student1 = new Student(5020210256987L, "Popescu Diana",
                    new Adresa("Brasov", "Calea Bucuresti", "10", 3897),
                    1058, 2, new Disciplina[]{Disciplina.ALGEBRA, Disciplina.POO}, new int[]{9, 8});
//            System.out.println(student1);
            Student student2 = new Student(5020210256987L);
//            System.out.println(student1.equals(student2));

            Student clona = (Student) student1.clone();
            clona.getNote()[0] = 7;
            clona.getAdresa().setLocalitate("Alta localitate");
            clona.getDiscipline()[1] = Disciplina.CONTABILITATE;
//            System.out.println("Obiect clonat:\n" + student1);
//            System.out.println("Clona:\n" + clona);

            Profesor profesor = new Profesor(1671212458741L, "Popescu Ion",
                    new Adresa("Bucuresti", "Brasov", "16", 7896), "Statistica",
                    new Punctaj(85, 87, 56));
            Profesor clonaProfesor = (Profesor) profesor.clone();
            clonaProfesor.getPunctaj().setVizibilitate(100);
//            System.out.println("\n\n->>\n" + profesor);
//            System.out.println(clonaProfesor);

            Main app = new Main();
            app.citire("studenti.csv");
            app.print("Lista de studenti:");
            List<Student> listaStudenti = app.getStudenti();
            Collections.sort(listaStudenti);
            app.print("Studentii sortati dupa medie:");
            Collections.sort(listaStudenti,new ComparatorNume());
            app.print("Studentii sortati alfabetic:");

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
