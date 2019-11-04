package linear_structures;


public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.insertAtFront(-1);
        list.print();
        list.insertAtBack(5);
        list.insertAtFront(1);
        list.print();
    }



}
