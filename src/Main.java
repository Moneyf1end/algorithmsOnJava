import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // *** Binary search ***
        /* implementation of binary search
           input : array + key
           have to compare key with mid
           class Second just for fun and use generics, wildcards
         */
        BinarySearch<Integer> binaryExample = new BinarySearch<Integer>(52);
        System.out.println("Your binaryNumber is " + binaryExample.getNumber());
        int ex = BinarySearch.binarySearch(new int[] {3, 6, 9, 10, 15, 19, 25, 35, 56, 79, 95}, 79);
        System.out.println("Index of your key is " + ex);

        Second<Integer, Integer> second = new Second<>(43, 56);
        System.out.println("Money:  " + second.getMoney());
        second.getCash(new Second<Integer, Integer>(60, 88));


        // *** Linked List ***
        /* implementation of linked list
           we can insert element to the beginning, to the middle or to the end
           create a new node if list is clear(new Node())
           to the beginning we use method add(value) to create a new node
           whose next -> gonna be previous head(value, next -> null)
         */

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(35);
        list.add(40);
        list.add(10);
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(3);
        list.print();

        System.out.println("Amount " + list.getamountOfNodes());

        list.insert(3, 8);
        list.insert(0, 69);
        System.out.println("Amount " + list.getamountOfNodes());

        list.print();


        // *** Stack ***
        /* Stack implementation with Dijkstra`s 2 stack algorithm
            main idea of this algorithm is to collect values into value stack
            and operators into operator stack
            Operator "(" : ignore
            Operator ")" : pop operator and 2 values, push the result of applying that
            operator to those values onto the operator stack
         */

        StackRealize<String> ops = new StackRealize<String>();
        StackRealize<Double> vals = new StackRealize<Double>();

        String example = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String[] splitFromExample = example.split(" ");

        for (int i = 0; i < splitFromExample.length; i++) {
            if (splitFromExample[i].equals("("))
                ;
            else if (splitFromExample[i].equals("+")) ops.push(splitFromExample[i]);
            else if (splitFromExample[i].equals("*")) ops.push(splitFromExample[i]);
            else if (splitFromExample[i].equals(")")) {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop())
                        ;
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            } else vals.push(Double.parseDouble(splitFromExample[i]))
                    ;
        }
        System.out.println(vals.pop());


        // *** Binary heap or Heap-ordered Binary tree ***
        /* implementation:
        Keys in nodes and Parent`s key no smaller than children`s key`s
        In this realization we can use array indices to move through tree:
        1) Parent of node k is at k / 2.
        2) Children of node k are at 2 * k and 2 * k + 1

        We have two different scenarios here:
        First one(method swim) - Child`s key becomes LARGER than its parent`s key and to solve this:
        1) Exchange key in child with key in parent
        2) Repeat until heap order restored

        And Second one(method sink) - Parent`s key SMALLER and to solve this:
        1) Exchange key in parent with key in LARGER CHILD

        Also, we have (insert) method: Add node at the end, then swim it up (cost: at most 1 + lgN compares)
        And method (delMax): Exchange root with node at the end, then sink it down (cost: at most 2lgN compares)

        Moreover, for more flexibility added methods resize, isEmpty, exchange, less, showInfo.
         */
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(new Integer[]{10, 20, 30, 40, 50});
        binaryHeap.insert(20);
        binaryHeap.showInfo();
        System.out.println(binaryHeap.delMax());
        binaryHeap.insert(100);
        binaryHeap.showInfo();
    }
}