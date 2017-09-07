package Examen01;

public class ArrayList<E> implements List<E> {
	public Object[] top;
	private int size;
	private int initialCapacity = 5;
	private int extraCapacity = 5;
	
	/**
	 * Creates a new ArrayList instance with the default initial capacity.
	 */
	public ArrayList() {
		top = new Object[initialCapacity];
		size = 0;
	}
	
	/**
	 * Increases the capacity of this ArrayList instance so that it 
	 * can hold at least extraCapacity elements more.
	 * This method allocates a new array with greater capacity than the
	 * current one (top.length + extraCapacity) and copies all elements
	 * from top to the newly allocated array. The reference top is then
	 * updated to point to the new array. 
	 * @param extraCapacity increase the capacity of this ArrayList by this amount
	 */
	private void reserveExtraCapacity(int extraCapacity) {
		
		Object[] newArr = new Object[size+extraCapacity];
		for(int x=0;x<size();x++) {
			newArr[x]=top[x];
		}
		top= new Object[size+extraCapacity];
		for(int i=0;i<size();i++) {
			top[i]=newArr[i];
		}
		size+=extraCapacity;
		
	}

	/**
	 * Increases the capacity of this list if its size equals the length of the array
	 * where the data is stored. This method calls reserveExtraCapacity when (size() >= top.length).
	 * reserveExtraCapacity is called using the instance variable extraCapacity.
	 */
	private void ensureCapacity() {
		
		if(size()>=top.length) {
			reserveExtraCapacity(extraCapacity);
		}
		
	}
	
	/**
	 * Shifts elements in the array (top) to the right, starting at the given position.
	 * @param index the position in which the shift will begin
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
	 */
	private void shiftContentsRight(int index) {

		if (index>top.length||index<0) {
			throw new IndexOutOfBoundsException();
		}
		reserveExtraCapacity(1);
		Object[] newArr = new Object[size()+1];
		
		for(int i=index;i<=size();i++) {
			newArr[i+1]=top[i];
		}
		top= new Object[size+1];
		for(int i=0;i<size();i++) {
			top[i]=newArr[i];
		}
	
		
		
	}
	
	@Override
	public void addFirst(E e) {
		E newElement = e;
		shiftContentsRight(0);
		top[0]=newElement;
		size++;
	}
	

	@Override
	public void addLast(E e) {
		E newElement = e;
		reserveExtraCapacity(1);
		top[size]=newElement;
		size++;
	}

	@Override
	public void add(int index, E element) {
		E newElement = element;
		shiftContentsRight(index);
		top[index]=newElement;
		size++;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getFirst() {
		return (E) top[0];
	}

	
	@Override
	public E getLast() {
		return (E) top[size()];
	}

	
	@Override
	public E get(int index) {
		return (E) top[index];
	}

	@Override
	public E set(int index, E element) {
		shiftContentsRight(index);
		E oldElement = get(index);
		top[index]=element;
		return oldElement;
	}

	@Override
	public void clear() {
		size=0;
		top= new Object[initialCapacity];
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
	public String toString() {
		
		if(size()==0) {
			return "[]";
		}else {
			String str = "[" + top[0];
			for(int x=1;x<size();x++) {
				str+=","+top[x];
			}
			
			str += "]";
			
			return str;
		
		
		}
	}
	}
