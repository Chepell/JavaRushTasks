package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        try {
            // Создается временный файл в TEMP папке
            File your_file_name = File.createTempFile("fileIO", ".tmp");
            // создаю потоки записи в файл и чтения из него
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            // создаю объект класса javaRush
            JavaRush javaRush = new JavaRush();
            // добаляются объекты класса User
            javaRush.users.add(new User());
            // т.к. конструктор не определен то все поля заполняются через сеттеры
            javaRush.users.get(0).setFirstName("Artem");
            javaRush.users.get(0).setLastName("Voytenko");
            javaRush.users.get(0).setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("03-08-1983"));
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.RUSSIA);
            // еще один объект добавляется
            javaRush.users.add(new User());
            javaRush.users.get(1).setFirstName("Olga");
            javaRush.users.get(1).setLastName("Bublik");
            javaRush.users.get(1).setBirthDate(new SimpleDateFormat("dd-MM-yyyy").parse("29-07-1988"));
            javaRush.users.get(1).setMale(false);
            javaRush.users.get(1).setCountry(User.Country.OTHER);
            // сохраняю объект в файл
            javaRush.save(outputStream);
            // принудительно пишу данные из буфера
            outputStream.flush();

            // создаю новый объект класса
            JavaRush loadedObject = new JavaRush();
            // загружаю данные из файла в сохданный объект
            loadedObject.load(inputStream);
            // проверка равенства созданного объекта и загруженного
            boolean isEqual = javaRush.equals(loadedObject);
            System.out.println(isEqual);
            // закрываю все потоки
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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            // создаю поток записи в файл строк
            PrintWriter printWriter = new PrintWriter(outputStream);
            // создаю флаг наличия записей в списке т.к. списко в любом случае существует
            String listNotEmpty = !users.isEmpty() ? "yes" : "no";
            // пишу флаг в файл
            printWriter.println(listNotEmpty);
            // если список не пустой
            if (!users.isEmpty()) {
                // то циклом прохожу по каждому элементу списка
                for (User user : users) {
                    // печаютаю значения построчно в файл
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
                            .format(user.getBirthDate()));
                    printWriter.println(Boolean.toString(user.isMale()));
                    printWriter.println(user.getCountry().toString());
                }
                // если список пустой, то не нужно null данные писать в файл
            }
            // принудительно пишу все из буфера
            printWriter.flush();
            // закрываю поток
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            // поток для чтения из файла по строкам
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // читаю первую строку, где находится флаг того, есть ли в списке данные, есть ли что читать
            String readListFlag = bufferedReader.readLine();
            // если данные есть
            if ("yes".equals(readListFlag)) {
                // цикл построчного чтения файла
                // указатель на элмент в списке
                int element = 0;
                while (bufferedReader.ready()) {
                    users.add(new User());
                    users.get(element).setFirstName(bufferedReader.readLine());
                    users.get(element).setLastName(bufferedReader.readLine());
                    users.get(element).setBirthDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
                            .parse(bufferedReader.readLine()));
                    users.get(element).setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                    users.get(element).setCountry(User.Country.valueOf(bufferedReader.readLine()));
                    // инкрементирую указатель что бы на следующем круге писать в следующий объект списка
                    element++;
                }
                // если данных нет, то ничего не записываю в объект
            }
            // в конце надо закрыть поток чтения
            bufferedReader.close();

        }
        // переопределение метода сравнения объектов
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
