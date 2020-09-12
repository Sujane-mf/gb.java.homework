package ru.geekbrains.homework5;

public class Employee
{
    String fullName;
    String position;
    String email;
    int salary;
    int age;
    Employee (String fullName, String position, String email, int salary, int age)
        {
            this.fullName = fullName;
            this.position = position;
            this.email = email;
            this.salary = salary;
            this.age = age;
        }
    void printInfo()
        {
                System.out.println("Должность: " + position);
                System.out.println("ФИО: " + fullName);
                System.out.println("email: " + email);
                System.out.println("Зарплата: " + salary);
                System.out.println("Возраст: " + age);
        }
}
