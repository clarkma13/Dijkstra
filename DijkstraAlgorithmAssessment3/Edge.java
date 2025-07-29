
/**
 * Write a description of class Edge here.
 *
 * Max Clarke
 * 23/7/25
 */
public class Edge
{
    // instance variables - replace the example below with your own
    private int weight;
    private Node start;
    private Node end;

    /**
     * Constructor for objects of class Edge
     */
    public Edge(int weight, Node start, Node end)
    {
        this.weight = weight;
        this.start = start;
        this.end = end;
    }
    
    public int getWeight(){
        return(this.weight);
    }
    
    public Node getStartNode(){
        return(this.start);
    }
    
    public Node getEndNode(){
        return(this.end);
    }
}
