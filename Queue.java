
import java.util.NoSuchElementException;

public class Queue<T> {
	
	private Node rear;
	private int size;
	
	public Queue() {
		rear = null;
		size = 0;
	}

	public void enqueue(Node item) {
		Node newItem = new Node(item.data, null);
		if (rear == null) {
			newItem.next = newItem;
		} else {
			newItem.next = rear.next;
			rear.next = newItem;
		}
		size++;
		rear = newItem;
	}
	
	public Node dequeue() 
	throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
		Node data = rear.next;
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
	
	public boolean contains(Queue T, Node person){
		while(!(T.isEmpty())){
			if(person.data.name.equals(T.peek().data.name)){
				return true;
			}
			else{
				T.dequeue();
			}
		}
			
		return false;
	}
	
	public void clear() {
		size = 0;
		rear = null;
	}
	
	public Node peek() 
			throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
		return rear.next;				
	}
}
