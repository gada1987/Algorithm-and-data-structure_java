package uppgift2;



public class Land implements Comparable<Land> {
	public int antal;
	public String namn;
    public String huvudstad;
	public Land(String namn, String huvudstad, int invånare) {
		this.namn = namn;
		this.huvudstad= huvudstad;
		this.antal= invånare;
	}
	
	public final int getInvånare() { return antal;}
    public final String getNamn() {return namn;}
	public final String getHuvudstad() {return huvudstad;}
	public String toString() {
	    return namn+" "+ antal +" "+ huvudstad;
	   }
	   
	   
	   public int compareTo(Land other) {
	       Land n=(Land)other;
	       if(namn.compareTo(n.getNamn())<0)
	           return -1;
	       else if (namn.compareTo(n.getNamn())>0)
	           return 1;
	       else

	           return 0; 
	       }
}


 


