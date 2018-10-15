package com.trading.watchlist.UserWatchlist.model;


public class UserTicker {
	private String userName;
	private String ticker;

	public UserTicker(String userName, String ticker) {
		this.userName = userName;
		this.ticker = ticker;
	}

	public String getUserName() {
		return userName;
	}

	public String getTicker() {
		return ticker;
	}
}
