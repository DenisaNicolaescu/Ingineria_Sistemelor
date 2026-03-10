

    public static void main() {
            Student s1 = new Student(586, "Victoria", "Roman", 22);

            System.out.println(s1);

        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(x); //a
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
        System.out.println(x);
        Collections.sort(y);
        System.out.println(y);

        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println(xPlusY);


}
