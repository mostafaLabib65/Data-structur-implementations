package linkedList;

public class SNode {
	private Object element;
	private SNode next;
	public SNode()
	{
		next = null;
		element = 0;
	}
	public SNode(Object s,SNode n)
	{
		element = s;
		next = n;
	}
	public Object getElement() { 
		return element; 
	}
	
	public SNode getNext() { 
		return next; 
	}
	
	public void setElement(Object newElem) {
		element = newElem;
	}
	
	public void setNext(SNode newNext) { 
		next = newNext; 
	}
}
