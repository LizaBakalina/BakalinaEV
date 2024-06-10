import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(10);

        hashTable.put("1", "Ноты");
        hashTable.put("2", "Пианино");
        hashTable.put("3", "Папка");
        hashTable.put("4", "Файл");
        hashTable.put("5", "Карандаш");
        hashTable.put("6", "Реприза");
        hashTable.put("7", "Ключ");
        hashTable.remove("1");
        System.out.println(Arrays.toString(hashTable.keys()));
        hashTable.display();
    }
}