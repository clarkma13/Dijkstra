
/**
 * Write a description of class Dijkstra here.
 *
 * Max Clarke
 * 23/7/25
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
public class Dijkstra
{
    public static void main(String[] args){
        Queue queue = new Queue();
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Node> visitedNodes = new ArrayList<Node>();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<Edge> currentEdges = new ArrayList<Edge>();
        Scanner keyboard = new Scanner(System.in);
        Node currentNode;
        Node otherNode;
        int thisCost;
        String input = null;
        
        System.out.println("Loading data from file...");
        readFile(nodes,edges);
        System.out.println("Nodes:");
        for(int i=0; i<nodes.size(); i++){
            System.out.println(nodes.get(i).getName());
        }
        
        System.out.println("What would you like the starting point to be?");
        input = keyboard.nextLine();
        Node startPoint = findNode(nodes, input);
        while(findNode(nodes,input)==null){
            System.out.println("Input error: Please enter one of the nodes listed above");
            input = keyboard.nextLine();
            startPoint = findNode(nodes, input);
        }
        
        System.out.println("What would you like the ending point to be?");
        input = keyboard.nextLine();
        Node endPoint = findNode(nodes, input);
        while(findNode(nodes,input)==null||endPoint.equals(startPoint)){
            System.out.println("Input error: Please enter one of the nodes listed above other than "+startPoint.getName());
            input = keyboard.nextLine();
            endPoint = findNode(nodes, input);
        }
        
        for(int i=0; i<nodes.size(); i++){
            nodes.get(i).setCost(9999);
            nodes.get(i).setVisited(false);
        }
        startPoint.setCost(0);
        startPoint.setPreviousNode(startPoint);
        
        queue.enqueue(startPoint);
        
        while(queue.emptyQueue()==false){
            currentNode = queue.dequeue();
            
            //System.out.println("Current node: "+currentNode.getName());
            for(int i=0; i<edges.size(); i++){
                if(edges.get(i).getStartNode().equals(currentNode)||
                   edges.get(i).getEndNode().equals(currentNode)){
                    currentEdges.add(edges.get(i));
                }
            }
            while(currentEdges.size() > 0){
                for(int i=0; i<currentEdges.size(); i++){
                    //System.out.println("From "+currentEdges.get(i).getStartNode().getName()+" to "+currentEdges.get(i).getEndNode().getName());
                    thisCost = currentEdges.get(i).getWeight()+currentNode.getCost();
                    //System.out.println(thisCost);
                    if(currentEdges.get(i).getStartNode() == currentNode){
                        if(currentEdges.get(i).getEndNode().nodeVisited() == false){
                            otherNode = currentEdges.get(i).getEndNode();
                            if(otherNode.getCost()>thisCost){
                                otherNode.setCost(thisCost);
                                otherNode.setPreviousNode(currentNode);
                                queue.enqueue(otherNode);
                            }
                        }
                    }else{
                        if(currentEdges.get(i).getStartNode().nodeVisited() == false){
                            otherNode = currentEdges.get(i).getStartNode();
                            if(otherNode.getCost()>thisCost){
                                otherNode.setCost(thisCost);
                                otherNode.setPreviousNode(currentNode);
                                queue.enqueue(otherNode);
                            }
                        }
                    }
                    currentEdges.remove(i);
                }
            }
            currentNode.setVisited(true);
            nodes.remove(currentNode);
            visitedNodes.add(currentNode);
        }
        // System.out.println("(City, Cost, Previous)");
        // for(int i=0; i<visitedNodes.size(); i++){
            // System.out.println(visitedNodes.get(i).getName()+", "+visitedNodes.get(i).getCost()+", "+visitedNodes.get(i).getPreviousNode().getName());
        // }
        findPath(startPoint, endPoint);
    }
    
    /**
     * Method that reads the graphData.csv file every time the program is run
     * It splits the lines by commas into separate qualities per node and edge
     * Then it adds them to the nodes and edges ArrayLists
     */
    static void readFile(ArrayList<Node> nodes, ArrayList<Edge> edges){
        try{
            File file = new File("graphData.csv");
            Scanner myReader = new Scanner(file);
            
            String line = myReader.nextLine();
            String[] currentLine = line.split(",");
            int nodesLength = Integer.parseInt(currentLine[0]);
           
            for(int i=0; i<nodesLength; i++){
                line=myReader.nextLine();
                currentLine = line.split(",");
                nodes.add(new Node(currentLine[0], Integer.parseInt(currentLine[1]), Integer.parseInt(currentLine[2])));
                    
            }
            line = myReader.nextLine();
            currentLine = line.split(",");
            int edgesLength = Integer.parseInt(currentLine[0]);
                
            for(int i=0; i<edgesLength; i++){
                line=myReader.nextLine();
                currentLine = line.split(",");
                edges.add(new Edge(Integer.parseInt(currentLine[0]), findNode(nodes, currentLine[1]), findNode(nodes, currentLine[2])));
                    
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    static Node findNode(ArrayList<Node> nodes, String target){
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).getName().toUpperCase().equals(target.toUpperCase())){
                return(nodes.get(i));
            }else{
                
            }
        }
        return(null);
    }
    
    static void findPath(Node start, Node end){
        Node n = end;
        ArrayList<Node> path = new ArrayList<Node>();
        while(!n.getPreviousNode().equals(start)){
            path.add(n.getPreviousNode());
            n=n.getPreviousNode();
        }
        System.out.println("The shortest path from "+start.getName()+" to "+end.getName()+":");
        System.out.print(start.getName()+"->");
        for(int i=path.size(); i>0; i--){
            System.out.print(path.get(i-1).getName()+"->");
        }
        System.out.println(end.getName());
        System.out.println("The total cost is "+end.getCost());
    }
}