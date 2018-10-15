package com.trading.watchlist.UserWatchlist.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.trading.watchlist.UserWatchlist.model.UserTicker;

@RestController
public class WatchlistController {
	private static final Logger log = LoggerFactory.getLogger(WatchlistController.class);

	@Autowired
	private KafkaTemplate<String,UserTicker> kafkaTemplate;
	final String TOPIC = "Boot_Sample";

	@GetMapping("/add/{userName}")
	public void addToWatchList(@PathVariable("userName") String userName,
	                           @RequestParam("ticker") String ticker) {
//		String msgPayload = new StringBuilder().append("userName:").append(userName)
//				.append(",").append("ticker:").append(ticker).toString();
		log.info("Ticker to be added for userName: "
				+userName +",ticker: "+ticker);
		kafkaTemplate.send(TOPIC,new UserTicker(userName,ticker));
	}
}
