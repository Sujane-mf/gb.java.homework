package ru.geekbrains.j3_homework7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args){
	ClassForTesting classForTesting = new ClassForTesting();
	Class<? extends ClassForTesting> aClass = classForTesting.getClass();
	    for (Method method : aClass.getDeclaredMethods()){
	        for (Annotation annotation : method.getDeclaredAnnotations()){
            System.out.println(annotation);
            }
        }
    try {
        start(aClass);
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e){
        e.printStackTrace();
        }
    }

    public static void start(Class aClass) throws InvocationTargetException, IllegalAccessException {

        if (!countMethodBeforeAndAfter(aClass)) {
            throw new RuntimeException();
        }
        Map<Integer, Method> map = new TreeMap<>();
        int min_priority = 1;
        int max_priority = 10;

        for (Method method : aClass.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                map.put(min_priority - 1, method);
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                map.put(max_priority + 1, method);
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method);
            }
        }

        System.out.println("Тестовый набор, отсортированный по приоритетам");
        for (Integer key : map.keySet()) {
            System.out.println("priority:" + key + " " + map.get(key).getName());
        }

        ClassForTesting classForTesting = new ClassForTesting();
        for (Integer key : map.keySet()) {
            map.get(key).invoke(classForTesting);
        }

    }

    // метод для подсчета количества методов с аннотациями BeforeSuite и AfterSuite
    private static boolean countMethodBeforeAndAfter(Class aClass){
        int countB = 0;
        int countA = 0;
        for (Method m : aClass.getDeclaredMethods()){
            if (m.getAnnotation(BeforeSuite.class) != null) {
                countB++;
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                countA++;
            }
            }
        if (countA > 1 && countB > 1){
            return false;
        } else return true;
        }
    }

