package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
Реализуй логику записи в файл и чтения из файла для класса ClassWithStatic.
Метод load должен инициализировать объект включая статические поля данными из файла.
Метод main не участвует в тестировании.


Требования:
1. Должна быть реализована возможность сохранения/загрузки объектов типа Solution.ClassWithStatic с помощью методов save/load.
2. Класс Solution не должен поддерживать интерфейс Serializable.
3. Класс Solution.ClassWithStatic не должен поддерживать интерфейс Serializable.
4. Класс Solution.ClassWithStatic должен быть публичным.
5. Класс Solution.ClassWithStatic не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File your_file_name = File.createTempFile("tempFile", ".tmp");
            // потоки записи/чтения файла
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            // создаем объек класса
            ClassWithStatic classWithStatic = new ClassWithStatic();
            // полям приваиваем значения
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            // методом класса сохраняем объект в файл
            classWithStatic.save(outputStream);
            outputStream.flush();

            // создаем новый объект
            ClassWithStatic loadedObject = new ClassWithStatic();
            // пробуем присвоить полю staticString значение
            // но уже даже тут среда IDE пишет, что доступ через экземпляр класса не разрешен
            loadedObject.staticString = "something";
            // присваиваю значения полям
            loadedObject.i = 6;
            loadedObject.j = 7;

            // теперь методом load загружаю  данные из файла в объект на котором этот метод вызван
            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            boolean isObjectsEqual = classWithStatic.equals(loadedObject);
            System.out.println(isObjectsEqual);
            System.out.println(ClassWithStatic.staticString);
            System.out.println(classWithStatic.i);
            System.out.println(classWithStatic.j);
            System.out.println(loadedObject.i);
            System.out.println(loadedObject.j);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        // создается статичное поле, которое принадлежит всему классу, а не отдельным объектам
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(staticString);
            printWriter.println(i);
            printWriter.println(j);
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            staticString = bufferedReader.readLine();
            i = Integer.parseInt(bufferedReader.readLine());
            j = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
