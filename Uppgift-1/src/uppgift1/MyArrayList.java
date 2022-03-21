package uppgift1;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
	int size;                    // keeps track of the number of elements
	private T[] array;           // stores the elements
	//skapa en tom lista
	public MyArrayList() {
		array = (T[]) new Object[7];
		size = 0;
	}
/*=====================================Add metod med en argument och boolean return value===========================================*/
	//lägg till t i slutet av listan 
	public boolean add(T t) {
		if (size >= array.length) {
			// make a bigger array and copy over the elements
			@SuppressWarnings("unchecked")
			T[] bigger = (T[]) new Object[array.length * 2];
			System.arraycopy(array, 0, bigger, 0, array.length);
			array = bigger;
		}
		array[size] = t;
		size++;
		return true;
	}
/*====================================Add metod med två argument=================================*/
	//lägg till t på plats index i listan
	public void add(int index, T t) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// add the element to get the resizing
		add(t);

		// shift the elements
		for (int i=size-1; i>index; i--) {
			array[i] = array[i-1];
		}
		// put the new one in the right place
		array[index] = t;
	}
/*===================================Contains metod ======================================*/
	//Returnerar true om t finns i listan. Annars returneras false.
	public boolean contains(T t ) {
		for(int i = 0 ; i < array.length; i++) {
		if(array[i]== t) {
			System.out.print("Element " + t + " finns i listan: ");
			return true;
			
			}
		}
		System.out.print("Element " + t + " finns inte i listan: ");
			return false;
		
   }

	
/*===================================get metod ======================================*/	
	//Returnerar värdet på plats index om det finns, annars returneras null
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(contains(array[index])) {
			System.out.println("i index["+ index + "]");
			return array[index];
		}
		return null;
	}
/*===================================indexOf metod ======================================*/
	//Returnerar antingen index för första förekomsten av t, eller returnerar -1.
	public int indexOf(T t) {
		int index;
		for(index = 0; index <array.length; index++) {
	 if(array[index] == t) {
		 return index;
		 }
	 }
		return -1;
	}
/*===================================remove metod som retunerar boolean värde ======================================*/
	//Om värdet t finns tas det bort och true returneras. Annars returneras false.

	public boolean remove(T t) {
		for(int i = 0; i < array.length; i++)
		if(array[i]== t) {
			array[i]= null;
			return true;
		}
		return false;
	}
/*===================================set metod ======================================*/	
	//Ersätter värdet på plats index med t och returnerar det gamla värdet.
	public T set(int index, T t) {
		int i = 0;
		T temp = null ;
		for(i = 0; i <array.length; i++) {
			if(index== i) {
				temp = array[i];
				array[i]= t;
			}
			
		}
		return temp;
	}

/*===================================size metod ======================================*/
	//Returnerar antalet element i listan.
	public int size() {
		int count = 0;
		T[] temp = (T[]) new Object[array.length];
		if(!isEmpty()) {
			for(int i = 0; i< array.length; i++) {
			count = indexOf(array[i]);
		}
			}
		
		return count;
	}

/*===================================isEmpty metod ======================================*/	
	//Undersöker om listan är tom.
	public boolean isEmpty() {
		if(size == 0) {
		return true;
		}
		return false;
	}

/*===================================iterator metod som loopar över listan======================================*/	
	//Retrurnerar en iterator för listan.
	public Iterator<T> iterator() {
		//kopia av array
		T[] copy = Arrays.copyOf(array, size);
		// gör lista och return iterator
		return Arrays.asList(copy).iterator();
	}


/*===================================Size metod som retunerar storlek på listan ======================================*/	
//Returnerar storleken på listan
	public int Size() {
		int storlek = array.length;
		return storlek;
	}

/*===================================clear metod ======================================*/	
	//Tar bort alla element i listan.
public void clear() {
		size=0;
	}

/*===================================toString() metod ======================================*/
//Konverterar listan till en sträng.
public String toString() {
	Iterator<T> it = iterator();
    if (! it.hasNext())
        return "[]";

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (;;) {
        T e = it.next();
        sb.append(e == this ? "(this Collection)" : e);
        if (! it.hasNext())
            return sb.append(']').toString();
        sb.append(',').append(' ');
    }
}

/*===================================Test metod ======================================*/
public static void main(String[] args) {
	System.out.println("Array lista innan Adding nån element är :");
	MyArrayList<Integer> mal = new MyArrayList<Integer>();
	System.out.println(mal.toString());
	System.out.println("======================================================");
	System.out.println("Array lista efter Adding är :");
	mal.add(10);
	mal.add(21);
	mal.add(23);
	System.out.println(mal.toString());
	System.out.println("======================================================");
	System.out.println("Array lista efter Adding 77 i index 2 är :");
	     mal.add(2, 77);
	System.out.println(mal.toString());
	System.out.println("======================================================");
	System.out.println("kika om array lista har element  :");
	System.out.println(mal.contains(12));
	System.out.println(mal.contains(21));
	System.out.println("======================================================");
	System.out.println("vilket elemnt finns i index ");
	System.out.println(mal.get(1));
	System.out.println("======================================================");
	System.out.println("Elementet finns i index ");
	System.out.println(mal.indexOf(23));
	System.out.println("======================================================");
	System.out.println("Ta bort 10 från listan: ");
	System.out.println(mal.remove(10));
	
	System.out.println("======================================================");
	System.out.println("listan innan ändring är, kommer du ihåg att denna listan är efter removing element 10:");
	System.out.println(mal.toString());
	System.out.println("ändra värdet i index 2 ");
	System.out.println(mal.set(2, 100));
	System.out.println("listan efter ändring är:");
	System.out.println(mal.toString());
	System.out.println("Nu ska vi lägga nytt element i index 0");
	mal.set(0, 77);
	System.out.println("Listan blir:");
	System.out.println(mal.toString());
	System.out.println("======================================================");
	System.out.println("är listan tom?");
	System.out.println(mal.isEmpty());
	System.out.println("======================================================");
	mal.add(1);
	System.out.println("Antal element i listan är:");
	System.out.println(mal.toString() + " size = " + mal.size());
	System.out.println("storlek i listan är:");
	System.out.println(mal.toString() + " size = " + mal.Size());
	System.out.println("======================================================");
	System.out.println("Antal element i listan efter clearing är :");
	mal.clear();
	System.out.println(mal.toString() + " Antal = " + mal.size());
	System.out.println("storlek i listan efter clearing är:");
	System.out.println(mal.toString() + " storlek = " + mal.Size());
	System.out.println("======================================================");
	System.out.println("är listan tom?");
	System.out.println(mal.isEmpty());
	System.out.println("======================================================");
	
}
 }

	

