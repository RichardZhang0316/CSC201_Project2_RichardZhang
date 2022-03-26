public class DLinkedList implements MyList {
    // The main class is used to check the correctness of the program
    public static void main(String[] args) {
        DLinkedList test=new DLinkedList();
        test.append(1);
        test.append(10);
        test.append(60);
        test.displayForward();
        test.insert(0,70);
        test.insert(0,90);
        test.append(100);
        System.out.println("the list is empty? "+test.isEmpty());
        test.displayForward();
        System.out.println(test.size());
        test.replace(1,99);
        test.displayForward();
        System.out.println(test.get(3));
        test.remove(3);
        test.displayForward();
        test.clear();
        System.out.println("the list is empty? "+test.isEmpty());
        test.displayForward();
    }
    private int size=0;
    private Node head=null; // The head of the LinkedList
    private Node tail=null; // The tail of the LinkedList

    private class Node{
        // Set the following two Nodes to be null by default
        Node prev;
        Node next;
        Object data; // Generic Object type

        // Constructor
        private Node(Object d){
            data=d;
        }
        private Node(){}
        private Object getData(){
            return data;
        }
    }

    // Check whether a given index is within the boundary
    // The Worst Case Complexity: O(1)
    private boolean isValidIndex(int index){
        return (index >= 0 && index <= size);
    }

    //insert 'item' at 'index'
    // The Worst Case Complexity: O(n)
    public boolean insert(int index, Object item){
        // error: the given index is out of boundary of the LinkedList
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("Error: <Index "+index+" is not valid for a linked list of size "+size+">");
        }
        Node newNode=new Node(item);
        Node trailer=head;
        // insert at the head of the LinkedList
        if(index==0){
            // if the LinkedList is empty, then the head and tail will both point to the new Node
            if(isEmpty()){
                tail=newNode;
            }
            else{
                head.prev=newNode;
            }
            newNode.next=head;
            head=newNode;
            size++;
        }
        // insert at the end of the LinkedList
        else if(index==size){
            append(item);
        }
        // insert at the middle of the LinkedList
        else{
            for(int i=0;i<index && trailer.next!=null;i++){
                trailer=trailer.next;
            }
            //rearrange the index
            newNode.next=trailer;
            trailer.prev.next=newNode;
            newNode.prev=trailer.prev;
            trailer.prev=newNode;
            size++;
        }
        return true;
    }

    // insert 'item' at the end of the list.
    // The Worst Case Complexity: O(1)
    public boolean append(Object item){
        Node newNode=new Node(item);
        // if the LinkedList is empty, then the head and tail will both point to the new Node
        if(isEmpty()){
            head=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
        }
        tail=newNode;
        size++;
        return true;
    }

    //clear the entire list.
    // The Worst Case Complexity: O(n)
    public void clear(){
        Node newNode=new Node();
        while(this.head!=null){
            newNode=this.head;
            head=this.head.next;
            newNode=null;
        }
        head=null;
        size=0;
    }

    // return true if list is empty or false otherwise.
    // The Worst Case Complexity: O(1)
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }

    // return the size of the list, else -1.
    // The Worst Case Complexity: O(1)
    public int size(){
        if(size>=0){
            return size;
        }
        else{
            return -1;
        }
    }

    // replaces the element at 'index' with 'item'.
    // The Worst Case Complexity: O(n)
    public boolean replace(int index, Object item){
        // error: the given index is out of boundary of the LinkedList
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("Error: <Index "+index+" is not valid for a linked list of size "+size+">");
        }
        Node trailer =head;
        for (int i = 0; i < index; i++) {
            trailer = trailer.next;
        }
        Node newNode = new Node(item);
        newNode.prev = trailer.prev;
        newNode.next = trailer.next;
        trailer.next.prev=newNode;
        trailer.prev.next=newNode;
        return true;
    }

    // removes the element at 'index'.
    // The Worst Case Complexity: O(n)
    public boolean remove(int index){
        // error: the given index is out of boundary of the LinkedList
        if(!isValidIndex(index+1)){
            throw new IndexOutOfBoundsException("Error: <Index "+index+" is not valid for a linked list of size "+size+">");
        }
        Node trailer=head;
        // if we need to remove the head
        if(index==0){
            // error: if the LinkedList is empty
            if(head==null){
                throw new RuntimeException("Error: <List is empty>");
            }
            if(head.next==null){
                tail=null;
            }else{
                head.next.prev=null;
            }
            head=head.next;
            size--;
        }
        // if we need to remove the tail
        else if(index==size-1){
            // error: if the LinkedList is empty
            if(tail==null){
                throw new RuntimeException("Error: <List is empty>");
            }
            if(head.next==null){
                head = null;
            }else{
                tail.prev.next = null;
            }
            tail = tail.prev;
            size--;
        }
        // if we want to delete any Node in the middle
        else{
            for(int i=0;i<index && trailer.next!=null;i++){
                trailer=trailer.next;
            }
            trailer.prev.next=trailer.next;
            trailer.next.prev=trailer.prev;
            size--;
        }
        return true;
    }

    // return the element at 'index', but don't remove the item.
    // The Worst Case Complexity: O(n)
    public Object get(int index){
        Node trailer=head;
        for(int i=0;i<index&&trailer.next!=null;i++){
            trailer=trailer.next;
        }
        return trailer.getData();
    }

    // Display all the items in the LinkedList
    // The Worst Case Complexity: O(n)
    public void displayForward(){
        Node current = head;
        while(current != null){
            System.out.print(current.getData()+" ");
            current = current.next;
        }
        System.out.println("");
    }
}
