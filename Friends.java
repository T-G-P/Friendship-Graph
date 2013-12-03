import java.io.*;
import java.lang.*;
import java.util.*;

public class Friends{

    static Scanner stdin = new Scanner(System.in);

    static char getOption() {
        System.out.print("\tChoose action: ");
        System.out.print("(1) students at a school, ");
        System.out.print("(2) shortest intro chain, ");
        System.out.print("(3) cliques at school, ");
        System.out.print("(4) connectors, ");
        System.out.print("(q)uit? => ");
        char response = stdin.next().toLowerCase().charAt(0);

        while (response != '1' && response != '2' && response != '3' && response != '4' && response != 'q') {
            System.out.print("\tYou must enter one of 1, 2, 3, 4, or q => ");
            response = stdin.next().toLowerCase().charAt(0);
        }
        return response;
    }
    public static void main(String[] args){
        //buildGraph
        //shortestPath
        //printClique
        //Graph Class
        //fields: mainGraph, subGraph
        //printConnectors
        System.out.print("Enter the input file name => ");
        String graphFile = stdin.next();
        //Graph graph = new Graph(new Scanner(new File(graphFile)));
        //graph.buildGraph();
        char option;
        while ((option = getOption()) != 'q') {
            if (option == '1') {
                System.out.print("1");
            } else if (option == '2') {
                System.out.print("2");

            } else if (option == '3') {
                System.out.print("3");

            } else if(option == '4') {
                System.out.print("4 ");

            }
            else{
                ;
            }

        }

    }


class User{

    /**
     * True if User is a Student, False if User is not
     */
    boolean student;

    /**
     * Name of User
     */
    String name;

    /**
     * Name of User's school.
     */
    String school;


    public User(boolean student, String name, String school){
        this.student = student;
        this.name = name;
        this.school = school;
    }


}

class Graph{
    /**
     * This will create the main graph
     */
    DATASTRUCTURE mainGraph;

    /**
     * This will create the sub graph
     */
    DATASTRUCTURE subGraph;

    /**
     * This scanner object contains the file inputed by the user.
     */
    Scanner sc;

    public Graph(Scanner sc){
        this.sc = sc;
        subGraph = null;
        mainGraph = null;
    }

    public graphBuild(){
        //builds the graph
    }

    public graphBuildSub(){
        //builds the subgraph
    }


}
