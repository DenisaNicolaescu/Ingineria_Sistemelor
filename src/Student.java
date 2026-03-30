import java.util.Objects;

public class Student {
   public int numarMatricol;
   public String prenume;
   public String nume;
   public String formatieDeStudiu;
   public float nota;


    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }
    public String getNume(){
        return nume;
    }
    public String getFormatie(){
        return formatieDeStudiu;
    }
    public float getNota(){
        return nota;
    }

//    public boolean equals(Object o){
//        if(this == o)return true;
//        if(o == null || getClass()!=o.getClass()) return false;
//        Student student = (Student) o;
//        return  Objects.equals(numarMatricol, student.numarMatricol) &&
//                Objects.equals(prenume, student.prenume) &&
//                Objects.equals(nume, student.nume) &&
//                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
//    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol;
    }

//    public int hashCode(){
//        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu);
//    }
    public int hashCode(){
        return Objects.hash(numarMatricol);
    }

    public String toString() {
        return "Student:" + "Nr. Matricol-" + " " + numarMatricol + " " + ",Nume-" + " " + nume + " "+ ",Prenume-"+ " " +prenume+ " " +",Grupa-"+ " "  +formatieDeStudiu + " " + ",Nota-" + nota;
    }

}