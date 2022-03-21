package uppgift2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;


public class TreeSetCounter<T extends Comparable<T>> implements Iterable<T>{
	public Node<T> root; //första element i trädet
	int size;
	int count=0;
	
//Skapa en treeSetCounter.
	public TreeSetCounter() {
		root = null;
		size = 0;
	}
	
/*=============================Add============================================*/	
	
	//lägg till element t
	public void add(T t) {
		 root = isAdded(root, t);
		 size++;
		}
	private Node<T> isAdded(Node<T> current, T value) {
		/* Skapa a ny node */
		Node<T> newNode = new Node<T>(value,count);
	    if (current == null) {
	        return newNode;
	    }
 //om current node är mindre än root node lägg current node i vänster sida annars i höger sida
	    if ((newNode.value).compareTo(current.value) <= 0) {
	        current.left = isAdded(current.left, value);
	    } else if ((newNode.value).compareTo(current.value) >= 0) {
	        current.right = isAdded(current.right, value);
	    } else {
	       // värdet finns redan
	        return current;
	    }

	    return current;
	    }

/*=============================clear()============================================*/	
//Tar bort alla element.
	void clear() {
		root = null;
	}
/*=============================getMaxFrequency()===========================================*/
//Returnerar antalet förekomster (counter-värdet) för det värde som förekommer mest.
	public int getMaxFrequency () {
		//if trädet har inget return 0
	if (root == null)
		return 0;
    //att använda en HashMap är mycket mer adekvat för att hålla reda på räkningarna.
    HashMap<T, Integer> counts = new HashMap<T, Integer>();
        
    int count = counter(root.value);
    counts.put(root.value, count);

    // gå genom trädet och fånga räkningar
    int left = getMaxFrequencyHelper(root.left, counts, count);
    int right = getMaxFrequencyHelper(root.right, counts, count);

    return left > right ? left : right;
}
	
//Denna teknik kallas memoization där de tidigare räkningarna cachas i en HashMap.
private int getMaxFrequencyHelper (Node<T> node, HashMap<T, Integer> counts,int max) {
    if (node == null) 
    	return max;
   if (!counts.containsKey(node.value))
        counts.put(node.value, counter(node.value));
    int maximum = counts.get(node.value) > max ? counts.get(node.value) : max;
//recursive för att undersöka hela trädet
    int left = getMaxFrequencyHelper(node.left, counts, maximum );
    int right = getMaxFrequencyHelper(node.right, counts, maximum );

    return left > right ? left : right;
}
/*=============================contains()============================================*/   
  //Finns t i mängden?
 
 boolean contains(T t) {
	  return isContains(root, t);
	  
 }
  private boolean isContains(Node<T> current, T value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.value) {
	        return true;
	    } 
	    if((value).compareTo(current.value) < 0)
	        return isContains(current.left, value);
		else
			return isContains(current.right, value);
	}
  
/*=============================isEmpty()============================================*/	  
  //Finns det några element?
  boolean isEmpty() {
	  boolean isEmpty = false;
	  if(root == null) {
		  isEmpty = true;
	  }
	  return isEmpty ;
  }
/*=============================size()============================================*/	  
  //Returnerar antalet element.
  public int size() {
		return size;
	}
  
  int size(Node<T> root) {
// If root är null, return 0 eller return size left subtree + size of right subtree + 1 för root
		if (root == null) {
			return 0;
		} else {
			return 1+ (size(root.left)) + (size(root.right));
		}
	}
 
 /*=============================counter()============================================*/	
//Returnerar antalet förekomster av t (counter-värdet).
   public int counter (T t) {
	  if (root == null) return 0;
	  int count = 0;
	  if (root.value.equals(t))
	    count++;
	  
	  count += counterRecursive(root.left, t);
	  count += counterRecursive(root.right, t);

	  return count;
	}

	public int counterRecursive (Node<T> root, T t) {
	   if (root == null)
		   return 0;
	   
	   if (root.value.equals(t))
	    return 1 + counterRecursive(root.left, t) + counterRecursive(root.right, t);
	    else
	    return counterRecursive(root.left, t) + counterRecursive(root.right, t);
	}
	
/*=============================Iterator()============================================*/	
//Returnerar en iterator som itererar i den sorterade ordningen över elementen i mängden.
  
	@Override
	public Iterator<T> iterator() {
		SorteradIterator<T>  iter = new SorteradIterator<T>(root);
		 return iter;
		
		
}}
//==================================End===============================================
	

