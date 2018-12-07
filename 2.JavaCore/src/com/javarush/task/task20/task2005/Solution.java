package com.javarush.task.task20.task2005;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Очень странные дела
При чтении/записи объектов типа Human возникают странные ошибки.
Разберись в чем дело и исправь их.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets равен null.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не равны null.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
6. Метод equals должен возвращать true для двух равных объектов типа Human и false для разных.
7. Метод hashCode должен всегда возвращать одно и то же значение для одного и того же объекта типа Human.
*/

public class Solution {
    public static void main(String[] args) {
        //исправь outputStream/inputStream в соответствии с путем к твоему реальному файлу
        try {
            File your_file_name = File.createTempFile("tempFile", ".tmp");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        //  публичное поле имени
        public String name;
        // поле списка объектов типа Asset
        public List<Asset> assets = new ArrayList<>();

        // пустой конструктор
        public Human() {
        }

        // конструктор с параметрами заполнения полей
        // вторым параметром подается массив объектов класса Assets
        public Human(String name, Asset... assets) {
            // инициирую поле имени
            this.name = name;
            // если массив параметров не нулевой
            if (assets != null) {
                // тогда добвляю сразу весь массив в список
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            // сравнение влоб
            // если ссылки на объекты равны, то и сами объекты равны
            if (this == o) return true;
            // если поданная ссылка объекта для сравнения указывает на null
            // или класс текущего объекта не равен классу объекта поданного для сравнения
            // тогда возвращаю false объекты точно не равны
            if (o == null || getClass() != o.getClass()) return false;

            // создаю ссылку на объект сравнения с явным приведением типа
            Human human = (Human) o;

            // если имя не пустой указатель и имя объекта не равно имени поданного объекта, то возвращаю false
            // если же имя пустой указатель и имя поданного объекта не пустой указатель, то возвращаю false
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
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            // проверяю не пустой ли список, сохраняю метку в переменную
            String haveAsset = !assets.isEmpty() ? "yes" : "no";
            // записываю метку доступности списка активов
            printWriter.println(haveAsset);
            printWriter.println(name);
            if (!assets.isEmpty()) {
                for (Asset current : assets) {
                    printWriter.println(current.getName());
                    printWriter.println(current.getPrice());
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // читаю строку с метокой есть ли список активов
            String haveAsset = reader.readLine();
            // читаю имя объекта
            name = reader.readLine();
            // если список не пуст
            if (haveAsset.equals("yes")) {
                // то циклом читаю теперь построчно до конца файла
                while (reader.ready()) {
                    // добавляю новые записи в список
                    String assetName = reader.readLine();
                    double assetPrice = Double.parseDouble(reader.readLine());
                    Asset addAsset;
                    assets.add(addAsset = new Asset(assetName));
                    addAsset.setPrice(assetPrice);
                }
            }
            // чтение закончено, закрываю поток
            reader.close();
//            String assetName;
//            int numOfAssets = 0;
//            while ((assetName = reader.readLine()) != null) {
//                double assetPrice = Double.parseDouble(reader.readLine());
//                assets.add(new Asset(assetName));
//                assets.get(numOfAssets).setPrice(assetPrice);
//                numOfAssets++;
//            }
//            reader.close();
        }
    }
}
