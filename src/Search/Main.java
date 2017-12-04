package Search;

import java.util.Arrays;

public class Main {
	
	public static int linearSearch(int values[], int target) {
		int index = 0;
		while(index < values.length) {
			if(values[index] == target) {
				return 1;
			}
			if(values[index] > target) {
				return -1;
			}
			index++;
	   }
	   return -1;
	}
	
	public static int binarySearch(int values[], int target) {
		
		int off = 0;
		int on = values.length-1;
		int mid;
		
		while(off <= on) {
			mid=((on+off)/2);
			
			if(values[mid] == target) {
				return 1;
			}
			if(values[mid] < target) {
				off= mid+1;
			}
			if(values[mid] > target) {
				on = mid - 1;
			}
			
		}
		return -1;
	}
	
	public static void insertionSort(int values[]) {
		String strg="";
		for (int i=1; i<values.length;i++) {
		
			int tmp = values[i];
			int j;
			for (j=i-1;j>=0 && tmp < values[j];j--) {
				values[j+1] = values[j];
			}
			values[j+1] = tmp;
		}

	}
	
	public static void selectionSort(int values[]) {
	    for (int i = 0; i < values.length - 1; i++ ) {
	      int min = values[i];
	      int tempMin = i;
	      for (int j = i + 1; j < values.length; j++) {
	        if (min > values[j]) {
	          min = values[j];
	          tempMin = j;
	        }
	      }
	      values[tempMin] = values[i];
	      values[i] = min;
	    }
	 }

	public static void bubbleSort(int values[]) {
	   
	    int uCiclo = values.length-1;
	    while (uCiclo > 0) {
	      int iCiclo = -1;
	      for (int i = 0; i < uCiclo; i++) {
		    int temp = values[i];
	        if (values[i] > values[i+1]) {
	        	values[i] = values[i+1];
	        	values[i+1] = temp;
	          iCiclo = i;
	        }
	      }
	      uCiclo = iCiclo;
	    }
	  }
	
	public static String toString(int[] vals) {
		String strg="(";
		for (int x=0;x<vals.length-1;x++) {
			strg += vals[x]+",";
		}
		strg+=vals[vals.length-1]+")";
		return strg;
	}

    public static void removeTopItem(int arr[], int arrayLength, int index){
    	int child1 = 2*index + 1;  
        int child2 = 2*index + 2; 
        
        int largest = index;
        
        if (child1 < arrayLength && arr[child1] > arr[largest])
            largest = child1;
        if (child2 < arrayLength && arr[child2] > arr[largest])
            largest = child2;
        if (largest != index)
        {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;
            removeTopItem(arr, arrayLength, largest);
        }
    }

    public static void heapSort(int[] values) 
    {
    	for (int i =  values.length/ 2 - 1; i >= 0; i--){
    		removeTopItem(values, values.length, i);
        }
        for (int i = values.length - 1; i>=0; i--)
        {
        	int temp = values[0];
        	values[0] = values[i];
        	values[i] = temp;
        	removeTopItem(values, i, 0);
        }
    }
	

    public static void makeHeap(int[] values){

        for(int i=0;i<values.length;i++){
            int index =i;
            while(index!=0){
                int parent =(index-1)/2;
                if(values[index]<=values[parent]) {
                    break;
                }
                int temp = values[index];
                values[index]=values[parent];
                values[parent]=temp;
                index=parent;
            }
        }
    }


	
	public static void main(String[] args) {
		int[] iArray = {22,34,780,900,78,98,123,456};
		
		System.out.println("Linear search para target 34: ");
		System.out.println(linearSearch(iArray,34));
		System.out.println("Linear search para target 777: ");
		System.out.println(linearSearch(iArray,777));
		System.out.println("Binary search para target 34: ");
		System.out.println(binarySearch(iArray,34));
		System.out.println("Binary search para target 777: ");
		System.out.println(binarySearch(iArray,777));
		
		String answer;
		System.out.println("\nArray original:");
		answer=toString(iArray);
		System.out.println(answer);
		System.out.println("Array después de insertionSort:");
		insertionSort(iArray);
		answer=toString(iArray);
		System.out.println(answer);
		
		int[] iArray2 = {34,56,89,123,43,98,790};
		
		System.out.println("\nArray original:");
		answer=toString(iArray2);
		System.out.println(answer);
		System.out.println("Array después de selectionSort:");
		selectionSort(iArray2);
		answer=toString(iArray2);
		System.out.println(answer);
		
		int[] iArray3 = {23,545,875,32,547,213,457,89,21,1,1,0,6,5};
		
		System.out.println("\nArray original:");
		answer=toString(iArray3);
		System.out.println(answer);
		System.out.println("Array después de bubbleSort:");
		bubbleSort(iArray3);
		answer=toString(iArray3);
		System.out.println(answer);
		
		int[] iArray4 = {23,545,875,32,547,213,457,89,21,1,1,0,6,5};
		System.out.println("\nArray original:");
		System.out.println(Arrays.toString(iArray4));
		System.out.println("\nArray después de makeHeap:");
		makeHeap(iArray4);
		System.out.println(Arrays.toString(iArray4));
		System.out.println("\nHeapSort:");
		heapSort(iArray4);
		System.out.println(Arrays.toString(iArray4));
	}

}

