package linear_structures;

class TreeNode<T extends Comparable<T>>{

    // Package access members
    TreeNode<T> leftNode;
    T data;
    TreeNode<T> rightNode;

    // Constructor initializes data and makes this a leaf node
    public TreeNode(T nodeData){
        data = nodeData;
        leftNode = rightNode = null;
    }

    public void insert(T insertValue){
        if (insertValue.compareTo(data) < 0){
            if (leftNode == null)
                leftNode = new TreeNode<T>(insertValue);
            else
                leftNode.insert(insertValue);

        } else if (insertValue.compareTo(data) > 0){
            if (rightNode == null)
                rightNode = new TreeNode<T>(insertValue);
            else
                rightNode.insert(insertValue);
        }
    }
}


// Tree class definition
public class Tree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int spaces = 0;

    public Tree(){
        root = null;
    }

    public void insertNode(T insertValue){
        if (root == null)
            root = new TreeNode<T>(insertValue);
        else
            root.insert(insertValue);

    }

    public void preorderTraversal(){
        preorderHelper(root);
    }

    private void preorderHelper(TreeNode<T> node){
        if (node == null)
            return;

        System.out.printf("%s ", node.data);
        preorderHelper(node.leftNode);
        preorderHelper(node.rightNode);
    }

    public void inorderTraversal(){
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode<T> node){
        if (node == null)
            return;

        inorderHelper(node.leftNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode);
    }

    public void postorderTraversal(){
        postorderHelper(root);
    }

    private void postorderHelper(TreeNode<T> node){
        if (node == null)
            return;
        postorderHelper(node.leftNode);
        postorderHelper(node.rightNode);
        System.out.printf("%s ", node.data);
    }

    public void outputTree(int totalSpaces, TreeNode<T> node){
        if (node == null)
            return;

        outputTree(totalSpaces + 5, node.rightNode);

        for (int i = 1; i <= totalSpaces; i++){
            System.out.print(" ");
        }

        System.out.println(node.data);

        node = node.leftNode;

        totalSpaces += 5;


        outputTree(totalSpaces, node);





    }

    public TreeNode<T> getRoot(){
        return this.root;
    }

}
