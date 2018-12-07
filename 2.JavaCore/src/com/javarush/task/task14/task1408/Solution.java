package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
Написать Фабрику(Factory) по производству кур(Hen):

1. Создать класс Hen.
1.1. Сделать его абстрактным.
1.2. Добавить в класс абстрактный метод int getCountOfEggsPerMonth().
1.3. Добавить в класс метод String getDescription(), который возвращает строку "Я - курица.".
2. Создать класс RussianHen, который наследуется от Hen.
3. Создать класс UkrainianHen, который наследуется от Hen.
4. Создать класс MoldovanHen, который наследуется от Hen.
5. Создать класс BelarusianHen, который наследуется от Hen.
6. В каждом из четырех последних классов написать свою реализацию метода getCountOfEggsPerMonth.
Методы должны возвращать количество яиц в месяц от данного типа куриц.
7. В каждом из четырех последних классов написать свою реализацию метода getDescription.

Методы должны возвращать строку вида:
<getDescription() родительского класса> + <" Моя страна - Sssss. Я несу N яиц в месяц.">
где Sssss - название страны
где N - количество яиц в месяц

8. В классе HenFactory реализовать метод getHen, который возвращает соответствующую стране породу кур.
9. Все созданные вами классы должны быть в отдельных файлах.


Требования:
1. Класс Hen должен быть абстрактным.

2. Класс Hen должен содержать абстрактный метод int getCountOfEggsPerMonth().

3. В классе Hen должен быть реализован метод String getDescription(), который возвращает строку "Я - курица.".

4. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны
    наследоваться от класса Hen и быть созданы в отдельных файлах.

5. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны
    реализовывать метод getCountOfEggsPerMonth, который должен возвращать количество яиц в месяц от данного типа куриц.

6. Классы RussianHen, UkrainianHen, MoldovanHen и BelarusianHen должны
    переопределять метод getDescription родительского класса, таким образом,
    чтобы возвращаемая ими строка имела вид: + < Моя страна - Sssss. Я несу N яиц в месяц.>
    где Sssss - название страны, а N - количество яиц в месяц.

7. Метод getHen должен быть реализован в классе HenFactory и должен возвращать тип кур для переданной в него страны.
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    // класс с реализацией интерфейса Country
    public static class HenFactory implements Country {
        // метод статичный, объект для его вызова создавать не нужно
        // метод создает и возвращает объект соответствующего класса исходя из страны указанной аргументом
        static Hen getHen(String country) {
            // создаю узатель на объект класса и инициирую его нулем
            Hen hen = null;
            if (country.equals(RUSSIA)) {
                return hen = new RussianHen();
            } else if (country.equals(UKRAINE)) {
                return hen = new UkrainianHen();
            } else if (country.equals(MOLDOVA)) {
                return hen = new MoldovanHen();
            } else if (country.equals(BELARUS)) {
                return hen = new BelarusianHen();
            } else {
                return hen;
            }
        }
    }
}