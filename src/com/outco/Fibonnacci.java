package com.outco;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class Fibonnacci {
	Fibonacci fbo;

	@Before
	public void setUp() throws Exception {
		fbo = new Fibonacci();
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void test() {		
		System.out.println(" number is " + fbo.getFibonnacciValue(8));
		assertEquals(21, fbo.getFibonnacciValue(8));
	}
	
	@Test 
	public void test2(){
		System.out.println(" this is the list of f " + fbo.nthFibonaci(8) );
		System.out.println(" this is the list of f " + fbo.buffer );
		
		
	}
	
	//numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
	class Fibonacci{
		
		ArrayList<Integer> buffer;		
		
		public Fibonacci(){
			buffer = new ArrayList<>();
			buffer.add(0);
			buffer.add(1);
		}
		
		int nthFinonacci2(int n){
			
			
			return buffer.get(n);
		}
		
		
		int nthFibonaci(int goal){
			int n = 2;
			return getNthFibo(n, goal);
		}
		
		int getNthFibo(int n,  int goal){
			
			if ( n <= goal){
				buffer.add(getFibonnacciValue(n));
				return getNthFibo(n + 1, goal );
			}			
			
			return buffer.get(goal);
			
		}
		
		int getFibonnacciValue(int n){
			
			if ( 0 == n) return 0;
			if ( 1 == n || 2 == n) return 1;
			
			return getFibonnacciValue( n - 1 ) + getFibonnacciValue(n - 2);			
		}
		
		
	}

}
