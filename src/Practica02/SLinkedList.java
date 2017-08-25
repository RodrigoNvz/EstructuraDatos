package Practica02;

import java.util.NoSuchElementException;

public class SLinkedList<E> implements List<E> {
	private SNode<E> top;
	private int size;
	
	public SLinkedList() {
		top = new SNode<E>();
		size = 0;
	}

	@Override
	public void addFirst(E e) {
		
		SNode<E> newNode = new SNode<E>(e);
		newNode.next = top.next;
		top.next = newNode;
		size++;
		
	}

	@Override
	public void addLast(E e) {
		
		SNode<E> newNode = new SNode<E>(e);
		SNode<E> current = top;
		while(current.next!=null)
			current = current.next;
		
		current.next=newNode;
		size++;
		
	}

	@Override
	public void add(int index, E element) {
		
		try {
			SNode<E> newNode = new SNode<E>(element);
			SNode<E> current = top;
			
			for(int x=0 ; x<index ; x++) {
				current = current.next;	
			}
			
			current.next=newNode;
			size++;
		
		}catch (NoSuchElementException e) {
			System.out.println("Error, ingrese un índice válido");

		}
	}

	@Override
	public E removeFirst() {
		
		try {
			
			if (top.next ==null) {
				throw new NoSuchElementException();
			}
			
			SNode<E> nodeToRemove = top.next;
			top.next = nodeToRemove.next;
			nodeToRemove.next = null;
			size--;
			
			return nodeToRemove.value;
			
		}catch (NoSuchElementException e) {
			System.out.println("Error, no hay elementos en la lista");
			return null;
		}

		
		
	}

	@Override
	public E removeLast() {
		try {
			
			if (top.next ==null) {
				throw new NoSuchElementException();
			}
			
			SNode<E> current = top;
			while((current.next).next!=null)
				current = current.next;
			
			SNode<E> nodeToRemove = current.next;
			current.next = nodeToRemove.next;
			size--; 
			
			return nodeToRemove.value;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error, no hay elementos en la lista");
			return null;
		}
		
	}

	@Override
	public E remove(int index) {
		
		SNode<E> current = top;
		
		for(int x=0 ; x<index ; x++) {
			current = current.next;	
		}
		
		SNode<E> nodeToRemove = current.next;
		current.next = nodeToRemove.next;
		size--; 
		
		return nodeToRemove.value;
		
	}

	@Override
	public boolean remove(Object o) {
		
		SNode<Object> objectToRemove = new SNode<Object>(o);
		SNode<E> current = top;
		try {
			
		
			while(!(current.next).value.toString().equals(objectToRemove.value.toString())) {
				current = current.next;		
			}
				
			SNode<E> nodeToRemove = current.next;
			current.next = nodeToRemove.next;
			size--; 
			return true;
			
			}catch (NoSuchElementException e) {
			System.out.println("Error, no hay ese elemento");
				return false;
			}
	}

	@Override
	public E getFirst() {
		try {
			if (top.next ==null) {
				throw new NoSuchElementException();
			}
			SNode<E> nodeToGet = top.next;
			
			return nodeToGet.value;
			
		}catch (NoSuchElementException e) {
			System.out.println("Error, no hay ese elemento");
			return null;
		}
	}

	@Override
	public E getLast() {
		
		try {
			if (top.next ==null) {
				throw new NoSuchElementException();
			}
			
			SNode<E> current = top;
			while((current.next).next!=null)
				current = current.next;
			
			SNode<E> nodeToGet = current.next;
			
			return nodeToGet.value;
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Error, no hay elementos en la lista");
			return null;
		}
		
	}

	@Override
	public E get(int index) {
		
		SNode<E> current = top;
		
		for(int x=0 ; x<=index ; x++) {
			current = current.next;	
		}
		
		return current.value;
		
	}
	

	@Override
	public E set(int index, E element) {
		
		SNode<E> objectToSet = new SNode<E>(element);
		SNode<E> current = top;
		
		
		for(int x=0 ; x<index ; x++) {
			current = current.next;	
		}
			
		SNode<E> nodeToRemove = current.next;
		current.next = nodeToRemove.next;
		objectToSet.next = current.next;
		current.next = objectToSet;
		size++;
		
		return objectToSet.value;
			
	}

	@Override
	public boolean contains(E e) {
		
		SNode<E> objectLookingFor = new SNode<E>(e);
		SNode<E> current = top;
		try {
			
		
			while(!(current.next).value.toString().equals(objectLookingFor.value.toString())) {
				current = current.next;		
			}
				
			return true;
			
			}catch (Exception indexOutOfBounds) {
			
				return false;

			}

	
	}

	@Override
	public int indexOf(Object o) {
		int index=0;
		
		if(o == null) {
			for(SNode<E> x = top.next;x!=null;x=x.next) {
				if(x.value == null)
					return index;
				index++;
			}
		}else {
			for(SNode<E> x= top.next; x!= null; x=x.next) {
				if (o.equals(x.value))
					return index;
				index++;
			}
			
		}
		return -1;
		
	}

	@Override
	public void clear() {
		top.next = null;
		size=0;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public Object[] toArray() {
		
		if(top.next == null) {
			Object[] array = new Object[0];
		}
		
		int counter = 0;
		SNode<E> checador = top;
		SNode<E> current = top;
		
		while(checador.next != null) {
			counter++;
			checador = checador.next;
		}
		
		Object[] array = new Object[counter];
		for(int x=0 ; x<counter ; x++) {
			current= current.next;
			array[x]=current.value;	
		}
		
		return array;
	}
	
	public String toString() {
		if(top.next == null)
			return "[]";
		
		SNode<E> current = top.next;
		String returnValue = "[" + current.value;
		while(current.next != null) {
			current = current.next;
			returnValue += ", " + current.value;
		}
		
		
		returnValue += "]";
		return returnValue;
		
	}
}
