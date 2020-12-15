package ru.geekbrains.j3_homework7;

public class ClassForTesting {

    public ClassForTesting() {
    }

    @BeforeSuite
    public void testBeforeSuite() {
        System.out.println("First case: BeforeSuite");
    }

    @AfterSuite
    public void lastTest() {
        System.out.println("Last case: AfterSuite");
    }

    @Test(priority = 1)
    public void Test1() {
        System.out.println("Case №1");
    }

    @Test(priority = 2)
    public void Test2 () {
        System.out.println("Case №2");
    }

    @Test(priority = 3)
    public void Test3 () {
        System.out.println("Case №3");
    }

    @Test(priority = 4)
    public void Test4 () {
        System.out.println("Case №4");
    }

    @Test(priority = 5)
    public void Test5 () {
        System.out.println("Case №5");
    }

    @Test(priority = 6)
    public void Test6 () {
        System.out.println("Case №6");
    }

    @Test(priority = 7)
    public void Test7 () {
        System.out.println("Case №7");
    }

    @Test(priority = 8)
    public void Test8 () {
        System.out.println("Case №8");
    }

    @Test(priority = 9)
    public void Test9 () {
        System.out.println("Case №9");
    }

    @Test(priority = 10)
    public void Test10 () {
        System.out.println("Case №10");
    }
}
