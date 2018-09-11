package com.toscano.LinkedList;

public class LinkedList<k,v> {
	
	// number of nodes in the list
	public int size = 0;
	public ListNode<k,v> head, tail;
	
	// constructor
	public LinkedList() {
		
		this.head = this.tail = null;
		
	}
	
	// add a node to the list
	public void Add(k key, v value) {
		
		// create a new node
		ListNode<k,v> newNode = new ListNode<k,v>(key, value);
		
		// if the list is empty, handle nulls
		if( this.size == 0 ) {
			
			// set the new node to the head, and tail since
			// it is the only node in the list
			this.head = this.tail = newNode;
			newNode.next = null;
			newNode.previous = null;
			
		} else {
			
			// add the node to the end of the linked list
			this.tail.next = newNode;
			newNode.previous = this.tail;
			this.tail = newNode;
			
		}
		
		this.size++;
		
	}
	
	public void Remove(ListNode<k,v> node) {
		
		if( this.size < 2 ) {
			
			this.head = null;
			this.tail = null;
			
		} else {
		
			if( node == this.head ) {
				
				// remove the first node
				node.next.previous = null;
				this.head = node.next;
				node.next = null;
				
			} else if( node == this.tail ) {
				
				// remove the last node
				node.previous.next = null;
				this.tail = node.previous;
				node.previous = null;
				
			} else {
				
				// delete middle node
				node.next.previous = node.previous;
				node.previous.next = node.next;
				node.previous = node.next = null;
				
			}
			
		}
		
		this.size--;
		
	}

}
