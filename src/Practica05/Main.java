package Practica05;


import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Testing array reversing");
		int[] inputArray = {1, 2, 3, 4, 5};
		
		// TODO: push every item in inputArray into a Stack
		Stack<Integer> iStack = new Stack<Integer>();
		for (int i=0;i< inputArray.length;i++) {
			iStack.push(inputArray[i]);
		}
		
		int[] outputArray = new int[inputArray.length];
		
		// TODO: pop every item in inputArray and save them in outputArray
		for (int i=0;i< outputArray.length;i++) {
			outputArray[i]=iStack.pop();
		}
		
		System.out.println("Input: " + Arrays.toString(inputArray));
		System.out.println("Output: " + Arrays.toString(outputArray));
		System.out.println();
		
		System.out.println("Testing train ordering");
		Stack<Integer> train = new Stack<Integer>();
		train.push(3);
		train.push(2);
		train.push(1);
		train.push(3);
		train.push(2);
		
		System.out.println("Train as it arrived to the station: " + Arrays.toString(train.toArray()));
		
		// TODO: sort the wagons in priority order	
		Stack<Integer> tempStack = new Stack<Integer>();
		Stack<Integer> tempStack2 = new Stack<Integer>();
		Stack<Integer> tempStack3 = new Stack<Integer>();
		while(train.empty()!=true) {
			if (train.peek()==1) {
				tempStack.push(train.pop());
			}else if(train.peek()==2) {
				tempStack2.push(train.pop());
			}else {
				tempStack3.push(train.pop());
			}
		}
		
		while (tempStack2.empty() != true) {
			tempStack3.push(tempStack2.pop());
		}
		while (tempStack.empty() != true) {
			tempStack3.push(tempStack.pop());
		}
		train=tempStack3;
		
		System.out.println("Train ordered by priority: " + Arrays.toString(train.toArray()));
		System.out.println();
		
		Stack<Integer> towerOne = new Stack<Integer>();
		Stack<Integer> towerTwo = new Stack<Integer>();
		Stack<Integer> towerThree = new Stack<Integer>();
		
		towerOne.push(3);
		towerOne.push(2);
		towerOne.push(1);
		
		System.out.println("At the beginning");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		
		// TODO: run a simulation so that towerTwo ends with all discs in correct order.
		towerTwo.push(towerOne.pop());
		towerThree.push(towerOne.pop());
		towerThree.push(towerTwo.pop());
		towerTwo.push(towerOne.pop());
		towerOne.push(towerThree.pop());
		towerTwo.push(towerThree.pop());
		towerTwo.push(towerOne.pop());
		
		System.out.println("At the end");
		System.out.println("Hanoi tower #1: " + Arrays.toString(towerOne.toArray()));
		System.out.println("Hanoi tower #2: " + Arrays.toString(towerTwo.toArray()));
		System.out.println("Hanoi tower #3: " + Arrays.toString(towerThree.toArray()));
		System.out.println();
	}
}
