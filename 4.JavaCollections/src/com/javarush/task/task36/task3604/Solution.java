package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {

        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(10);
        redBlackTree.insert(15);

        RedBlackTree.Node current = redBlackTree.current;
        System.out.println(current);

    }
}
