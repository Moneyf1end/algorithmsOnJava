class Node {
    public Object value;
    public Node next;


    Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }
}


class LinkedList {
    private int amountOfNodes = 0;
    public int getamountOfNodes() {
        return amountOfNodes;
    }
    public Node head = null;

    public void add(Object value) {
        head = new Node(value, head);
        amountOfNodes++;
    }

    public void insert(int index, Object value) {
        if (head == null) {
            head = new Node(value, null);
        } else if (index == 0) {
            add(value);
        } else {
            Node current = head;
            while (current.next != null && index > 1) {
                current = current.next;
                index = index - 1;
            }
            current.next = new Node(value, current.next);
            amountOfNodes++;
        }

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) System.out.print(" → ");
            current = current.next;
        }
        System.out.println();
    }
}
