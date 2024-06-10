public class MyHashTable {
    private int capacity;
    private int size;

    private Node[] table;
    private static class Node {
        private final String key;
        private final String value;
        private Node next;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Node[capacity];
    }
    private int hash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 31 * hash + key.charAt(i);
        }
        return Math.abs(hash);
    }

    public void put(String key, String value) {
        int index = hash(key) % capacity;
        Node newNode = new Node(key, value);
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return;
            }
            current = current.next;
        }
        newNode.next = table[index];//лежит справа значения
        table[index] = newNode;//сама ячейка равна новому элементу
        size++;
        if (size >= capacity * 0.75) {
            resize();
        }
    }

    private void resize() {
        capacity *= 2;
        Node[] newTable = new Node[capacity];
        for (Node node : table) {
            Node current = node;
            while (current != null) {
                Node next = current.next;
                int index = hash(current.key) % capacity;
                current.next = newTable[index];
                newTable[index] = current;
                current = next;
            }
        }

        table = newTable;
    }

    public void remove(String key) {
        int index = hash(key) % capacity;
        Node current = table[index];
        Node prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    table[index] = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Некорректный ключ");
    }

    public String get(String key) {
        int index = hash(key) % capacity;
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Некорректный ключ");
    }
    public void display() {
        System.out.println("____Hash Table____");
        String[] var1 = keys();

        for (String key : var1) {
            System.out.println(key + " | " + get(key));
        }
    }
    public String[] keys() {
        String[] keys = new String[size];
        int index = 0;
        for (Node node : table) {
            Node current = node;
            while (current != null){
                keys[index] = current.key;
                index++;
                current = current.next;
            }
        }
        return keys;
    }
}
