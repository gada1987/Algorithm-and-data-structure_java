package uppgift1;

public class MaxPQTest {

	public static void main(String[] args) {
		/*System.out.println("======================***Test Uppgift1,b****================");
		Comparable[] a = {"O", "G", "F", "E", "G", "A", "M", "P", "L", "R"};
        MaxPQ<String> test = new MaxPQ(a); 
        System.out.println(test.toString());
        System.out.println("======================***stårlek****================");
        System.out.println("Size: " + test.size());
        System.out.println("======================***Adding en nyckle****================");
        System.out.println("Inserting H");
        test.insert("H");
        System.out.println(test.toString());
        System.out.println("======================***Adding en nyckle****================");
        System.out.println("Inserting D");
        test.insert("D");
        System.out.println(test.toString());
        System.out.println("======================***Removing en nyckle****================");
        System.out.println("Deleting: " + test.delMax());
        System.out.println(test.toString());
        System.out.println("======================***Removing en nyckle****================");
        System.out.println("Deleting: " + test.delMax());
        System.out.println(test.toString());
        System.out.println("======================***Adding en nyckle****================");
        System.out.println("Inserting S");
        test.insert("S");
        System.out.println(test.toString());*/
		Comparable[] a = {9,6,5,1,3};
        MaxPQ<Integer> test = new MaxPQ(a);
        System.out.println(test.toString());
        test.insert(6);
        System.out.println(test.toString());
        test.delMax();
        System.out.println(test.toString());
        test.insert(11);
        System.out.println(test.toString());
        test.insert(12);
        System.out.println(test.toString());
    }

}
