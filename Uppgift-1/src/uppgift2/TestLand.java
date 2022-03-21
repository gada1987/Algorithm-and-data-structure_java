package uppgift2;

import java.util.ArrayList;
import java.util.Collections;

public class TestLand {
	
	    public static void Printout(String title ,ArrayList<Land> Cs) {
	        System.out.println(title);
	        System.out.println();
	        for ( Land S: Cs)
	            System.out.println(S.toString());
	        System.out.println("=====================================================");
	  
	    }
	    
	    public static void main(String[] args) {
	        ArrayList<Land> lista = new ArrayList<>();
	        lista.add(new Land("Swiden","Stockholm",10230000));
	        lista.add(new Land("Germany","Berline",83000000));
	        lista.add(new Land("France","Paris",67060000));
	        lista.add(new Land("United kingdum","London",66650000));
	        lista.add(new Land("Belgium","Broksill",11376070));
	        Printout ("*  Skriv ut listan utan sortering  *",lista);
	        Collections.sort(lista);
	     
	        Printout ("   **Sortering via namn**   ",lista);
	        
	        Collections.sort(lista, (i,j)-> i.huvudstad.compareTo(j.huvudstad));
	        
	        Printout ("   **Sortering via huvudstad**  ",lista);
	       
	        Collections.sort(lista, (i,j)->  (i.antal > j.antal)?1:-1);
	        Printout ("   **Sortering via antal invånare**   ",lista);
       }
}


