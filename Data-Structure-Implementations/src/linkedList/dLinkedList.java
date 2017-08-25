package linkedList;
import linkedList.ILinkedList;

public class dLinkedList implements ILinkedList{
	private DNode head;
	private DNode tail;
	private long size;
	/** Default constructor that creates an empty list 
	 * @return */
	public dLinkedList() {
	head = null;
	tail = head;
	size = 0;
	}
	/**
	* Inserts a specified element at the specified position in the list.
	*/
	public void add(int index, Object element)
	{
		if(index >= 0)
		{
		DNode newNode = new DNode();
		newNode.setElement(element);
		size++;
		if(index == size)
		{
			dLinkedList.this.add(element);
		}
		else if(index == 0)
		{
			newNode.setNext(head);
			head = newNode;
		}
		else
		{
			int counter = 1;
			DNode prevToIndexNode = head;
			while(counter <= index-1)
			{
				counter++;
				prevToIndexNode = prevToIndexNode.getNext();
			}
			newNode.setNext(prevToIndexNode.getNext());
			prevToIndexNode.setNext(newNode);
		}
		}
		else
		{
			throw null;
		}
	}
	/** Inserts the specified element at the end of the list. */
	public void add(Object element)
	{
		if(element != null)
		{
			DNode newNode = new DNode();
			newNode.setElement(element);
			newNode.setNext(null);
			if(size == 0)
			{
				head = newNode;
				tail = head;
			}
			else
			{
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
				
			}
			size++;
		}
		else
		{
			throw null;
		}
	}
	/** Returns the element at the specified position in this list. */
	public Object get(int index)
	{
		if(index < size && index >= 0 && size != 0)
		{
			DNode indexNode = head;
			int counter = 1;
			while(counter <= index)
			{
				
				counter++;
				
					indexNode = indexNode.getNext();	
			}
			
				return indexNode.getElement();
		}
		else
		{
			throw null;
		}
	}
	/**
	* Replaces the element at the specified position in this list with
	* the specified element.
	*/
	public void set(int index, Object element)
	{
		if(index < size && index >= 0 && size != 0)
		{
		DNode indexNode = head;
		int counter = 1;
		while(counter <= index)
		{
			counter++;
			indexNode = indexNode.getNext();
		}
		indexNode.setElement(element);
		}
		else
		{
			throw null;
		}
	}
	/** Removes all of the elements from this list. */
	public void clear()
	{
		tail = null;
		head = null;
		size = 0;
	}
	/** Returns true if this list contains no elements. */
	public boolean isEmpty()
	{
		if(size == 0)
		  {
			  return true;
		  }
		  else
			  return false;
	}
	/** Removes the element at the specified position in this list. */
	public void remove(int index)
	{
		if(index < size && index >= 0 && size != 0)
		{
		if(index == 0)
		{
			head = head.getNext();
			size--;
		}
		else if(index == size-1)
		{
			DNode prevToIndexNode = head;
			while(prevToIndexNode.getNext().getNext() != null)
			{
				prevToIndexNode = prevToIndexNode.getNext();
			}
			tail = prevToIndexNode;
			tail.setNext(null);
			size--;
		}
		else
		{
			int counter = 1;
			if(index <= size-1)
			{
				DNode prevToIndexNode = head;
				while(counter <= index-1)
				{
					prevToIndexNode = prevToIndexNode.getNext();
					counter++;
				}
				DNode indexNode = prevToIndexNode.getNext();
				prevToIndexNode.setNext(indexNode.getNext());
				indexNode.setElement(null);
				indexNode.setNext(null);
				size--;
			}
		}
		}
		else
		{
			throw new RuntimeException("labib");
		}
	}
	/** Returns the number of elements in this list. */
	public int size()
	{
		return (int) size;
	}
	/**
	* Returns a view of the portion of this list between the specified
	* fromIndex and toIndex, inclusively.
	*/
	public ILinkedList sublist(int fromIndex, int toIndex)
	{
		if(fromIndex >=0 && fromIndex < size && toIndex >=0 && toIndex < size && toIndex >= fromIndex)
		{
		ILinkedList DL = new dLinkedList();
		int counter = 1;
		DNode indexNode = head;
		while(counter <= fromIndex)
		{
			indexNode = indexNode.getNext();
			counter++;
		}
		while(counter <= toIndex+1)
		{
			DL.add(indexNode.getElement());
			indexNode = indexNode.getNext();
			counter++;
		}
		return DL;
		}
		else
		{
			throw null;
		}
	}
	/**
	* Returns true if this list contains an element with the same value
	* as the specified element.
	*/
	public boolean contains(Object o)
	{
		if( size != 0)
		{
		DNode currentNode = head;
		int ifContain = 0;
		while(currentNode != null)
		{
			if(currentNode.getElement().equals(o))
			{
				ifContain++;
				break;
			}
			else
			{
				currentNode = currentNode.getNext();
			}
		}
		if(ifContain == 1)
		{
			return true;
		}
		else
			return false;
	}
		else
		{
			throw null;
		}
	}
	
}
