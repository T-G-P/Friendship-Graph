
public class User {
	   /**
     * Name of User
     */
    String name;

    /**
     * Name of User's school.
     */
    String school; //if school is null, they are not a student
    
    Node neighbors; //each user has a linked list of friends


    public User(String name, String school, Node neighbors){

        this.name = name;
        this.school = school;
        this.neighbors = neighbors;
        
    }

}
