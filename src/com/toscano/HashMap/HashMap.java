package com.toscano.HashMap;

import com.toscano.LinkedList.LinkedList;
import com.toscano.LinkedList.ListNode;

public class HashMap<k,v> {
	
	// number of elements in the hashmap
	public int size = 0;
	// array to hold the buckets
	private Object[] buckets;
	// ratio of elements to buckets that will cause the hashmap to expand
	private double rehashFactor = 0.75;
	
	// constructor
	public HashMap() {
		
		this.buckets = new Object[4];
		
	}
	
	// Get the value associated with a key
	public v Get(k key) {
		
		return this.getNodeByKey(key).GetData();
		
	}
	
	// Add an element to the hashmap
	public void Put(k key, v value) {
		
		this.rehash();
		
		// determine which bucket this value will be placed in
		int indexOfBucket = HashMap.indexFor( key.hashCode(), this.buckets.length );
		
		// determine if the bucket is null
		if( this.buckets[indexOfBucket] == null ) {
			
			this.createBucketAtIndex(indexOfBucket);
			
		}
		
		// check if an element with the supplied key
		// already exists in this bucket
		ListNode<k,v> nodeWithGivenKey = getNodeByKey(key);
		LinkedList<k,v> bucket = (LinkedList<k,v>)this.buckets[indexOfBucket];
				
		if( nodeWithGivenKey == null ) {
			
			bucket.Add(key, value);
			
		} else {
			
			// replace the node with the same key with our new node
			bucket.Remove(nodeWithGivenKey);
			bucket.Add(key, value);
			
		}
		
		this.size++;
		
	}
	
	// rehash the hashmap
	private void rehash() {
						
		double ratioElementsToBuckets = (double)this.size / (double)this.buckets.length;
		
		if( ratioElementsToBuckets >= this.rehashFactor ) {
									
			Object[] newBuckets = new Object[this.buckets.length + this.size];
			Object[] tempBuckets = this.buckets;
			this.buckets = newBuckets;
			
			this.size = 0;
			
			// copy all old buckets over to new buckets array
			for( int i = 0; i < tempBuckets.length; i++ ) {
				
				// rehash each element in the current bucket
				LinkedList<k,v> bucket = (LinkedList<k,v>)tempBuckets[i];
				
				// make sure the bucket isn't null, otherwise we can skip it
				if( bucket != null ) {
				
					ListNode<k,v> currentNode = bucket.head;
					
					// add each node of the bucket back to the newly sized list
					while( currentNode != null ) {
						
						this.Put(currentNode.key, currentNode.data);
						
						currentNode = currentNode.next;
						
					}
					
				}
								
			}
			
			this.buckets = newBuckets;
			
		}
		
	}
	
	// get a node from within a bucket given a key
	private ListNode<k,v> getNodeByKey(k key) {
		
		// get the bucket we will be searching
		LinkedList<k,v> bucket = (LinkedList<k,v>)this.buckets[HashMap.indexFor( key.hashCode(), this.buckets.length )];
		
		// if the bucket is empty, the value is not here
		if( bucket == null || bucket.size == 0 ) {
			
			return null;
			
		}
		
		// traverse the list until we find the correct node
		ListNode<k,v> currentNode = bucket.head;
		while( currentNode != null ) {
			
			if( currentNode.Matches(key) ) {
				
				return currentNode;
				
			}
			
			currentNode = currentNode.next;
			
		}
		
		return null;
		
	}
	
	// create an empty bucket at the supplied index
	private void createBucketAtIndex(int index) {
		
		LinkedList<k,v> l = new LinkedList<k,v>();
		this.buckets[index] = l;
		
	}
	
	static int indexFor(int h, int length) {
		
	    return h & (length-1);
	    
	}

}
