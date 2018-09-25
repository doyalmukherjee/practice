package com.coding.questions.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
	String word;
	int count;

	public Pair(String word, int count) {
		this.word = word;
		this.count = count;
	}
}

public class KFrequencyWords {
	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
			public int compare(Pair a , Pair b){
                if(a.count==b.count){
                    return b.word.compareTo(a.word);
                }else{
                   return a.count-b.count; 
                }
            }
		});

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Pair p = new Pair(entry.getKey(), entry.getValue());
			queue.offer(p);
			if (queue.size() > k)
				queue.poll();
		}

		while (queue.size() > 0) {
			result.add(queue.poll().word);
		}

		//Collections.sort(result);
		Collections.reverse(result);

		return result;
	}
	
	public static void main(String[] args) {
		KFrequencyWords kf = new KFrequencyWords();
		System.out.println(kf.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
	}
}
