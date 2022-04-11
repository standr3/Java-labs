package seminar.seminar5.g1058;

import seminar.seminar2.g1058.Student;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try{
            seminar.seminar2.g1058.Main mainS2 = new seminar.seminar2.g1058.Main();
            mainS2.citire("studenti.csv");
//            mainS2.print("Lista studenti:");

            List<Student> studenti = mainS2.getStudenti();
            System.out.println("Lista initiala:");
//            studenti.forEach(new Consumer<Student>() {
//                @Override
//                public void accept(Student student) {
//                    System.out.println(student);
//                }
//            });
//            studenti.forEach( student -> System.out.println(student) );
            studenti.forEach( System.out::println );

//            Cerinta 1
            List<Student> grupa1058 = studenti.stream().filter(new Predicate<Student>() {
                @Override
                public boolean test(Student student) {
                    return student.getGrupa()==1058;
                }
            }).collect(Collectors.toList());
            System.out.println("Grupa 1058:");
            grupa1058.forEach(System.out::println);

//            Cerinta 2
            List<Student> listaMedii_5_7 = studenti.stream()
                    .filter( student -> student.medie()>=5&&student.medie()<=7 )
                    .collect(Collectors.toList());
            System.out.println("Studenti cu medii intre 5 si 7:");
            listaMedii_5_7.forEach(System.out::println);

//            Cerinta 3
            List<Student> promovati = studenti.stream()
                    .filter( Student::evaluare ).collect(Collectors.toList());
            System.out.println("Studenti promovati");
            promovati.forEach(System.out::println);

//            Cerinta 4
            List<Student> studentiSort = studenti.stream()
                    .sorted( (student1,student2)-> Double.compare(student1.medie(),student2.medie()) )
                    .collect(Collectors.toList());
            System.out.println("Lista studentilor sortati dupa medie:");
            studentiSort.forEach(System.out::println);

        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }
}
