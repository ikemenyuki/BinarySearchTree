package com.cse.ds;

import java.util.NoSuchElementException;

/**
 * Queue
 * 
 * @author Yueqi Liao
 * 
 * @login cs12sp19iv
 * 
 * @date May 25, 2019
 * 
 * @email yliao@ucsd.edu
 *
 * @param <E>
 */
public class Queue<E> {
	
	/**
	 * QNode
	 * 
	 * @author Yueqi Liao
	 * 
	 * inner class for nodes of linked list
	 *
	 * @param <E>
	 */
	@SuppressWarnings("hiding")
	public class QNode<E> {
		
		//FIELD
		private QNode<E> next;
		private E element;
		
		/**
		 * QNode
		 * 
		 * constructor for inner class
		 * 
		 * @param e
		 */
		public QNode(E e) {
			this.element = e;
			this.next = null;
		}
		
		/**
		 * setNext
		 * 
		 * @param next
		 * 
		 * set the next element for the linked list node
		 */
		public void setNext(QNode<E> next) {
			this.next = next;
		}
		
		/**
		 * getNext
		 * 
		 * getter
		 * 
		 * @return this.next
		 */
		public QNode<E> getNext() {
			return this.next;
		}
		
		/**
		 * getElement
		 * 
		 * getter
		 * 
		 * @return this.element
		 */
		public E getElement() {
			return this.element;
		}
	}
	
	//FIELD
	private QNode<E> head;
	private QNode<E> tail;
	private int nElements;
	
	/**
	 * Queue
	 * 
	 * constructor
	 * 
	 * initialize an empty queue
	 */
	public Queue() {

		head = null;
		tail = null;
		nElements = 0;
	}
	
	/**
	 * getHead
	 * 
	 * getter
	 * 
	 * @return head
	 */
	public QNode<E> getHead() { return this.head; }
	
	/**
	 * getTail
	 * 
	 * getter
	 * 
	 * @return Tail
	 */
	public QNode<E> getTail() { return this.tail; }
	
	/**
	 * enqueue
	 * 
	 * @param val
	 * 
	 * add elements to the end of queue
	 */
	public void enqueue(E val) {

		//exceptions handling
		if (val == null)
			throw new IllegalArgumentException("CANNOT BE NULL!");
		
		//initialize a new node
		QNode<E> newNode = new QNode<E>(val);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = tail.getNext();
		}
		nElements++;//size increment
	}
	
	/**
	 * dequeue
	 * 
	 * @return E element in the head node
	 * 
	 * remove and return the element in the head
	 */
	public E dequeue() {

		if (isEmpty()) {
			throw new NoSuchElementException("Empty Queue!");
		}
		
		E toDe = getHead().getElement();
		head = head.getNext();
		nElements--;//size decrement
		
		return toDe;
	}
	
	/**
	 * size
	 * 
	 * @return int nElement
	 * 
	 * return the size fo the node
	 */
	public int size() {
		
		return nElements;
	}
	
	/**
	 * isEmpty
	 * 
	 * @return whether the queue is empty
	 * 
	 * return true if the queue is empty
	 */
	public boolean isEmpty() {

		return nElements==0;
	}
}
