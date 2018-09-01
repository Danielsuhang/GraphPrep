import java.util.*;
public class main {
	public static void main(String[] args) {
		//Creating test graph from https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		int graphSize = 4;

		zero.adj = new ArrayList<Node>() {{
			add(one);
			add(two);
		}};
		one.adj = new ArrayList<Node>() {{
			add(two);
		}};
		two.adj = new ArrayList<Node>() {{
			add(zero);
			add(three);
		}};
		three.adj = new ArrayList<Node>() {{
			add(three);
		}};
		
		
		
		int adjGraphSize = 6;
		boolean[][] adjMatrix = new boolean[adjGraphSize][adjGraphSize];
		adjMatrix[zero.val][one.val] =  true;
		adjMatrix[zero.val][two.val] =  true;

		adjMatrix[one.val][zero.val] =  true;
		adjMatrix[one.val][three.val] =  true;

		adjMatrix[two.val][three.val] =  true;
		adjMatrix[two.val][five.val] =  true;

		adjMatrix[three.val][four.val] =  true;
		
		adjMatrix[four.val][three.val] =  true;
		adjMatrix[four.val][two.val] =  true;
		
		adjMatrix[five.val][four.val] =  true;




		/* End graph Initialization */
		//Expected order: 2, 0, 1, 3
		//OR
		//Expected order: 2, 3, 0, 1


		GraphDFS g = new GraphDFS();
		List<Integer> dfsAdjList = g.traverseDFSAdjList(two, graphSize);
		printList(dfsAdjList);
		
		
		//Graph adapted from: https://stackoverflow.com/questions/16261059/performing-dfs-and-bfs-on-a-directed-graph
		List<Integer> dfsAdjMatrix = g.traverseDFSmatrix(0, adjMatrix, adjGraphSize);
		printList(dfsAdjMatrix);

	}
	private static void printList(List<Integer> list) {
		if (list == null || list.size() == 0) {
			System.out.println("Empty List");
			return;
		}
		System.out.println("-----------------------");
		for (Integer i : list) {
			System.out.println(i);
		}
		System.out.println("-----------------------");

	}

}
