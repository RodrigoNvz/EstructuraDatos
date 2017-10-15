package Practica07;

import java.util.Arrays;

public class Main {
	
	public static String checkForBalance(String expression) {
		
		String[] arr = (expression.split("")); 
		Stack iStack = new Stack(); 
		String error="";
		
		for (int i=0;i<=arr.length-1;i++) {

			if(arr[i].equals("(") || arr[i].equals("{") || arr[i].equals("[")) {
				iStack.push(arr[i]);
			}else if(arr[i].equals(")")){
				
				if (iStack.empty()) {
					error+="\n";
					for (int e=0; e<i;e++) {
						error+=" ";
					}
					return expression+error+"^ Missing left symbol";
				}else if(iStack.peek().equals("(")) {
					iStack.pop();
				}else {
					error+="\n";
					for (int e=0; e<i;e++) {
						error+=" ";
					}
					return expression+error+"^ Missing left symbol";
				}
					
			}else if(arr[i].equals("]")){
				if (iStack.empty()) {
					error+="\n";
					for (int e=0; e<i;e++) {
						error+=" ";
					}
					return expression+error+"^ Missing left symbol";
				}else if(iStack.peek().equals("[")) {
					iStack.pop();
				}else {
					error+="\n";
					for (int e=0; e<i;e++) {
						error+=" ";
					}
					return expression+error+"^ Missing left symbol";
				}
			}else if(arr[i].equals("}")){
				if (iStack.empty()) {
					error+="\n";
					for (int e=0; e<i;e++) {
						error+=" ";
					}
					return expression+error+"^ Missing left symbol";
				}else if(iStack.peek().equals("{")) {
					iStack.pop();
				}else {
					error+="\n";
					for (int e=0; e<i;e++) {
						error+=" ";
					}
					return expression+error+"^ Missing left symbol";
				}
			}		
		}if(iStack.empty()) {
			return expression+"\nExpression is balanced";
		}else {
			error+="\n";
			for (int e=0; e<expression.length();e++) {
				error+=" ";
			}
			return expression+error+"^ Missing right symbol";
		}
	}

	public static String postfixEval(String expression) {
		int Total=0;
		String errorO="The expression has too many operands";
		String errorD="The expression has too many operators";
		String[] arr = (expression.split(" ")); 
		int D1;
		int D2;
		Stack OStack = new Stack(); 
		Stack DStack = new Stack();
		for (int i=0;i<=arr.length-1;i++) {
  			Total=0;
			if(arr[i].equals("+")) {
				if(!DStack.empty()) {
					D2=Integer.parseInt(DStack.pop().toString());
					if(!DStack.empty()) {
						D1=Integer.parseInt(DStack.pop().toString());
						Total=D1+D2;
						DStack.push(Total);
					}else {
						return errorD;
					}
				}else {
					return errorD;
				}
				
			}else if(arr[i].equals("*")) {
				if(!DStack.empty()) {
					D2=Integer.parseInt(DStack.pop().toString());
					if(!DStack.empty()) {
						D1=Integer.parseInt(DStack.pop().toString());
						Total=D1*D2;
						DStack.push(Total);
					}else {
						return errorD;
					}
				}else {
					return errorD;
				}
			}else if(arr[i].equals("/")) {
				if(!DStack.empty()) {
					D2=Integer.parseInt(DStack.pop().toString());
					if(!DStack.empty()) {
						D1=Integer.parseInt(DStack.pop().toString());
						Total=D1/D2;
						DStack.push(Total);
					}else {
						return errorD;
					}
				}else {
					return errorD;
				}
				
			}else if(arr[i].equals("-")) {
				if(!DStack.empty()) {
					D2=Integer.parseInt(DStack.pop().toString());
					if(!DStack.empty()) {
						D1=Integer.parseInt(DStack.pop().toString());
						Total=D1-D2;
						DStack.push(Total);
					}else {
						return errorD;
					}
				}else {
					return errorD;
				}
				
			}else {
				DStack.push(arr[i]);
			}
		}
		
		Total=Integer.parseInt(DStack.pop().toString());
		if(DStack.empty()) {
			return String.valueOf(Total);
		}else {
			return errorO;
		}
	
	}
	public static void fibonacci(int n) {
		String ans="";
		Queue<Integer> fila = new Queue<Integer>();
		int D1=1;
		int D2=1;
		fila.offer(D1);
		fila.offer(D2);
		for(int i =0;i<n;i++) {
			D1=Integer.parseInt(fila.remove().toString());
			ans+=D1+" ";
			D2=Integer.parseInt(fila.remove().toString());
			fila.offer(D2);
			fila.offer(D1+D2);
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		System.out.println("Testing balanced symbols");
		System.out.println(checkForBalance("t = arr[3] + a) - 4"));
		System.out.println(checkForBalance("if (arr(3] < 4)"));
		System.out.println(checkForBalance("System.out.println(std.charAt(3);"));
		System.out.println(checkForBalance("while (i > 100) { sum += i; i++; }"));
		System.out.println();
		
		System.out.println("Testing postfix evaluation");
		System.out.println("4 3 5 * + => " + postfixEval("4 3 5 * +"));
		System.out.println("1 2 * 3  4 / - => " + postfixEval("1 2 * 3 4 / -"));
		System.out.println("1 2 * 3 * 4 * 5 * 6 * => " + postfixEval("1 2 * 3 * 4 * 5 * 6 *"));
		System.out.println("1 2 3 * 4 + 5 / + => " + postfixEval("1 2 3 * 4 + 5 / +"));
		System.out.println("2 2 * 4 1 * 3 * - 2 1 * / => " + postfixEval("2 2 * 4 1 * 3 * - 2 1 * /"));
		System.out.println("3 8 + * 9 => " + postfixEval("3 8 + * 9"));
		System.out.println("9 8 + 7 => " + postfixEval("9 8 + 7"));
		System.out.println();
		
		System.out.println("Testing Fibonacci sequence");
		fibonacci(20);
		System.out.println();
		
		System.out.println("Testing the Printer class");
		Printer printer = new Printer();
		printer.printDocument("gato.jpg");
		printer.printDocument("tarea.docx");
		printer.printDocument("meme.png");
		try {
			printer.runPrinter();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
