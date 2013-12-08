
import java.util.NoSuchElementException;

public class Queue<T> {
	
	private Node rear;
	private int size;
	
	public Queue() {
		rear = null;
		size = 0;
	}

<<<<<<< HEAD
	public void enqueue(User item) {
		Node newItem = new Node(item, null);
=======
	public void enqueue(Node item) {
		Node newItem = new Node(item.data, null);
>>>>>>> 8373e4f07be49a0fdac4c8805dadccc1293437ab
		if (rear == null) {
			newItem.next = newItem;
		} else {
			newItem.next = rear.next;
			rear.next = newItem;
		}
		size++;
		rear = newItem;
	}
	
<<<<<<< HEAD
	public User dequeue() 
=======
	public Node dequeue() 
>>>>>>> 8373e4f07be49a0fdac4c8805dadccc1293437ab
	throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
<<<<<<< HEAD
		User data = rear.next.data;
=======
		Node data = rear.next;
>>>>>>> 8373e4f07be49a0fdac4c8805dadccc1293437ab
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
	
<<<<<<< HEAD
=======
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
	
>>>>>>> 8373e4f07be49a0fdac4c8805dadccc1293437ab
	public void clear() {
		size = 0;
		rear = null;
	}
	
<<<<<<< HEAD
	public User peek() 
=======
	public Node peek() 
>>>>>>> 8373e4f07be49a0fdac4c8805dadccc1293437ab
			throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
<<<<<<< HEAD
		return rear.next.data;				
=======
		return rear.next;				
>>>>>>> 8373e4f07be49a0fdac4c8805dadccc1293437ab
	}
}
