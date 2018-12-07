package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String[] args) {
		LogParser logParser = new LogParser(Paths.get("c:/logs/"));


		int number = logParser.getNumberOfAttemptToSolveTask(18, null, null);
		System.out.println(number);

//		Set<Object> get_ip = logParser.execute("get ip for user = \"Eduard Petrovich Morozko Moroz\"");
//		Set<Object> get_ip = logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"");
//		Set<Object> get_ip = logParser.execute("get ip");
//		Set<Object> get_ip = logParser.execute("get ip for user = \"Amigo\"");
//		Set<Object> get_ip = logParser.execute("get ip for user = \"Eduard Petrovich Morozko\"");
		Set<Object> get_ip = logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\"");
		for (Object o : get_ip) {
			System.out.println(o);
		}

//		// Pattern pattern = Pattern.compile("get\\s(\\w+)\\sfor\\s(\\w+)\\s=\\s\"(\\w)\"");
//		String[] get_ips = logParser.parseQuery("get user");
//
//		for (String getIp : get_ips) {
//			System.out.println(getIp);
//		}


	}
}