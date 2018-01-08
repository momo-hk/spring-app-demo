package com.momo.spring.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:demo.properties")
public class ConfigurationService {

	@Value("${pagination.page.number}")
	private int defaultPageNumber;
	
	@Value("${pagination.page.size}")
	private int defaultPageSize;

	@Value("${pagination.page.buttons}")
	private int buttonsToShow;
	
	@Value("${pagination.page.size.options}")
	private int[] pageSizeOptions;
	
	public int getDefaultPageNumber() {
		return defaultPageNumber;
	}

	public int getDefaultPageSize() {
		return defaultPageSize;
	}

	public int getButtonToShow() {
		return buttonsToShow;
	}

	public int[] getPageSizeOptions() {
		return pageSizeOptions;
	}
	
}
