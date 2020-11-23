package ru.geekbrains.j3_homework1_fruits_and_boxes;
/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
*/
/*
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо) +
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
поэтому в одну коробку нельзя сложить и яблоки, и апельсины;+
c. Для хранения фруктов внутри коробки можете использовать ArrayList;+
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);+
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
которую подадут в compare в качестве параметра, true - если их веса равны,
false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);+
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.+
 */
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    // 1 и 2 задание
    	Integer[] arr1 = new Integer[]{1,2,3,5};
    	String[] arr2 = new String[]{"один", "два", "три", "четыре"};
    	changePosition(arr1, 2,1);
		changePosition(arr2, 1,3);
		List<Integer> list1 = arrAsList(arr1);
		List<String> list2 = arrAsList(arr2);
		System.out.println(list1.getClass() + " состоящий из элементов: " + list1);
		System.out.println(list1.getClass() + " состоящий из элементов: " + list2);

   // коробки и фрукты

	Apple apple = new Apple(1f);
	Apple apple2 = new Apple(2f);
	Apple apple3 = new Apple(1.5f);
	Apple apple4 = new Apple(2f);
	Apple apple5 = new Apple(1.5f);
	System.out.println(apple.getWeight());
	Orange orange = new Orange(1.5f);
	Orange orange2 = new Orange(2.5f);
	Box<Apple> boxOfApples = new Box<>();
	Box<Apple> boxOfApples2 = new Box<>();
	Box<Orange> boxOfOrranges = new Box<>();
	boxOfApples.add(apple);
	boxOfApples.add(apple2);
	boxOfApples2.add(apple4);
	boxOfApples2.add(apple5);
	boxOfOrranges.add(orange);
	boxOfOrranges.add(orange2);
	boxOfApples.getWeight();
	boxOfOrranges.getWeight();
		System.out.println("Получившаяся коробка яблок: " + boxOfApples);
		System.out.println("Получившаяся коробка апельсинов: " + boxOfOrranges);
	Box<Apple> newBox = new Box<>();
		boxOfApples.moveTo(newBox);
		System.out.println("Старая коробка яблок: " + boxOfApples);
		System.out.println("Новая коробка яблок: " + newBox);
	newBox.add(apple3);
	newBox.getWeight();
	boxOfApples2.getWeight();
		System.out.println("Новая коробка яблок: " + newBox);
		System.out.println("Коробка яблок для сравнения: " + boxOfApples2);

		if (newBox.compare(boxOfApples2)){
			System.out.println("Коробки одинаковые");
		} else {
			System.out.println("Коробки разные");
		}


    }

	//метод для замены элементов
	public static <T> void changePosition(T[] arr,int ind1, int ind2){
		System.out.println(Arrays.toString(arr));
		T temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
		System.out.println(Arrays.toString(arr));
	}
	//метод для преобразования в Arraylist
	public static <E> List<E> arrAsList(E[]arr){
		return Arrays.asList(arr);
	}
}
