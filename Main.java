package ru.geekbrains.j2_homework2;
/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
, и вывести результат расчета.
 */
public class Main {

    public static void main(String[] args) {
	String [][] array = new String[2][2];
	try{
	    CheckArr.checkArrSize(array);
    }catch (MyArraySizeException e){
	    System.out.println(e.getMessage());
    }
	CheckArr.fillTheArr(array);
	CheckArr.printArr(array);
		try{CheckArr.convertAndSum(array);}
	catch (MyArrayDataException e2){
	System.out.println(e2.getMessage());
}
    }
}
