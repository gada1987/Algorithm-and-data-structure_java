package uppgift1;
import java.awt.RenderingHints.Key;


@SuppressWarnings("hiding")
public class HashElement<Key> implements Comparable<HashElement<Key>> {
	    private Key nyckel; //key
	    private int counter; //counter
	    int förekomst; //antal förkomst av ordet
/*===========================================================================*/
//skapa ett Hashelement med nyckel key och förkomsten 1
public HashElement(Key key) {
		this.nyckel = key;
		förekomst = 1;
		
	}
/*===========================================================================*/
//skapa ett Hashelement med nyckel key och förkomsten counter
public HashElement(Key key, int counter) {
	this.nyckel = key;
	förekomst = counter;
}
/*===========================================================================*/
//öka förkomst med 1
public void increment() {
	förekomst++;
}
/*===========================================================================*/
//minska förkomst med 1
public void decrement() {
	förekomst--;
}
/*===========================================================================*/
//retunera förkomst
int getFrequencey() {
	return förekomst;
}
/*===========================================================================*/
//Retunera nyckeln
public Key getKey() {
	return nyckel;
}
/*===========================================================================*/
//sätt nyckeln till key
public void setKey(Key key) {
	 nyckel = key;
}
/*===========================================================================*/
//jämför förkomsten för this med förekomstan för that
public int compareTo(HashElement that) {
	 int counterOne = this.getFrequencey();        
     int counterTwo = that.getFrequencey(); 
    
    
     if(counterOne < counterTwo)
         return 1;
      else if(counterOne > counterTwo)
          return -1;
      else
          return 0;  
          
	// Comparable<Key> comparable = (Comparable<Key>)nyckel;
	//return comparable.compareTo((Key) that);	
}

}

/*===========================================================================*/