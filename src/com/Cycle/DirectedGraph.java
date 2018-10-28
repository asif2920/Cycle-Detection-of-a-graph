package com.Cycle;
/**
 * 
 * @author Asif
 * @param vertices this defines the vertices for that graph
 * @param adjacencyList this linked list stores the 
 * adajacency list for each of the vertices
 *
 */

import java.util.LinkedList;

public class DirectedGraph {
	private int vertices;
	LinkedList<Integer>[] adjacencyList;
	/**
	 * INitialization is done here
	 * @param v
	 */
	public DirectedGraph(int v) {
		this.vertices=v;
		adjacencyList=new LinkedList[vertices];
		for(int i=0;i<vertices;i++) {
			adjacencyList[i]=new LinkedList<>();
		}
	}

	public void addEdge(int sourceNode, int destinationNode) {
		adjacencyList[sourceNode].addFirst(destinationNode);
		
	}
	
	public boolean isCycle() {
		
		boolean visited[]=new boolean[vertices];
		boolean recursiveArr[] = new boolean[vertices];
		for(int i=0;i<vertices;i++) {
			if(cycleCheck(i,visited,recursiveArr)) {
				return true;
			}
		}
		return false;
	}

	private boolean cycleCheck(int vertex, boolean[] visited, boolean[] recursiveArr) {
        visited[vertex]=true;
        recursiveArr[vertex]=true;
        //Recursive call to the adjacent vertices
        for(int i=0;i<adjacencyList[vertex].size();i++) {
        	int adjVertex=adjacencyList[vertex].get(i);
        	if(!visited[adjVertex] && cycleCheck(adjVertex, visited, recursiveArr)) {
        		return true;
        	}else if(recursiveArr[adjVertex]) {
        		return true;
        	}
        }
        // No cycle found out 
        recursiveArr[vertex]=false;
		return false;
	}

}
