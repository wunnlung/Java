import java.util.Scanner;

/**
this is the Capital Gain class which simulates buying and selling
shares. This can even have real-world applications as it shows the
process that an individual would go through
*/
public class CapGain{
	public double totCapGain;
	public Queue sharesHeld;

	public CapGain(){
		totCapGain=0;
		sharesHeld= new Queue();
	}

/**
prints out the main menu
@param  
@return 
*/
	public void mainMenuPrompt(){
		System.out.println("1. Buy");
		System.out.println("2. Sell");
		System.out.println("3. Total Capital Gain So Far");
		System.out.println("4. Quit");

	}

/**
function that lets you buy shares
@param int object, double object
@return
*/
	public void buy(int numShares, double price){
		Stock s = new Stock(numShares, price);
		sharesHeld.enqueue(s);
		//sharesHeld.printString();
		System.out.println("Bought "+ numShares+" share(s) at " + price+" dollar(s).");
	}

/**
function to sell shares
@param int object, double object
@return
*/
	public void sell(int numShares, double price){
		if(sharesHeld.isEmpty()==true){
			System.out.println("No shares to sell.");
			return;
		}
		if(numShares>sharesHeld.totalShares()){
			System.out.println("Not enough shares to sell.");
			return;
		}

		//sNode temp = sharesHeld.head;
		while(true){
			if(numShares>sharesHeld.head.entry.getShares()){
				totCapGain += (sharesHeld.head.entry.getShares() * (price-sharesHeld.head.entry.getPrice()));
				numShares-=sharesHeld.head.entry.getShares();
				//
				sharesHeld.dequeue();
			}else if(numShares==0){
				break;
			}else{
				totCapGain += (numShares * (price-sharesHeld.head.entry.getPrice()));
				sharesHeld.head.entry.shares-=numShares;
				numShares=0;
			}
		}

		System.out.println("Sold "+ numShares+" share(s) at " + price+" dollar(s).");

	}

/**
function that returns the total capital gained so far
@param
@return double object
*/
	public double getTotalCapGain(){
		return totCapGain;
	}

/**
function that prints out all of the users current shares
@param
@return
*/
	public void stockList(){
		sharesHeld.printString();
	}
}

/**
this is the test class for the capital gain
*/
class CapGainTest{
	public static void main(String[] args) {
		CapGain t = new CapGain();
		t.buy(1,100);
		t.buy(2,200);
		t.stockList();
		t.sell(3,300);

	}
}

/**
this is the class that creates the ui for capital gain
*/
class CapGainApp{
	public static void main(String[] args) {
		CapGain cg = new CapGain();
		Scanner scan = new Scanner(System.in);
		int inp = 1;
		do{
			System.out.println("");
			cg.mainMenuPrompt();
			inp = scan.nextInt();
			if(inp==1){
				System.out.println("");
				System.out.println("How many shares?");
				int s = scan.nextInt();
				System.out.println("At what price?");
				double p = scan.nextDouble();
				cg.buy(s,p);
			}else if(inp==2){
				System.out.println("");
				System.out.println("How many shares?");
				int s = scan.nextInt();
				System.out.println("At what price?");
				double p = scan.nextDouble();
				cg.sell(s,p);
			}else if(inp==3){
				System.out.println("");
				System.out.println("Your current total cap gain is "+cg.getTotalCapGain());
			}else if(inp==4){
				System.out.println("Goodbye");
			}

		}while(inp!=4);
	}
}






