/**
the stock class has two properties, shares and price
it is used as a replacement for a single integer in the node, as it is able to store
two variables in one
*/
public class Stock{
	public int shares;
	public double price;

	//constructor
	public Stock(int s, double p){
		shares = s;
		price = p;
	}

/**
returns the number of shares
@param
@return int object
*/
	public int getShares(){
		return shares;
	}

/**
returns the price
@param
@return double object
*/
	public double getPrice(){
		return price;
	}

/**
returns the shares and price as a string
@param
@return String object
*/
	public String toString() { 
		return "(" + shares + ", " + price + ")"; 
	}


}