import java.io.*;
import java.lang.*;
import java.util.*;

public class Friends{
	
	public static void main(String[] args){
		//buildGraph
		//shortestPath
		//printClique
		//Graph Class
			//fields: mainGraph, subGraph
		//printConnectors
		
		
	}
	
	public void buildGraph(){
		
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