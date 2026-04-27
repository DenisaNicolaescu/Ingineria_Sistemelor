import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MainStudentiImutabili {

    public static StudentImutabil schimbaFormatia(StudentImutabil st, String nouaFormatieDeStudiu){
        return new StudentImutabil(st.getNumarMatricol(),st.getPrenume(), st.getNume(), nouaFormatieDeStudiu, st.getNota());
    }

    static Set<StudentImutabil> imparteInDouaFormatii(Set<StudentImutabil>studenti, String formatia1, String formatia2){
        List<StudentImutabil> lista = new ArrayList<>(studenti);
        Set<StudentImutabil> rezultat = new LinkedHashSet<>();

        int mijloc = (lista.size() + 1) / 2;

        for (int i = 0; i < lista.size(); i++) {
            String grupaNoua = (i < mijloc) ? formatia1 : formatia2;
            rezultat.add(schimbaFormatia(lista.get(i), grupaNoua));
        }
        return rezultat;
    }
    public static void main(String[] args){
        Set<StudentImutabil> listaInitiala = new LinkedHashSet<>();
        listaInitiala.add(new StudentImutabil(1025, "Andrei", "Popa", "ISM141/2", 8.7f));
        listaInitiala.add(new StudentImutabil(1024, "Ioan", "Mihalcea", "ISM141/1", 9.8f));
        listaInitiala.add(new StudentImutabil(1026, "Anamaria", "Prodan", "TI131/1", 8.9f));
        listaInitiala.add(new StudentImutabil(1029, "Bianca", "Popescu", "TI131/1", 9.1f));

        System.out.println(" Lista dupa impartire ");

        Set<StudentImutabil> listaRepartizata = imparteInDouaFormatii(listaInitiala, "TI 211_1", "TI 211_2");

        for (StudentImutabil s : listaRepartizata) {
            System.out.println(s);
        }
    }


}
