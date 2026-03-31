import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MainStudenti4 {
    static void main() {

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

}
