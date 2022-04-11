package seminar.seminar2.g1058;

public class Main {
    public static void main(String[] args) {
        try {
            Student student1 = new Student(5020210256987L, "Popescu Diana",
                    new Adresa("Brasov", "Calea Bucuresti", "10", 3897),
                    1058, 2, new Disciplina[]{Disciplina.ALGEBRA, Disciplina.POO}, new int[]{9, 8});
            System.out.println(student1);
            Student student2 = new Student(5020210256987L);
            System.out.println(student1.equals(student2));
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }
}
