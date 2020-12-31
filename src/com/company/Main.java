package com.company;

public class Main {

    public static void main(String[] args) {
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringData = "5 7 3 9 8 2 0 4 6";

        String[] data = stringData.split(" ");
        for (String s: data){
            //create new item with value set to String s
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());
    }
}
