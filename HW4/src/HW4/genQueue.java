package HW4;

class EmptyQueueException extends Exception {
    public EmptyQueueException(String message) {
        super(message);
    }
}

// 定義佇列滿的例外
class FullQueueException extends Exception {
    public FullQueueException(String message) {
        super(message);
    }
}

public class genQueue <E>{
	private int size;
	private int rear;
	private E[] elements;
	
	public genQueue(int size) {
		this.size = size;
		this.rear = -1;
		this.elements = (E[]) new Object[size];
	}
	
	public void enqueue(E element) throws FullQueueException {
		if ( this.rear < this.size-1) {
			this.elements[rear+1] =element; 
			this.rear++;
		}
		else {
            throw new FullQueueException("Queue is full.");
		}
	}
	
	public void dequeue() throws EmptyQueueException {
		if ( this.rear > -1) {
			this.elements[this.rear] = null;
			this.rear--;
		}
		else {
            throw new EmptyQueueException("Queue is empty.");
		}
	}
	
	public E front() {
		if ( this.rear >= 0) {
			return this.elements[this.rear];
		}
		else {
			return null;
		}
	}
	
	public void enqueueAll(genQueue<E> queue, E[] array) throws FullQueueException {
        for (E element : array) {
            queue.enqueue(element);
        }
    }
	
	public void dequeueAll(genQueue<E> queue) throws EmptyQueueException {
        while (rear >= 0) {
            queue.dequeue();
        }
    }
}
