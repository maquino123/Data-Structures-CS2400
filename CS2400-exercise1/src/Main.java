
public class Main {
    public static void main(String[] args) {
	    BagInterface<Integer> bg = new ArrayBag<>();

        bg.add(9);
        bg.add(8);
        bg.add(7);
        bg.add(45);
        bg.add(7);
        bg.add(10);
        bg.add(10);
        bg.add(10);



        System.out.println(bg.getCurrentSize());
        System.out.println(bg.isEmpty());
        bg.clear();
        System.out.println(bg.getCurrentSize());
        System.out.println(bg.getFrequencyOf(10));
        System.out.println(bg.contains(45));
        System.out.println(bg.contains(0));




        Object[] objs = bg.toArray();

        for (Object o: objs){
            System.out.println(((Integer) o).toString());
        }
}
}