package com.mta.javacourse.model;

/**
 * Definition of stock portfolio: contains arrays of stocks and it's status. 
 * @author Irena Yakobovich
 * date 1st of December 2014 
 */
public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;
	enum ALGO_RECOMMENDATION{DO_NOTHING, BUY, SELL};
	private StockStatus[] stockStatus;
	private int portfolioSize;
	private String title;
	private float balance;

	/** 
	 * Stock portfolio contains an array of stocks and it's status.
	 */
	public Portfolio() {
		stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
		portfolioSize = 0;
	}

	/** 
	 * Portfolio copy c'tor
	 * @param p
	 */
	public Portfolio(Portfolio p){
		this();

		for(int i = 0; i < portfolioSize; i++){
			stockStatus[i] = new StockStatus(p.stockStatus[i]); 
		}
		setPortfolioSize(p.portfolioSize);
		setTitle(p.title);
	}

	/**
	 * Updates the balance 
	 * @param amount
	 */
	public void updateBalance(float amount) {
		balance += amount;
	}

	/**
	 * addStock receives a stock and adds it to stocks array.
	 * Each stock increases portfolioSize by one, so that the next stock would
	 * be placed in the next location of the stock array. 
	 */
	public void addStock(Stock stock){
		String symbol = stock.getSymbol();

		for (int i = 0; i < portfolioSize; i++) {
			if (stockStatus[i].getSymbol() == symbol) {
				System.out.println("The stock already exists in the portfolio.");
				return;
			}
		}

		if (portfolioSize >= MAX_PORTFOLIO_SIZE) {
			System.out.println("Not enough room in portfolio.");
			return;
		}

		else {
			stockStatus[portfolioSize] = new StockStatus(stock);
			portfolioSize++;
		}
	}

	/**
	 * Searches for the index of the symbol in the stock array
	 * @param symbol
	 * @returns the right index or an error message if symbol was not found. 
	 */
	private int findSymbolIndex (String symbol) {

		if (symbol != null) {
			for (int i = 0; i < portfolioSize; i++) {
				if (stockStatus[i].getSymbol().equals(symbol)) {
					return i;
				}
			}
		}
		System.out.println("Invalid stock symbol");
		return -1;
	}

	/**
	 * Removes the sold stock from the portfolio.
	 * @param success/failure
	 */
	public Boolean removeStock(String symbol) {

		int index = findSymbolIndex(symbol);

		if (index == -1) {
			return false;
		}

		sellStock (symbol, -1);

		if (portfolioSize >= 1) { 
			stockStatus[index] = stockStatus[portfolioSize - 1];
			stockStatus[portfolioSize - 1] = null;
			portfolioSize--;
		}

		else {
			System.out.println("Cannot remove empty portfolio");
			return false;
		}
		return true;
	}

	/**
	 * Sell stocks
	 * @param symbol
	 * @return
	 */

	public boolean sellStock (String symbol, int quantity) {

		int index = findSymbolIndex(symbol);

		if (index == -1 || quantity < -1 || quantity == 0) {
			System.out.println("Invalid quantity");
			return false;
		}

		if (quantity > stockStatus[index].getStockQuantity()) {
			System.out.println("Invalid quantity entered. your stock quantity is " + stockStatus[index].getStockQuantity());
			return false;
		}

		if (quantity == -1) {
			quantity = stockStatus[index].getStockQuantity();
		}

		updateBalance(quantity * stockStatus[index].getBid());
		stockStatus[index].setStockQuantity(stockStatus[index].getStockQuantity() - quantity);

		return true;
	}

	/**
	 * Buy Stocks
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public boolean buyStock (String symbol, int quantity) {

		int index = findSymbolIndex(symbol);

		if (index < 0) {
			System.out.println("The stock " + symbol + " was not found.");
			return false;
		}
		else if (quantity < -1 || stockStatus[index].getAsk() * quantity > balance) {
			System.out.println("Not enough balance. Your balance is " + balance + 
					", whereas the amount is " + stockStatus[index].getAsk() * quantity);
			return false;
		}

		if (quantity == -1) {
			quantity = (int)(balance / stockStatus[index].getAsk());
		}

		stockStatus[index].setStockQuantity(stockStatus[index].getStockQuantity() + quantity);
		balance -= stockStatus[index].getAsk() * quantity;

		return true;	}

	/**
	 * Calculates portfolio value.
	 * @returns total value
	 */

	public float getStocksValue() {
		float totalStocksValue = 0;

		for (int i = 0; i < portfolioSize; i++) {
			totalStocksValue += stockStatus[i].getStockQuantity() * stockStatus[i].getBid();
		}
		return totalStocksValue;
	}

	/**
	 * Calculates portfolio balance.
	 * @returns balance
	 */
	public float FinalBalance() {
		return balance;
	}

	/**
	 * Calculates portfolio total value.
	 * @returns Total value
	 */
	public float getTotalValue() {
		return FinalBalance() + getStocksValue();
	}

	public StockStatus[] getstockStatus() {
		return stockStatus;
	}

	public void setstockStatus(StockStatus[] stockStatus) {
		this.stockStatus = stockStatus;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}		

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setTitle(String title) {
		this.title = title;
	}	

	public String getTitle() {
		return title;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}

	/**
	 * Gathers the Stocks information into one string parameter res via loop.
	 * The loop goes on until it reaches the portfolioSize, which was defined by
	 * the number of stocks.
	 * 
	 * @param res contains a string of the title and the stocks array details.
	 * @return the title and the stock array details.  
	 */
	public String getHtmlString() {
		String res = "<h1>" + title + "</h1>" + "<br>";

		for(int i = 0; i < getPortfolioSize() ; i++) {
			res += stockStatus[i].getHtmlDescription() + "<br>" ;
		}
		res += "<br>" +"<b>" + "Total Portfolio Value: " + "</b>" + getTotalValue() + "$" + "<br>" +
				"<b>" + "Total Stocks value: " + "</b>" + getStocksValue() + "$" + "<br>" +
				"<b>" + "Balance: " + "</b>" + FinalBalance() + "$"; 

		return res;
	}
}