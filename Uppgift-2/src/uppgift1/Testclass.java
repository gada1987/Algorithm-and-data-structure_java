package uppgift1;

import java.util.Arrays;

public class Testclass {
	public static void main(String[]args) {
		
DoublyLinkedList<Integer> dllist = new DoublyLinkedList<>();
        dllist.add(7);
        dllist.add(91);
        dllist.add(3);
        System.out.println(dllist);
        System.out.println("----------------------------------------------------------------");
        System.out.println("The list efter adding a new item at position 2");
        dllist.add(2,12);
        System.out.println(dllist);
       
        System.out.println("----------------------------------------------------------------");
        System.out.println("=====================Test för uppgift 2=========================");
        System.out.println("The reverse lista is:");
        dllist.reverse();
        System.out.println(dllist);
        System.out.println("----------------------------------------------------------------");
        System.out.println("=====================Test för uppgift 3-a=========================");
        System.out.println("Add first smaller");
         dllist.addAtFirstSmaller(2);
        System.out.println(dllist);
        System.out.println("----------------------------------------------------------------");
        System.out.println("=====================Test för uppgift 3-b=========================");
        Comparable[] a = new Comparable[8];
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<Integer>();
        a[0] = Integer.valueOf(13);
        a[1] = Integer.valueOf(8);
        a[2] = Integer.valueOf(7);
        a[3] = Integer.valueOf(9);
        a[4] = Integer.valueOf(4);
        a[5] = Integer.valueOf(3);
        a[6] = Integer.valueOf(2);
        a[7] = Integer.valueOf(1);
        System.out.println("The insertion sort för comprable a array is:");
        lista.insertionSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The item att index 4 is:");
        System.out.println(dllist.get(4));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The first item in the list is:");
        System.out.println(dllist.getFirst());
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The Last item in the list is:");
        System.out.println(dllist.getLast());
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The list before removing is:");
        System.out.println(dllist);
        System.out.println("The list after removing is:");
        System.out.println(dllist.remove(1));
        System.out.println(dllist);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The list before removing is:");
        System.out.println(dllist);
        System.out.print("The removed element is:");
        System.out.println(dllist.remove(1));
        System.out.println("The list after removing is:");
        System.out.println(dllist);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The list before removing is:");
        System.out.println(dllist);
        System.out.print("The last removed element is:");
        System.out.println(dllist.removeLast());
        System.out.println("The list after removing is:");
        System.out.println(dllist);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("The list before removing is:");
        System.out.println(dllist);
        System.out.print("The first removed element is:");
        System.out.println(dllist.removeFirst());
        System.out.println("The list after removing is:");
        System.out.println(dllist);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Is the list empty?");
        System.out.println(dllist.isEmpty());
        System.out.print("The size is: ");
        System.out.println(dllist.size());
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Clear all element in the list! ");
        dllist.clear();
        System.out.println("The list after clearing is:");
        System.out.println(dllist);
        System.out.println("-----------------------------------------------------------------");
     DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
           for(int i = 0; i<3;i++) 
    	 list.add(i);
    	System.out.println(list);
    	
        System.out.println("-----------------------------------");
     System.out.println(list.get(1));
     System.out.println(list.get(0));
     System.out.println(list.get(2));
 
     
    
}
}
/*============================*********** End **********===========================*/ 