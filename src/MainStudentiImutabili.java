import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import static org.apache.poi.ss.usermodel.CellType.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class MainStudentiImutabili {

    public static StudentImutabil schimbaFormatia(StudentImutabil st, String nouaFormatieDeStudiu){
        return new StudentImutabil(st.getNumarMatricol(),st.getPrenume(), st.getNume(), nouaFormatieDeStudiu, st.getNota());
    }

    static Set<StudentImutabil> imparteInDouaFormatii(Set<StudentImutabil>studenti, String formatia1, String formatia2){
        List<StudentImutabil> lista = new ArrayList<>(studenti);
        Set<StudentImutabil> rezultat = new LinkedHashSet<>();

        int mijloc = (lista.size() + 1) / 2;

        for (int i = 0; i < lista.size(); i++) {
            String grupaNoua = (i < mijloc) ? formatia1 : formatia2;
            rezultat.add(schimbaFormatia(lista.get(i), grupaNoua));
        }
        return rezultat;
    }

    public static void exportaStudenti(Set<StudentImutabil> studenti, String numeFisier) {
        try (Workbook workbook = new HSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream(numeFisier)) {

            Sheet sheet = workbook.createSheet("Studenti");
            int rowNum = 0;


            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("Nr Matricol");
            headerRow.createCell(1).setCellValue("Nume");
            headerRow.createCell(2).setCellValue("Prenume");
            headerRow.createCell(3).setCellValue("Grupa");
            headerRow.createCell(4).setCellValue("Nota");


            for (StudentImutabil st : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(st.getNumarMatricol());
                row.createCell(1).setCellValue(st.getNume());
                row.createCell(2).setCellValue(st.getPrenume());
                row.createCell(3).setCellValue(st.getFormatie());
                row.createCell(4).setCellValue(st.getNota());
            }

            workbook.write(fileOut);
            System.out.println("Fisierul " + numeFisier + " a fost generat cu succes!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<StudentImutabil> citesteStudenti(String numeFisier) {
        Set<StudentImutabil> studentiCititi = new LinkedHashSet<>();

        try (FileInputStream fis = new FileInputStream(new File(numeFisier));
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                int nrMatricol = (int) row.getCell(0).getNumericCellValue();
                String nume = row.getCell(1).getStringCellValue();
                String prenume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();
                float nota = (float) row.getCell(4).getNumericCellValue();

                studentiCititi.add(new StudentImutabil(nrMatricol, prenume, nume, grupa, nota));
            }

        } catch (IOException e) {
            System.err.println("Eroare la citire: " + e.getMessage());
        }
        return studentiCititi;
    }


    public static void main(String[] args){
        Set<StudentImutabil> listaInitiala = new LinkedHashSet<>();
        listaInitiala.add(new StudentImutabil(1025, "Andrei", "Popa", "ISM141/2", 8.7f));
        listaInitiala.add(new StudentImutabil(1024, "Ioan", "Mihalcea", "ISM141/1", 9.8f));
        listaInitiala.add(new StudentImutabil(1026, "Anamaria", "Prodan", "TI131/1", 8.9f));
        listaInitiala.add(new StudentImutabil(1029, "Bianca", "Popescu", "TI131/1", 9.1f));

        System.out.println(" Lista dupa impartire ");

        Set<StudentImutabil> listaRepartizata = imparteInDouaFormatii(listaInitiala, "TI 211_1", "TI 211_2");

        for (StudentImutabil s : listaRepartizata) {
            System.out.println(s);
        }

        String fisierXls = "laborator8_students.xls";
        exportaStudenti(listaInitiala, fisierXls);

        System.out.println(" Studenti cititi din fisierul .xls ");
        Set<StudentImutabil> listaDinFisier = citesteStudenti(fisierXls);
        for (StudentImutabil s : listaDinFisier) {
            System.out.println(s);
        }

    }


}
