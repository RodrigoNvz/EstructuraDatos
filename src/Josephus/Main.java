package Josephus;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("** Testing Josephus method **");

		LinkedList<Integer> iList = new LinkedList<Integer>();
		Integer josephusPos;
		
		System.out.println("Romanos inicialmente");

		for(int i = 1; i <= 40; i++) {
			iList.addLast(i);
		}
		System.out.println(iList);
		System.out.println("\nLos romanos se fueron suicidando cada 3\n");
		
		josephusPos = iList.josephus(3);
		
		System.out.println("Josephus sobrevivió ya que estaba en la posición No."+josephusPos+" del círculo");
		
	}
}
