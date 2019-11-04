package linear_structures;

import java.util.Scanner;

// Tolerate static methods for now, but change before finalizing and submitting
public class InfixToPostfixConverter {
    public static void main(String[] args) {
        StringBuffer infix = new StringBuffer();
        StringBuffer postfix = new StringBuffer();
        Stack<Character> stackHelp = new Stack<>();
        Scanner stdInput = new Scanner(System.in);

        // Prompt user to enter expression
        System.out.print("Enter a mathematical expression");

        // Store user input
        String input = stdInput.nextLine();
        infix.append(input);
        System.out.println("String length is : " + infix.length());
        System.out.println(convertToPostfix(infix, postfix, stackHelp));


    }

    public static StringBuffer convertToPostfix(StringBuffer infix, StringBuffer postfix, Stack<Character> stack){
        // Procedures on stack and other stuff
        stack.push('(');
        stack.print();
        infix.append(')');
        System.out.println(infix.length());
        System.out.println(infix);

        while (!stack.isEmpty()) {
            //System.out.println("Not empty");
            for (int index = 0; index < infix.length(); index++) {
                System.out.println("Infix length is: " + infix.length());
                System.out.println(index);
                stack.print();
                if (infix.charAt(index) >= '0' && infix.charAt(index) <= '9') {
                    postfix.append(infix.charAt(index));
                    System.out.println("Digit this is");
                } else if (infix.charAt(index) == '('){
                    stack.push(infix.charAt(index));
                } else if (isOperator(infix.charAt(index))){
                    if (isOperator(stack.peek()) && precedence(infix.charAt(index), stack.peek())){
                        postfix.append(stack.pop());
                        while (isOperator(stack.peek()) && precedence(infix.charAt(index), stack.peek())){
                            postfix.append(stack.pop());
                        }

                    }
                        stack.push(infix.charAt(index));
                } else if (infix.charAt(index) == ')'){
                    while (stack.peek() != '('){
                        postfix.append(stack.pop());
                    }
                    stack.pop();
                }
            }

        }

        return postfix;
    }

    public static boolean isOperator(char value){
        switch (value){
            case '+':
            case '-':
            case '*':
            case '/':
            case '%':
            case '^':
                return true;
            default:
                return false;
        }
    }

    public static boolean precedence(char operator1, char operator2){
        if (operator1 == '^'){
            return false;
        } else if (operator1 == '*' || operator1 == '/' || operator1 == '%'){
            if (operator2 == '^')
                return true;
            else
                return false;
        } else{
            if (operator2 != '+' || operator2 != '-')
                return true;
            else
                return false;
        }
    }


}
