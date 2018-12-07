package com.javarush.task.task15.task1524;

/* 
Порядок загрузки переменных
Разберись, что и в какой последовательности инициализируется.
Поставь брейкпойнты и используй дебаггер.

Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name


Требования:
1. Программа должна выводить данные на экран.
2. Вывод на экран должен соответствовать условию задачи.
3. Результатом работы статического инициализатора класса
    Solution должен быть вывод на экран строк "static void init()" и "Static block".
4. Программа не должна считывать данные с клавиатуры.
*/
public class Solution {
    // 1. static-блок инициируется первым
    static {
        init();
    }
    // 7. Обрабатывается анонимный блок
    {
        System.out.println("non-static block");
        // 8. Вызов метода
        printAllFields(this);
    }
    // 12. Теперь инициируются поля значениями по умолчанию
    public int i = 6;
    public String name = "First name";
    // 3. еще один статик-блок, если несколько то инициализация сверху вниз
    static {
        System.out.println("Static block");
    }
    // 6. В конструкторе класса сразу инициируется анонимный блок
    public Solution() {
        // 13. Теперь наконец зашли в конструктор
        System.out.println("Solution constructor");
        // 14. Повторный вызов метода
        printAllFields(this);
    }
    // 2. блок статик вызывает этот метод. Если бы не вызов из
    // статик-блока, то метод бы вообще не сработал бы
    public static void init() {
        System.out.println("static void init()");
    }
    // 4. Далее инициируется статик-метод main
    public static void main(String[] args) {
        System.out.println("public static void main");
        // 5. Обращение к конструктору класса
        Solution s = new Solution();
    }
    // 9. Переход к методу из анонимного блока
    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        // 10. i инициирована по умолчанию, поэтому 0
        // 14. поля уже были инициированы значениями
        System.out.println(obj.i);
        // 11. name так же инициированна по умолчанию null
        // 15. И тут уже не null
        System.out.println(obj.name);
    }
}
