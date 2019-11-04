package linear_structures;

public class Stack<T> {
    private List<T> stackList;

    public Stack(){
        stackList = new List<T>("stack");
    }

    public void push(T object){
        stackList.insertAtFront(object);
    }

    public T pop() throws EmptyListException{
        return stackList.removeFromFront();
    }

    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    public void print(){
        stackList.print();
    }

    public T peek() throws EmptyListException{
        return stackList.getFirst();
    }
}
