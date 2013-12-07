import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Graph {
	Scanner sc;//being passed into constructor
	HashMap<String, Node> graph;
	
	public Graph(Scanner sc){
		this.sc = sc;
	}
<<<<<<< HEAD
	
	  /**
     * This method has two loops, the first fills the hashtables with nodes containing a user object as the data.
     * The second loop creates an array list of each persons complete list of friends
     */
=======
	/**
	 * This method has two loops, the first fills the hashtables with nodes containing a user object as the data. 
	 * The second loop creates an array list of each persons complete list of friends
	 */
>>>>>>> bf3f918e33f57ad2b58e7f3e09b3abe6d6d7e123
    public void buildGraph(){
    	int numPeople = Integer.parseInt(sc.nextLine());
    	graph = new HashMap<String, Node>();
    	while(graph.size() < numPeople && sc.hasNextLine()){
    		Node temp = new Node(makeUser(sc.nextLine()), null);
    		graph.put(temp.data.name, temp);
    	}
    	while(sc.hasNextLine()){
    		String line = sc.nextLine();
    		line.toLowerCase();
    		Scanner lineSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
        	Node firstFriend = graph.get(lineSc.next());
        	Node firstFriendCopy = new Node(firstFriend.data,null);
        	Node secondFriend = graph.get(lineSc.next());
        	Node secondFriendCopy = new Node(secondFriend.data, null);
    		makeFriendships(firstFriend, secondFriendCopy);    		
    		makeFriendships(secondFriend, firstFriendCopy);
    		
    	}
    	printGraph(graph);
    	
    }
    /**
     * Prints user and the friends they have
     */
    
    /**
    * Prints user and the friends they have
    */
        
    private void printGraph(HashMap<String, Node> graph){
    	for(String name: graph.keySet()){
    		System.out.println(graph.get(name).data.name);
    		Node testFriend = graph.get(name);
    		while( testFriend.next != null){
    			testFriend = testFriend.next;
    			System.out.println(" Is Friends With: " + testFriend.data.name);
    			
    		}
    	}
    	
    }
    
    /**
<<<<<<< HEAD
    * populates the user class objects
    * @param line this string is the line of the format "name|y/n|school"
    * @return returns a populated user object
    */
=======
     * populates the user class objects
     * @param line this string is the line of the format "name|y/n|school"
     * @return returns a populated user object
     */
>>>>>>> bf3f918e33f57ad2b58e7f3e09b3abe6d6d7e123
    
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
     * Completes an array list of friends, recurses to reach end of list. 
     * @param firstFriend
     * @param secondFriend
     */
>>>>>>> bf3f918e33f57ad2b58e7f3e09b3abe6d6d7e123
    private void makeFriendships(Node firstFriend, Node secondFriend) {
    	if(firstFriend.next == null){
    		firstFriend.next = secondFriend;
    	} else {
    		makeFriendships(firstFriend.next, secondFriend);
    	}
    	
    }
    
    
    /**
<<<<<<< HEAD
    * Prints out user object
    * @param person
    */
    
=======
     * Prints out user object
     * @param person
     */
>>>>>>> bf3f918e33f57ad2b58e7f3e09b3abe6d6d7e123
    public void printUser(User person) {
    	System.out.println("Name: " + person.name);
    	System.out.println("School: " + person.school);
    	
	}

   

}
