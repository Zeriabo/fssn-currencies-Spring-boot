package com.fssn.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fssn.job.FetchCurrencies;

@Configuration
public class ConfigureJob {

	@Bean
	public JobDetail fetchRates() {
		return JobBuilder.newJob(FetchCurrencies.class).withIdentity("fetchRates").storeDurably().build();
	}

	@Bean
	public Trigger FetchRatesTrigger(JobDetail ratesDetails) {

		return TriggerBuilder.newTrigger().forJob(ratesDetails)

				.withIdentity("fetchRates").startNow().withSchedule(CronScheduleBuilder.cronSchedule("* 1 * ? * * *"))
				.build();
	}
}