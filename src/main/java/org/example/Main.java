package org.example;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.addFirst("Hello");
        System.out.println(linkedList);
    }
}