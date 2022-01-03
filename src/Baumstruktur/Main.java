package Baumstruktur;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TreeNode tree = new Tree(4);
        tree.addSorted(3);
        tree.addSorted(59);
        tree.addSorted(30);
        tree.addSorted(1);

        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(34);
        liste.add(2);
        liste.add(5);
        liste.add(30);
        liste.forEach(n-> System.out.println(n));

    }

}
