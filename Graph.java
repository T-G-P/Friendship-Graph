import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Graph {
	Scanner sc;//being passed into constructor
	HashMap<String, Node> graph;
	
	public Graph(Scanner sc){
		this.sc = sc;
	}

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
            Node secondFriendCopy = new Node(secondFriend.data,null);
            makeFriendships(firstFriend, secondFriendCopy);
            makeFriendships(secondFriend, firstFriendCopy);
            
    	}
    	
    	printGraph(graph);
    	
=======
    		String line = sc.nextLine();
    		line.toLowerCase();
    		Scanner lineSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
        	Node firstFriend = graph.get(lineSc.next());
        	Node secondFriend = new Node(graph.get(lineSc.next()).data, null);
    		makeFriendships(firstFriend, secondFriend);
    		
    	}
    	printGraph(graph);
>>>>>>> f7c9e2a55ff594233ee2878d840a8749fc855ea9
    	
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
    
    private void printGraph(HashMap<String, Node> graph){
    	for(String name: graph.keySet()){
<<<<<<< HEAD
    		System.out.println(printList(graph.get(name)));
=======
    		System.out.println(graph.get(name).data.name);
    		Node testFriend = graph.get(name);
    		while( testFriend.next != null){
    			System.out.println(" Is Friends With: " + testFriend.data.name);
    			testFriend = testFriend.next;
    		}
>>>>>>> f7c9e2a55ff594233ee2878d840a8749fc855ea9
    	}
    	
    }
    
    private User makeUser(String line){
    	line.toLowerCase();
<<<<<<< HEAD
    	Scanner Usersc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
    	User person = new User(null, null);    	
    	person.name = Usersc.next();
    	if (Usersc.next().equals("y")){
    		person.school = Usersc.next();
=======
    	Scanner makeUserSc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
    	User person = new User(null, null);    	
    	person.name = makeUserSc.next();
    	if (makeUserSc.next().equals("y")){
    		person.school = makeUserSc.next();
>>>>>>> f7c9e2a55ff594233ee2878d840a8749fc855ea9
    	}    	 
    	return person;
    	     	   	
    }
    private void makeFriendships(Node firstFriend, Node secondFriend) {
    	System.out.print("HEEEEEEREEE:   " + firstFriend.data.name);
    	if(firstFriend.next == null){
    		System.out.prinln("hello");
    		firstFriend.next = secondFriend;
    	} else {
    		makeFriendships(firstFriend.next, secondFriend);
    	}
    	
    }
    
    
    
    public void printUser(User person) {
    	System.out.println("Name: " + person.name);
    	System.out.println("School: " + person.school);
    	
	}

   

}
