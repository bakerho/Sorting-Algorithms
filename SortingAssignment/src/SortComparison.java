import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Holly Baker
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        //todo: implement the sort
    	if(a==null){ //could be length
    		System.out.print("Array empty");
    		return null;
    	}
    	for(int i = 1; i <a.length; i++) {
    		double current = a[i];
    		int j = i;
    		while(j>0 && a[j-1]> current) {
    			a[j] =a[j-1];
    			j--;
    		}  
    		a[j]=current;
    	}
    	return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
    	if(a==null||a.length==0) {
    		System.out.print("Array empty");
    		return null;
    	}
    	doQuickSort(a,0,a.length-1);
    	return a;

    }//end quicksort
    private static void doQuickSort(double a[], int low, int high) {
    	if(low>=high)return;
    	//pick the pivot
    	int middle = low + (high -low)/2; 
    	double pivot =a[middle];
    	//make left < pivot and right > pivot
    	int i =low, j = high;
    	while(i<=j) {
    		while(a[i]<pivot) {
    			i++;
    		}
    		while(a[j]>pivot) {
    			j--;
    		}
    		if(i<=j) {
    			double temp= a[i];
    			a[i]=a[j];
    			a[j]=temp;
    			i++;
    			j--;	
    		}
    	}
    	//recursively sort two sub parts
    	if(low<j) doQuickSort(a,low,j);
    	if(high>i) doQuickSort(a,i,high);
    }
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {
    	if(a==null){
    		System.out.print("Array: empty");
    		return null;
    	}
    	int length = (a.length-1);
    	int currentSize; //varies from 1 to n/2
		int leftStart; // pick starting index of left subarray to be merged
		for(currentSize=1; currentSize <= length; currentSize = (2*currentSize)) { //Merge subarrays in bottom up manner
			 for(leftStart =0; leftStart < length ; leftStart += (2*currentSize)) { //Pick starting point of differnet subarrays of current size
				 int mid = leftStart + currentSize -1;
				 int rightEnd = Math.min(leftStart+2*currentSize-1, length);
				 merge(a,leftStart,mid,rightEnd);
			 }
		 }
		 return a;
    }
    //Fucntion to mrerge the two havle a[start...mid]and a [mid+1...end ] of array a[]
      static void merge(double a[],int start,int mid, int end) {
    	int i,j,k;
    	int size1 = mid - start +1;
    	int size2 = end - mid;
    	if (size2 > 0 && size1 > 0) {
    		double leftA[] = new double[size1]; // temp arrays
        	double rightA[] = new double[size2];
        	for(i=0;i < size1;i++) leftA[i] = a[start+i]; //Copy data into temp arrays 
        	for(j=0;j<size2;j++) rightA[j] = a[mid+1+j];
        	i=0; // Merge temp arrays back into a[]
        	j=0;
        	k=start;
        	while (i<size1 && j < size2) {
        		if(leftA[i]<=rightA[j]) {
        			a[k]=leftA[i];
        			i++;
        		}else {
        			a[k]=rightA[j];
        			j++;
        		}
        		k++;
        	}
        	while(i<size1) { //if remaining in leftA[] copy in
        		a[k]=leftA[i];
        		i++;
        		k++;
        	}
        	while(j<size2) { //if remaining in rightA[] copy in
        		a[k]=rightA[j];
        		j++;
        		k++;
        	}
    	}	
    }
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	if(a==null){
    		System.out.print("Array empty");
    		return null;
    	}
    	if(a.length>1) {
    		int mid=a.length/2;
    		//spilt left part
    		double[] left =new double[mid];
    		for(int i =0 ; i <mid;i++) {
    			left[i]=a[i];
    		}
    		//spilt right part
    		double[] right =new double[a.length-mid];
    		for(int i=mid; i< a.length;i++) {
    			right[i-mid]=a[i];
    		}
    		mergeSortIterative(left);
    		mergeSortIterative(right);
    		int i=0;
    		int j=0;
    		int k=0;
    		//Merge left and right arrays
    		while(i<left.length && j<right.length) {
    			if(left[i]<right[j]) {
    				a[k]=left[i];
    				i++;
    			}else {
    				a[k]=right[j];
    				j++;
    			}
    			k++;
    		}
    		//Collect remaining elements
    		while(i<left.length) {
    			a[k]=left[i];
    			i++;
    			k++;
    		}
    		while(j<right.length) {
    			a[k]=right[j];
    			j++;
    			k++;
    		}
    	}

    	return a;
    }
	
   //end mergeSortRecursive
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
    	if(a==null){
    		System.out.print("Array empty");
    		return null;
    	}
    	for (int i =0; i<a.length-1;i++) {
    		int minIndex = i;
    		for(int j =i+1; j<a.length ;j++) { //Find min element in unsorted array
    			if(a[j]<a[minIndex]) {
    				minIndex =j;
    			}
    		}
    		double temp = a[minIndex]; //Swap min with first element 
    		a[minIndex]=a[i];
    		a[i]=temp;
    	}
    	return a;
    }//end selectionsort
    
   
  /*
   * THIS IS THE MAIN THAT PRODUCED THE VALUES FOR THE TABLE.
   * UNCOMMENT FOR ITS FUNCTIONALITY 
   */

  /*  public static void main(String[] args) throws IOException
    {  	
    	int counter =0;
    	File f = new File("C:\\Users\\holly\\Downloads\\assignment input data files (1)");
        File[] files = f.listFiles();
       // for (File file : files) {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("What file would you like to sort: (enter a number)"+ "\n" + "(1)numbers10 " + "\n" +"(2)numbers100" 
				+ "\n" +"(3)numbers1000" + "\n" +"(4)numbers1000Duplicates"+ "\n" + "(5)numbersNearlyOrdered1000 " + "\n" + "(6)numbersReverse1000 " 
        		+ "\n" + "(7)numbersSorted1000 ");
        int choosenFile = (sc2.nextInt() -1 );
        if(files[choosenFile].isFile()) {
        	int sizeArray = getSizeForArray(choosenFile);
        	double a[] =new double [sizeArray];
        	File file = files[choosenFile];
        	System.out.println(file.getName());
        	System.out.println("---------------------------");
        	Scanner sc = new Scanner(file);
        	while (sc.hasNextLine()) {
        		
				a[counter] = Double.parseDouble(sc.nextLine());
				counter++;
        	}
			System.out.println("Which sort method would you like to choose? (enter a number) " + "\n" + "(1)insertion sort" + "\n" +"(2)quick sort" 
						+ "\n" +"(3)merge sort iterative" + "\n" +"(4)merge sort recursive"+ "\n" + "(5)selection sort");
			int sortType = sc2.nextInt();
			calculateSortTime(sortType, a );
        } else System.out.print("Not a number for a file.");
           	
    }
    public static int getSizeForArray(int choosenFile) {
    	choosenFile = choosenFile + 1;
    	if (choosenFile == 1) {
    		return 10;
    	}else if (choosenFile == 2) {
    		return 100;
    	} else {
    		return 1000;
    	}
    }
    public static void calculateSortTime (int sortType, double [] a) {
    	long startTime ; //Time in milliseconds
    	long duration ;
    	if(sortType ==1) {
    		startTime = System.currentTimeMillis();
    		insertionSort(a);
    		duration = System.currentTimeMillis() - startTime;
    		System.out.println("Insertion Sort Time  :    " + duration +" ms"); 		
    	}else if(sortType ==2) {
    		startTime = System.currentTimeMillis();
    		quickSort(a);
    		duration = System.currentTimeMillis() - startTime;
    		System.out.println("Quick Sort Time  :    " + duration +" ms");
    		
    	}else if(sortType==3) {
    		startTime = System.currentTimeMillis();
    		mergeSortIterative(a);
    		duration = System.currentTimeMillis() - startTime;
    		System.out.println("Merge Sort Iterative Time :    " + duration +" ms");
    		
    	}else if(sortType==4) {
    		startTime = System.currentTimeMillis();
    		mergeSortRecursive(a);
    		duration = System.currentTimeMillis() - startTime;
    		System.out.println("Merge Sort Recursive Time :   " + duration +" ms");
    	
    	}else if(sortType==5) {
    		startTime = System.currentTimeMillis();
    		selectionSort(a);
    		duration = System.currentTimeMillis() - startTime;
    		System.out.println("Selection Sort Time :    " + duration  +" ms");
    		
    	}else {
    		System.out.print("Not a valid number for a sort!");
    	
    	} 
    	System.out.println(" Sorted Array  :    " );
    	for(int i = 0; i< a.length; i++) {
    		System.out.println("             " +a[i] );
    	}
    	
    } */
 }//end class
