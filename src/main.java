import java.util.*;
public class main {
	public static void main(String[] args) {
		//Creating test graph from https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
		Node zero = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		
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
		
		GraphDFS g = new GraphDFS();
		List<Integer> dfs = g.traverseDFS(two, 4);
		printList(dfs);
		//Expected order: 2, 0, 1, 3
		
	}
	private static void printList(List<Integer> list) {
		if (list == null) return;
		for (Integer i : list) {
			System.out.println(i);
		}
		
	}

}
