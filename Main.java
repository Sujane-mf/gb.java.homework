package ru.geekbrains.alg_hw6;

public class Main {

    public static void main(String[] args) {
        Tree<Long>[] trees = new Tree[20];
        for (int i = 1; i < 20; i++) {
            trees[i] = new TreeImpl<>();
            for (int j = 1; j <= 7; j++) {
                long value = Math.round((Math.random() * 50 - 25) * 100) / 100;
                trees[i].add(value);
            }
            //trees[i].display();
            trees[i].traverse(Tree.TraversMode.IN_ORDER);
        }
    }
}