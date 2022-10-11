package com.fssn.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fssn.models.ExchangeRateStorage;
import com.fssn.payload.ExchangeRateResponse;
import com.fssn.service.FetchApi;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class FetchCurrencies implements Job {

	private static final Logger logger = LoggerFactory.getLogger(FetchCurrencies.class);
	public static final List<ExchangeRateStorage> rates = new ArrayList<ExchangeRateStorage>();

	@Override
	public void execute(JobExecutionContext context) {
		logger.info("fetching data At: " + ZonedDateTime.now().toString());

		// fetching rates
		if (rates.size() == 0) {

			rates.add(getExchangeRate("EUR", "USD"));
			rates.add(getExchangeRate("USD", "EUR"));
			rates.add(getExchangeRate("EUR", "SEK"));
			rates.add(getExchangeRate("SEK", "EUR"));
			rates.add(getExchangeRate("USD", "SEK"));
			rates.add(getExchangeRate("SEK", "USD"));

		}
	}

	public static ExchangeRateStorage getExchangeRate(String from, String to) {

		logger.info("Get echange rate and setting it to storage object");

		ExchangeRateResponse exchangeRateResponse = FetchApi.getRate("1", from, to);
		ExchangeRateStorage exchangeRateStorage = new ExchangeRateStorage();

		exchangeRateStorage.setCurrency(exchangeRateResponse.getFrom() + "-" + exchangeRateResponse.getTo());
		exchangeRateStorage.setExchangeRate(exchangeRateResponse.getExchange_rate());
		exchangeRateStorage.setDate(exchangeRateResponse.getDate());
		exchangeRateStorage.setUsed(true);
		rates.add(exchangeRateStorage);
		return exchangeRateStorage;

	}
}
