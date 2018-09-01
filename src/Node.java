import java.util.*;

public class Node {
	int val;
	List<Node> adj;
	public Node(int val) {
		this.val = val;
	}
	public Node(int val, ArrayList<Node> adj) {
		this(val);
		this.adj = adj;
	}
}
