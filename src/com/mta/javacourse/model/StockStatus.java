package com.mta.javacourse.model;

import com.mta.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * It would determine whether to buy, sell or do nothing with the stock, as it
 * takes into account the stock parameters: symbol, bid, ask, recommendation, quantity and its date.
 * @author Irena Yakobovich
 * @since 27th of December 2014 
 */
public class StockStatus extends Stock {

	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

	/**
	 * StockStatus c'tor, receives stock's details and updates the stock Status array.
	 * @param stock
	 */

	public StockStatus() {
		super();
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}

	public StockStatus(Stock stock) {
		super(stock);
		recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		stockQuantity = 0;
	}
	
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
