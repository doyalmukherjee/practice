package com.coding.questions.array;

import java.util.Collections;
import java.util.PriorityQueue;
class Pair
{
	int x;
	int y;
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class GFG {

	// function to display first N
	// maximum sum combinations
	static void NMaxCombinations(int A[], int B[], int N, int K) {
		// max heap.
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

		// insert all the possible
		// combinations in max heap.
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				int sum = A[i] + B[j];
				if(sum<=K)
					pq.add(new Pair(i,j));
			}
				
			
		}

		// pop first N elements
		// from max heap and
		// display them.

		while (!pq.isEmpty()) {
			System.out.println("["+pq.peek().x + ","+ pq.peek().y + "]");
			pq.remove();
		}
	}

	public static void main(String[] args) {
		int A[] = { 4, 2, 5, 1 };
		int B[] = { 8, 0, 5, 3 };
		int N = A.length;
		int K = 7;

		NMaxCombinations(A, B, N, K);

	}
}