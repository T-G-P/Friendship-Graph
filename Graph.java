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
    	while(graph.size() <= numPeople && sc.hasNextLine()){
    		Node temp = new Node(makeUser(sc.nextLine()), null);
    		graph.put(temp.data.name, temp);
    	}
    	while(sc.hasNextLine()){
    		String line = sc.nextLine();
    		line.toLowerCase();
    		Scanner sc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
        	Node firstFriend = graph.get(sc.next());
        	Node secondFriend = graph.get(sc.next());
    		makeFriendships(firstFriend, secondFriend);
    		
    	}
    	
    	
    }
    
    private void printGraph(HashMap<String, Node> graph){
    	for(String name: graph.keySet()){
    		System.out.println(graph.get(name).data.name);
    	}
    	
    }
    
    private User makeUser(String line){
    	line.toLowerCase();
    	Scanner sc = new Scanner(line).useDelimiter("\\s*\\|\\s*");
    	User person = new User(null, null);    	
    	person.name = sc.next();
    	if (sc.next().equals("y")){
    		person.school = sc.next();
    	}    	 
    	return person;
    	     	   	
    }
    private void makeFriendships(Node firstFriend, Node secondFriend) {
    	if(firstFriend.next == null){
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
