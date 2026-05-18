import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName){
        this.fileName = fileName;
    }

    public void doExport(List<Student> studenti){
        System.out.println("Export XLSX in: " + fileName);
    }
}
