public class Main{
    public static void main(String[] args){
        LinkedBag<String> bag = new LinkedBag<String>();
        bag.add("This is item 1");
        bag.add("Item 2");
        bag.add("Item 3");
        bag.add("Item 4");
        bag.add("Item 3");

        bag.remove("Item 3");

        Object[] obj = bag.toArray();

        for(Object o: obj){
            System.out.println(o.toString());
        }

    }
}