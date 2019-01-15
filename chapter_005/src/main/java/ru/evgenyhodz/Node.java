package ru.evgenyhodz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 09.03.2017
 */
public class Node {

    private int value;

    private Node next;

    private Node head;

    public Node(int value, Node next, Node head) {
        this.value = value;
        this.next = next;
        this.head = head;
    }

    public int sum(Node start) {
        int result = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (Node temp = start; temp != null; temp = temp.next) {
            if (!list.contains(temp.value)) {
                list.add(temp.value);
            }
        }
        for (Integer value : list) {
            result += value;
        }
        return result;
    }

    public boolean connectTo(Node node) {
        boolean result = false;
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.equals(node)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node node4 = new Node(1, null, null);
        Node node3 = new Node(1, node4, null);
        Node node2 = new Node(2, node3, null);
        Node node1 = new Node(1, node2, null);

        System.out.println(node1.sum(node1));
    }
}
