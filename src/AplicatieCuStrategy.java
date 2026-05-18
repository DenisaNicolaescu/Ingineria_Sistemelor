import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    static void main() {

        List<Student> studenti = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1", 10),
                new Student(1029,"Maria","Pana","TI131/2", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2", 2.22)
        );

        Exporter exporter = new Exporter();
        Importer importer = new Importer();

        //a
        exporter.startExport(new StudentiInConsola(), studenti);

        System.out.println();
        //b
        exporter.startExport(new StudentiInFisierText("studenti.txt"), studenti);

        System.out.println();
        //c
        exporter.startExport(new StudentiInFisierXlsx("studenti.xlsx"), studenti);

        System.out.println();
        //d
        List<Student> studentiDinText = importer.startImport(new StudentiDinFisierText("studenti.txt"));
        System.out.println("Studenti incarcati din TXT: " + studentiDinText.size());
        System.out.println();

        //e
        List<Student> studentiDinExcel = importer.startImport(new StudentiDinFisierXlsx("studenti.xlsx"));
        System.out.println("Studenti incarcati din XLSX: " + studentiDinExcel.size());
    }

}

