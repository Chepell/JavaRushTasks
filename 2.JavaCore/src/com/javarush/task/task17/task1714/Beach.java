package com.javarush.task.task17.task1714;

/* 
Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach.
Пляжи(Beach) будут использоваться нитями, поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число,
которое показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше.


Требования:
1. Класс Beach должен содержать три поля: String name, float distance, int quality.
2. Класс Beach должен реализовывать интерфейс Comparable.
3. Метод compareTo класса Beach как минимум должен учитывать качество пляжа и дистанцию.
4. Все методы класса Beach, кроме метода main, должны быть синхронизированы.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество
    // конструктор
    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }
    public synchronized void setName(String name) {
        this.name = name;
    }
    public synchronized float getDistance() {
        return distance;
    }
    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }
    public synchronized int getQuality() {
        return quality;
    }
    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
    public static void main(String[] args) {
    }
    // переопределение метода сортировки объктов класса пляж
    @Override
    public synchronized int compareTo(Beach o) {
        float thisCoef = this.quality / this.distance;
        float oCoef = o.quality / o.distance;

        if (thisCoef > oCoef) {
            return 1;
        } else if (thisCoef < oCoef) {
            return -1;
        } else {
            return 0;
        }
//        return Float.compare(thisCoef, oCoef);
    }
}
