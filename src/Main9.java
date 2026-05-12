import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class Main9 {
    static void main() {

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1,", 10),
                new Student(1029,"Maria","Pana","TI131/2,", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2,", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2,", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1,", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2,", 2.22)
        );

        //a
        System.out.println("a) Studentii cu nota 10: ");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(System.out::println);// .forEach(s -> System.out.println(s))

        System.out.println();

        //b
        System.out.println("b) Studenții cu nota sub 5:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(System.out::println);

        System.out.println();

        //c
        List<Student> studentiModificati = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4){
                        s.setNota(4.0);
                    }
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("\nc) Lista după aplicarea notei minime de 4: " + studentiModificati);
        studentiModificati.forEach(System.out::println);
        System.out.println();
        studentiCuNote.forEach(System.out::println);

        System.out.println();

        //d
        double sumaNote = studentiCuNote.stream()
                .map(Student::getNota) //.map(s -> s.getNota())
                .reduce(0.0, Double::sum); //.reduce(0.0, (a,b) -> a + b)
        System.out.println("d) Suma notelor: " + sumaNote);

        System.out.println();

        //e
        double media = sumaNote / studentiCuNote.size();
        System.out.println("e) Media notelor: " + media);

        /*OptionalDouble media = studentiCuNote.stream()
                .mapToDouble(Student::getNota)
                .average();
                //.orElse(0.0);
        if (media.isPresent()) {
            System.out.println("Media este: " + media.getAsDouble());
        } else {
            System.out.println("Nu s-a putut calcula media.");
        }*/


    }
}
