package uppgift1;
import java.util.NoSuchElementException;
import java.util.Iterator;
import uppgift2.MyStack;

public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {
	ListNode<T> head;
	int size = 0;
	
/*==============================Skapa en tom lista================================*/
	public DoublyLinkedList(){
		head = new ListNode<T>(null,null, null);
	} 
/*============================Lägg t på plats 1 i listan===============================*/		
	void addFirst(T t) {
		ListNode<T> ln = new ListNode<T>(head.next, head, t);
		if (head.next != null) {
			head.next.pre = ln;
		}
		head.next = ln;
		System.out.println(ln);
		
	}
	
/*============================Lägg t på plats i listan===============================*/	
	public void add(T t) {
		ListNode<T> end = get(size()-1);
		ListNode<T> next = new ListNode<T>(null, end, t);
		end.next = next;
		System.out.println(next);
	}
	
	
/*=========================Lägg till t på plats index i listan============================*/
public void add (int index, T t) {
	
if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
		}

		ListNode<T> nodeIns = null;

		if (t != null) {
			ListNode<T> node = head;

			if (node.next != null) {
				for (int i = 0; i < index; i++) {
					node = node.next;
				}
			}
			nodeIns = new ListNode<T>(node.next, node, t);
			
			if (node.next != null) {
				node.next.pre = nodeIns;
			}
			node.next = nodeIns;
		}
		System.out.println(nodeIns);
	}
	
	
/*========================Returnerar värdet på plats index=============================*/
	public ListNode<T> get(int index) {
		
	ListNode<T> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
			
		return  node;
	}
	   
/*=========================Returnerar det första värdet i listan=======================*/
	public ListNode<T> getFirst() {
		if(size()< 0 )
			throw new IndexOutOfBoundsException();
		ListNode<T> node = head.next;
		     // node = node.next;
		   return node; 
	}
	
/*============================Returnerar det sista värdet i listan=======================*/
	public ListNode<T> getLast() {
		int index = size()-1;
		if(size()< 0 )
			throw new IndexOutOfBoundsException();
		ListNode<T> node = get(index) ;
	     // node = node.next;
	   return node; 
	}
	
/*===========================remove(),ta bort t=================================*/

	boolean remove(T t) {
		int index = find(t);
		
		if (index == -1) {
			return false;
			} 
		 else 
			{
			 remove(index);
			}
		return true;
	}
	
	public int find(T item) {
		if (item == null)
			return -1;
		ListNode<T> currentNode = head;
		int i = -1;
		while (currentNode.next != null) {
			++i;
			currentNode = currentNode.next;
			if (item.equals(currentNode.element))
				return i;
		}
		return -1;
	}
/*======================Tar bort värdet på plats index och returnerar detta värde=================*/
	ListNode<T> remove(int index) {
		if (index >= size() || index < 0) {
			throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
		}
		ListNode<T> toBeRemoved = get(index);
		if (toBeRemoved == null)
			return toBeRemoved;
		ListNode<T> previous = toBeRemoved.pre;
		ListNode<T> next = toBeRemoved.next;
        previous.next = next;
		if (next != null) {
			next.pre = toBeRemoved.pre;
		}
		return toBeRemoved ;
	}
	
/*===========================Tar bort och returnerar det sista värdet i listan======================*/
	ListNode<T> removeLast() {
		ListNode<T> temp = get(size() - 1);
		ListNode<T> newLast = get(size() - 2);
		newLast.next = null;
		return temp;
	}
/*============================removeFirst(),Tar bort och returnerar det första värdet i listan===============================*/	
	
	ListNode<T> removeFirst() {
		ListNode<T> temp = get(0);
		if (temp != null && temp.next != null) {
			temp.next.pre = head;
			head.next = temp.next;
		}
		else {
			head.next = null;
		}
		
		return temp;
	}
	
/*============================isEmpty(),Undersöker om listan är tom===============================*/	
	
	boolean isEmpty() {
		boolean empty= true;
		if(size() > 0) {
		 empty= false;
		return empty;
		} 
		return empty;
	}
/*========================= size metod, Returnerar storleken på listan.=========================*/	
	
	 int size() {
	     int count = 0;
		ListNode<T> node = head.next;
		while (node != null) {
			++count;
			node = node.next;
		}
		return count;
	}
/*=========================iterator metod,Retrurnerar en iterator för listan=========================*/	
	
	 public Iterator<T> iterator() {
	// skapa och returnera en anonym klass som implementerar Iterator-interface
 return new Iterator<T>() {
    	// med hänvisning till den första icke noden
      ListNode<T> node = head.next;
 
             @Override
public boolean hasNext() {
 // det finns ett nästa element så länge som noden inte är noll
     return node != null;
             }

             @Override
public T next() {
 // throwing exception om det finns inte next element
      if (!hasNext()) {
          throw new NoSuchElementException();
                     }
       // else lagringselement för nod
       T elem = node.element;
       // framåtgående nod
         node = node.next;
       // returnerar lagrat värde
           return elem;
             }
            
     };
     }
/*=========================Clear metod,Tar bort alla element i listan. Gör den tom.=========================*/
	
	void clear() {
		ListNode<T> node = head.next;
		if(!isEmpty()) {
			head.next= null;
			node = null;
		}
		System.out.println(node);
		
	}
/*=========================toString(),Konverterar listan till en sträng.=========================*/	
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		ListNode<T> next = head.next;
		while (next != null) {
			sb.append(next.element + ", ");
			next = next.next;
		}
		String ret = sb.toString();
		if (ret.length() > 1) {
			ret = ret.substring(0, ret.length() - 2);
		}
		return (ret + "]");
	}
	
/*========================== Reverse metod för uppgift 2========================*/
	public void reverse() {
		
		   MyStack<T> ms = new MyStack<T>();

		// går igenom varje element i den här listan med hjälp av förbättrad för loop (detta kommer
       // använd internt metoden iterator () som vi definierade ovan)
		    
           for (T t : this) {
                   // lägga till varje element för att stack
                   ms.push(t);
           }
           // ta bort alla noder i den här listan
           head.next = null;
        // lägger nu till alla element från stacken tillbaka till listan. sedan Stack-processen
         // element på Last In First Out sätt kommer elementen att läggas till motsatt
         // ordning. (omvänd ordning)
           while (!ms.empty()) {
                   add(ms.pop());
           }

   }
/*==========================addAtFirstSmaller metod för uppgift3-a========================*/			
		
public void addAtFirstSmaller(T t) {
	
	ListNode<T> curr = getLast();
    // loop over the list from end to start until we reach the head node or a node with value < t
    while(curr != head)
    {
    	  // set curr to last node of list
    	
        if(curr.element.compareTo(t) <0)  // curr's element < t, exit the loop
        	  break;
        curr = curr.pre;
      
        
    }

    if (curr == head) // insert t as the first node
    {
        addFirst(t);
    }
    else
    {
        // create a new node with next = curr, pre = node previous to curr and element = t
        ListNode<T> node = new ListNode<T>(curr, curr.pre, t);
       
        // set next of node previous to curr to point to node
        curr.pre.next = node;
        curr.pre= node; // update previous of curr to node
    }  
  }

@SuppressWarnings("unchecked")
public void insertionSort(Comparable[] a) {
	long start = System.currentTimeMillis();
	//Skapa en lista av typen DoublyLinkedList
	DoublyLinkedList<T> lista = new DoublyLinkedList<T>();
	//Iterera över arrayen a.
	      T t;
          int ind =0;
	 //Iterera över arrayen a
	for(int i = 0; i< a.length; i++) {
		 t =(T) a[i]; 
		 //lägg till t i lista 
		
		lista.addAtFirstSmaller(t);
		
		}
	//Iterera över listan
	Iterator<T> ite = lista.iterator();
		while(ite.hasNext()) {
		a[ind] = ite.next();
		 ind++;
		}
		 long finish = System.currentTimeMillis();
		  int computationalTime = (int)(finish - start);
		    System.out.println("Execution time: "+computationalTime);
		}
    }


/*============================*********** End **********===========================*/ 

