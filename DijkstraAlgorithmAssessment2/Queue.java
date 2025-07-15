
/**
 * Write a description of class Queue here.
 *
 * Max Clarke
 * 24/6/25
 */
public class Queue
{
    // instance variables - replace the example below with your own
    private Node head;
    private Node tail;

    /**
     * Constructor for objects of class Queue
     */
    public Queue()
    {
        
    }
    
    public boolean emptyQueue(){
        if(this.head == null){
            return(true);
        }else{
            return(false);
        }
    }
    
    public void enqueue(Node node){
        if(emptyQueue() == true){
            this.head = node;
            this.tail = node;
        }else if(emptyQueue()==false){
            this.tail.setNextNode(node);
            this.tail = node;
        }
    }
    
    public Node dequeue(){
        Node node = this.head;
        if(emptyQueue()==false){
            this.head = head.getNextNode();
        }else if(emptyQueue()==true){
            this.head = null;
        }
        
        return(node);
    }

}
