import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Graph {
	Scanner sc;//being passed into constructor
	HashMap<String, Node> graph;
	
	public Graph(Scanner sc){
		this.sc = sc;
	}
	/**
	 * This method has two loops, the first fills the hashtables with nodes containing a user object as the data. 
	 * The second loop creates an array list of each persons complete list of friends
	 */
    public void buildGraph(){

    	int numPeople = Integer.parseInt(sc.nextLine());
    	graph = new HashMap<String, Node>();
    	while(graph.size() < numPeople && sc.hasNextLine()){
    		Node temp = new Node(makeUser(sc.nextLine()), null);
    		graph.put(temp.data.name, temp);
    		//System.out.println(graph.size());
    	}
    	while(sc.hasNextLine()){
<<<<<<< HEAD
    		String line = sc.nextLine();
    		line.toLowerCase();
    		Scanner lineSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
        	Node firstFriend = graph.get(lineSc.next());
        	Node firstFriendCopy = new Node(firstFriend.data,null);
        	Node secondFriend = graph.get(lineSc.next());
        	Node secondFriendCopy = new Node(secondFriend.data, null);
    		makeFriendships(firstFriend, secondFriendCopy);    		
    		makeFriendships(secondFriend, firstFriendCopy);
    		
=======
            String line = sc.nextLine();
            line.toLowerCase();
            Scanner lineSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
            Node firstFriend = graph.get(lineSc.next());
            Node firstFriendCopy = new Node(firstFriend.data,null);
            Node secondFriend = graph.get(lineSc.next());
            Node secondFriendCopy = new Node(secondFriend.data,null);
            makeFriendships(firstFriend, secondFriendCopy);
            makeFriendships(secondFriend, firstFriendCopy);
            
>>>>>>> 6e855668f0f23dd0086984b04ce9058b59bcd705
    	}
    	
    	printGraph(graph);
    	
    	
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
     * Prints user and the friends they have
     */
    
    private void printGraph(HashMap<String, Node> graph){
    	for(String name: graph.keySet()){
<<<<<<< HEAD
    		System.out.println(graph.get(name).data.name);
    		Node testFriend = graph.get(name);
    		while( testFriend.next != null){
    			testFriend = testFriend.next;
    			System.out.println(" Is Friends With: " + testFriend.data.name);
    			
    		}
=======
    		System.out.println(printList(graph.get(name)));
>>>>>>> 6e855668f0f23dd0086984b04ce9058b59bcd705
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
     * Completes an array list of friends, recurses to reach end of list. 
     * @param firstFriend
     * @param secondFriend
     */
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
