public class ThisExample {
    private int value;
    private ThisExample next;

    public ThisExample(int value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(ThisExample next) {
        this.next = next;
    }

    public ThisExample getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        ThisExample node1 = new ThisExample(10);
        ThisExample node2 = new ThisExample(20);
        
        // Linking nodes using 'this'
        node1.setNext(node2);
        
        System.out.println("Node1 Value: " + node1.getValue());
        System.out.println("Node2 Value (via Node1): " + node1.getNext().getValue());
    }
}