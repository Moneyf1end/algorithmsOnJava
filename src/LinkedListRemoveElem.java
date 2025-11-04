public class LinkedListRemoveElem {
    /* I did here only methods for removing items
       we have the same realization of inner body like in class LinkedList and Node
     */
    public Object remove() {
        if (head == null) return null;

        var value = head.value;
        head = head.next;
        return value;
    }
    public Object removeAt(int index) {
        if (head == null) {
            return null;
        } else if (index == 0 || head.next == null) {
            return remove();
        } else {
            var current = this.head;
            while (current.next.next != null && index > 1) {
                current = current.next;
                index = index - 1;
            }

            var value = current.next.value;
            current.next = current.next.next;

            return value;
        }
    }

}
