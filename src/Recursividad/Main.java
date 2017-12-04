package Recursividad;

public class Main {
	public int factorial(int n) {
		if (n==0){
			return 1;
		}else{
			return n* factorial(n-1);
		}
	}
	public int bunnyEars(int bunnies) {
		  if (bunnies==0){
		    return 0;
		  }else{
		    return 2+(bunnyEars(bunnies-1));
		  }
		}

	public int bunnyEars2(int bunnies) {
		  
		  if (bunnies == 0){
		    return 0;
		  }else if(bunnies%2 == 0 ){
		    return 3 + bunnyEars2(bunnies-1);
		  }else{
		    return 2 + bunnyEars2(bunnies-1);  
		  }
		  
		}
	
	public int fibonacci(int n)  {
	    if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public int triangle(int rows) {
		  if(rows==0){
		    return 0;
		  }else{
		    return rows+(triangle(rows-1));
		  }
	}
	public int sumDigits(int n) {
		  if (n==0){
		    return 0;
		  }
		  else{
		    int x = n%10;
		    int y = n/10;
		    
		    return x + (sumDigits(y));
		  }
	}
	public int count7(int n) {
	      if (n==0){
	        return 0;
	      }
	  		int x = n%10;
			  int y = n/10;
			  if (x!=7){
			    return 0 + count7(y);
			  }else{
			    return 1 + count7(y);
			  }
	}
	public int count8(int n) {
	      if (n==0){
	        return 0;
	      }
	  		int x = n%10;
			  int y = n/10;
			  int x2 = (y%10);
			  if (x!=8){
			    return 0 + count8(y);
			  }else if(x2==8){
			    return 2 + count8(y);
			  }else{
			    return 1 + count8(y);
			  }
	}
	public int powerN(int base, int n) {
		  if (n==1){
		    return base*n;
		  }
		  else{
		    return base*(powerN(base,n-1));
		  }
	}
	public int countX(String str) {
	    if(str.length()==0) {
	        return 0;
	    }

	    if ((str.substring(0,1).equals("x"))) {
	        return 1 + countX(str.substring(1));
	    }

	    return countX(str.substring(1));
	}

	public String changeXY(String str) {
		  if (str.length() == 0){
		    return str;
		  }
		  if (str.charAt(0) == 'x'){
		    return 'y' + changeXY(str.substring(1));
		  }
		  return str.charAt(0) + changeXY(str.substring(1));
		}
	public boolean array6(int[] nums, int index) {
	    if (nums.length == 0){
	       return false;
	    } 
	    if (index == nums.length - 1) {
	      return nums[index] == 6;
	    }
	    if (nums[index] == 6){
	      return true;
	    }else{
	    
	    return array6(nums, index + 1);

	    }
	}
	public int array11(int[] nums, int index) {
	    if (index == nums.length) {
	      return 0;
	    }
	    if (nums[index] == 11) {
	      return 1 + array11(nums, index + 1);
	    }else {
	      
	    return array11(nums, index + 1);
	    }
	}
	void merge(int arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        /* Create temp arrays */
	        int L[] = new int [n1];
	        int R[] = new int [n2];
	 
	        /*Copy data to temp arrays*/
	        for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	        for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	 
	        int i = 0, j = 0;
	 
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        /* Copy remaining elements of L[] if any */
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	    // Main function that sorts arr[l..r] using
	    // merge()
	    void sort(int arr[], int l, int r)
	    {
	        if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
	// Recursive Java program for insertion sort

	    // Recursive function to sort an array using
	    // insertion sort
    static void insertionSortRecursive(int arr[], int n)
    {
        // Base case
        if (n <= 1)
            return;
      
        // Sort first n-1 elements
        insertionSortRecursive( arr, n-1 );
      
        // Insert last element at its correct position
        // in sorted array.
        int last = arr[n-1];
        int j = n-2;
      
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }
	    
	
	public static void main(String[] args) {
		System.out.println(2%2);
	}

}
