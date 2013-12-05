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
    	
		/*StringTokenizer st = new StringTokenizer(sc.toString(), "|", false);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
    	System.out.println(sc.useDelimiter("|"));*/

    	int numPeople = Integer.parseInt(sc.nextLine());
    	System.out.print(numPeople);
    	graph = new HashMap<String, User>();
    	while(graph.size() <= numPeople && sc.hasNext()){
    		User temp = getUser(sc.next());
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
    
    private User getUser(String line){
    	 String splitStrings[] = line.split("|");
    	 User person;
    	 
    	 try{
    		 person = new User(splitStrings[0], splitStrings[2], null);
    	 }catch(IndexOutOfBoundsException e){
    		 person = new User(splitStrings[0], null, null);
    	 }
    	 
    	 return person;
    	 
    	
    	
    }

   

}
