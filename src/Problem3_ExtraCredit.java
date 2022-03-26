public class Problem3_ExtraCredit {
    private SingularLinkedList stack1;
    private SingularLinkedList stack2;

    // non-argument constructor
    public Problem3_ExtraCredit(){
        stack1=new SingularLinkedList();
        stack2=new SingularLinkedList();
    }

    // The Worst Case Complexity: O(n)
    public void enqueue(Object item){
        // put all the objects from stack1 to stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        // put the new object into the empty stack1
        stack1.push(item);

        // put everything in stack2 back to stack1 so that a WeirdQueue can be achieved
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    // The Worst Case Complexity: O(1)
    public Object dequeue(){
        //Error: the queue is empty (in fact, this will happen when the stack1 is empty)
        if(stack1.isEmpty()){
            System.out.println("Error: <the WeirdQueue is empty>");
            System.exit(0);
        }

        //get the head of the WeirdQueue by get the top value of the stack1
        return stack1.pop();
    }
}
