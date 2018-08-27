package com.coding.questions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if(node == null)
	        return null;
	 
	    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	 
	    HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	 
	    queue.offer(node);
	    while(!queue.isEmpty()){
	        UndirectedGraphNode top = queue.poll();
	        map.put(top, new UndirectedGraphNode(top.label));
	 
	        for(UndirectedGraphNode n: top.neighbors){
	            if(!map.containsKey(n))
	                queue.offer(n);
	        }    
	    }
	 
	    queue.offer(node);
	    HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
	    set.add(node);
	 
	    while(!queue.isEmpty()){
	        UndirectedGraphNode top = queue.poll();
	        for(UndirectedGraphNode n: top.neighbors){
	            if(!set.contains(n)){
	                queue.offer(n);
	                set.add(n);
	            }    
	            map.get(top).neighbors.add(map.get(n));    
	        }    
	    }
	 
	    return map.get(node);
	}
	
	public static void main(String[] args) {
		UndirectedGraphNode ug0 = new UndirectedGraphNode(0);
		UndirectedGraphNode ug1 = new UndirectedGraphNode(1);
		UndirectedGraphNode ug2 = new UndirectedGraphNode(2);
		ug0.neighbors= new ArrayList<UndirectedGraphNode>(Arrays.asList(ug1,ug2));
		ug1.neighbors= new ArrayList<UndirectedGraphNode>(Arrays.asList(ug2));
		ug2.neighbors= new ArrayList<UndirectedGraphNode>(Arrays.asList(ug2));
		
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode result = cg.cloneGraph(ug0);
		for (UndirectedGraphNode string : result.neighbors) {
			
		}
	}

}
