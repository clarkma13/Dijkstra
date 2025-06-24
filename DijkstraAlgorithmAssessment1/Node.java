
/**
 * Write a description of class Node here.
 *
 * Max Clarke
 * 16/6/25
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private int x;
    private int y;
    private int cost;
    private boolean visited;

    /**
     * Constructor for objects of class Node
     * Nodes with a name
     */
    public Node(String name, int x, int y)
    {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return(this.name);
    }
    
    public int getX(){
        return(this.x);
    }
    
    public int getY(){
        return(this.y);
    }
    
    public int getId(){
        return(this.id);
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getCost(){
        return(this.cost);
    }
    
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public boolean nodeVisited(){
        return(this.visited);
    }
    
    public void setVisited(boolean visited){
        this.visited = visited;
    }
}
