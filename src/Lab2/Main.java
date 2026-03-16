import Lab2.Student;

public static boolean existaStudent(List<Student> lista, Student sCautat) {
    for (Student s : lista) {
        if (s.prenume.equals(sCautat.prenume) && s.nume.equals(sCautat.nume) && s.formatieDeStudiu.equals(sCautat.formatieDeStudiu)) {
            return true;
        }
    }
    return false;
}

public static void main() {
    //Lab2.Student s1 = new Lab2.Student(586, "Victoria", "Roman", "ISM21/22");
    List<Student> studenti = new ArrayList<>();
    studenti.add(new Student(586, "Victoria", "Roman", "ISM21/2"));
    studenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
    studenti.add(new Student(112, "Maria", "Popa", "TI21/1"));

    System.out.println("Listade studenti:");
    for (Student s : studenti) {
        System.out.println(s);
    }

    Student s1=new Student(120, "Alis", "Popa", "TI21/2");
    Student s2=new Student(112, "Maria", "Popa", "TI21/1");

    System.out.println(
            existaStudent(studenti,s1) ? "Exista- Alis Popa de la TI21/2" : "Nu exista- Alis Popa de la TI21/2"
    );

    System.out.println(
            existaStudent(studenti,s2) ? "Exista- Maria Popa de la TI21/1" : "Nu exista- Maria Popa de la TI21/1"
    );


            //System.out.println(s1);

        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        Random rand=new Random();

        for(int i=0;i<5;i++){
            x.add(rand.nextInt(11));
        }

        for(int i=0;i<7;i++){
            y.add(rand.nextInt(11));
        }


        Collections.sort(x);
        System.out.println("x:" + x);
        Collections.sort(y);
        System.out.println("y:" + y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("xPlusY:" + xPlusY);

        zSet.addAll(x);
        zSet.retainAll(y);
        System.out.println("zSet:" + zSet);

        xMinusY.addAll(x);
        xMinusY.removeAll(y);
        System.out.println("xMinusY:" + xMinusY);

        Set<Integer> Set = new TreeSet<>();
        for (Integer val : xPlusY) {
            if (val <= p) {
                Set.add(val);
            }
        }
        xPlusYLimitedByP.addAll(Set);
        System.out.println("xPlusYLimitedByP:" + xPlusYLimitedByP);
}
