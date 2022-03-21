package uppgift2;

import java.util.Iterator;

public class Treetest {

	public static void main(String[] args) {
		TreeSetCounter <String> tsc= new TreeSetCounter<String>();
		tsc.add("hej");
		tsc.add("hej");
		tsc.add("på");
		tsc.add("dig");
		tsc.add("hej");
		tsc.add("hej");
		tsc.add("igen");
		tsc.add("hej");
		tsc.add("igen");
		tsc.add("igen");
		tsc.add("igen");
		
	    System.out.println("==============*********Är trädet töm?***********=========================");	
		System.out.println(tsc.isEmpty());
		System.out.println("\n");
		System.out.println("==============*********hur mycket noder har trädet?************===========");	
		System.out.println(tsc.size());
		System.out.println("\n");
		System.out.println("===============*********Finns ordet igen i trädet?*********===============");	
		System.out.println(tsc.contains("igen"));
		System.out.println("\n");
		System.out.println("=============*********hur mycket ordet hej finns i trädet?*********=======");	
		System.out.println(tsc.counter("hej"));
		System.out.print("\n");	
		System.out.println("================*********hur mycket ordet på finns i trädet?*********======");	
		System.out.println(tsc.counter("på"));
		System.out.print("\n");	
		System.out.println("=================********Antal max frekvens är ***********===================");	
		System.out.println(tsc.getMaxFrequency());
		System.out.println("=================********Skriv ut tree in order ***********===================");
	      Iterator<String> itr = tsc.iterator();
	       while(itr.hasNext()) {
	        System.out.print(itr.next()+" ");
	        System.out.println("\n");
	        }

		
		
	}
	
}
