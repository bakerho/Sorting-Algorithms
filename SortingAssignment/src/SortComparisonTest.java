//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
/*
 * 	a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * 			Insertion Sort - this factor can calculate the worst case running time for this sorting algorithm.
 * 							 The worst case for Insertion Sort is when the array is reverse sorted.
 * 							 Therefore, the order of input has an impact on the this sorting algorithm.
 * 			Quick Sort - 	 The worst case of this algorithm is impacted when the array is sorted or reverse sorted.
 * 							 Therefore, the order of input matters.
 * 			The rest of the algorithms are independent of the distribution of input. 
 * 
	b. Which algorithm has the biggest difference between the best and worst performance, based
	on the type of input, for the input of size 1000? Why?
	
			 Quick Sort -   best performance: O(nlog(n))	// n = size of input
							worst performance: O(n^2)
					     	One of the fastest sorting algorithms in terms of best and average  time complexity. But in relation to worst-case input,
					    	its performances is O(n^2). 
	
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	based on the input size? Please consider only input files with random order for this answer.
		 
	Merge Sort-		This sorting algorithm scales very well to large lists, as its worst-case running time is O(nlogn).
					With a best running time of O(nlogn), therefore the best scalability.
	Selection +Insertion Sort -	This has the worst scalability as it has the biggest difference in performance time compared to the other
								sorting algorithms.
	d. Did you observe any difference between iterative and recursive implementations of merge
	sort?
		Variables created during recursion are stored on stack whereas, iteration doesnt't require a stack. The iterative mergesort doesn'y
		require explicit auxiliary stack.
		
	e. Which algorithm is the fastest for each of the 7 input files? 
		 (1) 10 -> all algorithms had same timing
		 (2) 100 -> insert/quick and both merge
		 (3) 1000 -> Quick Sort
		 (4) 1000 Duplicates -> Both merge Sorts
		 (5) 1000 nearly Orded -> Quick Sort
		 (6) 1000 reverse -> Quick sort + Both Merge Sorts
		 (7) 1000 sorted -> Insertion Sort 
 */
//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Holly Baker
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double a[] = new double [0];
    	a=null;
    	assertEquals(null,SortComparison.insertionSort(a));
    	assertEquals(null,SortComparison.quickSort(a));
    	assertEquals(null,SortComparison.mergeSortRecursive(a));
    	assertEquals(null,SortComparison.mergeSortIterative(a));
    	assertEquals(null,SortComparison.selectionSort(a));
    }
    @Test 
    public void testWholeArray() {
    	double a[] = {6,3,8,9,7,2};
    	double b[] = a ;
    	double correctArray[] = {2,3,6,7,8,9};
    	SortComparison.insertionSort(a);
    	assertTrue(Arrays.equals(correctArray, a));
    	a = b;
    	SortComparison.quickSort(a);
    	assertTrue(Arrays.equals(correctArray, a));
    	a = b;
    	SortComparison.mergeSortIterative(a);
    	assertTrue(Arrays.equals(correctArray, a));
    	a = b;
    	SortComparison.mergeSortRecursive(a);
    	assertTrue(Arrays.equals(correctArray, a));
    	a = b;
    	SortComparison.selectionSort(a);
    	assertTrue(Arrays.equals(correctArray, a));
    	a = b;
    	//Test missed branches in code 
    	double c[] = {7,3,3,9,1,6,5,2,6};
    	double d[]= c;
    	double secondCorrectArray [] = {1,2,3,3,5,6,6,7,9}; 
    	SortComparison.mergeSortIterative(c);
    	assertTrue(Arrays.equals(secondCorrectArray, c));
    	

    	double e[] = {7,3,3,9,1,6,5,2,6,2,4,6,8};
    	double f[]= e;
    	double thirdCorrectArray [] = {1,2,2,3,3,4,5,6,6,6,7,8,9}; 
    	SortComparison.mergeSortRecursive(e);
    	assertTrue(Arrays.equals(thirdCorrectArray, e));
    	e = f;
    	
    	double g[] = {8,4,9,2,1,1,4,9,5};
    	double h[]= g;
    	double fourthCorrectArray [] = {1,1,2,4,4,5,8,9,9}; 
    	SortComparison.selectionSort(g);
    	assertTrue(Arrays.equals(fourthCorrectArray, g));
    	g = h;
    	
 
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *	Did in other main 
     */
	 /*`						Insert 	Quick 	Merge Recursive	 Merge Iterative 	Selection
	  * 	10 random			 0 ms	0 ms			0ms			0ms					0ms
			100 random			 0 ms   0 ms 			0ms			0ms					1ms
			1000 random			 8 ms   2 ms			3ms			4ms					11ms
			1000 few unique		 9 ms   4 ms            2ms         2ms    				8ms
			1000 nearly ordered  4 ms   1 ms			3ms			2ms					10ms
			1000 reverse order   12ms	2 ms			2ms			2ms					9ms
			1000 sorted			 0ms	1 ms			3ms			2ms					8ms
     * 
     */
    //public static void main(String[] args)
    //{
    	
    //}

}
