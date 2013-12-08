import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Graph Class
 * 
 * @author Raphael Kelly
 * @author Tobias Perelstein 
 */

public class Graph {
	Scanner sc;//being passed into constructor
	HashMap<String, Node> graph, subGraph;
	
	/**
	 * Constructor Method
	 */
	public Graph(Scanner sc){
		this.sc = sc;
<<<<<<< HEAD
	}	
	
	
	
	/**
	 * This method has two loops, the first fills the hashtables with nodes containing a user object as the data. 
	 * The second loop creates an linked list of each persons complete list of friends
	 */
=======
	}
	
	  /**
     * This method has two loops, the first fills the hashtables with nodes containing a user object as the data.
     * The second loop creates an array list of each persons complete list of friends
     */
>>>>>>> 8002673a021d6b213836a19b09371a9e81b48e73
    public void buildGraph(){

    	int numPeople = Integer.parseInt(sc.nextLine());
    	graph = new HashMap<String, Node>();
    	while(graph.size() < numPeople && sc.hasNextLine()){
    		Node temp = new Node(makeUser(sc.nextLine()), null);
    		graph.put(temp.data.name, temp);
    		//System.out.println(graph.size());
    	}
    	while(sc.hasNextLine()){
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
<<<<<<< HEAD
=======
    	
    	printGraph(graph);
>>>>>>> 8002673a021d6b213836a19b09371a9e81b48e73
    	
    	
    }
    
    private String printList(Node friend){
    	Node ptr;
    	String answer = "";
    	for(ptr=friend; ptr!=null; ptr=ptr.next){
    		
    		if(ptr==friend){
    			continue;
    		}
    		answer+=(ptr.data.name+" ");
    	}
    	return friend.data.name+" is friends with: "+answer;
    }
    
    /**
<<<<<<< HEAD
     * Creates a subgraph of friendships within a school.
     * @param school
     */
    public void subGraph(String school){
    	subGraph = new HashMap<String, Node>();
    	for (String name: graph.keySet()){
    		if(graph.get(name)!= null && graph.get(name).data.school.equals(school)){
    			subGraph.put(name, graph.get(name));
    		}
=======
    * Prints user and the friends they have
    */
        
    private void printGraph(HashMap<String, Node> graph){
    	for(String name: graph.keySet()){
    		System.out.println(printList(graph.get(name)));
>>>>>>> 8002673a021d6b213836a19b09371a9e81b48e73
    	}
    }
    
    
    
    /**
    * populates the user class objects
    * @param line this string is the line of the format "name|y/n|school"
    * @return returns a populated user object
    */
    
    private User makeUser(String line){
    	line.toLowerCase();
    	Scanner Usersc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
    	User person = new User(null, null);    	
    	person.name = Usersc.next();
    	if (Usersc.next().equals("y")){
    		person.school = Usersc.next();
    	}    	 
    	return person;
    	     	   	
    }
    
    /**
<<<<<<< HEAD
     * Completes an linked list of friends, recurses to reach end of list. 
     * @param firstFriend
     * @param secondFriend
     */
=======
    * Completes an array list of friends, recurses to reach end of list.
    * @param firstFriend
    * @param secondFriend
    */
    
>>>>>>> 8002673a021d6b213836a19b09371a9e81b48e73
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
     * Prints user and the friends they have
     */
    
    private String printList(Node friend){
        Node ptr;
        String answer = "";
        for(ptr=friend; ptr!=null; ptr=ptr.next){
                
                if(ptr==friend){
                        continue;
                }
                answer+=(ptr.data.name+" ");
        }
        return friend.data.name+" is friends with: "+answer;
    }

    
    

}
