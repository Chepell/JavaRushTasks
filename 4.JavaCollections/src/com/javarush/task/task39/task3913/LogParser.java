package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.nio.file.Path;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
	//	private Path logDir;
	private LogHelper helper;

	public LogParser(Path logDir) {
		helper = new LogHelper(logDir);
//		this.logDir = logDir;
	}

	// должен возвращать количество уникальных IP адресов за выбранный период
	@Override
	public int getNumberOfUniqueIPs(Date after, Date before) {
		return getUniqueIPs(after, before).size();
	}

	// Метод getUniqueIPs() должен возвращать множество, содержащее все не повторяющиеся IP.
	@Override
	public Set<String> getUniqueIPs(Date after, Date before) {
		return helper.getSetOfIPsDateSorted(helper.logsList(), after, before);
	}

	// должен возвращать IP адреса с которых работал переданный пользователь за выбранный период.
	@Override
	public Set<String> getIPsForUser(String user, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным user
		logsLists.removeIf(log -> !user.equals(log.getUser()));
		return helper.getSetOfIPsDateSorted(logsLists, after, before);
	}

	public Set<String> getIPsForDate(Date date, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужной date
		logsLists.removeIf(log -> !date.equals(log.getDate()));
		return helper.getSetOfIPsDateSorted(logsLists, after, before);
	}

	// должен возвращать IP адреса с которых было произведено переданное событие за выбранный период
	@Override
	public Set<String> getIPsForEvent(Event event, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным event
		logsLists.removeIf(log -> log.getEvent() != event);
		return helper.getSetOfIPsDateSorted(logsLists, after, before);
	}

	@Override
	public Set<String> getIPsForStatus(Status status, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным status
		logsLists.removeIf(log -> log.getStatus() != status);
		return helper.getSetOfIPsDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать всех пользователей
	@Override
	public Set<String> getAllUsers() {
		return helper.getSetOfUsersDateSorted(helper.logsList(), null, null);
	}

	// метод должен возвращать количество уникальных пользователей
	@Override
	public int getNumberOfUsers(Date after, Date before) {
		return helper.getSetOfUsersDateSorted(helper.logsList(), after, before).size();
	}

	// Метод должен возвращать количество событий от определенного пользователя
	@Override
	public int getNumberOfUserEvents(String user, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным user
		logsLists.removeIf(log -> !user.equals(log.getUser()));
		return helper.getSetOfEventsDateSorted(logsLists, after, before).size();
	}

	public Set<String> getUsersForDate(Date date, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужной date
		logsLists.removeIf(log -> !date.equals(log.getDate()));
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	public Set<String> getUsersForEvent(Event event, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным Event
		logsLists.removeIf(log -> log.getEvent() != event);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	public Set<String> getUsersForStatus(Status status, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным Event
		logsLists.removeIf(log -> log.getStatus() != status);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод getUsersForIP() должен возвращать пользователей с определенным IP
	// Несколько пользователей могут использовать один и тот же IP
	@Override
	public Set<String> getUsersForIP(String ip, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужным ip
		logsLists.removeIf(log -> !ip.equals(log.getIp()));
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые были залогинены
	@Override
	public Set<String> getLoggedUsers(Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием LOGIN
		logsLists.removeIf(log -> log.getEvent() != Event.LOGIN);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые скачали плагин
	@Override
	public Set<String> getDownloadedPluginUsers(Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием DOWNLOAD_PLUGIN
		logsLists.removeIf(log -> log.getEvent() != Event.DOWNLOAD_PLUGIN);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые отправили сообщение
	@Override
	public Set<String> getWroteMessageUsers(Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием WRITE_MESSAGE
		logsLists.removeIf(log -> log.getEvent() != Event.WRITE_MESSAGE);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые решали любую задачу
	@Override
	public Set<String> getSolvedTaskUsers(Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием SOLVE_TASK
		logsLists.removeIf(log -> log.getEvent() != Event.SOLVE_TASK);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые решали задачу с номером task
	@Override
	public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием SOLVE_TASK и с номером события task
		logsLists.removeIf(log -> log.getEvent() != Event.SOLVE_TASK || log.getTask() != task);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые решали любую задачу
	@Override
	public Set<String> getDoneTaskUsers(Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием SOLVE_TASK
		logsLists.removeIf(log -> log.getEvent() != Event.DONE_TASK);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать пользователей, которые решали задачу с номером task
	@Override
	public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с событием DONE_TASK
		// осталвляю задачи с определенным номером task
		logsLists.removeIf(log -> log.getEvent() != Event.DONE_TASK || log.getTask() != task);
		return helper.getSetOfUsersDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать даты, когда определенный пользователь произвел определенное событие
	@Override
	public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с определенным именем и событием
		logsList.removeIf(log -> !user.equals(log.getUser()) || event != log.getEvent());
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	public Set<Date> getDatesForUser(String user, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с определенным именем
		logsList.removeIf(log -> !user.equals(log.getUser()));
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	public Set<Date> getDatesForEvent(Event event, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с определенным событием
		logsList.removeIf(log -> event != log.getEvent());
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	public Set<Date> getDatesForStatus(Status status, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с определенным статусом
		logsList.removeIf(log -> status != log.getStatus());
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	public Set<Date> getDatesForIp(String ip, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с определенным именем и событием
		logsList.removeIf(log -> !ip.equals(log.getIp()));
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	// Метод должен возвращать даты, когда любое событие не выполнилось (статус FAILED)
	@Override
	public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с событием FAILED
		logsList.removeIf(log -> log.getStatus() != Status.FAILED);
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	// Метод должен возвращать даты, когда любое событие закончилось ошибкой (статус ERROR)
	@Override
	public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с событием ERROR
		logsList.removeIf(log -> log.getStatus() != Status.ERROR);
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	// Метод должен возвращать дату, когда пользователь залогинился впервые за
	// указанный период. Если такой даты в логах нет - null
	@Override
	public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с событием LOGIN для конкретного пользователя
		logsList.removeIf(log -> !user.equals(log.getUser()) || log.getEvent() != Event.LOGIN);
		return helper.getFirstDateDateSorted(logsList, after, before);
	}

	// Метод должен возвращать дату, когда пользователь впервые попытался решить
	// определенную задачу. Если такой даты в логах нет - null
	@Override
	public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи с определенным номером задачи
		logsList.removeIf(log -> !user.equals(log.getUser()) || log.getEvent() != Event.SOLVE_TASK || log.getTask() != task);
		return helper.getFirstDateDateSorted(logsList, after, before);
	}

	// Метод должен возвращать дату, когда пользователь впервые решил определенную задачу
	// Если такой даты в логах нет - null
	@Override
	public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь конекретного пользователя с определенным номером решенной задачи
		logsList.removeIf(log -> !user.equals(log.getUser()) || log.getEvent() != Event.DONE_TASK || log.getTask() != task);
		return helper.getFirstDateDateSorted(logsList, after, before);
	}

	// Метод должен возвращать даты, когда пользователь написал сообщение
	@Override
	public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи от конкретного пользователя с событием WRITE_MESSAGE
		logsList.removeIf(log -> !user.equals(log.getUser()) || log.getEvent() != Event.WRITE_MESSAGE);
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	// Метод должен возвращать даты, когда пользователь скачал плагин
	@Override
	public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке лишь логи от конкретного пользователя с событием WRITE_MESSAGE
		logsList.removeIf(log -> !user.equals(log.getUser()) || log.getEvent() != Event.DOWNLOAD_PLUGIN);
		return helper.getSetOfDatesDateSorted(logsList, after, before);
	}

	// Метод должен возвращать количество уникальных событий за выбранный период
	@Override
	public int getNumberOfAllEvents(Date after, Date before) {
		return getAllEvents(after, before).size();
	}

	// Метод должен возвращать множество уникальных событий за выбранный период
	@Override
	public Set<Event> getAllEvents(Date after, Date before) {
		return helper.getSetOfEventsDateSorted(helper.logsList(), after, before);
	}

	// Метод должен возвращать множество уникальных событий,
	// которые происходили с переданного IP адреса за выбранный период
	@Override
	public Set<Event> getEventsForIP(String ip, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		logsList.removeIf(log -> !ip.equals(log.getIp()));
		return helper.getSetOfEventsDateSorted(logsList, after, before);
	}

	// Метод должен возвращать множество уникальных событий, которые произвел
	// переданный пользователь за выбранный период
	@Override
	public Set<Event> getEventsForUser(String user, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		logsList.removeIf(log -> !user.equals(log.getUser()));
		return helper.getSetOfEventsDateSorted(logsList, after, before);
	}

	public Set<Event> getEventsForDate(Date date, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужной date
		logsLists.removeIf(log -> !date.equals(log.getDate()));
		return helper.getSetOfEventsDateSorted(logsLists, after, before);
	}

	public Set<Event> getEventsForStatus(Status status, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		logsList.removeIf(log -> log.getStatus() != status);
		return helper.getSetOfEventsDateSorted(logsList, after, before);
	}

	// Метод getFailedEvents(Date, Date) должен возвращать множество уникальных событий,
	// у которых статус выполнения FAILED за выбранный период
	@Override
	public Set<Event> getFailedEvents(Date after, Date before) {
//		List<Log> logsList = helper.logsList();
//		logsList.removeIf(log -> log.getStatus() != Status.FAILED);
//		return helper.getSetOfEventsDateSorted(logsList, after, before);
		return getEventsForStatus(Status.FAILED, after, before);
	}

	// Метод должен возвращать множество уникальных событий, у которых статус выполнения ERROR за выбранный период
	@Override
	public Set<Event> getErrorEvents(Date after, Date before) {
//		List<Log> logsList = helper.logsList();
//		logsList.removeIf(log -> log.getStatus() != Status.ERROR);
//		return helper.getSetOfEventsDateSorted(logsList, after, before);
		return getEventsForStatus(Status.ERROR, after, before);

	}

	public Set<Status> getStatusForIP(String ip, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		logsList.removeIf(log -> !ip.equals(log.getIp()));
		return helper.getSetOfStatusDateSorted(logsList, after, before);
	}

	public Set<Status> getStatusForUser(String user, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		logsList.removeIf(log -> !user.equals(log.getUser()));
		return helper.getSetOfStatusDateSorted(logsList, after, before);
	}

	public Set<Status> getStatusForEvent(Event event, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		logsList.removeIf(log -> log.getEvent() != event);
		return helper.getSetOfStatusDateSorted(logsList, after, before);
	}

	public Set<Status> getStatusForDate(Date date, Date after, Date before) {
		List<Log> logsLists = helper.logsList();
		// оставляю в списке лишь логи с нужной date
		logsLists.removeIf(log -> !date.equals(log.getDate()));
		return helper.getSetOfStatusDateSorted(logsLists, after, before);
	}

	// Метод должен возвращать количество попыток решить задачу с номером task за выбранный период
	@Override
	public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке только логи с событием SOLVE_TASK и номером задачи task
		logsList.removeIf(log -> log.getEvent() != Event.SOLVE_TASK || log.getTask() != task);
		// фильтурую список по датам и возвращаю его длину
		return helper.filterDataLogs(logsList, after, before).size();
	}

	// Метод должен возвращать количество успешных решений задачи с номером task за выбранный период
	@Override
	public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
		List<Log> logsList = helper.logsList();
		// оставляю в списке только логи с событием DONE_TASK и номером задачи task
		logsList.removeIf(log -> log.getEvent() != Event.DONE_TASK || log.getTask() != task);
		// фильтурую список по датам и возвращаю его длину
		return helper.filterDataLogs(logsList, after, before).size();
	}

	// Метод должен возвращать мапу (номер_задачи : количество_попыток_решить_ее) за выбранный период
	@Override
	public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
		List<Log> logs = helper.filterDataLogs(helper.logsList(), after, before);
		Map<Integer, Integer> map = new HashMap<>();
		for (Log log : logs) {
			if (log.getEvent() == Event.SOLVE_TASK) {
				int task = log.getTask();
				if (map.containsKey(task)) {
					int newValue = map.get(task) + 1;
					map.put(task, newValue);
				} else {
					map.put(task, 1);
				}
			}
		}
		return map;
	}

	// Метод должен возвращать мапу (номер_задачи : сколько_раз_ее_решили) за выбранный период
	@Override
	public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
		List<Log> logs = helper.filterDataLogs(helper.logsList(), after, before);
		Map<Integer, Integer> map = new HashMap<>();
		for (Log log : logs) {
			if (log.getEvent() == Event.DONE_TASK) {
				int task = log.getTask();
				if (map.containsKey(task)) {
					int newValue = map.get(task) + 1;
					map.put(task, newValue);
				} else {
					map.put(task, 1);
				}
			}
		}
		return map;
	}

	@Override
	public Set<Object> execute(String query) {
		List<Log> logsList = helper.logsList();
		Set<? extends Object> result = null;
		// парсер запроса
		String[] queArr = helper.parseQuery(query);
		// разбираю по командам
		String field1 = queArr[0];
		String field2 = queArr[1];
		String value1 = queArr[2];
		Date after = helper.getDate(queArr[3]);
		Date before = helper.getDate(queArr[4]);


		/** IP **/
		if ("ip".equals(field1) && field2 == null && value1 == null) {
			result = getUniqueIPs(null, null);
		}

		// Вызов метода execute с параметром "get ip for user = "[any_user]"" должен возвращать множество
		//	 уникальных IP адресов, с которых работал пользователь с именем [any_user]
		if ("ip".equals(field1) && "user".equals(field2) && value1 != null) {
			result = getIPsForUser(value1, after, before);
		}

		// Вызов метода execute с параметром "get ip for date = "[any_date]"
		// and date between "[after]" and "[before]"" должен возвращать множество уникальных IP адресов,
		// события с которых произведены в указанное время [any_date] в период между датами [after] и [before].
		if ("ip".equals(field1) && "date".equals(field2) && value1 != null) {
			result = getIPsForDate(helper.getDate(value1), after, before);
		}


		// Вызов метода execute с параметром "get ip for event = "[any_event]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных IP адресов, у которых событие равно [any_event]
		// в период между датами [after] и [before].
		if ("ip".equals(field1) && "event".equals(field2) && value1 != null) {
			result = getIPsForEvent(Event.valueOf(value1), after, before);
		}

		// Вызов метода execute с параметром "get ip for status = "[any_status]"
		// and date between "[after]" and "[before]"" должен возвращать множество уникальных IP адресов,
		// события с которых закончились со статусом [any_status] в период между датами [after] и [before].
		if ("ip".equals(field1) && "status".equals(field2) && value1 != null) {
			result = getIPsForStatus(Status.valueOf(value1), after, before);
		}

		/** USER **/
		if ("user".equals(field1) && field2 == null && value1 == null) {
			result = helper.getSetOfUsersDateSorted(logsList, null, null);
		}

		// Вызов метода execute с параметром "get user for ip = "[any_ip]" and date between "[after]" and "[before]""
		// должен возвращать множество уникальных пользователей, которые работали с IP адреса [any_ip] в период между
		// датами [after] и [before].
		if ("user".equals(field1) && "ip".equals(field2) && value1 != null) {
			result = getUsersForIP(value1, after, before);
		}

		// Вызов метода execute с параметром "get user for date = "[any_date]" and date between "[after]" and "[before]""
		// должен возвращать множество уникальных пользователей, которые произвели любое действие в
		// указанное время [any_date] в период между датами [after] и [before].
		if ("user".equals(field1) && "date".equals(field2) && value1 != null) {
			result = getUsersForDate(helper.getDate(value1), after, before);
		}

		// Вызов метода execute с параметром "get user for event = "[any_event]" and date between "[after]" and "[before]""
		// должен возвращать множество уникальных пользователей, у которых событие равно [any_event]
		// в период между датами [after] и [before].
		if ("user".equals(field1) && "event".equals(field2) && value1 != null) {
			result = getUsersForEvent(Event.valueOf(value1), after, before);
		}

		// Вызов метода execute с параметром "get user for status = "[any_status]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных пользователей, у которых статус равен [any_status]
		// в период между датами [after] и [before].
		if ("user".equals(field1) && "status".equals(field2) && value1 != null) {
			result = getUsersForStatus(Status.valueOf(value1), after, before);
		}

		/** DATE **/
		if ("date".equals(field1) && field2 == null && value1 == null) {
			result = helper.getSetOfDatesDateSorted(logsList, null, null);
		}

		// Вызов метода execute с параметром "get date for ip = "[any_ip]" and date between "[after]" and "[before]""
		// должен возвращать множество уникальных дат, за которые с IP адреса [any_ip] произведено любое действие
		// в период между датами [after] и [before].
		if ("date".equals(field1) && "ip".equals(field2) && value1 != null) {
			result = getDatesForIp(value1, after, before);
		}

		// Вызов метода execute с параметром "get date for user = "[any_user]" and date between "[after]" and "[before]""
		// должен возвращать множество уникальных дат, за которые пользователь [any_user] произвел любое действие
		// в период между датами [after] и [before].
		if ("date".equals(field1) && "user".equals(field2) && value1 != null) {
			result = getDatesForUser(value1, after, before);
		}

		// Вызов метода execute с параметром "get date for event = "[any_event]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных дат, за которые произошло событие равно [any_event]
		// в период между датами [after] и [before].
		if ("date".equals(field1) && "event".equals(field2) && value1 != null) {
			result = getDatesForEvent(Event.valueOf(value1), after, before);
		}

		// Вызов метода execute с параметром "get date for status = "[any_status]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных дат, за которые произошло любое событие со статусом
		// [any_status] в период между датами [after] и [before].
		if ("date".equals(field1) && "status".equals(field2) && value1 != null) {
			result = getDatesForStatus(Status.valueOf(value1), after, before);
		}

		/** EVENT **/
		if ("event".equals(field1) && field2 == null && value1 == null) {
			result = helper.getSetOfEventsDateSorted(logsList, null, null);
		}

		// Вызов метода execute с параметром "get event for ip = "[any_ip]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных событий, которые произошли с IP адреса [any_ip]
		// в период между датами [after] и [before].
		if ("event".equals(field1) && "ip".equals(field2) && value1 != null) {
			result = getEventsForIP(value1, after, before);
		}

		// Вызов метода execute с параметром "get event for user = "[any_user]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных событий, которые произвел пользователь [any_user]
		// в период между датами [after] и [before].
		if ("event".equals(field1) && "user".equals(field2) && value1 != null) {
			result = getEventsForUser(value1, after, before);
		}

		// Вызов метода execute с параметром "get event for date = "[any_date]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных событий, которые произошли во время [any_date]
		// в период между датами [after] и [before].
		if ("event".equals(field1) && "date".equals(field2) && value1 != null) {
			result = getEventsForDate(helper.getDate(value1), after, before);
		}

		// Вызов метода execute с параметром "get event for status = "[any_status]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных событий, которые завершены со статусом [any_status]
		// в период между датами [after] и [before].
		if ("event".equals(field1) && "status".equals(field2) && value1 != null) {
			result = getEventsForStatus(Status.valueOf(value1), after, before);
		}

		/** STATUS **/
		if ("status".equals(field1) && field2 == null && value1 == null) {
			result = helper.getSetOfStatusDateSorted(logsList, null, null);
		}

		// Вызов метода execute с параметром "get status for ip = "[any_ip]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных статусов, которые произошли с IP адреса [any_ip]
		// в период между датами [after] и [before].
		if ("status".equals(field1) && "ip".equals(field2) && value1 != null) {
			result = getStatusForIP(value1, after, before);
		}

		// Вызов метода execute с параметром "get status for user = "[any_user]" and date between "[after]" and
		// "[before]"" должен возвращать множество уникальных статусов, которые произвел пользователь [any_user]
		// в период между датами [after] и [before].
		if ("status".equals(field1) && "user".equals(field2) && value1 != null) {
			result = getStatusForUser(value1, after, before);
		}

		// Вызов метода execute с параметром "get status for date = "[any_date]" and date between "[after]"
		// and "[before]"" должен возвращать множество уникальных статусов, которые произошли во время [any_date]
		// в период между датами [after] и [before].
		if ("status".equals(field1) && "date".equals(field2) && value1 != null) {
			result = getStatusForDate(helper.getDate(value1), after, before);
		}

		// Вызов метода execute с параметром "get status for event = "[any_event]" and date
		// between "[after]" and "[before]"" должен возвращать множество уникальных статусов, у которых событие
		// равно [any_event] в период между датами [after] и [before].
		if ("status".equals(field1) && "event".equals(field2) && value1 != null) {
			result = getStatusForEvent(Event.valueOf(value1), after, before);
		}
		return (Set<Object>) result;
	}
}