package uppgift1;

import java.util.ArrayList;
import java.util.PriorityQueue;




public class LinearProbingHashSet <Key>{
	  private static int capacity ;
	  private int n;          // antal element sparade
	  private int m;         //array storlek
	 // private Key[] a;      // vi sparar nycklar i arryen a
	  private HashElement<Key>[] a;
	  //hashValue=hashvärde
	  private double maxLoadFactor;
	  private double loadFactor;
	 

/*===========================================================================*/
//Skapa en instans där array storlek är m
public LinearProbingHashSet(int m){
		this.m = m;
		n= 0;
		a =  new HashElement[m];
		maxLoadFactor = loadFactor;
	
	}
/*===========================================================================*/
//skapa en instans där kapacitetn m är satt till defaultvärde 
public LinearProbingHashSet(){
		this(4); //eller 2
	}
/*===========================================================================*/	
public int size() {
	   return n;
	    }
/*===========================================================================*/		  
public boolean isEmpty() {
	        return size() == 0;
	    }

/*===========================================================================*/
//Returnera hashvärdet för key.
public int hash(Key key) {
	 return (key.hashCode() & 0x7fffffff) % m;
	}

private double loadFactor() {
	return (double)n / (double) a.length;
}


/*===========================================================================*/	
//Returnera arraystorleken m.
int getCapacity() {
	return m;
		
	}
/*===========================================================================*/
//lägg till key i hashtabellen, eller öka förekomst med 1 om den redan finns.
void insert(Key key) {
	int i;
	int hashValue = hash(key); //räkna hashvärde som nyckeln har
	if(a[hashValue]==null) {   //
		a[hashValue]=new HashElement<Key>(key);
		n++;
		return;
	}
	/*om laodFactor är större eller lika med 0.5 
	 * if(laodFactor >= 0.5){
	 * resize(2*m);
	 * }
	 */
	 if (n >= m/2) 
		 resize(2*m);
	 for (i = hashValue; a[i] != null; i = (i + 1) % m) {
		 if (a[i].getKey().equals(key)) {
			 a[i].increment();
	        return; 
         	}
     }
     a[i] = new HashElement<Key>(key);
   
     n++;
 }

/*===========================================================================*/
//finns nycklen key
boolean contains(Key key) {
	boolean isfound= false;
	if (key == null)
		throw new IllegalArgumentException("Key is null");
	for (int i = hash(key);a[i] != null; i = (i + 1) % m) {
		if (a[i].getKey().equals(key)) {
			isfound= true;
			return isfound;
		}
	}
	return isfound;
}

/*===========================================================================*/

/* Minska ner förekomst för key med 1.
 *  Om förekomst blir 0, så tas nyckeln bort från arrayen
 */
void decrease(Key key) {
    // performing basic checks
    if (key == null)
            throw new IllegalArgumentException("Key is null");
    if (!contains(key))
            return;
    // locating initial index
    int hashValue = hash(key);
    // locating element
    while (!key.equals(a[hashValue].getKey())) {
            hashValue = (hashValue + 1) % m;
    }
    // decrementing frequency of element at index=hashValue
    a[hashValue].decrement();
    // if frequency is now 0, deleting the value entirely from the set
    if (a[hashValue].getFrequencey() <= 0) {
            delete(key);
    }
}
	

/*===========================================================================*/
//Ta bort key
void delete(Key key) {
	if (key == null)
		throw new IllegalArgumentException("Key is null");
	 if (!contains(key))
		 return;
     int hashValue = hash(key);//räkna hashvalue
     //itererar man tills elementet hiittas 
     while (!key.equals(a[hashValue].getKey())) {
    	 hashValue = (hashValue + 1) % m;
     }
//sätter man elementet till null
     a[hashValue] = null;
     hashValue = (hashValue + 1) % m; //räkna efter följande plats 
     while (a[hashValue] != null) {
      Key  keyToRehash = a[hashValue].getKey();
      int freq = a[hashValue].getFrequencey();
       a[hashValue] = null;
         n--;  //minskar n med 1  
         for (int i = 0; i < freq; i++) {
             insert(keyToRehash);
     }
         hashValue = (hashValue + 1) % m;
     }

     n--;   //minskar n med 1     

 /*if loadfactor är mindre eller lika med 1/8 så halverar man arrayen
  * if(laodFactor <= 1/8){
	 * resize(m/2);
	 * }
  */
     
     if (n > 0 && n <= m/8)
    	 resize(m/2);

 }
/*===========================================================================*/
/*Returnera en Iterable<Key>- objekt där iterering sker över nycklarna 
 * i förekomstordning. Den mest förekommande nyckeln kommer först, 
 * den näst mest förekommande kommer sen osv.
 */

public Iterable<Key> keys() {
    // creating a list to store results
    ArrayList<Key> results = new ArrayList<Key>();
    // a priority queue to store hash elements sorted by frequency, temporarily
    PriorityQueue<HashElement<Key>> q = new PriorityQueue<HashElement<Key>>();
    // looping through array a and adding each hash element to q
    for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                    q.add(a[i]);
            }
    }
    // now looping and removing each element from queue, adding key of each removed
    // value to results list. the elements will be removed according to the way
    // compareTo method written in HashElement class
    while (!q.isEmpty()) {
            results.add(q.remove().getKey());
    }
    return results;
}
/*===========================================================================*/
public void resize(int capacity) {
	LinearProbingHashSet<Key> temp = new LinearProbingHashSet<Key>(capacity);
     for (int i = 0; i < m; i++) {
         if (a[i] != null) {
        	  for (int j = 0; j < a[i].getFrequencey(); j++) {
                  temp.insert(a[i].getKey());
          }
         }
     }
     a = temp.a;
     m= temp.m;
 }
public void print(){
    for(int i =0; i <this.size(); i++){
        if(a[i] != null){
     System.out.println(((HashElement<Key>) a[i]).getKey() + " " + ((HashElement<Key>) a[i]).getFrequencey() );
    }
   }
 }
}
/*===========================================================================*/

