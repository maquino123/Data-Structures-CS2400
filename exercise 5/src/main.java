public class main{
    public static void main(String[] args){
        LinkedDeque<Integer> test = new LinkedDeque();

        test.addToFront(5);
        test.addToBack(65);
        test.addToFront(34);
        test.addToBack(97);
        test.addToFront(32);
        test.addToBack(76);
        test.clear();
        System.out.println(test.isEmpty());


    }
}