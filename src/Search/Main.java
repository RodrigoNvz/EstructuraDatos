package Search;

import javax.xml.crypto.Data;

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
	public static String toString(int[] vals) {
		String strg="(";
		for (int x=0;x<vals.length-1;x++) {
			strg += vals[x]+",";
		}
		strg+=vals[vals.length-1]+")";
		return strg;
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
	}
	

}

