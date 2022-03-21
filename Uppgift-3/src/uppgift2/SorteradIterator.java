package uppgift2;

import java.util.Iterator;
import java.util.Stack;

public class SorteradIterator <T>implements Iterator<T> {
     Stack<StackElement<T>> iteratorStack;
	    
public SorteradIterator(Node<T> root){
	   iteratorStack = new Stack<StackElement<T>>();
	   iteratorStack.push(new StackElement<T>(root, false));
	    }
	    public boolean hasNext() {        
	        return !iteratorStack.isEmpty();
	    }
	    public T next() {
	    // Repeat until we have a visited node on top of the stack.
	        while( !iteratorStack.peek().isVisited() ){
	      // Get current node from top of the stack.
	        Node<T> curNode = iteratorStack.pop().getNode(); 
	       // If right child is present, push it on the stack as not-visited.
	        	if( curNode.getRight() != null )
	        		iteratorStack.push( new StackElement<T>(curNode.getRight(), false) );
	            
	            // Push current node on the stack as visited.
	        	iteratorStack.push(new StackElement<T>(curNode, true));
	            
	            // If left child is present, push it on the stack as not-visited.
	        	if( curNode.getLeft() != null )
	        		iteratorStack.push(new StackElement<T>(curNode.getLeft(), false));
	        }
	        
	        // Pop the node on top of the stack (this node is a visited node) 
	        // and return its data.
	        return iteratorStack.pop().getNode().getValue();
	    }
	    public void remove() {}
	}
	
	class StackElement<T> {
	    Node<T> btreeNode;
	    boolean visited;
	    StackElement( Node<T> btreeNode, boolean visited ){
	        this.btreeNode = btreeNode;
	        this.visited = visited;
	    }
	    Node<T> getNode(){ return btreeNode; }
	    boolean isVisited(){ return visited; }
	}
	 


	


