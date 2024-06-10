public class IListMain {
    public static void main(String[] args) {
        ILinkedList list = new ILinkedList();
        list.add(1);
        list.add(4);
        System.out.println(list);
        list.add(1,2);
        list.add(2,3);
        System.out.println(list);
        System.out.println(list.get(2));
        list.remove(0);
        System.out.println(list);
        list.remove(x -> x < 4);
        System.out.println(list);
        list.remove(5);
    }
}
