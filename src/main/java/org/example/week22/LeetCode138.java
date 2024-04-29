package org.example.week22;

public class LeetCode138 {
    public Node copyRandomList(Node head) {
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;

            current = current.next.next;
        }
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        current = head;
        Node prev = new Node(0);
        Node prevHead = prev;
        while (current != null) {
            prev.next = current.next;
            current.next = current.next.next;
            prev = prev.next;
            current = current.next;
        }
        return prevHead.next;
    }
}
