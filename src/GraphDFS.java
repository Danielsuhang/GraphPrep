import java.util.*;
public class GraphDFS {

	public List<Integer> traverseDFS(Node root, int size) {
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

}
