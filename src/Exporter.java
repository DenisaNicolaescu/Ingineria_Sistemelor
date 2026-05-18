import java.util.List;

public class Exporter {
    public void startExport(IStudentiExport strategy, List<Student> students){
        strategy.doExport(students);
    }
}
