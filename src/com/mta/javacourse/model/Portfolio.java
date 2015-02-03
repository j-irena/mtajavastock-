package com.mta.javacourse.model;

import java.util.ArrayList;
import java.util.List;

import com.mta.javacourse.exception.BalanceException;
import com.mta.javacourse.exception.IllegalQuantityException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistsException;
import com.mta.javacourse.exception.StockNotExistsException;

/**
 * Definition of stock portfolio: contains arrays of stocks and it's status. 
 * @author Irena Yakobovich
 * @date 1st of December 2014 
 */
public class Portfolio {
	public final static int SIZE = 5;
	public enum ALGO_RECOMMENDATION{DO_NOTHING, BUY, SELL};
	private ArrayList<StockStatus> stockStatus;
	private String title;
	private float balance;
	private int portfolioSize;

	/** 
	 * Stock portfolio contains an array of stocks and it's status.
	 */
	public Portfolio() {
		stockStatus = new ArrayList<StockStatus>(SIZE);
	}

	/** 
	 * Portfolio copy c'tor
	 * @param stockStatuses
	 */
	public Portfolio(List<StockStatus> stockStatus){
		this();
		
		for(int i = 0; i < stockStatus.size(); i++) {
			stockStatus.add(stockStatus.get(i));
		}
	}

	public Portfolio(Portfolio p) {
		this();

		title = p.title;
		balance = p.balance;
		stockStatus.addAll(p.stockStatus);
	}
	
	public StockStatus[] getStocks() {
		StockStatus[] ret = new StockStatus[stockStatus.size()];
		ret =  stockStatus.toArray(ret);
		return ret;
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
	 * @param stock
	 * @throws StockAlreadyExistsException
	 * @throws PortfolioFullException
	 */
	public void addStock(Stock stock) throws StockAlreadyExistsException, PortfolioFullException {
		
		if(stockStatus.size() == SIZE) {
		
			System.out.println("Can’t add new stock, portfolio can have only "+ SIZE +" stocks");
			throw new PortfolioFullException();
		}
		
		for (int i = 0; i < stockStatus.size(); i++) {
			
			if (stockStatus.get(i).getSymbol().equals(stock.getSymbol())) {
				System.out.println(stockStatus.get(i).getSymbol() + " Already exists in the portfolio");
				
				throw new StockAlreadyExistsException(stock.getSymbol());
			}
		}
		
		stockStatus.add(new StockStatus(stock));	
	}

	/**
	 * Searches for the index of the symbol in the stock array
	 * @param symbol
	 * @returns the right index or an error message if symbol was not found. 
	 */
	private int findSymbolIndex(String symbol) {

		if (symbol != null) {
			for (int i = 0; i < stockStatus.size(); i++) {
				if(stockStatus.get(i).getSymbol().toLowerCase().equals(symbol.toLowerCase())) {
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
	 * @throws StockNotExistException 
	 * @throws IllegalQuantityException 
	 */
	public void removeStock(String symbol) throws StockNotExistsException, IllegalQuantityException {

		int index = findSymbolIndex(symbol);

		if (index == -1) {
			throw new StockNotExistsException(symbol);
		}

		sellStock (symbol, -1);

		while (index < stockStatus.size()) {
			stockStatus.remove(index);
			index++;
		}
	}

	/**
	 * Sell stocks
	 * @param symbol
	 * @param quantity
	 * @throws StockNotExistException
	 * @throws IllegalQuantityException
	 */
	public void sellStock (String symbol, int quantity) throws StockNotExistsException, IllegalQuantityException {

		int index = findSymbolIndex(symbol);
		
		if (index == -1)
		{
			throw new StockNotExistsException(symbol);
		}
		if(quantity < -1)
		{
			System.out.println("Can't sell negative stocks");
			throw new IllegalQuantityException("Can't sell negative stocks");
		}
		
		if(quantity > stockStatus.get(index).getStockQuantity())
		{
			System.out.println("Not enough stocks to sell");
			throw new IllegalQuantityException("Not enough stocks to sell");
		}
		
		if(quantity == -1)
		{	
			quantity = stockStatus.get(index).getStockQuantity();
		}

		updateBalance(quantity * stockStatus.get(index).getBid());
		stockStatus.get(index).setStockQuantity(stockStatus.get(index).getStockQuantity() - quantity);
	}
	/**
	 * Buy Stocks
	 * @param symbol
	 * @param quantity
	 * @throws StockNotExistException
	 * @throws IllegalQuantityException
	 * @throws BalanceException
	 */
	public void buyStock (String symbol, int quantity) throws StockNotExistsException, IllegalQuantityException, BalanceException {

		int index = findSymbolIndex(symbol);
		
		if (index == -1)
		{
			throw new StockNotExistsException(symbol);
		}
		if(quantity < -1)
		{
			System.out.println("Can't buy nagative stocks");
			throw new IllegalQuantityException("Can't buy nagative stocks");
		}
		if(getBalance() < 0)
		{
			throw new BalanceException(symbol);
		}
		
		if(quantity == -1){
			quantity = (int) (balance / stockStatus.get(index).getAsk());
		}
					
		float price = quantity * (stockStatus.get(index).getAsk()); 					
		if (price > balance)
		{
			System.out.println("Not enough balance to complete purchase");
			throw new BalanceException(symbol);
		}
					
		updateBalance(-price);
		stockStatus.get(index).setStockQuantity(stockStatus.get(index).getStockQuantity() + quantity);
	}
	
	/**
	 * Checks if the symbol exists 
	 * @param symbol
	 * @return
	 * @throws StockNotExistsException
	 */
	public StockStatus findBySymbol(String symbol) throws StockNotExistsException {
		
		for (int i = 0; i < SIZE ; i++) {
			if(this.stockStatus.get(i) != null && symbol.equals(stockStatus.get(i).getSymbol())) {
				return stockStatus.get(i);
			}
		}
		
		throw new StockNotExistsException(symbol);
	}
	
	/**
	 * Calculates portfolio value.
	 * @returns total value
	 */
	public float getStocksValue() {
		
		float totalStocksValue = 0;

		for (int i = 0; i < portfolioSize; i++) {
			totalStocksValue += stockStatus.get(i).getStockQuantity() * stockStatus.get(i).getBid();
		}
		
		return totalStocksValue;
	}

	/**
	 * Calculates portfolio balance.
	 * @returns balance
	 */
	public float finalBalance() {
		return balance;
	}

	/**
	 * Calculates portfolio total value.
	 * @returns Total value
	 */
	public float getTotalValue() {
		return finalBalance() + getStocksValue();
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
			res += stockStatus.get(i).getHtmlDescription() + "<br>" ;
		}
		res += "<br>" +"<b>" + "Total Portfolio Value: " + "</b>" + getTotalValue() + "$" + "<br>" +
				"<b>" + "Total Stocks value: " + "</b>" + getStocksValue() + "$" + "<br>" +
				"<b>" + "Balance: " + "</b>" + finalBalance() + "$"; 

		return res;
	}
	
	public  ArrayList<StockStatus> getstockStatus() {
		return stockStatus;
	}

	public void setstockStatus(ArrayList<StockStatus> stockStatus) {
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

	public static int getSize() {
		return SIZE;
	}

	public List<StockStatus> getStocksStatus() {
		return this.stockStatus;
	}
}