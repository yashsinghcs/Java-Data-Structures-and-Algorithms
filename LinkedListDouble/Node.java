
public class Node {
	
	public int info;
	public Node prev, next;
	public Node() {
		this.prev = null;
		this.next = null;
	}
	public Node(int i) {
		this.info = i;
		this.prev = null;
		this.next =null;
	}
	public Node(int i, Node p, Node n) {
		this.info = i;
		this.prev = p;
		this.next = n;
	}
	public int print() {
		return this.info;
	}
}