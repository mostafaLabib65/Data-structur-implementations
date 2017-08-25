package linkedList;

public class DNode {
	private Object element;
	private DNode next;
	private DNode prev;
	public DNode()
	{
		next = null;
		prev = null;
		element = 0;
	}
	public DNode(Object s,DNode n,DNode p)
	{
		element = s;
		next = n;
		prev = p;
	}
	public Object getElement() { 
		return element; 
	}
	
	public DNode getNext() { 
		return next; 
	}
	
	public DNode getPrev() { 
		return prev; 
	}
	public void setElement(Object newElem) {
		element = newElem;
	}
	
	public void setNext(DNode newNext) { 
		next = newNext; 
	}
	
	public void setPrev(DNode newNext) { 
		prev = newNext; 
	}

}
