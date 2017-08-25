package Stack;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import linkedList.dLinkedList;
import Stack.IStack;

public class stack implements IStack{
	int size = 0;
	dLinkedList stack = new dLinkedList();
	
	/**
	* Inserts a specified element at the specified position in the list.
	* @param index
	zero-based index
	* @param element object to insert
	*/
	@Override
	public void add(int index, Object element) {
		if(index > size || index < 0 )
			throw new RuntimeErrorException(null);
		stack.add(index, element);
		size++;
	}
	
	/**
	* Removes the element at the top of stack and returns that element.
	* @return
	top of stack element, or through exception if empty
	*/
	@Override
	public Object pop() {
		
		if(size == 0 )
		{
			throw null;
		}
		else
		{
			Object temp = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			size--;
			return temp;
		}
	}
	
	/**
	* Get the element at the top of stack without removing it from stack.
	* @return
	top of stack element, or through exception if empty
	*/
	@Override
	public Object peek() {
		if(size == 0)
		{
			throw null;
		}
		else
		{
			return stack.get(stack.size()-1);
		}
	}

	/**
	* Pushes an item onto the top of this stack.
	* @param
	object to insert
	*/
	@Override
	public void push(Object element) {
		
		stack.add(element);
		size++;
	}
	
	/**
	* Tests if this stack is empty
	* @return
	true if stack empty
	*/
	@Override
	public boolean isEmpty() {
		if(size == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	* Returns the number of elements in the stack.
	* @return
	number of elements in the stack
	*/
	@Override
	public int size() {
		return size;
	}
	

}
