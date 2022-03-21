package uppgift1;

public class HashTest {
	
	 public static void main(String[] args){ 
		 HashElement<Character> he= new HashElement<Character>('p',2);
		 HashElement<Character> he1= new HashElement<Character>('a',2);
		 HashElement<Character> he2= new HashElement<Character>('c',1);
		 HashElement<Character> he3= new HashElement<Character>('z',1);
		 HashElement<Character> he4= new HashElement<Character>('d',1);
		 System.out.println("========================Test för HashElement Class=========================");
		 System.out.println("=========================Compare Class=================================");
		 System.out.println(he.compareTo(he4));
		 System.out.println("========================Antal förkomst=================================");
		 System.out.println(he1.getKey()+ " = "+ he1.förekomst);
		 System.out.println(he3.getKey()+ " = "+ he3.förekomst);
		 System.out.println("=========================test equals metod=============================");
		 System.out.println("Är he lika med he2 ?");
		 System.out.println(he.equals(he2));
		 System.out.println("======================Test för getFrequencey metod=====================");
		 System.out.println("Hur många gånger kommer p och d");
		 System.out.println(he.getKey()+ " = "+  he.getFrequencey());
		 System.out.println(he4.getKey()+ " = "+ he4.getFrequencey());
		 System.out.println("=======================Test för getKey metod===========================");
		 System.out.println("Vilken nyckel har he2 ?");
		 System.out.println(he2.getKey());
		 System.out.println("======================Test increment& Decrement metoder=================");
		 System.out.println("Antal p innan increment ");
		 System.out.println(he.getFrequencey());
		 he.increment();
		 System.out.println("Antal p Efter increment ");
		 System.out.println(he.getFrequencey());
		 he.decrement();
		 System.out.println("Antal p Efeter decrement ");
		 System.out.println(he.getFrequencey());
		 System.out.println("=======================Test setKey() metod=============================");
		 System.out.println("nyckel innan ändring är: ");
		 System.out.println(he.getKey());
		 he.setKey('s');
		 System.out.println("nyckel efter ändring blir: ");
		 System.out.println(he.getKey());
		 System.out.println("========================================================================");
         System.out.println("==================Test för LinearProbingHashSet.Java====================");
		 LinearProbingHashSet<HashElement> lphs = new LinearProbingHashSet<HashElement>(10);
			 lphs.insert(he);
			 lphs.insert(he1);
			 lphs.insert(he2);
			 lphs.insert(he3);
			 lphs.insert(he4);
			 System.out.println(lphs.contains(he1));
			// System.out.println(lphs.contains(null));
			 System.out.println(lphs.getCapacity());
			 System.out.println(lphs.size());
			 System.out.println(lphs.isEmpty());
			   lphs.decrease(he4);
			   System.out.println(lphs.size());
			   lphs.delete(he3);
			   System.out.println(lphs.size());
			   lphs.insert(he4);
			   System.out.println(lphs.size());
			   //test om vi vill addera samma element
			  // lphs.insert(he4);
			 //System.out.println(lphs.size());
			// lphs.insert(he4);
		   // System.out.println(lphs.size());
		}
}


