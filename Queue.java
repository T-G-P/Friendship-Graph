import java.util.NoSuchElementException;

public class Queue<T> {
<<<<<<< HEAD
	
	private SeshNode<T> rear;
	private int size;
	
	public Queue() {
		rear = null;
		size = 0;
	}

	public void enqueue(T item) {
		SeshNode<T> newItem = new SeshNode<T>(item, null);
		if (rear == null) {
			newItem.next = newItem;
		} else {
			newItem.next = rear.next;
			rear.next = newItem;
		}
		size++;
		rear = newItem;
	}
	
	public T dequeue() 
	throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
		T data = rear.next.data;
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
	
	public T peek() 
			throws NoSuchElementException {
		if (rear == null) {
			throw new NoSuchElementException("queue is empty");
		}
		return rear.next.data;				
	}
}
=======
        
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
>>>>>>> 62ae90cc0229d5e4fc7f79c8f9320746d4581848
