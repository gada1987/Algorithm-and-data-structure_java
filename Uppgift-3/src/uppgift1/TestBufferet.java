package uppgift1;

public class TestBufferet {
	public static void main(String[]args) throws Exception {
		System.out.println("**************************Test for uppgift1-a*****************************");
		System.out.print("\n");
		DataBuffer <Integer> db = new DataBuffer<Integer>(10);
		System.out.println("========================DataBuffer i början==============================");
		System.out.print("\n");
		System.out.println(db.toString());
		db.enqueue(4);
		db.enqueue(7);
		db.enqueue(2);
		db.enqueue(9);
		System.out.print("\n");
		System.out.println("======================== DataBuffer efter adding ========================");
		System.out.print("\n");
		System.out.println(db.toString());
		System.out.print("\n");
		System.out.println("==========================Removed element=================================");
		System.out.print("\n");
		//System.out.println("Ta bort första element i bufferet: " + db.dequeue().toString());
		System.out.println("Ta bort första element i bufferet: " + db.dequeue().toString());
		System.out.print("\n");
		System.out.println("======================== DataBuffer efter removing =======================");
		System.out.print("\n");
		System.out.print("Databuffer efter removing är: ");
		System.out.println(db.toString());
		System.out.print("\n");
		db.enqueue(1);
		db.enqueue(1);
		db.enqueue(1);
		db.enqueue(1);
		db.enqueue(1);
		db.enqueue(1);
		//db.enqueue(1);
		//db.enqueue(1);
		System.out.println("======================== cirkular DataBuffer ===========================");
		System.out.print("\n");
		System.out.println(db.toString());
        System.out.println("======================== undersök om dp är full ===========================");
        System.out.println(db.isFull());
        System.out.println("======================== undersök om dp är tum ===========================");
        System.out.println(db.isEmpty());
        System.out.println("======================== Vad är DataBuffer stårlek innan ändring ===========================");
        //System.out.println(db.size());
        System.out.println(db.capacity());
        System.out.println("======================== Vad är DataBuffer storlek efter ändring ===========================");
        DataBuffer <Integer> db2 = new DataBuffer<Integer>(11);
        db2.enqueue(0);
        db2.enqueue(1);
        db2.enqueue(2);
        db2.enqueue(3);
        db2.enqueue(4);
        db2.enqueue(5);
        db2.enqueue(6);
        System.out.println(db2.toString());
        db2.dequeue();
        db2.dequeue();
        System.out.println(db2.toString());
    	db2.changeBufferSize(5);
    	System.out.println(db2.toString());
        System.out.println(db2.capacity());
        System.out.println(db2.emptyDataBuffer());
        System.out.println("======================== Test if we have empty databuffer ======================");
        DataBuffer <Integer> db3 = new DataBuffer<Integer>(0);
        db3.emptyDataBuffer();
       
       /* Iterator<Integer> iterator = db.iterator();
        while(iterator.hasNext()){
			int elem = iterator.next();
			System.out.println(elem );
		System.out.println(db.Iterator().toString());
		
	    }*/


	}
	    }


