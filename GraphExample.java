
//Mark Shepherd
//CPTR 276
/** Found the path through a given maze
 * of a graph.
 * @author rlsummerscales
 * @modifier Mark Shepherd
 * */
public class GraphExample {
 public static void main(String[] args){
  UndirectedGraph g = new UndirectedGraph();
  
  ///These edges represents the links betwiin the empty spaces on the graph
 g.addEdge("0,0", "0,1");
  g.addEdge("0,1", "0,2");
  g.addEdge("0,2", "0,3");
    g.addEdge("0,3", "1,3");
  g.addEdge("1,3", "2,3");
  g.addEdge("1,3", "1,4");
  g.addEdge("1,4", "1,5");
  g.addEdge("1,5", "0,5");
  g.addEdge("2,3", "2,2");
  g.addEdge("2,2", "2,1");
  g.addEdge("2,1", "2,0");
  g.addEdge("2,1", "3,1");
  g.addEdge("3,1", "4,1");
  g.addEdge("4,2", "4,3"); 
  g.addEdge("4,1", "4,2");
  g.addEdge("5,1", "4,1");
  g.addEdge("5,1", "5,0");
  g.addEdge("5,0", "6,0");
  g.addEdge("6,0", "7,0");
  g.addEdge("7,0", "7,1");
  g.addEdge("7,1", "7,2");
  g.addEdge("7,2", "6,2");
  g.addEdge("6,2", "6,3");
  g.addEdge("6,3", "6,4");
  g.addEdge("6,4", "6,5");
  g.addEdge("6,5", "7,5");
  g.addEdge("6,5", "5,5");
  g.addEdge("5,5", "5,6");
  g.addEdge("5,6", "5,7");
  g.addEdge("5,7", "4,7");
  g.addEdge("5,7", "6,7");
  g.addEdge("6,7", "7,7");
  g.addEdge("4,3", "4,4");
  g.addEdge("4,4", "3,4");
  g.addEdge("3,4", "3,5");
  g.addEdge("3,5", "3,6");
  g.addEdge("3,6", "2,6");
  g.addEdge("2,6", "2,7");
  g.addEdge("2,7", "1,7");
  g.addEdge("1,7", "0,7");


  //Performd DFS Through all the verticies
   g.depthFirstSearch("0,0");
   
System.out.println(" The Directions through the maze are: " );
// Prints the path from (0,0) to (0,7) on the maze
   g.printPath("0,0", "7,7");
  System.out.println(" ");

 } 
}
 