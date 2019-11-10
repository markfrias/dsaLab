package linear_structures;

import java.util.Scanner;

public class StringBST {

    public static void main(String[] args){
        // Instantiate a new Scanner object for accepting user input
        Scanner input = new Scanner(System.in);

        // Instantiate new Tree object
        Tree<String> stringTree = new Tree<String>();

        // Prompt user to enter a String
        System.out.print("Enter words: ");

        // Store string in a variable
        String words = input.nextLine();

        // Tokenize words and store in an array
        String[] arrayOfWords = words.split(" ");

        /*for (String word : arrayOfWords){
            System.out.println(word);
        } */

        // Inserts words to tree
        for (String word : arrayOfWords){
            stringTree.insertNode(word);
        }

        // Print tree in inorder
        System.out.print("Inorder traversal: ");
        stringTree.inorderTraversal();
        System.out.println();

        // Print tree in preorder
        System.out.print("Preorder traversal: ");
        stringTree.preorderTraversal();
        System.out.println();

        // Print tree in postorder
        System.out.print("Postorder traversal: ");
        stringTree.postorderTraversal();
        System.out.println();

    }



}
