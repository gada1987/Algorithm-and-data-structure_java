package uppgift1;
import java.io.*;
public class Trader extends Thread
{
    DataBuffer<StockPick> stockPicks;
    // Fler intstansvariabler?
   
    //MaxPQ<StockPick> mpq;
    
    OutputStreamWriter dataOut ;
    int nrPicks; // nr of stock picks for printing to log-file each second
    int endTime; // time to run in seconds
    StockPick sp;
   // MaxPQ<StockPick> mpq;
   MaxPQ<StockPick> mpq = new MaxPQ<StockPick>(nrPicks); 
    public Trader(DataBuffer<StockPick> stockPicks,
    		int bufferSize, int nrPicks, int endTime)
    {
    	
        this.stockPicks = stockPicks;
        this.nrPicks = nrPicks;
        this.endTime = endTime;
        this.mpq = mpq;
        
    }
    
    public void run() 
    {
    	
         try
         {
             OutputStreamWriter writer = 
             new OutputStreamWriter(new 
             FileOutputStream("log.txt"));
             writer.write("Start\n");
             writer.close();
            
         }
         catch(IOException e){}
         
         
         int time = 0;
         while (time < endTime)
         {
        	
             try
             {
                 sleep(1000);
                 
             }
            
             catch( InterruptedException e){}
  
             try {
            	 /*
                  * Lägg till kod här.
                  * 
                  * 1: Töm stockPicks och lägg elementen i en tom priortietskö. 
                  * Denna prioritetskö kan t.ex. vara en instansvariabel och initieras i 
                  * konstruktorn.
                  * 
                  * 2: Ta de nrPicks största elementen från prioritetskön och skriv 
                  * ut dessa i prioritetsordning sist i log.txt. Ni ska inte skriva 
                  * över det som finns i filen utan lägga till på slutet.
                  */
            	 

            	 if(!(stockPicks.isEmpty())) 
            		//Töm stockPicks
                     sp = stockPicks.dequeue();
                    //lägg elementen i en tom priortietskö.
                      mpq.insert(sp);
            	//Ta de nrPicks största elementen från prioritetskön
                     StockPick num = mpq.max();
  					System.out.println(num);
				for (int i = 0; i <nrPicks; i++){	
					
	          //skriv ut dessa i prioritetsordning sist i log.txt
	         dataOut = new OutputStreamWriter(new FileOutputStream("log.txt", true));
	         dataOut.write("\n");
			
	        }
				//lägga till på slutet
				 dataOut.append(mpq.delMax().toString() + "\n");
				 dataOut.close();
				}
            	 
                 
            	 
         
           //String path = "/Users/ghadaalsayed/Desktop/log.txt";
             //File file = new File(path); 
           /* if(!stockPicks.isEmpty()) {
            	 
                	 //Töm stockPicks
                     sp = stockPicks.dequeue();
                    //lägg elementen i en tom priortietskö.
                      mpq.insert(sp);
            	//Ta de nrPicks största elementen från prioritetskön
				StockPick num = mpq.max();
				System.out.println(num);
				for (int i = 0; i < stockPicks.capacity(); i++){	
	          //skriv ut dessa i prioritetsordning sist i log.txt
	         dataOut = new OutputStreamWriter(new FileOutputStream(file, true));
			//lägga till på slutet
	         dataOut.append(num.toString());
	         dataOut.close();
			
			}}
				
             } */
             
			catch (Exception e) {
			
				e.printStackTrace();
			}
             
             time++;
            
             System.out.println("Time elapsed: " + time 
             + " seconds.");
         }
    }
    
    
    public static void main(String[] cmdLn)
    {
        int bufferSize = 50;
       
        DataBuffer<StockPick> stockPicks = 
        new DataBuffer<StockPick>(bufferSize);
        
        // StockPicker 1
        String[] stocks1 = new String[]{
            "TSLA", "CCJ", "GME", "UUUU", 
            "MFST", "GOOGL", "AAPL",
            "AMZN"};
            
        StockPicker Stockpicker1 = 
        new StockPicker("North America analyzer", 
        stockPicks, stocks1, 10);
        
        
        // StockPicker 2
        String[] stocks2 = new String[]{
            "ETH", "BTC"};
        
        StockPicker Stockpicker2 = 
        new StockPicker("Cryptocurrencices analyzer", 
        stockPicks, stocks2, 10);
        
        // trader
        Trader trader = new Trader(stockPicks, bufferSize, 3, 10);
        
        // run simulation
        Stockpicker1.start();
        Stockpicker2.start();
        trader.start();
    }
    
    
    
    
}
 


