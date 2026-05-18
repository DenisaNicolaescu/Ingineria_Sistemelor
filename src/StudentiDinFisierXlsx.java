import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements IStudentiImport {
    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> doImport() {
        List<Student> studentiCititi = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            System.err.println("Fisierul Excel nu exista: " + fileName);
            return studentiCititi;
        }

        try(FileInputStream fileIn = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fileIn)){

            Sheet sheet = workbook.getSheetAt(0);
            for(int i = 1; i<= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);

                if (row == null) {
                    continue;
                }
                int numarMatricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String formatieDeStudiu = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();

                Student student = new Student(numarMatricol, prenume, nume, formatieDeStudiu, nota);
                studentiCititi.add(student);
            }
            System.out.println("Importul Excel a fost finalizat cu succes din: " + fileName);
        }catch(IOException e){
            System.err.println("Eroare la citirea fisierului Excel: " + e.getMessage());
            e.printStackTrace();
        }catch(NullPointerException e){
            System.err.println("Eroare: Structura fisierului Excel nu este cea asteptata (celule goale).");
            e.printStackTrace();
        }
        return studentiCititi;
    }
}