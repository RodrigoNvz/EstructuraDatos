package Examen03;

import Practica07.Stack;

public class Main {
	
	public static String allStar(String str) {

		if (str.length() == 1) {
			return str;
		}else {	
			char firstChar = str.charAt(0);
			return firstChar+"*"+allStar(str.substring(1));			
		}
		
	}
	
	public static String endX(String str) {
		if (str.length()==0) {
			return str;
		}else if (str.substring(0, 1).equals("x")) {
			return endX(str.substring(1)) + "x";
		}else {
			return str.substring(0, 1)+endX(str.substring(1));
		}
	}
	
	public static int maxDepth(String exp) {
		int stabilizer=0;
		int max=0;
		
		for (int i=0; i<exp.length();i++) {
			String iChar = exp.substring(i,i+1);
			if (iChar.equals("(")) {
			//	System.out.println("Find one )");
				stabilizer+=1;
				if (stabilizer>max) {
					max=stabilizer;
				}
			}else if(iChar.equals(")")) {
			// System.out.println("1"+stabilizer);
				if (stabilizer>0) {
					stabilizer-=1;
				}else {
					return -1;
				}
			}
			
		}
		// System.out.println("s"+stabilizer);
		if (stabilizer==0) {
			return max;
		}else {
			return -1;
		}
		
	}
	
	public static LinkedList<Integer> intersect(LinkedList<Integer> list1,LinkedList<Integer> list2){
		LinkedList<Integer> list3= new LinkedList<Integer>();
		for (int i = 0 ; i<list1.size(); i++ ) {
			Integer element = list1.get(i);
			for(int j=0; j<list2.size(); j++) {
				if (element.equals(list2.get(j))){
					if (!list3.contains(element)) {
						list3.addFirst(element);
					}
				}
			}
		}
		return list3;
	}
	
	public static LinkedList<Integer> difference(LinkedList<Integer> list1,LinkedList<Integer> list2){
		LinkedList<Integer> list3= new LinkedList<Integer>();
		boolean estuvo = false;
		for (int i = 0 ; i<list1.size(); i++ ) {
			Integer element = list1.get(i);
			for(int j=0; j<list2.size(); j++) {
				if (element.equals(list2.get(j))){
					if (element.equals(list2.get(j))){
						estuvo=true;
					}
				}
			}
			if (estuvo==false) {
				if (!list3.contains(element)) {
					list3.addFirst(element);
				}
			}
		}
		
		return list3;
		
	}
		
	
	public static void main(String[] args) {
		System.out.println(allStar("HELLO"));
		System.out.println(allStar("o"));
		System.out.println(endX("xox"));
		System.out.println(endX("xhxixhxix"));
		System.out.println(maxDepth("(a(b)(d(e(f)g)h)o)"));
		LinkedList<Integer> list1=new LinkedList<Integer>();
		list1.addFirst(1);
		list1.addFirst(2);
		list1.addFirst(3);
		list1.addFirst(4);
		list1.addFirst(5);
		list1.addFirst(6);
		LinkedList<Integer> list2=new LinkedList<Integer>();
		list2.addFirst(1);
		list2.addFirst(2);
		list2.addFirst(3);
		LinkedList<Integer> list3=new LinkedList<Integer>();
		System.out.println("Lista1 : "+list1.toString());
		System.out.println("Lista2 : "+list2.toString());
		list3 = intersect(list1,list2);
		System.out.println("INTER"+list3.toString());
		list3 = difference(list1,list2);
		System.out.println("DIF"+list3.toString());
		
	}
}
