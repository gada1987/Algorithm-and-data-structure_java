package uppgift1;


public class ListNode <T> {
	public T element; // värdet
	public ListNode <T> pre; // förra referens
	public ListNode <T> next; //nästa referens
	
/*===============Constructor 1 som innehåller bara ett värde av type T=================*/
	public ListNode(T elem) {
		  element = elem;
		}
/*===============Constructor 2 som innehåller refernses och värde=========================*/
	public ListNode(ListNode<T> efter, ListNode<T> before, T item) {
		next = efter;
		pre  = before;
		element = item;
	}
public ListNode(T t, ListNode<T> head) {
		// TODO Auto-generated constructor stub
	}
	/*===========================to String metod för att skriva ut på ett bra sätt==============*/	
	public String toString() {
		return element + "";
	}
	

}
/*============================*********** End **********===========================*/ 