import java.util.*;
public class GraphBFS {
	public List<Integer> traverseBFSAdjList(Node root, int size) {
		List<Integer> sol = new ArrayList<>();
		if (root == null || size <= 0) {
			return sol;
		}
		//Create a visited boolean array to account for cycles: Use Node val as index
		//Note: size is the largest Node value that exists
		boolean[] visited = new boolean[size];
		visited[root.val] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int queueSize = queue.size(); //Only traverse through size of array
			while (queueSize-- > 0) {
				//Traverse through current node here
				Node curr = queue.poll();
				sol.add(curr.val);

				//Add in all valid children here
				for (Node n : curr.adj) {
					if (!visited[n.val]) {
						visited[n.val] = true;
						queue.offer(n);
					}
				}
			}
		}
		return sol;
	}


	//Adj Matrix
	//graph[i][j] means: src -> dest   i.e: graph[2][3]: 2 -> 3
	public List<Integer> traverseBFSmatrix(int root, boolean[][] graph, int size) {
		List<Integer> sol = new ArrayList<>();
		if (graph == null) {
			return sol;
		}
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(root);
		visited[root] = true;

		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			while (queueSize-- > 0) {
				int curr = queue.poll();
				sol.add(curr);
				
				//Traverse through children of curr
				for (int i = 0; i < graph[0].length; i++) {
					if (graph[curr][i] && !visited[i]) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
		}		
		return sol;
	}
}
