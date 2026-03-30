import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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


//    Set<Student> studenti = new HashSet<>();
//    studenti.add(new Student(586, "Victoria", "Roman", "ISM21/2"));
//    studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
//    studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
//
//    Student s1=new Student(120, "Alis", "Popa", "TI21/2");
//    Student s2=new Student(112, "Maria", "Popa", "TI21/1");
//
//
//        System.out.println(" Studentul Alis Popa exista? " + studenti.contains(s1));
//        System.out.println(" Studentul Maria Popa exista? " + studenti.contains(s2));
//

    // 3.5.2/3.5.3
//    Path inputPath = Paths.get("studenti_in.txt");
//    Path outPath = Paths.get("studenti_out_sorted.txt");
//
//    try {
//        List<String> lines = Files.readAllLines(inputPath);
//        List<Student> listaStudenti = new ArrayList<>();
//
//        for (String line : lines) {
//            if (line.trim().isEmpty()) continue;
//
//            String[] date = line.split(",");
//            int numarMatricol = Integer.parseInt(date[0].trim());// converteste textul in nr
//            String prenume = date[1].trim();
//            String nume = date[2].trim();
//            String formatieDeStudiu = date[3].trim();
//
//            listaStudenti.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu));
//        }
//
//        System.out.println("Studentii cititi din fisier: ");
//        for (Student s : listaStudenti) {
//            System.out.println(s);
//        }

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

//        Collections.sort(listaStudenti, new Comparator<Student>(){
//            public int compare(Student s1, Student s2){
//               int compGrupa = s1.formatieDeStudiu.compareTo(s2.formatieDeStudiu);
//               if(compGrupa != 0){
//                   return compGrupa;
//               }
//               return s1.nume.compareTo(s2.nume);
//            }
//        });// acelasi lucru cu *1
//
//        listaStudenti.sort(
//                Comparator.comparing(Student::getFormatie).thenComparing(Student::getNume)
//        );//*1
//
//        List<String> DeSalvat = new ArrayList<>();
//        for(Student s : listaStudenti){
//            DeSalvat.add(s.toString());
//        }
//        Files.write(outPath, DeSalvat);
//    }catch(IOException e){
//        System.err.println("Eroare la manipularea fisierelor: " + e.getMessage());
//    }
//}
    //}

    //4.5.2
    HashMap<Integer, Student> studentiMap = new HashMap<>();

    try{
        File fisierStudenti = new File("studenti_in.txt");
        Scanner scStudenti = new Scanner(fisierStudenti);

        while(scStudenti.hasNextLine()){
            String linie = scStudenti.nextLine();
            if (linie.trim().isEmpty()) continue;

            String[] date = linie.split(",");

            int nrMatricol = Integer.parseInt(date[0].trim());
            String prenume = date[1].trim();
            String nume = date[2].trim();
            String grupa = date[3].trim();

            Student s = new Student(nrMatricol, prenume, nume, grupa);
            studentiMap.put(nrMatricol, s);
        }
        scStudenti.close();

       File fisierNote = new File("note_anon.txt");
       Scanner scNote = new Scanner(fisierNote);

       while(scNote.hasNextLine()){
           String linie = scNote.nextLine();
           if (linie.trim().isEmpty()) continue;

           String[] dateNote = linie.split(",");
           int nrMatricolNote = Integer.parseInt(dateNote[0].trim());
           float valoareNota = Float.parseFloat(dateNote[1].trim());

           Student s = studentiMap.get(nrMatricolNote);
           if(s != null){
               s.setNota(valoareNota);
           }
       }
       scNote.close();

       System.out.println("Rezultate finale: ");
       for(Student s : studentiMap.values()){
           System.out.println(s);
       }

    } catch (FileNotFoundException e){
        System.out.println("Eroare: Fisierul nu a fost gasit.");
        e.printStackTrace();
    }

    float notaM = gasesteNota("Bianca", "Popescu", studentiMap);
    float notaN = gasesteNota("Ioan", "Popa", studentiMap);

    System.out.println("Nota pentru Bianca Popescu: " + notaM);
    System.out.println("Nota pentru Ioan Popa: " + notaM);
}

public static float gasesteNota(String prenume, String nume, HashMap<Integer, Student> tineri){
    HashMap<String, Student> mapAuxiliar = new HashMap<>();
    for(Student s : tineri.values()){
        String cheieIdentificare = s.prenume + "-" + s.nume;
        mapAuxiliar.put(cheieIdentificare, s);
    }

    String cheieCautata = prenume + "-" + nume;
    Student studentGasit = mapAuxiliar.get(cheieCautata);

    if(studentGasit !=null){
        return studentGasit.getNota();
    }
    return 0.0f;
}
