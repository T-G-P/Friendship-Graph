import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Graph {
	Scanner sc;//being passed into constructor
	HashMap<String, User> graph;
	
	public Graph(Scanner sc){
		this.sc = sc;
	}

    public void buildGraph(){

    	int numPeople = Integer.parseInt(sc.nextLine());
    	System.out.println(numPeople);
    	graph = new HashMap<String, User>();
    	while(graph.size() <= numPeople && sc.hasNext()){
    		User temp = makeUser(sc.next());
    		System.out.print(temp);
    		graph.put(temp.name, temp);
    	}
    	
    	printGraph(graph);
    	
    }
    
    private void printGraph(HashMap<String, User> graph){
    	for(String name: graph.keySet()){
    		System.out.println(graph.get(name));
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
    
    public void printUser(User person) {
    	System.out.println("Name: " + person.name);
    	System.out.println("School: " + person.school);
    	
	}

   

}
