package com.momo.spring.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

	@Value("${paging.page.size}")
	private int defaultPageSize;
	
	@Value("${paging.page.number}")
	private int defaultPageNum;

	@Value("${paging.page.defaultButton}")
	private int defaultButtonToShow;
	
	public int getDefaultPageSize() {
		return defaultPageSize;
	}

	public int getDefaultPageNum() {
		return defaultPageNum;
	}

	public int getDefaultButtonToShow() {
		return defaultButtonToShow;
	}
	
}
