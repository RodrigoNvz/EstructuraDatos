package Examen02;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class Main {
	
	public static String reverseParentheses(String expression) {
		String[] arr = (expression.split(""));
		Stack<String> pila = new Stack<String>();
		Stack<String> pila2 = new Stack<String>();
		Stack<String> pila3 = new Stack<String>();
		for (int i = 0; i<arr.length;i++) {
			if (arr[i].equals("(")) {
				int counter=i+1;
				int j=i+1;
				while (!arr[j].equals(")")) {
						counter++;
						j++;
				}
				for(int z=counter-1;z>i;z--) {
					pila2.push(arr[z]);
				}
				i=j;
			}else {
				pila2.push(arr[i]);
			}
		}
		String r="";
		while(!pila2.empty()) {
			pila.push(pila2.pop());
		}
		while(!pila.empty()) {
			r+=(pila.pop());
		}
		
		
		//Mal intento de recursividad 
		while(Left(r))
		{
			r = reverseParentheses(r);
		}
		return r;
	}
	
	
	
	public static boolean Left(String exp) {
		String[] arr = (exp.split(""));
			for(int i =0; i<arr.length;i++) {
				if (arr[i].equals("(")){
					return true;
				}
			}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(reverseParentheses("Examen estructura de datos"));
		System.out.println(reverseParentheses("a(bc)de"));
		System.out.println(reverseParentheses("(ab)(cd)(ef)g"));
		System.out.println(reverseParentheses("a(bc(de)fg)h"));
		
	}
}
