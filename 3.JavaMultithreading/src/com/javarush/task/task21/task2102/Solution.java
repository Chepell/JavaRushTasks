package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
Реализовать логику метода isAllModifiersContainSpecificModifier,
который проверяет, содержит ли переданный параметр allModifiers значение конкретного модификатора specificModifier.

P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов isPublic, isStatic и т.п.


Требования:
1. Метод isAllModifiersContainSpecificModifier должен быть статическим.
2. Метод isAllModifiersContainSpecificModifier должен возвращать значение типа boolean.
3. Метод isAllModifiersContainSpecificModifier должен принимать два параметра типа int.
4. Метод isAllModifiersContainSpecificModifier должен возвращать корректное значение
    в соответствии с условием задачи(true, если заданный модификатор присутствует в allModifiers, иначе false).
*/
public class Solution {
    public static void main(String[] args) {
        int modifiersOfThisClass = Solution.class.getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.PUBLIC));   //true
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfThisClass, Modifier.STATIC));   //false

        int modifiersOfMethod = getMainMethod().getModifiers();
        System.out.println(isAllModifiersContainSpecificModifier(modifiersOfMethod, Modifier.STATIC));      //true

        System.out.println(Modifier.isStatic(modifiersOfMethod));
//        String binare = Integer.toBinaryString(modifiersOfMethod);
//        binare = String.format("%8s", binare);
//        binare = binare.replace(" ", "0");
//        System.out.println(binare);
    }


//    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
//        // на самом деле в int соединено несколько модификаторов т.е. реальные значения 16ти байтовые
//        //
//        if ((allModifiers & specificModifier) != 0) {
//            return true;
//        }
//        return false;
//    }

    public static boolean isAllModifiersContainSpecificModifier(int allModifiers, int specificModifier) {
        switch (specificModifier) {
            case Modifier.PUBLIC:
                if (Modifier.isPublic(allModifiers)) return true;
                break;

            case Modifier.PRIVATE:
                if (Modifier.isPrivate(allModifiers)) return true;
                break;

            case Modifier.PROTECTED:
                if (Modifier.isProtected(allModifiers)) return true;
                break;

            case Modifier.STATIC:
                if (Modifier.isStatic(allModifiers)) return true;
                break;

            case Modifier.FINAL:
                if (Modifier.isFinal(allModifiers)) return true;
                break;

            case Modifier.SYNCHRONIZED:
                if (Modifier.isSynchronized(allModifiers)) return true;
                break;

            case Modifier.VOLATILE:
                if (Modifier.isVolatile(allModifiers)) return true;
                break;

            case Modifier.TRANSIENT:
                if (Modifier.isTransient(allModifiers)) return true;
                break;

            case Modifier.NATIVE:
                if (Modifier.isNative(allModifiers)) return true;
                break;

            case Modifier.INTERFACE:
                if (Modifier.isInterface(allModifiers)) return true;
                break;

            case Modifier.ABSTRACT:
                if (Modifier.isStrict(allModifiers)) return true;
                break;
        }
        return false;
    }


    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
