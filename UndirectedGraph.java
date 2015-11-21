

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class UndirectedGraph {
 
 /** Edge object contains information about an edge to a given vertex */ 
 public class Edge {
  /** label for the vertex that the edge is connects to */
  public String vertexLabel = "";
  
  /** weight for the edge */
  public int weight = 0;
  
  public Edge(String vLabel){
   vertexLabel = vLabel;
  }
  
  public Edge(String vLabel, int w){
   vertexLabel = vLabel;
   weight = w;
  }
 }
 
    /** Vertex object contains all of the relevant information for a vertex */
 public class Vertex {
  /** adjacency list specifying edges from this vertex */
  public LinkedList<Edge> adjacencyList = new LinkedList<Edge>();
  /** label for the vertex */
  public String label = null;
  
  /** used in BFS and DFS */
  public boolean discovered = false;
  public boolean visited = false;
  public String parent = null;
  public int distance = Integer.MAX_VALUE;
  public int discoveryTime = 0;
  public int finishingTime = 0;
  
  public Vertex(String label){
   this.label = label;
  }
  
  /** add an edge to the vertex with the given label */
  public void addEdge(String vLabel){
   adjacencyList.add(new Edge(vLabel));
  }
  
  /** add a weighted edge to the vertex with the given label */
  public void addWeightedEdge(String vLabel, int w){
   adjacencyList.add(new Edge(vLabel, w));
  }
  
  /** output all of the vertices that this vertex has edges to */
  public void displayEdges() {
   System.out.print("Edges to: ");
   for (Edge e: adjacencyList){
    System.out.print(e.vertexLabel+" ");
   }
   System.out.println();
  }
  
  /** remove all of the edges from this vertex */
  public void clear() {
   adjacencyList.clear();
  }
 }
 
 /** stores the set of vertices in the graph. keyed by the name of the vertex. */
 public HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();
 
 /** current finishing time. used by DFS */
 private int time = 0;
 
 /** add the undirected edge (v,u) to the graph */
 public void addEdge(String vLabel, String uLabel){
  // add edge (v,u)
  if (vertices.containsKey(vLabel)){
   vertices.get(vLabel).addEdge(uLabel);
  } else {
   Vertex v = new Vertex(vLabel);
   v.addEdge(uLabel);
   vertices.put(vLabel, v);
  }
  // add edge (u,v)
  if (vertices.containsKey(uLabel)){
   vertices.get(uLabel).addEdge(vLabel);
  } else {
   Vertex u = new Vertex(uLabel);
   u.addEdge(vLabel);
   vertices.put(uLabel, u);
  }
 }
 
 /** output the vertices and their edges */
 public void display() {
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()){
   Vertex v = vertexEntry.getValue();
   System.out.print("Vertex: "+v.label+", ");
   v.displayEdges();
  }
 }

 /** remove all vertices and their edges from the graph */
 public void clear() {
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()){
   Vertex v = vertexEntry.getValue();
   v.clear();   // clear adjacency list for v
  }
  vertices.clear();      // delete set of vertices
 }

 
 /** output the vertices and their edges and information relevant to BFS*/
 public void displayBFS() {
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()){
   Vertex v = vertexEntry.getValue();
   System.out.print("Vertex: "+v.label+", d = "+v.distance+", ");
   v.displayEdges();
  }
 }

 /** output the vertices and their edges and information relevant to DFS */
 public void displayDFS() {
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()){
   Vertex v = vertexEntry.getValue();
   System.out.print("Vertex: "+v.label);
   System.out.print(", discovery time = "+v.discoveryTime);
   System.out.print(", finishing time = "+v.finishingTime+", ");
   v.displayEdges();
  }
 }
 
 
 /** perform a breadth-first search of the graph starting at 
  * the vertex with given label */
 public void breadFirstSearch(String label) {
  Vertex s = vertices.get(label);

  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()) {
   Vertex u = vertexEntry.getValue();
   u.discovered = false;
   u.visited = false;
   u.distance = Integer.MAX_VALUE;
   u.parent = null;
  }
  
  s.discovered = true;
  s.distance = 0;

  LinkedList<Vertex> q = new LinkedList<Vertex>();
  q.addLast(s);
  
  while(q.isEmpty() == false) {
   Vertex u = q.remove();
   for(Edge e: u.adjacencyList){
    Vertex v = vertices.get(e.vertexLabel);
    if (v.discovered == false) {
     v.discovered = true;
     v.distance = u.distance + 1;
     v.parent = u.label;
     q.addLast(v);
    }
   }
   u.visited = true;
  }
 }
 
 /** output the vertices on the path from s to v */
 public void printPath(String sLabel, String vLabel){
  Vertex s = vertices.get(sLabel);
  Vertex v = vertices.get(vLabel);
  
  if (s == v) {
   System.out.print(sLabel);
  } else if (v.parent == null) {
   System.out.println("No path from "+s.label+" to "+v.label+" exists");
  } else {
   printPath(s.label, v.parent);
   System.out.print(", "+v.label);
  }
 }
 
 /** perform depth first search of graph */
 public void depthFirstSearch() {
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()) {
   Vertex u = vertexEntry.getValue();
   u.discovered = false;
   u.visited = false;
   u.parent = null;
  }

  time = 0;
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()) {
   Vertex u = vertexEntry.getValue();
   if (u.discovered == false){
    dfsVisit(u);
   }
  }  
 }
 
 /** recursively visit each vertex connected to vertex u */
 private void dfsVisit(Vertex u){
  time = time + 1;
  u.discoveryTime = time;
  u.discovered = true;

  // explore each edge (u,v)
  for(Edge e: u.adjacencyList){
   Vertex v = vertices.get(e.vertexLabel);
   if (v.discovered == false){
    v.parent = u.label;
    dfsVisit(v);
   }
  }
  u.visited = true;
  time = time + 1;
  u.finishingTime = time;
 }
 
 /** perform depth first search of graph starting at a node with a given label*/
 public void depthFirstSearch(String sLabel) {
  for (Entry<String, Vertex> vertexEntry: vertices.entrySet()) {
   Vertex u = vertexEntry.getValue();
   u.discovered = false;
   u.visited = false;
   u.parent = null;
  }

  time = 0;
  Vertex u = vertices.get(sLabel);
  dfsVisit(u); 
 }


}