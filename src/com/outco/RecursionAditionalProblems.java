package com.outco;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class RecursionAditionalProblems {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void problem1() {
		int [] input = {1,9,3,4,5};
		
		Problem1 problem1 = new Problem1(input);		
		assertEquals(9, problem1.iterativeSolution());
		assertEquals(9, problem1.recursiveSolution());
	}
	
	
	@Test
	public void problem2(){
		int [] input = {1,9,3,4,5,1};
		Problem2 problem2 = new Problem2(input);
		
		assertEquals(2, problem2.getOccurrencesIteratively(1));
		assertEquals(2, problem2.getOccurrencesRecursively(1));
		assertEquals(2, problem2.getOccurrencesRecursively2(1));
	}
	
	@Test
	public void problem3(){
		int [] input = {1,9,3,4,5};
		int [] expected = {5,4,3,9,1};
		
		Problem3 problem3 = new Problem3(input);
		assertTrue( Arrays.equals(expected, problem3.reverseIterativaly()));
		assertTrue( Arrays.equals(expected, problem3.reverseRecursively()));
		System.out.println(" " + Arrays.toString(problem3.reverseRecursively()));
		
		
		
	}
	
	
	class Problem1{
		private int [] input;
		
		public Problem1(int [] input){
			this.input = input;
		}		
		
		public int iterativeSolution(){
			int result = Integer.MIN_VALUE;
			
			for( int n : input){
				if ( n > result) result = n;
			}						
			return result;
		}
		
		public int recursiveSolution(){
			return getSmallest(0, Integer.MIN_VALUE);
		}
		
		private int getSmallest(int index, int biggestNumber){
			if ( index >= input.length) return biggestNumber;
			
			if (input[index] > biggestNumber) biggestNumber = input[index];
			return getSmallest(index + 1, biggestNumber);
			
		}
		
	}
	
	class Problem2{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		private int [] input;
		
		
		public Problem2(int [] input){			
			this.input = input;
		}
		
		
		public int getOccurrencesIteratively(int number){
			int result = 0;
			
			for( int x : input){
				if( x == number) result++;				
			}			
			return result;
		}
		
		
		public int getOccurrencesRecursively(int number){
			return getOccurrences(0, number, 0);
		}
		
		public int getOccurrencesRecursively2(int number){
			return getOccurrences2(0, number);
		}
		
		private int getOccurrences(int index, int number, int occurrences){
			if( index >= input.length) return occurrences;
			
			if( input[index] == number) occurrences++;
			
			return getOccurrences(index + 1, number, occurrences);
		}
		
		private int getOccurrences2(int index, int number){
			int result = 0;
			if( index >= input.length) return 0;
			
			if( input[index] == number) result = 1;
			
			return getOccurrences2(index + 1, number) + result;
		}
	}

	class Problem3{
		private int [] input;
		
		public Problem3(int [] input){
			this.input = input;
		}
		
		public int [] reverseIterativaly(){
			int [] result = new int[input.length];
			
			for( int i= 0; i < input.length; i++){
				result[i] = input[input.length - ( 1 + i)];
			}			
			return result;
		}
		
		public int [] reverseRecursively(){
			int [] result = new int[input.length];
			getValue(0, result);
			return result;
		}
		
		private void getValue(int index, int [] result){
			if ( index >= input.length) return;
			int value = input[input.length - ( 1 + index)];
			getValue(index + 1, result);
			result[index] = value;
		}
		
		
		
		
		
		
	}
	
	

}










































//