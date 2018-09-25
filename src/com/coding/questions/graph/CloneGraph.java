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
		if (node == null)
			return null;

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

		queue.add(node);
		map.put(node, newHead);

		while (!queue.isEmpty()) {
			UndirectedGraphNode curr = queue.pop();
			ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors;

			for (UndirectedGraphNode aNeighbor : currNeighbors) {
				if (!map.containsKey(aNeighbor)) {
					UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
					map.put(aNeighbor, copy);
					map.get(curr).neighbors.add(copy);
					queue.add(aNeighbor);
				} else {
					map.get(curr).neighbors.add(map.get(aNeighbor));
				}
			}

		}
		return newHead;
	}

	public static void main(String[] args) {
		UndirectedGraphNode ug0 = new UndirectedGraphNode(0);
		UndirectedGraphNode ug1 = new UndirectedGraphNode(1);
		UndirectedGraphNode ug2 = new UndirectedGraphNode(2);
		ug0.neighbors = new ArrayList<UndirectedGraphNode>(Arrays.asList(ug1, ug2));
		ug1.neighbors = new ArrayList<UndirectedGraphNode>(Arrays.asList(ug2));
		ug2.neighbors = new ArrayList<UndirectedGraphNode>(Arrays.asList(ug2));

		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode result = cg.cloneGraph(ug0);
		for (UndirectedGraphNode string : result.neighbors) {

		}
	}

}
