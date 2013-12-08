public class Node {
	public User data;
	public Node next;
	// constructor name does not get the <T>
	public Node(User data, Node next) {
		this.data = data;
		this.next = next;
	}
	public Node getNeighbours(Node v) {
		// TODO Auto-generated method stub
		Node neighbors = null;
		Node ptr;
		for(ptr=v; ptr!=null; ptr=ptr.next){
			
			if(ptr==v){
				continue;
			}
			neighbors.next=ptr;
			
			
		}
		
		return neighbors;
	}
	
	public boolean equals(Node n){
		return n.data.equals(this.data);
	}
}