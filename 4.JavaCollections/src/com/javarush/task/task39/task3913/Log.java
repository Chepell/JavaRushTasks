package com.javarush.task.task39.task3913;

import java.util.Date;

/**
 * Artem Voytenko
 * 03.12.2018
 */

public class Log {
	private String ip;
	private String user;
	private Date date;
	private Event event;
	private int task;
	private Status status;

	public Log(String ip, String user, Date date, Event event, int task, Status status) {
		this.ip = ip;
		this.user = user;
		this.date = date;
		this.event = event;
		this.task = task;
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getTask() {
		return task;
	}

	public void setTask(int task) {
		this.task = task;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String result;
		if (task == 0) {
			result = String.format("%s %s %s %s %s", ip, user, date, event, status);
		} else {
			result = String.format("%s %s %s %s %s %s", ip, user, date, event, task, status);
		}
		return result;
	}
}
