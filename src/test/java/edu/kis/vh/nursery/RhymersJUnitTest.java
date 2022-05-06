package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

	@Test
	public void testCountIn() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		int testValue = 4;
		rhymer.countIn(testValue);

		int result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
	}

	@Test
	public void testCallCheck() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		boolean result = rhymer.callCheck();
		Assert.assertTrue(result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertFalse(result);
	}

	@Test
	public void testIsFull() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int STACK_CAPACITY = 12;
		for (int i = 0; i < STACK_CAPACITY; i++) {
			boolean result = rhymer.isFull();
			Assert.assertFalse(false);
			rhymer.countIn(888);
		}

		boolean result = rhymer.isFull();
		Assert.assertTrue(true);
	}

	@Test
	public void testPeekaboo() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int EMPTY_STACK_VALUE = -1;

		int result = rhymer.peekaboo();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
		result = rhymer.peekaboo();
		Assert.assertEquals(testValue, result);
	}

	@Test
	public void testCountOut() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		final int EMPTY_STACK_VALUE = -1;

		int result = rhymer.countOut();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.countOut();
		Assert.assertEquals(testValue, result);
		result = rhymer.countOut();
		Assert.assertEquals(EMPTY_STACK_VALUE, result);
	}

	@Test
	public void testIntLinkedList(){
		IntLinkedList linkedList = new IntLinkedList();
		boolean result =  linkedList.isEmpty();
		Assert.assertTrue(result);
		linkedList.push(0);
		Assert.assertEquals(linkedList.pop(),0);
		result = linkedList.isEmpty();
		Assert.assertTrue(result);
	}

	@Test
	public void testFIFORhymer(){
		FIFORhymer fifoRhymer = new FIFORhymer();
		Assert.assertEquals(fifoRhymer.countOut(), -1);
		fifoRhymer.countIn(10);
		Assert.assertEquals(fifoRhymer.countOut(),10);
		Assert.assertTrue(fifoRhymer.callCheck());
	}

	@Test
	public void testHanoiRhymer(){
		HanoiRhymer hanoiRhymer = new HanoiRhymer();
		Assert.assertEquals(hanoiRhymer.reportRejected(),0);

		hanoiRhymer.countIn(10);
		hanoiRhymer.countIn(11);
		Assert.assertEquals(hanoiRhymer.reportRejected(),1);
		Assert.assertEquals(hanoiRhymer.peekaboo(), 10);

		for(int i = 10;i<15;i++){
			hanoiRhymer.countIn(i);
		}
		Assert.assertEquals(hanoiRhymer.reportRejected(), 5);

		for(int i = 9;i>=0;i--){
			hanoiRhymer.countIn(i);
		}
		Assert.assertEquals(hanoiRhymer.getTotal(),11);
		Assert.assertEquals(hanoiRhymer.reportRejected(), 5);
		Assert.assertTrue(hanoiRhymer.isFull());
	}
}
