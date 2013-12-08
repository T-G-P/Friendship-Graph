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
            
            printGraph(graph);
            
    }
    
    /**
* Creates a subgraph of friendships within a school.
* @param school
*/
    public void subGraph(String school){
            subGraph = new HashMap<String, Node>();
            for (String name: graph.keySet()){
                    if(graph.get(name).data.school.equals(school)){
                            subGraph.put(name, graph.get(name));
                    }
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

}