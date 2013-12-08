
import java.util.NoSuchElementException;

public class Queue<T> {
	
	private Node rear;
	private int size;
	
	public Queue() {
		rear = null;
		size = 0;
	}

	public void enqueue(User item) {
		Node newItem = new Node(item, null);
		if (rear == null) {
			newItem.next = newItem;
		} else {
			newItem.next = rear.next;
			rear.next = newItem;
		}
		size++;
		rear = newItem;
	}
	
	public User dequeue() 
	throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
		User data = rear.next.data;
		if (rear == rear.next) {
			rear = null;
		} else {
			rear.next = rear.next.next;
		}
		size--;
		return data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		size = 0;
		rear = null;
	}
	
	public User peek() 
			throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
		return rear.next.data;				
	}
}
