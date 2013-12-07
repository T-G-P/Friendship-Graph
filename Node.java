public class Node<T> {
	public User data;
	public Node<T> next;
	// constructor name does not get the <T>
	public Node(User data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
}