package Queue;

import javax.management.RuntimeErrorException;

import Queue.IArrayBased;
import Queue.IQueue;

public class arrayQueue implements IQueue,IArrayBased{
	int n;
	Object[] queue;
	int size;
	int rear = 0;
	int front  = 0;
	public arrayQueue(int n)
	{
		this.n = n;
		queue = new Object[n];
	}
	@Override
	public void enqueue(Object item) {
		if(size == n)
			throw new RuntimeErrorException(null,"labib");
		queue[rear] = item;
		rear++;
		size++;
		if(rear == n)
			rear = 0;
	}

	@Override
	public Object dequeue() {
		if(size == 0)
			throw new RuntimeErrorException(null,"labib");
		Object temp = queue[front];
		size--;
		front++;
		if(front == n)
			front = 0;
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
