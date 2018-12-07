package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
//            File your_file_name = File.createTempFile("human", ".bin");
            File your_file_name = File.createTempFile("human", ".txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            boolean persEquals = ivanov.equals(somePerson);
            System.out.println(persEquals);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    // статичный класс, что бы был доступ к нему в статичном методе main
    public static class Human {
        // поле класса имя
        public String name;
        // поле класса список объектов типа Asset
        public List<Asset> assets = new ArrayList<>();

        // пустой конструктор класса
        public Human() {
        }

        // полный конструктор, принимает имя и неопределенное количество параметров класса Asset
        public Human(String name, Asset... assets) {
            // с именем все понятно
            this.name = name;
            // а вот инициализация множества интересна
            // объекты там складываются автоматически в массив
            // идет проверка что массив не пустой
            if (assets != null) {
                // тогда в список с помощью метода addAll добавляется массив, который другим методом
                // сконвертирован в лист
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        // для сравнения объектов класса реализован свой метод equals
        @Override
        public boolean equals(Object o) {
            // базовая проверка, что переменные указываю на один и тот же объект в памяти
            if (this == o) return true;
            // если ссылка для сравнения подана нулевая или это объекты разных классов, то точно false
            if (o == null || getClass() != o.getClass()) return false;

            // иначе создаю переменную и указываю на объект поданный
            // для сравнения, которому делаю явное приведение типов
            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            // создаю поток для записи объектов в который подаю поток побайтовой записи в файл
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            // записываю в файл поля объекта класса имя и список активов
            objectOutputStream.writeObject(name);
            objectOutputStream.writeObject(assets);
            // принудительная запись всего что есть в файл
            objectOutputStream.flush();
            // закрытие потока
            objectOutputStream.close();
        }

        public void load(InputStream inputStream) throws Exception {
            // создаю объект для чтения объектов из файла в который подаю поток побайтового чтения из файда
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            // читаю объект и делаю явное приведение типа к строке и сохраняю в поле именя объекта
            name = (String) objectInputStream.readObject();
            // читаю объект и делаю явное приведение типа к списку объектов типа Asset и сохраняю в поле списка объекта
            assets = (List<Asset>) objectInputStream.readObject();
            // закрываю поток чтения объектов из файла
            objectInputStream.close();
        }

//        public void save(OutputStream outputStream) throws Exception {
//            // создаю объект записи
//            PrintWriter writer = new PrintWriter(outputStream);
//            // проверяю не пустой ли список, сохраняю метку в переменную
//            String haveAsset = assets != null ? "yes" : "no";
//            // записываю имя объекта
//            writer.println(name);
//            // записываю метку доступности списка активов
//            writer.println(haveAsset);
//            // если список не пуст
//            if (assets != null) {
//                // циклом иду по списку активов
//                for (Asset a : assets) {
//                    // и печатаю поля активов
//                    writer.println(a.getName());
//                    writer.println(a.getPrice());
//                }
//            }
//            writer.flush();
//            writer.close();
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            // создаю объект чтения строк из файла
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            // читаю строку с именем объекта класса
//            name = reader.readLine();
//            // читаю строку с метоко есть ли список активов
//            String haveAsset = reader.readLine();
//            // если список не пуст
//            if (haveAsset.equals("yes")) {
//                // то циклом читаю теперь построчно до конца файла
//                while (reader.ready()) {
//                    // добавляю новые записи в список
//                    String assetName = reader.readLine();
//                    double assetPrice = Double.parseDouble(reader.readLine());
//                    assets.add(new Asset(assetName, assetPrice));
//                }
//            }
//            // чтение закончено, закрываю поток
//            reader.close();
//        }
    }
}
