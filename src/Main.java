

public class Main {


    public static void main(String[] args) {

        ImplementationOfQueue<Integer> myImplement = new ImplementationOfQueue<>();


        /* test Object offer(Object object) method */
        myImplement.offer(49);
        myImplement.offer(50);
        myImplement.offer(51);
        myImplement.offer(52);
        myImplement.offer(53);
        System.out.println(myImplement.toString());



        /* test Object add(Object object) method */
        myImplement.add(22);
        myImplement.add(77);
        System.out.println(myImplement.toString());

        /* test Object remove() method */
//        myImplement.remove();
//        myImplement.remove();
//        myImplement.remove();
//        myImplement.remove();
//        myImplement.remove();
//        System.out.println(myImplement.toString());

        /* test Object peek() method */
        System.out.println(myImplement.peek());
        System.out.println();

        /* test boolean contains(Object obj) method */
//        System.out.println(myImplement.contains(49));
//        System.out.println(myImplement.contains(50));
//        System.out.println(myImplement.contains(53));
//        System.out.println(myImplement.contains(9999));


        /* test Object[] toArray() method */
        Object [] myarr = myImplement.toArray();
        for (Object nod: myarr) {
            System.out.println(nod);
        }

        /* test Object[] toArray(Object[] a) method */
//        Object [] a = new Object[myImplement.size()];
//        myImplement.toArray(a);
//        for (Object nod: a) {
//            System.out.println(nod);
//        }

        /* test boolean remove(Object o) method */
//        myImplement.remove(52);
//        System.out.println(myImplement.toString());

        /* test addAll(Collection collection) */
//        List<Integer> myList = new ArrayList<>();
//        myList.add(100);
//        myList.add(200);
//        myList.add(300);
//        myImplement.addAll(myList);
//        for (Object nod: myImplement) {
//            System.out.println(nod);
//        }

        /* test clear() method */
//        myImplement.clear();
//        System.out.println("My Queue :" + myImplement.toString());

        /* test retainAll(Collection collection) */
//        List<Integer> myList = new ArrayList<>();
//        myList.add(49);
//        myList.add(52);
//        myImplement.retainAll(myList);
//        for (Object nod: myImplement) {
//            System.out.println(nod);
//        }

        /* test removeAll(Collection collection) */
//        List<Integer> myList = new ArrayList<>();
//        myList.add(49);
//        myList.add(52);
//        myImplement.removeAll(myList);
//        for (Object nod: myImplement) {
//            System.out.println(nod);
//        }

        /* test containsAll(Collection collection) */
//        List<Integer> myList = new ArrayList<>();
//        myList.add(49);
//        myList.add(52);
////        myList.add(500);
//        System.out.println(myImplement.containsAll(myList));


    }

}
