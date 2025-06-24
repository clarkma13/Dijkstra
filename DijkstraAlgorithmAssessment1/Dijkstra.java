
/**
 * Write a description of class Dijkstra here.
 *
 * Max Clarke
 * 24/6/25
 */
import java.util.ArrayList;
public class Dijkstra
{
    public static void main(String[] args){
        Queue queue = new Queue();
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        
        nodes.add(new Node("A", 100, 100));
        nodes.add(new Node("B", 100, 100));
        nodes.add(new Node("C", 100, 100));
        nodes.add(new Node("D", 100, 100));
        
        edges.add(new Edge(4, nodes.get(0), nodes.get(1)));
        edges.add(new Edge(5, nodes.get(1), nodes.get(2)));
        edges.add(new Edge(6, nodes.get(2), nodes.get(3)));
        edges.add(new Edge(1, nodes.get(3), nodes.get(0)));
        
        for(int i=0; i<nodes.size(); i++){
            nodes.get(i).setCost(9999);
            nodes.get(i).setVisited(false);
        }
        nodes.get(0).setCost(0);
        
        
    }
}
