
/*
 * BFS.java
 * breadth first search in binary tree
 * */

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Breadth {
	public static void main(String[] args) {
		Graph graph = new Graph(8);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(4, 7);
		
		graph.addEdge(1, 0);
		graph.addEdge(2, 0);
		graph.addEdge(3, 1);
		graph.addEdge(4, 1);
		graph.addEdge(5, 2);
		graph.addEdge(6, 2);
		graph.addEdge(7, 3);
		graph.addEdge(7, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 5);
		
		
			
		graph.DFS(0);
		graph.printSet();
	}

}

class Graph {
	private int V;
	private List<Integer> list[];
	private boolean[] flag;
	private Set<Integer> set = new LinkedHashSet<>(); 
	
	public Graph(int v) {
		V = v;
		flag = new boolean[V];
		list = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			flag[i] = false; //
			list[i] = new LinkedList<Integer>();
		}
	}
	
	// add an edge m->n to graph
	public void addEdge(int m, int n) {
		list[m].add(n);
	}
	
	public void BFS(int start) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		Set<Integer> set = new LinkedHashSet<>(); 
		
		set.add(start); // visit the head
		flag[start] = true;
		
		int cur;
		int adj;
		queue.add(start);
		while (queue.isEmpty() == false) {
			cur = queue.remove(); // fetch and remove the head
			for (int i = 0; i < list[cur].size(); i++) {
				adj = list[cur].get(i);
				if (flag[adj] == false) {
					set.add(adj); // visit adj
					flag[adj] = true;
					queue.add(adj); // add to queue
				}
			}
		}
		
		System.out.println(set);
	}
	
	public void DFS(int cur) {
		int adj;
	
		set.add(cur); // visit current node
		flag[cur] = true;
		
		while ((adj = adjNotVisted(cur)) != -1) {
			DFS(adj);
		}
	}
	
	// return adj not visited or -1 
	public int adjNotVisted(int node) {
		int adj;
		
		for (int i = 0; i < list[node].size(); i++) {
			adj = list[node].get(i);
			if (flag[adj] == false) {
				return adj;
			}	
		}
		
		adj = -1;
		
		return adj;
	}
	
	public void printSet() {
		System.out.println(set);
	}
}


















