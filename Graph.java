import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Graph {
	Scanner sc;//being passed into constructor
	HashMap<String, Node> graph;
	
	public Graph(Scanner sc){
		this.sc = sc;
<<<<<<< HEAD
	}
	
	  /**
     * This method has two loops, the first fills the hashtables with nodes containing a user object as the data.
     * The second loop creates an array list of each persons complete list of friends
     */
=======
	}	
	
	
	
	/**
	 * This method has two loops, the first fills the hashtables with nodes containing a user object as the data. 
	 * The second loop creates an linked list of each persons complete list of friends
	 */
>>>>>>> fc88c8de0eaa450c78145a2d721f679adce9cb7e
    public void buildGraph(){
    	int numPeople = Integer.parseInt(sc.nextLine());
    	graph = new HashMap<String, Node>();
    	while(graph.size() < numPeople && sc.hasNextLine()){
    		Node temp = new Node(makeUser(sc.nextLine()), null);
    		graph.put(temp.data.name, temp);
    	}
    	while(sc.hasNextLine()){
<<<<<<< HEAD
            String line = sc.nextLine();
            line.toLowerCase();
            Scanner lineSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
            Node firstFriend = graph.get(lineSc.next());
            Node firstFriendCopy = new Node(firstFriend.data,null);
            Node secondFriend = graph.get(lineSc.next());
            Node secondFriendCopy = new Node(secondFriend.data,null);
            makeFriendships(firstFriend, secondFriendCopy);
            makeFriendships(secondFriend, firstFriendCopy);
            
    	}
    	
    	printGraph(graph);
    	
    	
    }
    
    private String printList(Node friend){
    	Node ptr;
    	String answer = "";
    	for(ptr=friend; ptr!=null; ptr=ptr.next){
=======
    		String line = sc.nextLine();
    		line.toLowerCase();
    		Scanner lineSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
        	Node firstFriend = graph.get(lineSc.next());
        	Node firstFriendCopy = new Node(firstFriend.data,null);
        	Node secondFriend = graph.get(lineSc.next());
        	Node secondFriendCopy = new Node(secondFriend.data, null);
    		makeFriendships(firstFriend, secondFriendCopy);    		
    		makeFriendships(secondFriend, firstFriendCopy);
>>>>>>> fc88c8de0eaa450c78145a2d721f679adce9cb7e
    		
    	}
    	
    }
    
    /**
<<<<<<< HEAD
    * Prints user and the friends they have
    */
        
    private void printGraph(HashMap<String, Node> graph){
    	for(String name: graph.keySet()){
    		System.out.println(printList(graph.get(name)));
=======
     * Creates a subgraph of friendships within a school.
     * @param school
     */
    public void subGraph(String school){
    	subGraph = new HashMap<String, Node>();
    	for (String name: graph.keySet()){
    		if(graph.get(name)!= null && graph.get(name).data.school.equals(school)){
    			subGraph.put(name, graph.get(name));
    		}
>>>>>>> fc88c8de0eaa450c78145a2d721f679adce9cb7e
    	}
    	
    }
    
    /**
     * populates the user class objects
     * @param line this string is the line of the format "name|y/n|school"
     * @return returns a populated user object
     */
    
    private User makeUser(String line){
    	line.toLowerCase();
    	Scanner makeUserSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
    	User person = new User(null, null);    	
    	person.name = makeUserSc.next();
    	if (makeUserSc.next().equals("y")){
    		person.school = makeUserSc.next();
    	}    	 
    	return person;
    	     	   	
    }
    
    /**
<<<<<<< HEAD
    * Completes an array list of friends, recurses to reach end of list.
    * @param firstFriend
    * @param secondFriend
    */
    
=======
     * Completes an linked list of friends, recurses to reach end of list. 
     * @param firstFriend
     * @param secondFriend
     */
>>>>>>> fc88c8de0eaa450c78145a2d721f679adce9cb7e
    private void makeFriendships(Node firstFriend, Node secondFriend) {
    	if(firstFriend.next == null){
    		firstFriend.next = secondFriend;
    	} else {
    		makeFriendships(firstFriend.next, secondFriend);
    	}
    	
    }
    
    
    /**
     * Prints out user object
     * @param person
     */
    public void printUser(User person) {
    	System.out.println("Name: " + person.name);
    	System.out.println("School: " + person.school);
    	
	}

   

}
