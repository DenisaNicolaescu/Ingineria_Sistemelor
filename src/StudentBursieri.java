import java.util.Objects;

public class StudentBursieri extends Student{

    private double cuantumBursa;

    public StudentBursieri(int numarMatricol, String prenume, String nume, String formatieDeStudiu, float nota, double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursieri student = (StudentBursieri) o;
        return Double.compare(student.cuantumBursa, cuantumBursa) == 0;
    }

    public int hashCode(){
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    public String toString() {
        return super.toString() + ", Bursa-" + cuantumBursa;
    }
}
