// This object class is used in the extra credit problem (LinkedList implementation)
public class SingularLinkedList {
    private class Node {
        Object data;
        Node next;
    }
    Node top;

    // constructor
    public SingularLinkedList() {
        top=null;
    }

    // push a new item to the top of the stack
    public void push(Object item) // insert at the beginning
    {
        Node temp = new Node();
        //Error check: if we use LinkedList to implement stack, stack overflow will only happen when we run off the space memory of computer.
        if (temp == null) {
            System.out.println("Stack Overflow");
            System.exit(0);
        }
        temp.data = item;
        temp.next = top;
        top = temp;
    }

    // check whether the stack is empty
    public boolean isEmpty()
    {
        return (top == null);
    }

    //pop the top value from the stack. Return an Object type
    public Object pop(){
        // Error: stack underflow check
        if (top == null) {
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        Object tempData=top.data;
        top = top.next;
        return tempData;
    }
}
