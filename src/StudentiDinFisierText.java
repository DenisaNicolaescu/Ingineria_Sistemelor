import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements IStudentiImport{
    private String fileName;

    public StudentiDinFisierText(String fileName){
        this.fileName = fileName;
    }


    public List<Student> doImport() {
        List<Student> studentiCititi = new ArrayList();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String linie;
            while((linie = reader.readLine()) != null){
                String[] date = linie.split(",");
                if(date.length >= 5){
                    int numarMatricol = Integer.parseInt(date[0].trim());
                    String prenume = date[1].trim();
                    String nume = date[2].trim();
                    String formatieDeStudiu = date[3].trim();
                    double nota = Double.parseDouble(date[4].trim());

                    studentiCititi.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu, nota));
                }
            }
            System.out.println("Import text finalizat cu succes din: " +fileName);
        }catch(IOException | NumberFormatException e){
            System.err.println("Eroare la citirea din fisierul text: " + e.getMessage());
        }
        return studentiCititi;
    }
}
