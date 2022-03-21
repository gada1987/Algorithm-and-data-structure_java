package uppgift1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ <Key extends Comparable<Key>>{
	public Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    @SuppressWarnings("unused")
	private Iterator <Key> ite;          // optional comparator
    private Comparator<Key> comparator;
    int pqi []; 
    int iqp []; 
/*=================================Constructor-1=========================================*/
 //skapa en tum prioritet queue
public MaxPQ() {
	 this(1);
}
/*==================================Constructor-2========================================*/
//max den initiala kapaciteten för den här prioritetskön
@SuppressWarnings("unchecked")
public  MaxPQ(int max) {
	pq = (Key[]) new Comparable[max + 1];
    n = 0;
	}
/*==================================Constructor-3========================================*/
//skapa en prioritetskö från nycklar av array.

public  MaxPQ(Key [] a) {
	// Key[] nyarray;
		 n = a.length;
   //Lägg elementen i arrayen a på platserna 1 till n i en ny array av längd n+1.
		 pq = (Key[]) new Comparable[a.length +1];
		 System.arraycopy(a, 0, pq, 1, a.length);
	     //pq = (Key[]) new Object[a.length +1];
	     for (int i = 1; i <= n; i++){ // iterera framåt i arrayen, index för index
	    	 pq[i] = a[i-1];}
	     for (int k = n/2; k >= 1; k--){
	         sink(k);//sink-funktionen för att låta elementet sjunka ner i arrayen 
	         } 
	     assert isMaxHeap();
	     
	     }

	/*int N;
	pq = (Key[]) new Comparable[a.length + 1];
	System.arraycopy(a, 0, pq, 1, a.length);

	for (int i = pq.length / 2; i >= 1; i--)
		sink(i);

	N = pq.length - 1;
}*/
	
/*==================================resize()========================================*/

//resize the underlying array to have the given capacity
private void resize(int capacity) {
    assert capacity > n;
    @SuppressWarnings("unchecked")
	Key[] temp = (Key[]) new Comparable[capacity];
    for (int i = 1; i <= n; i++) {
        temp[i] = pq[i];
    }
    pq = temp;
}
/*====================================Insert======================================*/
public void insert(Key v) {
	
	// double size of array if necessary
   if (n == pq.length - 1) {resize(2 * pq.length);}

    // add x, and percolate it up to maintain heap invariant
    pq[++n] = v;
    swim(n);
    assert isMaxHeap();
}
/*==================================== Max()======================================*/
//retunerar största nyckel
 public Key max() {
	 if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
     return pq[1];
 }
 /*==================================delMax()========================================*/
 //retunerar och ta bort största nyckel
 public Key delMax() {
	 if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
     Key max = pq[1];
     exch(1, n--);
     sink(1);
     pq[n+1] = null;     // to avoid loitering and help with garbage collection
     if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
     assert isMaxHeap();
     return max;
 }
 /*==================================IsEmpty()========================================*/
 //kollar if kö är töm
 boolean isEmpty() {
	 boolean tum = false;
	 if(n==0) {
		 tum = true;
	 }
	 return tum;
 }
 
/*====================================size()======================================*/
 //retunerar stårlek av nycklar i kön 
 int size() {
	 return n;
 }
 /*================================== swim()========================================*/
 
 private void swim(int k) {
     while (k > 1 && less(k/2, k)) {
         exch(k, k/2);
         k = k/2;
     }
 }
 

 
 /*====================================sink()======================================*/
 public void sink(int k) {
     while (2*k <= n) {
         int j = 2*k;
         if (j < n && less(j, j+1)) j++;
         if (!less(k, j)) 
        	 break;
         exch(k, j);
         k = j;
     }
 }
 /*=====================================less()=====================================*/
 /*private boolean less(int i, int j) {
     if (comparator == null) {
         return  pq[i].compareTo(pq[j]) < 0;
     }
     else {
         return comparator.compare(pq[i], pq[j]) < 0;
     }
 }*/
 private boolean less(int i, int j)
	{
		if (pq[i].compareTo(pq[j]) > 0)
			return true;
		return false;
	}
 /*====================================exch()======================================*/
 private void exch(int i, int j) {
     Key swap = pq[i];
     pq[i] = pq[j];
     pq[j] = swap;
 }
 /*=====================================isMaxHeap()=====================================*/
 // is pq[1..n] a max heap?
 private boolean isMaxHeap() {
     for (int i = 1; i <= n; i++) {
         if (pq[i] == null) return false;
     }
     for (int i = n+1; i < pq.length; i++) {
         if (pq[i] != null) return false;
     }
     if (pq[0] != null) return false;
     return isMaxHeapOrdered(1);
 }
 /*====================================isMaxHeapOrdered()======================================*/
 // is subtree of pq[1..n] rooted at k a max heap?
 private boolean isMaxHeapOrdered(int k) {
     if (k > n) return true;
     int left = 2*k;
     int right = 2*k + 1;
     if (left  <= n && less(k, left))  return false;
     if (right <= n && less(k, right)) return false;
     return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
 }
 public Iterator<Key> iterator() {
     return new HeapIterator();
 }
 public String toString()
 {
     String ret = "";
     for (int i = 1; i <= n; i++)
     {
         ret += pq[i] + " ";
     }
     return ret;
 }

 /*====================================HeapIterator()======================================*/
 private class HeapIterator implements Iterator<Key> {

     // create a new pq
     private MaxPQ<Key> copy;

     // add all items to copy of heap
     // takes linear time since already in heap order so no keys move
     public HeapIterator() {
         if (comparator == null) copy = new MaxPQ<Key>(size());
         for (int i = 1; i <= n; i++)
             copy.insert(pq[i]);
     }

     public boolean hasNext(){ 
    	 return !copy.isEmpty();
     }
     public void remove(){ 
    	 throw new UnsupportedOperationException(); 
     }

     public Key next() {
         if (!hasNext()) throw new NoSuchElementException();
         return copy.delMax();
     }
 }
 
}
