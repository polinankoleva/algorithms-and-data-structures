package com.data.structures.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test cases for {@link OrderedArrayPriorityQueue}.
 * 
 * @author Polina Koleva
 *
 */
public class OrderedArrayPriorityQueueTest {

	@Test
	public void buildEmptyPQTest() {
		OrderedArrayPriorityQueue pq  = new OrderedArrayPriorityQueue();
		Assert.assertNull(pq.extractMax());
		//Assert.assertNull(pq.max());
	}

	@Test
	public void buildPQTest() {
		Integer[] actual = { 1, 13, 3, 18 };
		OrderedArrayPriorityQueue pq = new OrderedArrayPriorityQueue(actual);
		Assert.assertTrue(18 == pq.max());	
		Assert.assertTrue(18 == pq.extractMax());
		Assert.assertTrue(13 == pq.max());	
		Assert.assertTrue(13 == pq.extractMax());
		Assert.assertTrue(3 == pq.max());	
		Assert.assertTrue(3 == pq.extractMax());
		Assert.assertTrue(1 == pq.max());	
		Assert.assertTrue(1 == pq.extractMax());
		Assert.assertEquals(null, pq.max());	
		Assert.assertEquals(null, pq.extractMax());

		actual = new Integer[] { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 };
		pq = new OrderedArrayPriorityQueue(actual);
		Assert.assertTrue(16 == pq.max());	
		Assert.assertTrue(16 == pq.extractMax());
		Assert.assertTrue(14 == pq.max());	
		Assert.assertTrue(14 == pq.extractMax());
		Assert.assertTrue(10 == pq.max());	
		Assert.assertTrue(10 == pq.extractMax());
		Assert.assertTrue(9 == pq.max());	
		Assert.assertTrue(9 == pq.extractMax());
		Assert.assertTrue(8 == pq.max());	
		Assert.assertTrue(8 == pq.extractMax());
		Assert.assertTrue(7 == pq.max());	
		Assert.assertTrue(7 == pq.extractMax());		
	}
	
	@Test
	public void doublingPQTest() {
		
	}
	
	@Test
	public void duplicatesTest() {
		
	}
	
	@Test
	public void insertPQTest() {
		OrderedArrayPriorityQueue pq = new OrderedArrayPriorityQueue();
		pq.insert(1);
		pq.insert(13);
		pq.insert(18);
		pq.insert(3);
		Assert.assertTrue(18 == pq.max());	
		Assert.assertTrue(18 == pq.extractMax());
		Assert.assertTrue(13 == pq.max());	
		Assert.assertTrue(13 == pq.extractMax());
		Assert.assertTrue(3 == pq.max());	
		Assert.assertTrue(3 == pq.extractMax());
		Assert.assertTrue(1 == pq.max());	
		Assert.assertTrue(1 == pq.extractMax());
		Assert.assertEquals(null, pq.max());	
		Assert.assertEquals(null, pq.extractMax());

		
	}
}
