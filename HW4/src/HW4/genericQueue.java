package HW4;

public class genericQueue {

	public static void main(String[] args) throws FullQueueException, EmptyQueueException {
		// TODO Auto-generated method stub
		int size = 5;
		
		genQueue<Integer> intQueue =new genQueue(size);
		genQueue<Number> numQueue =new genQueue(size);
		genQueue<Double> doubleQueue =new genQueue(size);
		
		try {
			System.out.print("Int queue: ");
			int i = 6;
			while(i-- > 0) {
				intQueue.enqueue(i);
				System.out.print(intQueue.front()+", ");
			}
		}catch (FullQueueException e) {
            System.out.println("Caught Exception: " + e.getMessage());
            e.printStackTrace();
        }
		
		try {
			int i = 6;
			while(i-- > 0) {
				intQueue.dequeue();
				System.out.println("\nDequeue intQueue 1 time");
				System.out.println("Int queue's front: "+intQueue.front()+"\n");
			}
		}catch (EmptyQueueException e) {
            System.out.println("Caught Exception: " + e.getMessage());
            e.printStackTrace();
        }
		
		
		System.out.print("Number queue: ");
		numQueue.enqueue(1);
		System.out.print(numQueue.front()+", ");
		numQueue.enqueue(1.5);
		System.out.print(numQueue.front()+", ");
		numQueue.enqueue(2);
		System.out.println(numQueue.front());
		
		numQueue.dequeue();
		numQueue.dequeue();
		System.out.println("\nDequeue numQueue 2 time");
		System.out.println("Number queue's front: "+numQueue.front()+"\n");
		
		System.out.print("Double queue: ");
		doubleQueue.enqueue(1.2);
		System.out.print(doubleQueue.front()+", ");
		doubleQueue.enqueue(1.5);
		System.out.print(doubleQueue.front()+", ");
		doubleQueue.enqueue(1.8);
		System.out.println(doubleQueue.front());
		
		doubleQueue.dequeue();
		doubleQueue.dequeue();
		doubleQueue.dequeue();
		System.out.println("\nDequeue doubleQueue 3 time");
		System.out.println("Int queue's front: "+doubleQueue.front()+"\n");
		
		Integer[] intArray = {4, 5, 6};
		System.out.print("\ninput int array: ");
		for ( Integer i: intArray) {
			System.out.print(i+" ");
		}
		intQueue.enqueueAll(intQueue, intArray);
		
		Number a = intQueue.front();
		System.out.print("\nintqueue: ");
		while ( a!= null) {
			System.out.print(a+" ");
			intQueue.dequeue();
			a = intQueue.front();
		}
		
		Number[] numArray = {4, 5.3, 6.6};
		System.out.print("\n\ninput num array: ");
		for ( Number i: numArray) {
			System.out.print(i+" ");
		}
		numQueue.enqueueAll(numQueue, numArray);
		a = numQueue.front();
		System.out.print("\nnumber: ");
		while ( a!= null) {
			System.out.print(a+" ");
			numQueue.dequeue();
			a = numQueue.front();
		}

        Double[] doubleArray = {2.2, 2.5, 2.8};
		System.out.print("\n\ninput double array: ");
		for ( Double i: doubleArray) {
			System.out.print(i+" ");
		}
		System.out.println();
        doubleQueue.enqueueAll(doubleQueue, doubleArray);
        
        a = doubleQueue.front();
		System.out.print("\ndouble: ");
		while ( a!= null) {
			System.out.print(a+" ");
			doubleQueue.dequeue();
			a = doubleQueue.front();
		}
		
		
		
		System.out.print("\n\ninput int array: ");
		for ( Integer i: intArray) {
			System.out.print(i+" ");
		}
		intQueue.enqueueAll(intQueue, intArray);
		intQueue.dequeueAll(intQueue);
		System.out.print("\nintqueue: " + intQueue.front());
		
		System.out.print("\n\ninput num array: ");
		for ( Number i: numArray) {
			System.out.print(i+" ");
		}
		numQueue.enqueueAll(numQueue, numArray);
		numQueue.dequeueAll(numQueue);
		System.out.print("\nnumber: " + numQueue.front());

		System.out.print("\n\ninput double array: ");
		for ( Double i: doubleArray) {
			System.out.print(i+" ");
		}
		System.out.println();
        doubleQueue.enqueueAll(doubleQueue, doubleArray);
        doubleQueue.dequeueAll(doubleQueue);
		System.out.print("\ndouble: " + doubleQueue.front());

				
		
	}

}
