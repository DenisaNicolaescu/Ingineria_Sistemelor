public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String formatieDeStudiu;


    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }


    public String toString() {
        return "Student:" + "Nr. Matricol-" + " "+ numarMatricol +" " + "Nume-" +" " + nume + " "+ "Prenume-"+" "+prenume+" "+"Grupa-"+" "+formatieDeStudiu;
    }

}