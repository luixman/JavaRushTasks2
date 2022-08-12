package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();



    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node current = new Node();
        current.value = value;

        if (first.next == null && last.prev == null) {
            first.next = current;
            last.prev = current;
        }

        Node lastNode = last.prev;
        lastNode.next = current;
        current.prev = lastNode;
        last.prev = current;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
