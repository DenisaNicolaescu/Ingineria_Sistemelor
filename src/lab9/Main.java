package lab9;

import java.util.Random;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static void main() {
        Random random = new Random();

        List<Integer> numere = new Random().ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + numere);

        //a
        int suma = numere.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("a) Suma elementelor : " + suma);

        //b
        int max = numere.stream().max(Comparator.naturalOrder()).get();
        int min = numere.stream().min(Comparator.naturalOrder()).get();

        System.out.println("b) Max: " + max + ", Min: " + min);

        //c
        List<Integer> listaFiltrata = numere.stream()
                .filter(n-> n >= 10 && n<=20)
                .collect(Collectors.toList());

        System.out.println("c) Elemente între [10..20]: " + listaFiltrata);

        //d
        List<Double> listaDouble = numere.stream()
                .map(n-> Double.valueOf(n))
                .collect(Collectors.toList());

        System.out.println("d) Lista ca Double: " + listaDouble);

        //e
        boolean gasit = numere.stream()
                .anyMatch(n -> n == 12);

        System.out.println(("e) Se gaseste valoarea 12? " + (gasit ? "Da" : "Nu")));

        System.out.println();

        //2
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        //a
        List<String> cuvinteLungi = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >=5)
                .collect(Collectors.toList());

        long numarCuvinteLungi = cuvinteLungi.size();
        System.out.println("a) Lista filtrată (lungime >= 5): " + cuvinteLungi);
        System.out.println("   Numărul de cuvinte lungi: " + numarCuvinteLungi);

        //b
        List<String> cuvinteOrdonate = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("b) Lista ordonată alfabetic: " + cuvinteOrdonate);

        //c
        Optional<String> cuvantCuP = cuvinte.stream()
                .filter(cuvant -> cuvant.startsWith("p"))
                .findFirst();

        if (cuvantCuP.isPresent()) {
            System.out.println("c) Un element care începe cu 'p': " + cuvantCuP.get());
        } else {
            System.out.println("c) Nu s-a găsit niciun cuvânt care să înceapă cu 'p'.");
        }
    }
}
