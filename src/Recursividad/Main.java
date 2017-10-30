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
	
	public static void main(String[] args) {
		System.out.println(2%2);
	}

}
