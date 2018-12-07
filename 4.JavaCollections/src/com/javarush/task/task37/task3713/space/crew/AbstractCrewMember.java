package com.javarush.task.task37.task3713.space.crew;

/**
 * Необходимо срочно исправить поведение программы,
 * ведь полы может помыть и юнга, а приказ "к бою!" может дать только капитан.
 * <p>
 * P.S. Постарайся реализовать метод handleRequest таким образом,
 * чтобы при добавлении новых должностей нам не требовалось вносить в него изменения. Другие методы не трогай.
 * <p>
 * P.P.S. Все enum поддерживают интерфейс Comparable.
 * <p>
 * <p>
 * Требования:
 * 1. Запрос должен быть обработан текущим членом команды, если это возможно.
 * 2. Запрос должен быть передан по цепочке выше, если текущий член команды не может его обработать.
 * 3. Классы CabinBoy, Engineer, FirstMate и Captain должны быть потомками класса AbstractCrewMember.
 * 4. Класс AbstractCrewMember должен быть абстрактным.
 */
public abstract class AbstractCrewMember {
	public enum CompetencyLevel {
		NOVICE,
		INTERMEDIATE,
		ADVANCED,
		EXPERT
	}

	protected CompetencyLevel competencyLevel;

	protected AbstractCrewMember nextCrewMember;

	public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
		this.nextCrewMember = nextCrewMember;
	}

	// в абстрактном классе реализован метод поиска подходящего обработчика по цепочке ответственности
	public void handleRequest(CompetencyLevel competencyLevel, String request) {
		// если компетенция текущего объекта соответствует переданному параметру
		if (this.competencyLevel == competencyLevel) {
			// то обрабатываю сам
			doTheJob(request);
		} else if (nextCrewMember != null) { // проверяю есть ли следующий член команды
			// иначе на следующем члене команды вызываю рекурсивно этот же метод обработчика событий
			nextCrewMember.handleRequest(competencyLevel, request);
		} else {
			System.out.println("Никто не может вам помочь!");
		}
	}

	protected abstract void doTheJob(String request);
}
