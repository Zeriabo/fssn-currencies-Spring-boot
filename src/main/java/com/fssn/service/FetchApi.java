package com.fssn.service;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fssn.payload.ExchangeRateResponse;
import com.fssn.models.ExchangeRate;
import com.fssn.models.ExchangeRateStorage;

public class FetchApi {

	private static final Logger logger = LoggerFactory.getLogger(FetchApi.class);

	/*
	 * you need 3 data structures to store different rates EUR SEK USD 2 to power 3
	 * = 6 api's 6 rates 3 api's to fetch store in datastructure maybe an ArrayList
	 * one api to fetch the exchange rate that is stored
	 * 
	 */
	public static ExchangeRateResponse getRate(String amount, String from, String to) {

		String apiKey = "0OJGjEjhnnFOVLgDsiMoZWrupTnR4kMb";
		System.out.print(apiKey);
		String uri = "https://api.apilayer.com/currency_data/convert?to=" + to + "&from=" + from + "&amount=" + amount
				+ "&apikey=" + apiKey;
		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		HttpEntity<ExchangeRate> requestEntity = new HttpEntity<>(headers);

		ExchangeRateStorage exchangeRateStorage = new ExchangeRateStorage();

		headers.add("User-Agent", "Mozilla/5.0");

		ResponseEntity<ExchangeRate> uriResponse = template.exchange(uri, HttpMethod.GET, requestEntity,
				ExchangeRate.class);

		logger.info("Exchange rates fetched");

		exchangeRateStorage.setCurrency(from + "-" + to);
		exchangeRateStorage.setExchangeRate(uriResponse.getBody().getResult());
		exchangeRateStorage.setUsed(false);

		ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();

		exchangeRateResponse.setTo_amount(uriResponse.getBody().getResult());
		exchangeRateResponse.setFrom(from);
		exchangeRateResponse.setTo(to);
		exchangeRateResponse.setExchange_rate(uriResponse.getBody().getInfo().getQuote());
		exchangeRateResponse.setDate(new Date(uriResponse.getBody().getInfo().getTimestamp()));

		return exchangeRateResponse;
	}

}
