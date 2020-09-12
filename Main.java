package ru.geekbrains.homework5;

public class Main {

    public static void main(String[] args) {
    Employee [] empGroupMember = new Employee[5];
    empGroupMember[0] = new Employee("Иванов Иван Иванович", "Генеральный директор", "IIIvanov@company.ru", 150000, 45);
    empGroupMember[1] = new Employee("Петров Петр Петрович", "инженер", "PPPetrov@company.ru", 80000, 37);
    empGroupMember[2] = new Employee("Сидорова Ирина Павловна", "бухгалтер", "IPSidorova@company.ru", 75000, 42);
    empGroupMember[3] = new Employee("Павлова Татьяна Валерьевна", "администратор", "TVPavlova@compeny.ru", 40000, 23);
    empGroupMember[4] = new Employee("Снигирева Елена Васильевна", "дизайнер", "EVSnigireva@company.ru", 60000, 33);
    for (int i = 0; i < empGroupMember.length; i++)
        {
        if (empGroupMember[i].age > 40) {
            empGroupMember[i].printInfo();
            System.out.println();
        }
        }

    }
}
