package com.itpro.util;

public class test {
	public static void main(String[] args) {
	    
	    int sum = 0;
	    String c = "임다";

	    for(int i=1; i<31; i++) {
	          if(!(i%5==0||i%4==0)) {
	        	  System.out.println("i:"+i);
	               sum+=i;
	          }		
		
	    }
	    
	    if(c.charAt(0)=='임') {
	    	System.out.println("임");
	    }

	   System.out.println(sum);
	}

}
