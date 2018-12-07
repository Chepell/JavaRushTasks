package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки
Асинхронность выполнения нитей.
1. Класс Note будет использоваться нитями.
2. Создай public static нить NoteThread (Runnable не является нитью),
которая в методе run 1000 раз (index = 0-999) сделает следующие действия:
2.1. Используя метод addNote добавит заметку с именем
[getName() + "-Note" + index], например, при index=4 "Thread-0-Note4"
2.2. Заснет на 1 миллисекунду
2.3. Используя метод removeNote удалит заметку
2.4. В качестве параметра в removeNote передай имя нити - метод getName()


Требования:
1. Класс Solution должен содержать public static класс NoteThread.
2. Класс NoteThread должен быть нитью.
3. В методе run класса NoteThread должен быть цикл.
4. Метод run класса NoteThread должен 1000 раз вызывать метод addNote c параметром (getName() + "-Note" + index).
5. Метод run класса NoteThread должен 1000 раз вызывать Thread.sleep() c параметром (1).
6. Метод run класса NoteThread должен 1000 раз вызывать метод removeNote c параметром (getName()).
*/

public class Solution {
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    // статичный класс с методами наполнения списка и удаления объектов из него
    // без создания объектов
    public static class Note {
        // список статичный и неизменяемый
        public static final List<String> notes = new ArrayList<>();

        // метод добавляет аргумент в качестве строки в начало списка
        public static void addNote(String note) {
            notes.add(0, note);
        }

        // метод из заданного потока удаляет первый элемент списка
        public static void removeNote(String threadName) {
            // удаляя элемент сохраняем его в строку
            String note = notes.remove(0);
            // если там null, то кто-то уже до нас удалил элемент
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
                // если удаленная строка не начинается с поданного в качестве аргумента имени
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                Note.addNote(getName() + "-Note" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Note.removeNote(getName());
            }
        }
    }

}
