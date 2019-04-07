package com.data.structures;

/**
 * Simple implementation of Hash Table. Used separate chaining approach. When
 * load factor is > 0.75, doubling in size and rehashing.
 * 
 * @author Polina Koleva
 *
 */
public class CustomHashTable {

	private HashEntry[] hashTable;
	private int entries;

	/**
	 * Create a hash table instance with the default capacity (16).
	 */
	public CustomHashTable() {
		this.hashTable = new HashEntry[16];
	}

	public CustomHashTable(int capacity) {
		this.hashTable = new HashEntry[capacity];
	}

	private double getLoadFactor() {
		return (double) entries / hashTable.length;
	}

	public void put(String key, String value) {
		entries++;
		doubleInSize();
		// add new value
		insertIntoArray(key, value, this.hashTable);
	}

	private void doubleInSize() {
		// if load factor is bigger than 0.75, double the arr
		if (getLoadFactor() > 0.75) {
			// double the size of the array
			HashEntry[] biggerHashTable = new HashEntry[this.hashTable.length * 2];
			// rehash all the values and copy them to the new array
			for (int i = 0; i < hashTable.length; i++) {
				HashEntry e = hashTable[i];
				while (e != null) {
					insertIntoArray(e.key, e.value, biggerHashTable);
					e = e.next;
				}
			}
			// add new value
			this.hashTable = biggerHashTable;
		}
	}

	private void insertIntoArray(String key, String value, HashEntry[] arr) {
		// if key already exists, update its value
		if (get(arr, key) != null) {
			get(arr, key).value = value;
		// insert a new non-existing key
		} else {
			HashEntry entry = new HashEntry(key, value);
			int index = getHashCode(entry.key) % arr.length;
			HashEntry firstEntry = arr[index];
			// no entry at this position
			if (firstEntry == null) {
				arr[index] = entry;
			} else {
				// find the last element in the list
				while (firstEntry.next != null) {
					firstEntry = firstEntry.next;
				}
				firstEntry.next = entry;
			}
		}
	}

	public void remove(String key) {
		// find entry
		int index = getHashCode(key) % hashTable.length;
		HashEntry previos = hashTable[index];
		if (previos != null) {
			// first element needs to be deleted
			if (previos.key.equals(key)) {
				hashTable[index] = previos.next;
				entries--;
			} else {
				HashEntry current = previos.next;
				while (current != null && !current.key.equals(key)) {
					previos = current;
					current = current.next;
				}
				if (current != null) {
					// remove current
					previos.next = current.next;
					entries--;
				}
			}
		}
		// done only if load factor is small enough
		shrink();
	}

	private void shrink() {
		// shrink the array when entries are lower that 1/4 of the size of the array
		if (getLoadFactor() < (this.hashTable.length / 4)) {
			System.out.println("Shrinking....");
			HashEntry[] smallerHashTable = new HashEntry[this.hashTable.length / 2];
			// rehash all the values and copy them to the new array
			for (int i = 0; i < hashTable.length; i++) {
				HashEntry e = hashTable[i];
				while (e != null) {
					System.out.println("Copy values" + e.key);
					insertIntoArray(e.key, e.value, smallerHashTable);
					e = e.next;
				}
			}
			// add new value
			this.hashTable = smallerHashTable;
			System.out.println(this);
		}
	}

	public HashEntry get(String key) {
		return get(this.hashTable, key);
	}

	private HashEntry get(HashEntry[] arr, String key) {
		int index = getHashCode(key) % arr.length;
		HashEntry firstEntry = arr[index];
		while (firstEntry != null && !firstEntry.key.equals(key)) {
			firstEntry = firstEntry.next;
		}
		return firstEntry;
	}
	
	private int getHashCode(String key) {
		// key.hashCode();
		// 31^(n-1)*s[0] + 31^(n-2)*s[1] .... 31^0*s[n-1]
		int hashCode = 0;
		char[] keyArr = key.toCharArray();
		for (int i = 0; i < keyArr.length; i++) {
			hashCode += Math.pow(31, key.length() - (i + 1)) * keyArr[i];
		}
		return hashCode;
	}

	@Override
	public String toString() {
		int bucket = 0;
		StringBuilder hashTableStr = new StringBuilder();
		for (HashEntry entry : hashTable) {
			if (entry == null) {
				continue;
			}
			hashTableStr.append("\n bucket[").append(bucket).append("] = ").append(entry.toString());
			bucket++;
			HashEntry temp = entry.next;
			while (temp != null) {
				hashTableStr.append(" -> ");
				hashTableStr.append(temp.toString());
				temp = temp.next;
			}
		}
		return hashTableStr.toString();
	}

}

class HashEntry {
	String key;
	String value;
	HashEntry next;

	public HashEntry(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public void setNext(HashEntry entry) {
		this.next = entry;
	}

	public HashEntry getNext() {
		return this.next;
	}

	@Override
	public String toString() {
		return "[" + this.key + "," + this.value + "]";
	}
}
