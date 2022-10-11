package com.fssn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fssn.controller.RestJobSchedulerController;
import com.fssn.exceptions.NonNegativeNumberException;
import com.fssn.exceptions.UnSupportedCurrencyException;
import com.fssn.job.FetchCurrencies;
import com.fssn.models.ExchangeRateStorage;
import com.fssn.payload.ExchangeRateRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestJobSchedulerController.class)
class FetchCurrenciesApplicationTests {

	@InjectMocks
	private RestJobSchedulerController restJobSchedulerController;

	@Test
	void ExchangeRateStorageTest() throws Exception {

		ExchangeRateStorage exchangeRateStorage = FetchCurrencies.getExchangeRate("EUR", "USD");
		assertThat(exchangeRateStorage).isInstanceOf(ExchangeRateStorage.class);

	}

	@Test
	void ControllerNegativeNumberTest() throws Exception {

		ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
		exchangeRateRequest.setFrom("USD");
		exchangeRateRequest.setTo("EUR");
		exchangeRateRequest.setFrom_amount(-99.356f);
		Assertions.assertThrows(NonNegativeNumberException.class,
				() -> restJobSchedulerController.getExchangeAmount(exchangeRateRequest));

	}

	@Test
	void ControllerUnsupportedCurrencyTest() throws Exception {

		ExchangeRateRequest exchangeRateRequest = new ExchangeRateRequest();
		exchangeRateRequest.setFrom("LBP");
		exchangeRateRequest.setTo("EUR");
		exchangeRateRequest.setFrom_amount(100.00f);

		Assertions.assertThrows(UnSupportedCurrencyException.class,
				() -> restJobSchedulerController.getExchangeAmount(exchangeRateRequest));
	}
}
