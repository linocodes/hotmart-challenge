package br.com.hotmart.challenge.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {

	public static int randomNumber(int lowerBound, int upperBound) {
		Random r = new Random();
		return r.nextInt(upperBound - lowerBound) + lowerBound;
	}

	public static String randomString(int n) {
		return RandomStringUtils.randomAlphabetic(n);
	}

	public static Date converterLocalDateTimeToDate(LocalDateTime localDateTime) {
		return java.sql.Timestamp.valueOf(localDateTime);
	}

	public static boolean between(int i, int minValue, int maxValue) {
		if (i >= minValue && i <= maxValue)
			return true;
		else
			return false;
	}

	public static String converterObjectTosTring(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.info("Erro ao converter objeto para string %s", e.getMessage());
		}
		return null;
	}

	public static int calculateDayDifference(Date dateAfter, Date dateBefore){
	    return (int)(dateAfter.getTime()-dateBefore.getTime())/(1000 * 60 * 60 * 24);
	}
}
