package ExamenFinal;

import java.util.Random;

import Examen03.LinkedList;

public class Main {
	
	public static String cleanString(String str) {
		String newStr = new String();
		str = str.toUpperCase();
		
		for (int i=0; i<str.length();i++) {
			String iChar = str.substring(i,i+1);
			if(iChar.codePointAt(0)>=65 && iChar.codePointAt(0)<=90) {
				newStr+=iChar;
			}

		}
		return newStr;
	}

	
	public static int mystery(int n,int m) {
		if(m==0) {
	    	return n+1;
	    }else if (m>0 && n==0) {
	    	return mystery(m-1,1); 
	    }else if(m>0 && n>0){
	    	return mystery(m-1,mystery(m,n-1)); 
	    }else {
	    	return 0;
	    }
	
	}
	public static LinkedList<Integer> union(LinkedList<Integer> list1,LinkedList<Integer> list2){
		LinkedList<Integer> list3= new LinkedList<Integer>();
		for (int i = 0 ; i<list1.size(); i++ ) {
			Integer element = list1.get(i);
			list3.addLast(element);
		}
		for (int i = 0 ; i<list2.size(); i++ ) {
			Integer element = list2.get(i);
			list3.addLast(element);
		}
		return list3;
	}
	public static void insertInOrder(LinkedList<Integer> list1,int element){
		boolean didIt =false;
		for (int i = 0 ; i <  list1.size(); i++ ) {

			System.out.println(list1.size());
			Integer elt = list1.get(i);
			if(elt>element) {
				didIt=true;
				System.out.println("NO");
				list1.add(i, element);;
			}else if(i==(list1.size()-1) && didIt ==false ) {
				list1.addLast(element);
			}
		}
	
	}
	
	public static void eraseInOrder(LinkedList<Integer> lst, int count, boolean desc) {
		if (count<lst.size()) {
			if(desc==true) {
				for (int i = 0 ; i<count; i++ ) {
					lst.removeLast();
				}
			}else {
				for (int i = 0 ; i<count; i++ ) {
					lst.removeFirst();
				}
			}
		}else {
			lst =new LinkedList<Integer>();
		}
	}
	
	public static int get(Stack<Integer> stack, int i) {
		try {
			for (int j =0;j<i-1;j++) {
				stack.pop();
			}
			return stack.pop();
		} finally {
			return -1;
		}
	}
	
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
	public static LinkedList<Item> greedy(LinkedList<Item> lista, int maxVal) {
		LinkedList<Item> listPV= new LinkedList<Item>();
		Item itemCero = new Item(0,0);
		listPV.addFirst(itemCero);
		//Llena una lista en base a los valores de los objetos
		for (int i=0;i<lista.size();i++) {
			Item item = lista.get(i);
			int value = item.getValor();
			
			boolean flag = false;
			for (int j=0;j<listPV.size();j++) {
				Item itemPV = listPV.get(j);
				if (itemPV.getValor()>item.getValor()) {
					listPV.add(j, item);
					j=listPV.size();
					flag=true;
				}else if(j==listPV.size()-1 && flag==false) {
					listPV.addLast(item);
				}
			}
		}
		// Bucador de objetos de mayor ganancia sin excederse del peso
		LinkedList<Item> listTop= new LinkedList<Item>();
		int cPeso=0;
		int x=listPV.size();
		while (cPeso<maxVal && x>0) {
			Item it = listPV.get(x);
			if(cPeso+it.getPeso()<maxVal) {
				cPeso+=it.getPeso();
				listTop.addLast(it);
			}
			x-=1;
		}
		
		return listTop;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(cleanString("AZ212#$&456mnolcd s3az"));
		//System.out.println(mystery(1,1));
		LinkedList<Integer> list1=new LinkedList<Integer>();
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.addLast(5);
		list1.addLast(6);

		LinkedList<Integer> list2=new LinkedList<Integer>();
		list2.addLast(1);
		list2.addLast(2);
		list2.addLast(3);
		LinkedList<Integer> list3=new LinkedList<Integer>();
		System.out.println("Lista1 : "+list1.toString());
		System.out.println("Lista2 : "+list2.toString());
		list3 = union(list1,list2);
		System.out.println("Union"+list3.toString());
		//insertInOrder(list3,11);
		//System.out.println("Insert 11"+list3.toString());
		eraseInOrder(list3,2,true);
		System.out.println("DELETE"+list3.toString());
		System.out.println("Trabajando en la mochila");
		//Mochila
		int MaxCap=100;
		LinkedList<Item> items=new LinkedList<Item>();
		for (int i=0 ; i<100;i++) {
			int randVal= randInt(0,25);
			int randW= randInt(0,25);
			Item item = new Item(randW,randVal);
			items.addLast(item);
		}
		LinkedList<Item> Mochila=new LinkedList<Item>();
		Mochila = greedy(items,MaxCap);
		
		

		
	}
}
