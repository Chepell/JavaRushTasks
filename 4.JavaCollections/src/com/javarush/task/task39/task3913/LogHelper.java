package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Artem Voytenko
 * 04.12.2018
 */

public class LogHelper {
	private Path logDir;

	public LogHelper(Path logDir) {
		this.logDir = logDir;
	}


	/**
	 * CЕРВИСНЫЕ МЕТОДЫ
	 **/

//	// метод фильтрует список логов по датам и возвращает
//	public List<Log> filterDataLogs(List<Log> logs, Date after, Date before) {
//		List<Log> resultList = new ArrayList<>();
//		for (Log log : logs) {
//			long logTime = log.getDate().getTime();
//			// возвратить данные касающиеся только данного периода (включая даты after и before)
//			if (after != null && before != null) {
//				if (logTime >= after.getTime() && logTime <= before.getTime()) {
//					resultList.add(log);
//				}
//				// нужно обработать все записи, у которых дата меньше или равна before
//			} else if (after == null && before != null) {
//				if (logTime <= before.getTime()) {
//					resultList.add(log);
//				}
//				// то нужно обработать все записи, у которых дата больше или равна after
//			} else if (after != null) {
//				if (logTime >= after.getTime()) {
//					resultList.add(log);
//				}
//				// нужно обработать абсолютно все записи (без фильтрации по дате)
//			} else {
//				resultList.add(log);
//			}
//		}
//		return resultList;
//	}
//
//	// метод принимает уже отфильтрованный нужным образом список логов
//	// осталось только пройтись по датам и собрать из них IP в сэт
//	public Set<String> getSetOfIPsDateSorted(List<Log> logs, Date after, Date before) {
//		Set<String> resultSet = new HashSet<>();
//		for (Log log : logs) {
//			long logTime = log.getDate().getTime();
//			// возвратить данные касающиеся только данного периода (включая даты after и before)
//			if (after != null && before != null) {
//				if (logTime >= after.getTime() && logTime <= before.getTime()) {
//					resultSet.add(log.getIp());
//				}
//				// нужно обработать все записи, у которых дата меньше или равна before
//			} else if (after == null && before != null) {
//				if (logTime <= before.getTime()) {
//					resultSet.add(log.getIp());
//				}
//				// то нужно обработать все записи, у которых дата больше или равна after
//			} else if (after != null) {
//				if (logTime >= after.getTime()) {
//					resultSet.add(log.getIp());
//				}
//				// нужно обработать абсолютно все записи (без фильтрации по дате)
//			} else {
//				resultSet.add(log.getIp());
//			}
//		}
//		return resultSet;
//	}
//
//	// метод принимает уже отфильтрованный нужным образом список логов
//	// и возвращает множестов пользователей отфильтрованное по датам
//	public Set<String> getSetOfUsersDateSorted(List<Log> logs, Date after, Date before) {
//		Set<String> resultSet = new HashSet<>();
//		for (Log log : logs) {
//			long logTime = log.getDate().getTime();
//			// возвратить данные касающиеся только данного периода (включая даты after и before).
//			if (after != null && before != null) {
//				if (logTime >= after.getTime() && logTime <= before.getTime()) {
//					resultSet.add(log.getUser());
//				}
//				// нужно обработать все записи, у которых дата меньше или равна before.
//			} else if (after == null && before != null) {
//				if (logTime <= before.getTime()) {
//					resultSet.add(log.getUser());
//				}
//				// то нужно обработать все записи, у которых дата больше или равна after.
//			} else if (after != null) {
//				if (logTime >= after.getTime()) {
//					resultSet.add(log.getUser());
//				}
//				// нужно обработать абсолютно все записи (без фильтрации по дате).
//			} else {
//				resultSet.add(log.getUser());
//			}
//		}
//		return resultSet;
//	}
//
//	// метод принимает уже отфильтрованный нужным образом список логов
//	// и возвращает множестов уникальных событий отфильтрованное по датам
//	public Set<Event> getSetOfEventsDateSorted(List<Log> logs, Date after, Date before) {
//		Set<Event> resultSet = new HashSet<>();
//		for (Log log : logs) {
//			long logTime = log.getDate().getTime();
//			// возвратить данные касающиеся только данного периода (включая даты after и before).
//			if (after != null && before != null) {
//				if (logTime >= after.getTime() && logTime <= before.getTime()) {
//					resultSet.add(log.getEvent());
//				}
//				// нужно обработать все записи, у которых дата меньше или равна before.
//			} else if (after == null && before != null) {
//				if (logTime <= before.getTime()) {
//					resultSet.add(log.getEvent());
//				}
//				// то нужно обработать все записи, у которых дата больше или равна after.
//			} else if (after != null) {
//				if (logTime >= after.getTime()) {
//					resultSet.add(log.getEvent());
//				}
//				// нужно обработать абсолютно все записи (без фильтрации по дате).
//			} else {
//				resultSet.add(log.getEvent());
//			}
//		}
//		return resultSet;
//	}
//
//	// метод принимает уже отфильтрованный нужным образом список логов
//	// и возвращает множестов уникальных статусов отфильтрованное по датам
//	public Set<Status> getSetOfStatusDateSorted(List<Log> logs, Date after, Date before) {
//		Set<Status> resultSet = new HashSet<>();
//		for (Log log : logs) {
//			long logTime = log.getDate().getTime();
//			// возвратить данные касающиеся только данного периода (включая даты after и before).
//			if (after != null && before != null) {
//				if (logTime >= after.getTime() && logTime <= before.getTime()) {
//					resultSet.add(log.getStatus());
//				}
//				// нужно обработать все записи, у которых дата меньше или равна before.
//			} else if (after == null && before != null) {
//				if (logTime <= before.getTime()) {
//					resultSet.add(log.getStatus());
//				}
//				// то нужно обработать все записи, у которых дата больше или равна after.
//			} else if (after != null) {
//				if (logTime >= after.getTime()) {
//					resultSet.add(log.getStatus());
//				}
//				// нужно обработать абсолютно все записи (без фильтрации по дате).
//			} else {
//				resultSet.add(log.getStatus());
//			}
//		}
//		return resultSet;
//	}
//
//	// метод принимает уже отфильтрованный нужным образом список логов
//	// и возвращает множестов уникальных Дат отфильтрованное по датам
//	public Set<Date> getSetOfDatesDateSorted(List<Log> logs, Date after, Date before) {
//		Set<Date> resultSet = new HashSet<>();
//		for (Log log : logs) {
//			long logTime = log.getDate().getTime();
//			// возвратить данные касающиеся только данного периода (включая даты after и before).
//			if (after != null && before != null) {
//				if (logTime >= after.getTime() && logTime <= before.getTime()) {
//					resultSet.add(log.getDate());
//				}
//				// нужно обработать все записи, у которых дата меньше или равна before.
//			} else if (after == null && before != null) {
//				if (logTime <= before.getTime()) {
//					resultSet.add(log.getDate());
//				}
//				// то нужно обработать все записи, у которых дата больше или равна after.
//			} else if (after != null) {
//				if (logTime >= after.getTime()) {
//					resultSet.add(log.getDate());
//				}
//				// нужно обработать абсолютно все записи (без фильтрации по дате).
//			} else {
//				resultSet.add(log.getDate());
//			}
//		}
//		return resultSet;
//	}
	private boolean inTimePeriod(Date current, Date after, Date before) {
		boolean result = false;
		if (after == null && before == null) {
			result = true;
		} else if (after != null && before == null) {
			if (current.getTime() > after.getTime()) result = true;
		} else if (after == null && before != null) {
			if (current.getTime() < before.getTime()) result = true;
		} else if (after != null && before != null) {
			if (current.getTime() > after.getTime() && current.getTime() < before.getTime()) result = true;
		}
		return result;
	}

	// метод фильтрует список логов по датам и возвращает
	public List<Log> filterDataLogs(List<Log> logs, Date after, Date before) {
		List<Log> resultList = new ArrayList<>();
		for (Log log : logs) {
			if (inTimePeriod(log.getDate(), after, before)) {
				resultList.add(log);
			}
		}
		return resultList;
	}

	// метод принимает уже отфильтрованный нужным образом список логов
	// осталось только пройтись по датам и собрать из них IP в сэт
	public Set<String> getSetOfIPsDateSorted(List<Log> logs, Date after, Date before) {
		Set<String> resultSet = new HashSet<>();
		for (Log log : logs) {
			if (inTimePeriod(log.getDate(), after, before)) {
				resultSet.add(log.getIp());
			}
		}
		return resultSet;
	}

	// метод принимает уже отфильтрованный нужным образом список логов
	// и возвращает множестов пользователей отфильтрованное по датам
	public Set<String> getSetOfUsersDateSorted(List<Log> logs, Date after, Date before) {
		Set<String> resultSet = new HashSet<>();
		for (Log log : logs) {
			if (inTimePeriod(log.getDate(), after, before)) {
				resultSet.add(log.getUser());
			}
		}
		return resultSet;
	}

	// метод принимает уже отфильтрованный нужным образом список логов
	// и возвращает множестов уникальных событий отфильтрованное по датам
	public Set<Event> getSetOfEventsDateSorted(List<Log> logs, Date after, Date before) {
		Set<Event> resultSet = new HashSet<>();
		for (Log log : logs) {
			if (inTimePeriod(log.getDate(), after, before)) {
				resultSet.add(log.getEvent());
			}
		}
		return resultSet;
	}

	// метод принимает уже отфильтрованный нужным образом список логов
	// и возвращает множестов уникальных статусов отфильтрованное по датам
	public Set<Status> getSetOfStatusDateSorted(List<Log> logs, Date after, Date before) {
		Set<Status> resultSet = new HashSet<>();
		for (Log log : logs) {
			if (inTimePeriod(log.getDate(), after, before)) {
				resultSet.add(log.getStatus());
			}
		}
		return resultSet;
	}

	// метод принимает уже отфильтрованный нужным образом список логов
	// и возвращает множестов уникальных Дат отфильтрованное по датам
	public Set<Date> getSetOfDatesDateSorted(List<Log> logs, Date after, Date before) {
		Set<Date> resultSet = new HashSet<>();
		for (Log log : logs) {
			if (inTimePeriod(log.getDate(), after, before)) {
				resultSet.add(log.getDate());
			}
		}
		return resultSet;
	}

	// метод возвращает первую дату из списка с логами
	public Date getFirstDateDateSorted(List<Log> logs, Date after, Date before) {
		TreeSet<Date> resultSet = new TreeSet<>(getSetOfDatesDateSorted(logs, after, before));
		Date result = null;
		if (resultSet.size() != 0) {
			result = resultSet.first();
		}
		return result;
	}

	// метод чтения строк всех лог файлов в список строк
	private List<String> logsListString() {
		List<String> list = new ArrayList<>();
		// открываю поток чтения файлов из директории только log файлов
		try (DirectoryStream<Path> paths = Files.newDirectoryStream(logDir, "*.log")) {
			// у каждого файла вычитываю все строки и помещаю в список
			for (Path path : paths) {
				list.addAll(Files.readAllLines(path));
			}
		} catch (IOException e) {
			System.out.println("Пробемы с чтением из файлов в список");
		}
		return list;
	}

	// парсер запросов
	public String[] parseQuery(String query) {
		// массив под отпарсенные запросы
		String[] result = new String[5];
		if (query.contains("between")) {
			// Pattern pattern =
			//					Pattern.compile("^get\\s(\\w+)(\\sfor\\s(\\w+?)\\s=\\s\"(.+?)\"( and date between \"(.+?)+\" and \"(" +
			//							".+&)+\")?)?");
			Pattern pattern = Pattern.
					compile("^get\\s(\\w+)\\sfor\\s(\\w+)\\s=\\s\"(.+?)\" and date between \"(.+?)\" and \"(.+?)\"$");
			Matcher matcher = pattern.matcher(query);
			while (matcher.find()) {
				result[0] = matcher.group(1);
				result[1] = matcher.group(2);
				result[2] = matcher.group(3);
				result[3] = matcher.group(4);
				result[4] = matcher.group(5);
			}
			// "get ip for user = "[any_user]""
		} else if (query.contains("for")) {
			Pattern pattern = Pattern.
					compile("^get\\s(\\w+)\\sfor\\s(\\w+)\\s=\\s\"(.+?)\"$");
			Matcher matcher = pattern.matcher(query);
			while (matcher.find()) {
				result[0] = matcher.group(1);
				result[1] = matcher.group(2);
				result[2] = matcher.group(3);
			}
		} else {
			Pattern pattern = Pattern.
					compile("^get\\s(\\w+)$");
			Matcher matcher = pattern.matcher(query);
			while (matcher.find()) {
				result[0] = matcher.group(1);
			}
		}
		return result;
	}

	// метод получения списка объектов класса Log из списка строк
	public List<Log> logsList() {
		List<String> list = logsListString();
		List<Log> logsList = new ArrayList<>();

		for (String line : list) {
			String[] split = line.split("\t");
			String ip = split[0];
			String name = split[1];
			Date date = getDate(split[2]);
			Event event;
			int eventNum = 0;
			String[] splitStatus = split[3].split(" ");
			if (splitStatus.length == 2) {
				event = Event.valueOf(splitStatus[0]);
				eventNum = Integer.parseInt(splitStatus[1]);
			} else {
				event = Event.valueOf(split[3]);
			}
			Status status = Status.valueOf(split[4]);
			logsList.add(new Log(ip, name, date, event, eventNum, status));
		}
		return logsList;
	}

	// конвертер из строки в дату по заданному формату
	public Date getDate(String dateInString) {
		Date resultDate = null;
		// парсю только если передан не нулл, иначе возвращаю нулл
		if (dateInString != null) {
			try {
				resultDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(dateInString);
			} catch (ParseException e) {
				System.out.println("Пробема с получением даты из лога");
			}
		}
		return resultDate;
	}
}
