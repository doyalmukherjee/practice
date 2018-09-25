package com.coding.questions.string;

public class ReverseStringWords {
	public void reverseWords(String source) {
		char[] s = source.toCharArray();
	    int i=0;
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	            reverse(s, i, j-1);      //reverse parts  
	            i=j+1;
	        }
	    }
	 
	    reverse(s, i, s.length-1); // reverse remaining array
	 
	    reverse(s, 0, s.length-1); //reverse whole array
	    
	    System.out.println(s);
	}
	 
	public void reverse(char[] s, int i, int j){
	    while(i<j){
	        char temp = s[i];
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	}
	
	public static void main(String[] args) {
		ReverseStringWords rs = new ReverseStringWords();
		rs.reverseWords("the sky is blue");
	}
}
