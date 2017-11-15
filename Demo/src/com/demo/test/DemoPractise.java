package com.demo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoPractise {
    static int x = 10;

    public static void main(String args[]) throws ParseException
    {
	
	Stream.of("M","u","sdf").filter(fr -> {System.out.println("sdfs" + fr);
	return true;
	});
	System.out.println();
    }
    
    public void showConsumer(Supplier<String> name)
    {
	int x = 5;
	System.out.println(this.x);
    }
}
