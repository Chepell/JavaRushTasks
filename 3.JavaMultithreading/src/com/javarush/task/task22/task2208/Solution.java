package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
//        Map<String, String> testMap = new LinkedHashMap<>();
//        testMap.put("name", "Ivanov");
//        testMap.put("country", "Ukraine");
//        testMap.put("city", "Kiev");
//        testMap.put("age", null);
//
//        String str = getQuery(testMap);
//        System.out.println(str);
    }

    public static String getQuery(Map<String, String> params) {
        String key;
        String value;
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            counter++;
            key = pair.getKey();
            value = pair.getValue();
            if (value != null && counter == 1) {
                sb.append(key).append(" = '").append(value).append("'");
            } else if (value != null && counter != 1) {
                sb.append(" and ").append(key).append(" = '").append(value).append("'");
            }
        }
        return sb.toString();
    }
}
