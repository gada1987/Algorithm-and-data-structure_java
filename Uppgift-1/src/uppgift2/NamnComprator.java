package uppgift2;
import java.util.Comparator;
public class NamnComprator implements Comparator<Land>{

	   @Override
	   public int compare(Land arg0, Land arg1) {
	       String aName = arg0.getNamn();
	String bName = arg1.getNamn();
	  
	   return aName.compareTo(bName);
	   }
	   
	 }


