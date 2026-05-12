import java.util.List;

public class StudentiInConsola implements IStudentiExport{

    public void doExport(List<Student> studenti){
        System.out.println(" Lista Studenti: ");
        for(Student s: studenti){
            System.out.println(s);
        }
    }

}
