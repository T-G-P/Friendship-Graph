import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


/**
* Graph Class
*
* @author Raphael Kelly
* @author Tobias Perelstein
*/

public class Graph {
        Scanner sc;//being passed into constructor
        HashMap<String, Node> graph;
		ArrayList<String> visited = new ArrayList<String>();
        
    /**
     * Constructor Method
     */
    public Graph(Scanner sc){
                this.sc = sc;
        }        
        
        
        
    /**
     * This method has two loops, the first fills the hashtables with nodes containing a user object as the data.
     * The second loop creates an linked list of each persons complete list of friends
     */
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
            
    }
    
    /**
     * Creates a subgraph of friendships within a school and prints them out in graph input format. 
     * @param school
     */
    public HashMap<String,Node> subGraph(String school){
            HashMap<String,Node> subGraph = new HashMap<String, Node>();
            for (String name: graph.keySet()){
                    if(graph.get(name).data.school != null && graph.get(name).data.school.equals(school)){
                            subGraph.put(name, scanFriends(school, graph.get(name)));
                    }
            }
            return subGraph;
    }
    
    
    public void buildCliques(HashMap<String,Node> subGraph){
    		int i = 1 ;
    		HashMap<String, Node> resultMap = new HashMap<String, Node>();
    		for (String name: subGraph.keySet()){
    			if (!visited.contains(subGraph.get(name))){
    				resultMap = dfs(subGraph, subGraph.get(name));
    				System.out.println("Clique" + i + " 1:");
    				i++;
    			}
    		}
    }	
    
    public HashMap<String,Node> dfs(HashMap<String,Node> subGraph, Node person){
    	return resultMap;
    }
    
    public void printSubGraph(HashMap<String, Node> subGraph){

        Stack<ArrayList<String>> qf = new Stack<ArrayList<String>>();
        System.out.println(subGraph.size());
        for (String name: subGraph.keySet()){
        	char student;
        	if (subGraph.get(name).data.school != null){
        		student = 'y';
        	} else {
        		student = 'n';
        	}
        	if (student == 'n'){
        		System.out.println(subGraph.get(name).data.name + "|" + student );
        	} else {
        		System.out.println(subGraph.get(name).data.name + "|" + student + "|" + subGraph.get(name).data.school );
        	}
        }
        for (String friendAlpha: subGraph.keySet()){
        	Node friendBeta = subGraph.get(friendAlpha);
        	while(friendBeta.next != null){
        		friendBeta = friendBeta.next;
        		ArrayList<String> twoFriends = new ArrayList<>(2);
        		twoFriends.add(friendAlpha);
        		twoFriends.add(friendBeta.data.name);
        		qf.push(twoFriends);
        	}
        	
        }
        while (!qf.empty()){
        	ArrayList<String> test = qf.pop();
        	ArrayList<String> reverse = new ArrayList<String>(2);
        	reverse.add(test.get(1));
        	reverse.add(test.get(0));
        	if (!qf.contains(reverse)){
        		System.out.println(reverse.get(0) + "|" + reverse.get(1));
        	}
        }
        
        
    }
    
    
    /**
     * 
     */
    public Node scanFriends(String school, Node person){
    		if (person.next != null){
    			person.next = scanFriends(school, person.next);
    		}
	    	if (person.data.school != null && person.data.school.equals(school)){
	    		return person; 
	    	} else {
	    		return person.next;
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
     * Completes an linked list of friends, recurses to reach end of list.
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
    
    
    /**
     * Prints user and the friends they have
     */
    
    void printGraph(HashMap<String, Node> graph){
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


    public String BFS(String source, String target){
    	Queue<ArrayList<String>> paths = new Queue<ArrayList<String>>();
    	ArrayList<String> path = new ArrayList<String>();
    	Queue<Node> q = new Queue<Node>();
    	Node start = graph.get(source);
    	q.enqueue(start);
    	ArrayList<Node> visited = new ArrayList<Node>();
    	
    	//ArrayList<String> previous = new ArrayList<String>();
    	visited.add(start);
    	path.add(start.data.name);
    	paths.enqueue(path);
    	
    	
    	while(!(q.isEmpty())){
        	Node temp = graph.get(q.dequeue().data.name);
        	ArrayList<String> tempPath = paths.dequeue();
        	//visited.add(temp);
        	//previous.add(temp.data.name);
        	
    		if(temp.data.name.equals(target)){
    			String answer="";
    			for(int i = 0; i<tempPath.size(); i++){
    				answer+=tempPath.get(i)+"--";
    				
    			}
    			answer = answer.substring(0,(answer.length()-2));
    			return answer;
    		}
    		else{
    			for(Node ptr=temp; ptr!=null; ptr=ptr.next){
    				if(!(visited.contains(ptr))){
    					q.enqueue(ptr);
    					ArrayList<String> tempPathCopy = new ArrayList<String>(tempPath);
    					tempPathCopy.add(ptr.data.name);
    					paths.enqueue(tempPathCopy);
    					visited.add(ptr);
    					
    				}
    				
    			}
    			
    		}
    		for(int i = 0; i<visited.size(); i++){
    			System.out.println(visited.get(i).data.name);
    		}
    		
    	}
    	
    	return "No Path ExiZts";
    }

}