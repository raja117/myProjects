package com.phone.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;

public class MobileBill {

	public static float Totalcost = 0;
	public int sec;
	public int promo_durtion = 0;
	public float promoAmount = 0;
	public String promonumber = null;
	public int highest_duration;

	/*
	 * This Part of code calculates the amount for each phone call.
	 */
	public float calculateAmount(LocalTime time) {
		float costPerCall = 0;
		if (time.getMinute() < 5 && time.getHour()==0) {
			int seconds = (time.getMinute() * 60) + time.getSecond();
			costPerCall = (float) (seconds * 0.03);
		} else{
			int min = time.getMinute() + (time.getHour() * 60);
			if (time.getSecond() > 0) {
				min = min + 1;
			}
			costPerCall = (float) (min * 1.50);
		}
		return costPerCall;
	}

	@SuppressWarnings("deprecation")
	public void dupmain() throws ParseException, IOException {
		String	log =  new  String(Files.readAllBytes(Paths.get("C:/Users/santh/Desktop/mobilelogdata.txt")));
		String[] res = log.split("\n");
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		for (int j = 0; j < res.length; j++) {
			SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss");
			Date duration = timeformat.parse((res[j].split(","))[0]);
			sec = duration.getSeconds() + (duration.getMinutes() * 60) + (duration.getHours() * 3600);
			String PhoneNumber = (res[j].split(","))[1].trim();
			if (!h.containsKey(PhoneNumber)) {
				h.put(PhoneNumber, sec);
				if (promo_durtion == 0) {
					promonumber = PhoneNumber;
					promo_durtion = sec;
				}
				if (promo_durtion < sec) {
					promonumber = PhoneNumber;
					promo_durtion = sec;
				}
			} else {
				int new_Duration = h.get(PhoneNumber) + sec;
				h.put(PhoneNumber, new_Duration);
				if (promo_durtion == 0) {
					promo_durtion = new_Duration;
				}
				if (promo_durtion < new_Duration) {
					promonumber = PhoneNumber;
					promo_durtion = new_Duration;
				}
			}
			LocalTime time = LocalTime.ofSecondOfDay(sec);
			float costpc = calculateAmount(time);
			Totalcost = Totalcost + costpc;
			System.out.println(PhoneNumber + " : " + time.toString() + " : " + costpc + "$");
		}
		highest_duration = h.get(promonumber);
		LocalTime lt = LocalTime.ofSecondOfDay(highest_duration);
		promoAmount = calculateAmount(lt);
		System.out.println("\nPhone Number under Promotional offer : " + promonumber);
		System.out.println("Total Due Amount : " + Totalcost + "$");
		System.out.println("PromoAmount : " + "-" + promoAmount + "$");
		System.out.println("Final Total Amount after promo adjustment : " + (Totalcost - promoAmount) + " $");
	}

	public static void main(String args[]) throws ParseException, IOException {

		MobileBill mb = new MobileBill();
		mb.dupmain();
	}
}
