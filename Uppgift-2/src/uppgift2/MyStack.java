package uppgift2;
import java.util.NoSuchElementException;
import java.util.Stack;
import uppgift1.ListNode;

public class MyStack <T extends Comparable<T>>{
	  Stack<T> st;
	  ListNode<T> top;
	
/*============================Skapa en tom stack===========================*/
public MyStack() {
	st = new Stack<T>();
	top = null;
	
	}
/*============================Undersöker om stacken är tom===========================*/

public boolean empty() {
	boolean flag = false;
	if(top == null) {
		flag = true;
	}
	return flag;
}
/*============================Peek metod===========================*/
//Returnerar det översta värdet på stacken.
 T Peek() {
	 if (top == null) {
         throw new NoSuchElementException("The stack is empty.");
     }
     return top.element;
 }
 /*============================Remove t i stacken===========================*/
 //Returnerar det översta värdet på stacken, samt tar bort det från stacken.
 public T pop() {
	 if (top == null) {
         throw new NoSuchElementException("The stack is empty.");
     }

     T output = top.element;
     top = top.next;

     return output;
 }

	
 
 /*============================ Lägger t överst på stacken.===========================*/ 

 public void push(T t) {
 ListNode<T> newelem = new ListNode<T>(t); //skapa ny element 
      if (top == null) { //kika om stack är tom
         top = newelem;  //lägg ny (första element)element 
     } 
      else {
         // skapa ny top
         newelem.next = top;
         top = newelem; //lägg ny element en ny top
     } 
      System.out.println("the new pushed element is:" + top.toString());
 }

}
/*============================*********** End **********===========================*/ 