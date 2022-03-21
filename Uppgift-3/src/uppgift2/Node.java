package uppgift2;

public class Node <T>{
	T value;
	int counter;
    Node<T> left;
    Node<T> right;
    
    Node(T value, int count) {
        this.value = value;
        right = null;
        left = null;
        this.counter= count;
    }
    T getValue(){ return value; }
    Node<T> getLeft(){ return left; }
    Node<T> getRight(){ return right; }

  public String toString() {
		StringBuilder s = new StringBuilder();

		// recursively construct a string for the left sub-tree:
		if ( left != null )
			s.append("L:[").append(left.toString()).append("] ");

		// include the value at this node:
		s.append(value.toString());

		// recursively construct a string for the right sub-tree:
		if ( right != null )
			s.append(" R:[").append(right.toString()).append(']');

		return s.toString();
	}
   
}
