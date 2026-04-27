import java.util.Objects;

public class StudentImutabil {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final float nota;


    public StudentImutabil(int nrMatricol, String prenume, String nume, String formatieDeStudiu, float nota){
        this.numarMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public int getNumarMatricol(){return numarMatricol;}
    public String getPrenume(){return prenume;}
    public String getNume(){return nume;}
    public String getFormatie(){return formatieDeStudiu;}
    public float getNota(){return nota;}

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        StudentImutabil student = (StudentImutabil) o;
        return numarMatricol == student.numarMatricol;
    }

    public int hashCode(){
        return Objects.hash(numarMatricol);
    }

    public String toString() {
        return "Student: Nr. Matricol- " + numarMatricol + ", Nume- " + nume + ", Prenume- " + prenume + ", Grupa- " + formatieDeStudiu + ", Nota- " + nota;
    }
}
