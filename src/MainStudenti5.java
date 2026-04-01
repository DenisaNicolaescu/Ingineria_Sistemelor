import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainStudenti5 {
    static void main() {
        List<StudentBursieri> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10f, 780.80));

        salveazaInFisier("bursieri_out.txt", bursieri);
    }


    public static void salveazaInFisier(String numeFisier, List<? extends Student> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            for (Student s : lista) {
                String linie = s.toString();
                writer.write(linie);
                writer.newLine();
                System.out.println(linie);
            }
            System.out.println("Datele au fost scrise în " + numeFisier);
        } catch (IOException e) {
            System.err.println("Eroare la scriere: " + e.getMessage());
        }
    }
}
