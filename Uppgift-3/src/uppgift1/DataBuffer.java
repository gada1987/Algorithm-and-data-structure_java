package uppgift1;
import java.util.*;

public class DataBuffer <T> implements Iterable<T> {
	

T [] a ;    //buffee array
int back;  //last
int front; //first
int count;
public int bufferSize; //buffer storlek
int capacity; //capacity of the queue
int s ;
/*=============================================================================*/
//Skapa en databuffert med bufferstorlek bufferSize.
@SuppressWarnings("unchecked")
public DataBuffer(int bufferSize){
	
	capacity= bufferSize;
	count = 0;
    back = 0;
    front = 0;
	a =  (T[])(new Object[capacity]);
	
}
public int emptyDataBuffer()throws Exception {
	if(capacity() <= 0) {
		throw new Exception("It is empty databuffer");
	}
	return capacity();
	
}
/*=============================================================================*/

public synchronized void enqueue(T item) throws Exception {
    if (isFull()) {
    	throw new RuntimeException("Data Buffer overflow");
    }
    else {
      
        a[back] = item;
        count += 1;
        back +=1;
        
        if (back == capacity()) {
			back = 0;
		}
    }
}


/*=============================================================================*/
//Ta bort första elementet i bufferten (först i kön)
public synchronized T dequeue() throws Exception {
	
   if(isEmpty()) 
    {
    	 throw new RuntimeException("Data Buffer underflow");
    }

   T del = a[front];
   a[front] = null;
   count--;
   front +=1;
   if (front == capacity()) {
       front = 0;
   }
   
  // do this to reset front position to 0 if it becomes equal to capacity
    //front = (front+1) % a.length;
    
    
    return del;
    
}
/*=============================================================================*/
//Ändrar kapaciteten på bufferten till newBufferSize.
public void changeBufferSize( int newBufferSize) {
         int s = newBufferSize;
         T[] temp = a;
		 a  = (T[])new Object[s];
        for(int j = 0; j < a.length; j++) {
          a[j] = temp[(front+j)% a.length];
        }
      // a = temp;
       front = 0;
       back= newBufferSize;
       }


/*=============================================================================*/

public String toString() {
	
	StringBuilder sb = new StringBuilder();
	String result;
	sb.append("[");
	for (int i = 0; i < a.length; i++) {
		sb.append(a[i] + ",");
		}
	sb.append("]");
	result = sb.toString();

	return result;
	
}
/*=============================================================================*/
//Är bufferten full?
public boolean isFull() {
	return count()== capacity();
}
public int count() {
	return count;
}
/*=============================================================================*/
//Är bufferten tom?
public boolean isEmpty() {
	return capacity()==0;
}

/*=============================================================================*/
//Returnerar antalet element i bufferten. 
/*public int size() {
	return capacity;
}*/

/*=============================================================================*/
//Returnerar kapaciteten på bufferten, dvs. hur mycket den kan innehålla.
public int capacity() {
	return a.length;
}
/*=============================================================================*/

public T peek()
{
   if(isEmpty()) {
	   throw new RuntimeException("Data Buffer underflow");
	   }
 else
    return a[front];
}
/*=============================================================================*/
public Iterator<T> Iterator(){
	if(isEmpty()) {
		throw new RuntimeException("Data Buffer underflow");
	}
	else {
	return new BufferIterator();
	}
}

private class BufferIterator implements Iterator<T> {
    private int count;
    private int pos;

    BufferIterator() {
        count = 0;
        pos = front;
    }

    public boolean hasNext() {
        return count < count();
    }

    public T next() {
        T item = a[pos];
        pos += 1;
        if (pos == capacity()) {
            pos = 0;
        }
        count += 1;
        return item;
    }
}
@Override
public java.util.Iterator<T> iterator() {
	// TODO Auto-generated method stub
	return null;
}

}
