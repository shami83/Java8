package com.example.impl;

import com.example.java.Print;
import com.example.java.Shape;

public class ShapeClosure {

	
	
	public void computeArea(Shape shape,Print print,int length,int breadth)
	{
		int result = shape.execute(length, breadth);		
		print.print(result);
	}
	
	public static void main(String[] args) {
		
		ShapeClosure closure = new ShapeClosure();
		Shape circle = (a,b)->(int)3.14f*a*b;		
		Print area = (result)->System.out.println("Area of Circle " + result);
		
		closure.computeArea((a,b)->a*b, (result)->System.out.println("Area of Rectangle " + result), 10, 20);
		closure.computeArea(circle, area, 10, 5);
		
		
	}
}
