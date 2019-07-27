import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testQueue {

	@Test
	void hasEnqueuedToNewAndNotToOld() {
		ImmutableQueue<Integer> orgQueue = new ImmutableQueue<Integer>();
		var newQueue = orgQueue.enQueue(5);
		assertEquals(5, newQueue.head());
		assertEquals(null, orgQueue.head());
	}
	
	@Test
	void hasDequeuedFromNewAndNotFromOld() {
		ImmutableQueue<Integer> orgQueue = new ImmutableQueue<Integer>();
		orgQueue = orgQueue.enQueue(5);
		Integer curNum = orgQueue.head();
		assertEquals(5, curNum);
		
		var newQueue = orgQueue.deQueue();
		assertEquals(5, orgQueue.head());
		assertEquals(null, newQueue.head());
	}
	
	@Test
	void isEmptyWorks() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		assertEquals(queue.isEmpty(), true);
		
		queue = queue.enQueue(5);
		assertEquals(queue.isEmpty(), false);
		
		queue = queue.deQueue();
		assertEquals(queue.isEmpty(), true);
		
		queue = queue.enQueue(5);
		queue = queue.enQueue(6);
		queue = queue.deQueue();
		queue = queue.deQueue();
		assertEquals(queue.isEmpty(), true);
		
		queue = queue.enQueue(5);
		queue = queue.enQueue(6);
		queue = queue.enQueue(7);
		queue = queue.deQueue();
		queue = queue.deQueue();
		assertEquals(queue.isEmpty(), false);
		queue = queue.deQueue();
		assertEquals(queue.isEmpty(), true);
	}
	
	
	@Test
	void isDequeuedNullOnEmpty() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		assertEquals(queue.isEmpty(), true);
		
		queue = queue.deQueue();
		assertEquals(queue.head(), null);
	}
	
	@Test
	void isHeadRight() {
		ImmutableQueue<Integer> queue = new ImmutableQueue<Integer>();
		
		queue = queue.enQueue(5);
		assertEquals(5, queue.head());
		queue = queue.deQueue();
		assertEquals(null, queue.head());

		
		queue = queue.enQueue(5);
		assertEquals(5, queue.head());
		queue = queue.enQueue(6);
		assertEquals(6, queue.head());
		queue = queue.deQueue();
		assertEquals(5, queue.head());
		queue = queue.deQueue();
		assertEquals(null, queue.head());

		
		queue = queue.enQueue(5);
		queue = queue.enQueue(6);
		queue = queue.enQueue(7);
		assertEquals(7, queue.head());
		queue = queue.deQueue();
		queue = queue.deQueue();
		assertEquals(5, queue.head());
		queue = queue.deQueue();
		assertEquals(null, queue.head());
	}
}
