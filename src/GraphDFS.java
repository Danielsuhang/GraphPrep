import java.util.*;
public class GraphDFS {
	//Unweighted directed Graph BFS traversal

	public List<Integer> traverseDFSAdjList(Node root, int size) {
		List<Integer> sol = new ArrayList<>();
		if (root == null || size <= 0) {
			return sol;
		}
		//Create a visited boolean array to account for cycles: Use Node val as index
		//Note: size is the largest Node value that exists
		boolean[] visited = new boolean[size];
		visited[root.val] = true;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			sol.add(node.val);
			//Traverse through all adj and add to stack
			for (Node adj : node.adj) {
				if (!visited[adj.val]) {
					visited[adj.val] = true;
					stack.push(adj);
				}
			}
		}
		return sol;
	}
	//Adj Matrix
	//graph[i][j] means: src -> dest   i.e: graph[2][3]: 2 -> 3
	public List<Integer> traverseDFSmatrix(int root, boolean[][] graph, int size) {
		List<Integer> sol = new ArrayList<>();
		if (graph == null) {
			return sol;
		}
		boolean[] visited = new boolean[size];
		Stack<Integer> stack = new Stack<>();
		stack.push(root);
		visited[root] = true;
		
		while (!stack.isEmpty()) {
			int node = stack.pop();
			sol.add(node);
			//Traverse through all current node's children
			//Add to stack is not yet visited
			for (int i = 0; i < graph[0].length; i++) {
				if (graph[node][i] && !visited[i]) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		
		return sol;
		
		
	}

}
