public class Node {
	public User data;
	public Node next;
	// constructor name does not get the <T>
	public Node(User data, Node next) {
		this.data = data;
		this.next = next;
	}
}