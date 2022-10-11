package com.fssn.controller;

import com.fssn.exceptions.NonNegativeNumberException;
import com.fssn.exceptions.UnSupportedCurrencyException;
import com.fssn.job.FetchCurrencies;
import com.fssn.models.ExchangeRateStorage;
import com.fssn.payload.ExchangeRateRequest;
import com.fssn.payload.ExchangeRateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

@CrossOrigin("*")
@RestController
public class RestJobSchedulerController {
	private static final Logger logger = LoggerFactory.getLogger(RestJobSchedulerController.class);

	@RequestMapping(method = RequestMethod.POST, value = "/exchange_amount", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ExchangeRateResponse getExchangeAmount(@RequestBody ExchangeRateRequest exchangeRateRequest)
			throws UnSupportedCurrencyException, NonNegativeNumberException {
		logger.info("get exchange amount");

		ExchangeRateStorage exchangeRateToStore = new ExchangeRateStorage();
		ExchangeRateResponse exchangeRateResponse = new ExchangeRateResponse();
		boolean found = false;

		if (exchangeRateRequest.getFrom_amount() < 0) {
			throw new NonNegativeNumberException(exchangeRateRequest.getFrom_amount());
		}

		if (FetchCurrencies.rates.size() == 0) {
			exchangeRateToStore = FetchCurrencies.getExchangeRate(exchangeRateRequest.getFrom(),
					exchangeRateRequest.getTo());

			exchangeRateResponse.setFrom(exchangeRateRequest.getFrom());
			exchangeRateResponse.setTo(exchangeRateRequest.getTo());
			exchangeRateResponse.setExchange_rate(exchangeRateToStore.getExchangeRate());
			exchangeRateResponse
					.setTo_amount(exchangeRateRequest.getFrom_amount() * exchangeRateToStore.getExchangeRate());

			return exchangeRateResponse;

		} else {
			Iterator<ExchangeRateStorage> iterator = FetchCurrencies.rates.iterator();
			while (iterator.hasNext()) {
				ExchangeRateStorage searchedExchangeRate = iterator.next();
				if (searchedExchangeRate.getCurrency()
						.equals(exchangeRateRequest.getFrom() + '-' + exchangeRateRequest.getTo())) {
					found = true;
					break;
				}
			}
		}

		exchangeRateToStore.setCurrency(exchangeRateRequest.getFrom() + '-' + exchangeRateRequest.getTo());

		String request = exchangeRateRequest.getFrom() + '-' + exchangeRateRequest.getTo();

		if (found && FetchCurrencies.rates.size() != 0) {
			FetchCurrencies.rates.sort(new Comparator<ExchangeRateStorage>() {
				public int compare(ExchangeRateStorage o1, ExchangeRateStorage o2) {
					return o1.getDate().compareTo(o2.getDate());
				}
			});

			ExchangeRateStorage lastElement = FetchCurrencies.rates.get(FetchCurrencies.rates.size() - 1);
			Date lastDate = lastElement.getDate();

			for (ExchangeRateStorage exchangeRate : FetchCurrencies.rates) {

				if (exchangeRate.getCurrency().equals(request)
						&& (!exchangeRate.getDate().after(lastDate) && !exchangeRate.getDate().before(lastDate))) {

					exchangeRateResponse.setFrom(exchangeRateRequest.getFrom());
					exchangeRateResponse.setTo(exchangeRateRequest.getTo());
					exchangeRateResponse.setExchange_rate(exchangeRate.getExchangeRate());
					exchangeRateResponse
							.setTo_amount(exchangeRateRequest.getFrom_amount() * exchangeRate.getExchangeRate());

					if (!exchangeRate.isUsed()) {
						exchangeRate.setUsed(true);
					}
					break;
				}
			}

		}

		else {
			logger.info("Currency not found! ");
			throw new UnSupportedCurrencyException(exchangeRateRequest.getFrom() + '-' + exchangeRateRequest.getTo());
		}

		return exchangeRateResponse;

	}
}