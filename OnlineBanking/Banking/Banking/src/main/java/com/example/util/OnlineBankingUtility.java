package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import com.example.objects.PaymentCardDetails;

public class OnlineBankingUtility {

	public static String generateRandomAccountNumber() {
		Random random = new Random();
		int number = random.nextInt(900000000) + 100000000; // Generate a random 9-digit number
		return String.format("%012d", number); // Format the number as a 12-digit string with leading zeros

	}

	public static String generateCintNumber() {
		Random random = new Random();
		int number = random.nextInt(900000000) + 100000000; // Generate a random 9-digit number
		return String.valueOf(number);

	}

	public static String generateCVV() {
		Random random = new Random();
		int cvv = random.nextInt(900) + 100; // Generate a random 3-digit number
		return String.valueOf(cvv);
	}

	public static Date cardValidThrough() {
		LocalDate currentDate = LocalDate.now();

		LocalDate cardValidThrough = currentDate.plusYears(5);
		return Date.from(cardValidThrough.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public static String generateFifteenDigitNumber() {
		Random random = new Random();
		long number = (random.nextLong() % 900000000000000L) + 100000000000000L; // Generate a random 15-digit number
		return String.valueOf(Math.abs(number));
	}

	public static String generateRoutingNumber() {
		Random random = new Random();
		int number = random.nextInt(900000000) + 100000000; // Generate a random 9-digit number
		return String.valueOf(number); // Format the number as a 12-digit string with leading zeros

	}

	public static boolean cardValidator(PaymentCardDetails cardDetailsInDB, String cardNumber, String CVV,
			String validthroughDate) {

		return cardDetailsInDB.getCardNumber().equals(cardNumber) && cardDetailsInDB.getCVV().equals(CVV)
				&& cardDetailsInDB.getCardValidThroughDate()
						.equals(cardValidThroughDateConverter("MM/yy", validthroughDate)) ? true : false;

	}

	public static Date cardValidThroughDateConverter(String inputDate, String dateFormat) {

		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		try {
			date = simpleDateFormat.parse(inputDate);
			System.out.println("Parsed Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
