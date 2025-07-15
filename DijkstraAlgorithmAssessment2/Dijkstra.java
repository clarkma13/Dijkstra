
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
        ArrayList<Node> visitedNodes = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<Edge> currentEdges = new ArrayList<Edge>();
        Node currentNode;
        Node otherNode;
        int thisCost;
        
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
        
        queue.enqueue(nodes.get(0));
        
        while(queue.emptyQueue()==false){
            currentNode = queue.dequeue();
            
            System.out.println(currentNode.getName());
            for(int i=0; i<edges.size(); i++){
                if(edges.get(i).getStartNode().equals(currentNode)||
                   edges.get(i).getEndNode().equals(currentNode)){
                    currentEdges.add(edges.get(i));
                }
            }
            while(currentEdges.size() > 0){
                for(int i=0; i<currentEdges.size(); i++){
                    System.out.println(currentEdges.get(i).getStartNode().getName()+", "+currentEdges.get(i).getEndNode().getName());
                    thisCost = currentEdges.get(i).getWeight()+currentNode.getCost();
                    System.out.println(thisCost);
                    if(currentEdges.get(i).getStartNode() == currentNode){
                        if(currentEdges.get(i).getEndNode().nodeVisited() == false){
                            otherNode = currentEdges.get(i).getEndNode();
                            System.out.println(otherNode.getName());
                            if(otherNode.getCost()>thisCost){
                                otherNode.setCost(thisCost);
                                otherNode.setPreviousNode(currentNode);
                                queue.enqueue(otherNode);
                            }
                        }
                    }else
                    //if(currentEdges.get(i).getStartNode().equals(currentNode))
                    {
                        if(currentEdges.get(i).getStartNode().nodeVisited() == false){
                            otherNode = currentEdges.get(i).getStartNode();
                            System.out.println(otherNode.getName());
                            if(otherNode.getCost()>thisCost){
                                otherNode.setCost(thisCost);
                                otherNode.setPreviousNode(currentNode);
                                queue.enqueue(otherNode);
                            }
                        }
                    }
                    // if(otherNode.getCost()>thisCost){
                    // otherNode.setCost(thisCost);
                    // otherNode.setPreviousNode(currentNode);
                    // queue.enqueue(otherNode);
                    // }
                
                    currentEdges.remove(i);
                
                }
            }
            
            
            currentNode.setVisited(true);
            nodes.remove(currentNode);
            visitedNodes.add(currentNode);
        }
    }
    
    
}
