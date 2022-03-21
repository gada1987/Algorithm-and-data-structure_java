package uppgift2;
import java.util.Comparator;
public class AntalInvånare implements Comparator<Land> {

	   @Override
	   public int compare(Land o1, Land o2) {
	       int c1Pop=o1.getInvånare();
	       int c2Pop=o2.getInvånare();
	       if(c1Pop>c2Pop)
	           return 1;
	       else if (c1Pop<c2Pop)
	           return -1;
	       else
	           return 0;
	       }
	   }


