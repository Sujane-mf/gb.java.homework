package ru.geekbrains.j2_homework8;

public interface GbList extends GBIterable {
    void add(String val);
    boolean remove(String val);
    int size();
    String get(int n);

}
