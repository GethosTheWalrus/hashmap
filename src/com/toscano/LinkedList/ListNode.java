package com.toscano.LinkedList;

public class ListNode<k,v> {
	
	public k key;
	public v data;
	public ListNode<k,v> next, previous;
	
	// set the data, and the key it is mapped to
	public ListNode(k key, v value) {
		
		this.key = key;
		this.data = value;
		
	}
	
	public boolean Matches(k key) {
		
		if( this.key == key ) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	// return the data stored within this node
	public v GetData() {
		
		return this.data;
		
	}

}
