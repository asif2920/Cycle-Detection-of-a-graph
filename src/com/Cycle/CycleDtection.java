package com.Cycle;

public class CycleDtection {

	public static void main(String[] args) {
		DirectedGraph dg=new DirectedGraph(5);
		
        dg.addEdge(0, 0);
        boolean result=dg.isCycle();
        System.out.println("Is there a cycle?: "+result);


	}

}
