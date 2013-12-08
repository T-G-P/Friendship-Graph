//import java.util.List;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Set;

public class BreadthFirstSearch {

	/**
	 * The shortest path between two nodes in a graph.
	 */
	private static ArrayList<Node> shortestPath = new ArrayList<Node>();
		
	/**
	 * Finds the shortest path between two nodes (src and dst) in a graph.
	 * @param graph the graph to be searched for the shortest path.
	 * @param src the source node of the graph specified by Node.
	 * @param dst the destination node of the graph specified by Node.
	 * @return the shortest path stored as a list of nodes.
	 *         or null if a path is not found.
	 * Requires: src != null, dst != null and must have a name (e.g.
	 * cannot be an empty string).
	 */
	public static ArrayList<Node> bfs(Graph graph, Node src, Node dst) {
		shortestPath.clear();
		
		// A list that stores the path.
		ArrayList<Node> path = new ArrayList<Node>();
		
		// If the source is the same as destination, I'm done.
		if (src.data.name.equals(dst.data.name) && graph.graph.containsKey(src.data.name)) {
			path.add(src);
			return path;
		}
		
		// A queue to store the visited nodes.
		Queue q = new Queue();
		
		// A queue to store the visited nodes.
		Queue visited = new Queue();
		
		q.enqueue(src);
		while (!q.isEmpty()) {
			Node v = q.dequeue();
			visited.enqueue(v);
			
			// Search reachableList of v.
			ArrayList<Node> reachableList = graph.getNeighbours(v);
			int i = 0;
			while (i != reachableList.size()) {
				// Extracts the next neighbour of v.
				Node neighbour = reachableList.get(i);
				
				path.add(neighbour);
				path.add(v);
				
				if (neighbour.equals(dst)) {
					// Process path
					//System.out.println(processPath(src, dst, path));
					return processPath(src, dst, path);
				}
				else {
					if (!visited.contains(visited, neighbour)) {
						q.enqueue(neighbour);
					}
				}
				i++;
			}
			
		}
		return null;
	} 
	
	/**
	 * Adds the nodes involved in the shortest path.
	 * @param src the source node.
	 * @param dst the destination node.
	 * @param path the path that has nodes and their neighbours.
	 * @return the shortest path.
	 */
	private static ArrayList<Node> processPath(Node src, Node dst, ArrayList<Node> path) {
		
		// Finds out where the destination node directly comes from.
		int i = path.indexOf(dst);
		Node source = path.get(i + 1);
		
		// Adds the destination node to the shortestPath.
		shortestPath.add(0, dst);
		
		if (source.equals(src)) {
			// The original source node is found.
			shortestPath.add(0, src);
			return shortestPath;
		} else {
			// We find where the source node of the destination node 
			// comes from.
			// We then set the source node to be the destination node.
			return processPath(src, source, path);
		}
	}
} // BreadthFirstSearch
