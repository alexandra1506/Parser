package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        ArrayList<String> list = new ArrayList<>(); // лист для имен переменных
        //напишите тут ваш код
        String copystr = url.substring((url.indexOf("?"))+1); //убираю лишнее
        String valueObj = null; //для запоминания значения obj
        String[] arrString = copystr.split("&");
        for(int i = 0; i < arrString.length; i++){//идем по строкам вида "переменная=значение" и вытаскиваем переменные
            if(arrString[i].contains("=")) {
                String element = arrString[i].substring(0, arrString[i].indexOf("=")); // если знак "равно" есть то берем переменную до знака равно
                list.add(element); // и кладем в лист
                if (element.equals("obj")) { // запоминаем значение obj для дальнейшей работы
                    valueObj = arrString[i].substring(arrString[i].indexOf("=") + 1, arrString[i].length() - 1);
                }
            } else list.add(arrString[i]); // если равно нету, то просто переменную кладем в лист
        }

        for(String str: list){
            System.out.print(str + " ");
        }

        System.out.println();
        if(!(valueObj == null)) {
            try {
                Double value = Double.parseDouble(valueObj); // Double метод
                alert(value);
            } catch (Exception e) {
                alert(valueObj); //String метод
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}