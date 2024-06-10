import java.util.function.Predicate;

public class ILinkedList implements IList {
    private static class Node {
        Node next;
        int payload;
        public Node (int payload) {
            this.payload = payload;
            next = null;
        }
    }
    private Node head;
    int size;
    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
        size ++;
    }

    @Override
    public void add(int index, int value) {
        Node currentNode = head;
        if (index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        } else if (index == 0) {
            Node node = new Node(value);
            node.next = currentNode;
            head = node;
        }
        int counter = 0;
        index--;
        while (counter < index) {
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("Некорректный индекс");
            }
            currentNode = currentNode.next;
            counter++;
        }
        if (counter == index) {
            Node node = new Node(value);
            node.next = currentNode.next;
            currentNode.next = node;
        }
        size ++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
        int counter = 0;
        Node currNode = head;
        Node prevNode = head;
        if (index == 0) {
            head = head.next;
        } else {
            while (counter != index) {
                if (currNode.next == null) {
                    throw new IndexOutOfBoundsException("Некорректный индекс");
                }
                prevNode = currNode;
                currNode = currNode.next;
                counter++;
            }
            prevNode.next = currNode.next;
        }
        size --;
    }

    @Override
    public void remove(Predicate<Integer> condition) {
        Node currNode = head;
        Node prevNode = null;
        while (currNode != null) {
            if (condition.test(currNode.payload)) {
                if (prevNode == null) {
                    head = head.next;
                } else {
                    prevNode.next = currNode.next;
                }
                size --;
            } else {
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
    }

    @Override
    public int get(int index) {
        if ((index == 0 & head != null)) {
            return head.payload;
        } else if (index < size & index > 0 & head != null) {
           Node currNode = head;
            int couter = 0;
            while (couter < index) {
                currNode = currNode.next;
                couter++;
            }
            return currNode.payload;
        }
        throw new IndexOutOfBoundsException("Некорректный индекс");
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node currNode = head;
        while (currNode != null) {
            list.append(currNode.payload);
            if (currNode.next != null) {
                list.append(", ");
            }
            currNode = currNode.next;
        }
        return list.toString();
    }
}