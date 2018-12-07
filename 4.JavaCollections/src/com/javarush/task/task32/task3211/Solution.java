package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.constants.AsmConstants.S;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); // исходяший байтолвый массив
        ObjectOutputStream oos = new ObjectOutputStream(bos); // байтовый массив оборачиваю в поток записи объектов
        oos.writeObject(new String("test string")); // запись объекта
        oos.flush(); // принудительное продавливание в байтовый массив
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        String digest;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(byteArrayOutputStream.toByteArray());
        //converting byte array to Hexadecimal String
        StringBuilder sb = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            sb.append(String.format("%02x", b & 0xff));
        }
        digest = sb.toString();
        return digest.equals(md5);
    }
}