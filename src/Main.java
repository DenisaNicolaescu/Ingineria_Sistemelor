import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//public static boolean existaStudent(List<Student> lista, Student sCautat) {
//    for (Student s : lista) {
//        if (s.prenume.equals(sCautat.prenume) && s.nume.equals(sCautat.nume) && s.formatieDeStudiu.equals(sCautat.formatieDeStudiu)) {
//            return true;
//        }
//    }
//    return false;
//}

public static void main() {
    //Student s1 = new Student(586, "Victoria", "Roman", "ISM21/22");
//    List<Student> studenti = new ArrayList<>();
//    studenti.add(new Student(586, "Victoria", "Roman", "ISM21/2"));
//    studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
//    studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
//
//    System.out.println("Listade studenti:");
//    for (Student s : studenti) {
//        System.out.println(s);
//    }
//
//    Student s1=new Student(120, "Alis", "Popa", "TI21/2");
//    Student s2=new Student(112, "Maria", "Popa", "TI21/1");

//    System.out.println(
//            existaStudent(studenti,s1) ? "Exista- Alis Popa de la TI21/2" : "Nu exista- Alis Popa de la TI21/2"
//    );
//
//    System.out.println(
//            existaStudent(studenti,s2) ? "Exista- Maria Popa de la TI21/1" : "Nu exista- Maria Popa de la TI21/1"
//    );


            //System.out.println(s1);


    Set<Student> studenti = new HashSet<>();
    studenti.add(new Student(586, "Victoria", "Roman", "ISM21/2"));
    studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
    studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));

    Student s1=new Student(120, "Alis", "Popa", "TI21/2");
    Student s2=new Student(112, "Maria", "Popa", "TI21/1");


        System.out.println(" Studentul Alis Popa exista? " + studenti.contains(s1));
        System.out.println(" Studentul Maria Popa exista? " + studenti.contains(s2));


    // 3.5.2
    Path inputPath = Paths.get("studenti_in.txt");
    Path outPath = Paths.get("studenti_out_sorted.txt");

    try{
        List<String> lines = Files.readAllLines(inputPath);
        List<Student> listaStudenti = new ArrayList<>();

        for(String line : lines){
            if(line.trim().isEmpty()) continue;

            String[] date = line.split(",");
            int numarMatricol = Integer.parseInt(date[0].trim());// converteste textul in nr
            String prenume = date[1].trim();
            String nume = date[2].trim();
            String formatieDeStudiu = date[3].trim();

            listaStudenti.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu));
        }

        System.out.println("Studentii cititi din fisier: ");
        for(Student s : listaStudenti){
            System.out.println(s);
        }

//        Collections.sort(listaStudenti, new Comparator<Student>(){
//            public int compare(Student s1, Student s2){
//                return s1.nume.compareTo(s2.nume);
//            }
//        });
//
//        List<String> liniiDeSalvat = new ArrayList<>();
//        for(Student s : listaStudenti){
//            liniiDeSalvat.add(s.toString());
//        }
//        Files.write(outPath, liniiDeSalvat);
//    }catch(IOException e){
//        System.err.println("Eroare la manipularea fisierelor: " + e.getMessage());
//    }

        Collections.sort(listaStudenti, new Comparator<Student>(){
            public int compare(Student s1, Student s2){
               int compGrupa = s1.formatieDeStudiu.compareTo(s2.formatieDeStudiu);
               if(compGrupa != 0){
                   return compGrupa;
               }
               return s1.nume.compareTo(s2.nume);
            }
        });

        List<String> DeSalvat = new ArrayList<>();
        for(Student s : listaStudenti){
            DeSalvat.add(s.toString());
        }
        Files.write(outPath, DeSalvat);
    }catch(IOException e){
        System.err.println("Eroare la manipularea fisierelor: " + e.getMessage());
    }
}
