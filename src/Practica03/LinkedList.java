package Practica03;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {
	private Node<E> header;
	private int size;
	
	public LinkedList() {
		header = new Node<E>();
		size = 0;
	}
	
	/**
	 * Gets the node at the specified index.
	 * @param index the index of the node to get
	 * @return the node at the specified position
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
	 */
	private Node<E> node(int index) {
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index < (size >> 1)) {
			Node<E> x = header.next;
			for(int i=0; i<index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = header.prev;
			for(int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	@Override
	public void addFirst(E e) {
		// TODO Auto-generated method stub
		Node<E> newElement = new Node<E>(e);
		
		Node<E> firstElement = header.next;
		newElement.next = firstElement;
		firstElement.prev = newElement;
		
		newElement.prev = header;
		header.next = newElement;

		size++;
		
	}

	@Override
	public void addLast(E e) {
		// TODO Auto-generated method stub
		Node<E> newElement = new Node<E>(e);
		Node<E> lastElement = header.prev;
		
		newElement.next = header;
		newElement.prev = lastElement;
		
		lastElement.next = newElement;
		header.prev=newElement;
		
		size++;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> newElement = new Node<E>(element);
		Node<E> current = header.prev;
		Node<E> temp;
		
		 if(index<0 || index>size())
	            throw new IndexOutOfBoundsException("error de índice");
	        else if(index==0)
	           addFirst(element);
	        else if(index==size())
	            this.addLast(element);
	        else{

	            if(index < (size() >> 1)){
	                for(int i=0;i<index;i++) {
	                	current=current.next;
	                }
	                temp=current.next;
	                
	                newElement.prev=current;
	                newElement.next=temp;
	                current.next=newElement;
	                temp.prev=newElement;
	            }
	            else{
	                for(int x=size(); x > index;x--) {
	                	current=current.prev;
	                }
	                temp=current.prev;
	                
	                newElement.prev=temp;
	                newElement.next=current;
	                temp.next=newElement;
	                current.prev=newElement;
	            }
	            size++;
	        }
	    }

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		Node<E> current = header.next;
        header.next = current.next;
        current.next.prev = header;
        
        current.next=current.prev;
        size--;
        return current.value;
	}

	@Override
	public E removeLast() {
		// TODO Auto-generated method stub
		Node<E> current = header.prev;
        current.prev.next=header;
        header.prev=current.prev;

        current.next=current.prev;
        size--;
        return current.value;
		
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		Node<E> current=header;
		Node<E> temp;
		Node<E> lock;
		
			if(index==0)
				removeFirst();
	        else if(index < (size()>>1)){

	                for(int x=0;x<index;x++) {
	                	current=current.next;
	                }
	                temp=current.next;
	                lock=temp.next;
	                
	                current.next=lock;
	                lock.prev=current;
	                temp.next=temp.prev;
	                
	                this.size--;
	                return temp.value;
	            }else{
	            	for(int x= size();x > index; x--) {
	                	current=current.prev;
	                }
	            	temp=current.prev;
	            	lock=temp.prev;
	            	
	            	lock.next=current;
	            	current.prev=lock;
	                temp.next=temp.prev;
	                
	                this.size--;
	                return temp.value;
	            }
	        return null;
	    }

	@Override
	public boolean remove(Object o) {
		Node<E> current=header.next;
        int x = 0;

        while(current.next!=header){
            if(current.value.equals(o)){
                remove(x);
                return true;
            }
            current=current.next;
            x++;
        }
        if(current.value.equals(o)){
            removeLast();
            return true;
        }
        return false;

    }

	@Override
	public E getFirst() {

        return header.next.value;

    }

	@Override
	public E getLast() {
		
        return header.prev.value;
    }


	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		Node<E> current=header.next;
		
		if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("índice no válido");
		}
		
        for(int x= 0;x < index;x++) {
        	current=current.next;
        }
        
        return current.value;

    }

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
    	Node<E> current=header.next;
    	E savData;
    	
    	if(index < 0 || index >= size()) {
    		throw new IndexOutOfBoundsException("índice no válido");
    	}
 
    	if(index < (size() >> 1)){
    			for (int x=0;x<index;x++) {
    				current=current.next;
    			}
    			savData=current.value;
    			current.value=element;
    	}else{
	        for(int x = size();x > index;x--) {
	        	current=current.prev;
	        }
	        savData=current.value;
	        current.value=element;
	        
	    }

    	return savData;
}
	
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
        Node<E> current=header.next;
        
		if(this.isEmpty()) {
            return false;
		}
		
        while(current.next!=header){
            if(current.value.equals(e))
                return true;
            current=current.next;
        }
        return current.value.equals(e);

    }

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
        Node<E> current=header.next;
        int counter=0;
        
		if(isEmpty()) {
            return -1;
		}

        while(current.next!=header){
            if(current.value.equals(o)) {
                return counter;
            }
            current = current.next;
            counter++;
        }
        return -1;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
        header.next=header;
        header.prev=header;
        size=0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		 Object[] Arry = new Object[size];

	        if(this.isEmpty()) {
	            return Arry;
	        }else {
		        Node<E> current=header.next;
		        for(int x=0;x<size;x++) {
		            current=current.next;
		            Arry[x]=get(x);
		        }
		        return Arry;
	        }
	    }

	
	@Override
	public String toString() {
		if(header.next == header) {	
			return "[]";
			
		}else {
			Node<E> current = header.next  ;
			String returnValue= "[" + current.value;
		        while(current.next!=header){
		            current=current.next;
		            returnValue+=", "+ current.value;
		        }
	
			returnValue += "]";
			return returnValue;
		}
	
	}
}
