package Queue;

import java.util.LinkedList;

import javax.management.RuntimeErrorException;

import linkedList.dLinkedList;
import Queue.ILinkedBased;
import Queue.IQueue;

public class LinkedListQueue implements IQueue,ILinkedBased{
	
	dLinkedList que = new dLinkedList();
	int size = 0;
	@Override
	public void enqueue(Object item) {
		que.add(0, item);
		size++;
		
	}

	@Override
	public Object dequeue() {
		if(size == 0)
			throw new RuntimeErrorException(null,"labib");
		size--;
		Object temp = que.get(que.size()-1);
		que.remove(que.size()-1);
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		return size;
	}

}
