package com.example.memoryleak;

public class Adder {
	
	public long addIncremental(long l)
	{
		Long sum=0L;
		 sum=sum+l;
		
		 return sum;
		
	}
	
	public static void main(String[] args) {
		Adder adder = new Adder();
		long totsum =0;
		for(long i=0;i<1000;i++)
		{
			adder.addIncremental(i);
		}
		 
	}

}
