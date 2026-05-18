import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport{
    private String fileName;

    public StudentiInFisierText(String fileName){
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti){
        try(PrintWriter writer = new PrintWriter(fileName)){
            for(Student s : studenti){
                writer.println(s.getNrMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatie() + "," + s.getNota());
            }
            System.out.println("Export text finalizat in: " + fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
