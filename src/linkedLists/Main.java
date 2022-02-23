package linkedLists;

public class Main {
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        int count = 1;
        if(Node.head == null){
            Node n = new Node(value);
            Node.head = n;
            return;
        }
        Node h = Node.head;
        while( count < position - 1 && h.next != null) {
            h = h.next;
            count++;
        }
        Node temp = h.next;
        Node n = new Node(value);
        h.next = n;
        n.next = temp;

    }

    public static void delete_node(int position) {
        // @params position, integer
        if(Node.head == null) return;
        if(position == 1){
            Node.head = Node.head.next;
            return;
        }
        int count = 1;
        Node h = Node.head;
        while(count < position - 1 && h.next != null){
            h = h.next;
            count++;
        }
        if(h.next != null)
        h.next = h.next.next;
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node h = Node.head;
        while(h != null) {
            System.out.println(h.value);
            h = h.next;
        }
    }

    static class Node {
        int value;
        Node next;
        static Node head;

        public Node(int data) {
            this.value = data;
            next = null;
            if(head == null) {
                head = this;
            }
        }
    }

    public static void main(String[] args) {
        insert_node(1,1);
        insert_node(2,2);
        insert_node(3,3);
        insert_node(4,4);
        insert_node(5,5);
        delete_node(3);
        delete_node(2);


        print_ll();

    }
}
