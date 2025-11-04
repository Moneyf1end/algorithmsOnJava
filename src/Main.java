//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
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
    }
}