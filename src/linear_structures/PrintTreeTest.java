package linear_structures;

public class PrintTreeTest {
    public static void main(String[] args){
        Tree<Integer> tree = new Tree<>();

        tree.insertNode(2);
        tree.insertNode(3);
        tree.insertNode(7);
        tree.insertNode(21);
        tree.insertNode(9);






        tree.outputTree(1, tree.getRoot());

    }
}
