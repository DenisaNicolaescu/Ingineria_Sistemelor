

    public static void main() {
            Student s1 = new Student(586, "Victoria", "Roman", "ISM/22");

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
