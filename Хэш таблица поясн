public class MyHashTablePoyacnylka {
    private int capacity; //поле capacity которое хранит вместимость таблицы
    private int size;// поле size которое хранит количество заполненных ячеек
    private Node[] table;// поле table которое хранит массив из элементов класса Node(это и есть хеш таблица)

    private static class Node { //создание класса Node
        private final String key;//поле key которое хранит ключ элемента, final означает, что это поле нельзя изменить после его создания
        private final String value;// поле value хранит значение элемента
        private Node next;// поле next хранит в себе ссылку на следующий элемент односвязного списка
        public Node(String key, String value) {// конструктор класса Node
            this.key = key;//указываем, что поле key принимает значение, передаваемое в параметре функции-конструктора
            this.value = value;//указываем, что поле value принимает значение, передаваемое в параметре функции-конструктора
            this.next = null;//поле next по умолчанию равно null
        }
    }

    public MyHashTablePoyacnylka(int capacity) {//конструктор класса MyHashTable
        this.capacity = capacity; //указываем, что поле capacity принимает значение, передаваемое в параметре функции-конструктора
        this.size = 0;// поле size равно 0
        this.table = new Node[capacity];//поле table равно массиву из элементов класса Node размера capacity
    }
    private int hash(String key) {//хеш-функция
        int hash = 0;//переменная хеш равна 0
        for (int i = 0; i < key.length(); i++) {//перебираем каждый символ в ключе
            hash = 31 * hash + key.charAt(i);//умножаем на 31(смещаем на 3 бита в лево) хеш и прибавляем битовую запись символа
        }
        return Math.abs(hash);// возвращаем полученный хеш в 10 СС и берем от него модуль
    }


    public void put(String key, String value) {//функция put которая добавляет элемент в таблицу
        int index = hash(key) % capacity;// считаем индекс элемента, взяв остаток от деления хеш от ключа(который мы передаем в параметре) на вместимость таблицы
        Node newNode = new Node(key, value);// создаем новый элемент класса Node
        Node current = table[index];//приравниваем текущий элемент к элементу по индексу
        while (current != null) {
            if (current.key.equals(key)) {// если ключи совпадают
                return;//прерываем выполнение функции
            }
            current = current.next;//шагаем на следующий элемент
        }//если ячейке таблицы 1 элемент, то current равен 0 после 1 прогона цикла
        newNode.next = table[index];//новый элемент ссылается на текуший, лежащий в ячейке по индексу
        table[index] = newNode;//помещаем новый элемент в ячейку
        size++;// увеличиваем размер на 1
        if (size >= capacity * 0.75) {// если размер таблицы больше чем 75%
            resize();//выполняем увеличение вместимости
        }
    }

    private void resize() {//функция, которая увеличиваем вместимость таблицы в двое
        capacity *= 2;// увеличение таблицы в двое
        Node[] newTable = new Node[capacity];//создаем таблицу нового размера
        for (Node node : table) {//перебираем каждый элемент старой таблицы
            Node current = node;//текущий элемент равен рассматриваемому элементу
            while (current != null) {
                Node next = current.next;//создаем переменную next в которой хранится следующий элемент
                int index = hash(current.key) % capacity;//считаем новый индекс для нового размера таблицы
                current.next = newTable[index];//текущий элемент ссылается на элемент по индексу в новой таблице(есл там ничего нет, то на null)
                newTable[index] = current;//помещаем текущий элемент в ячейку по индексу в новой таблице
                current = next;//шагаем на следующий элемент
            }
        }
        table = newTable;//в поле table помещаем новую таблицу
    }

    public void remove(String key) {//функция, которая удаляет элемент по ключу
        int index = hash(key) % capacity;//считаем индекс удаляемого элемента
        Node current = table[index];//текущий элемент равен элементу таблицы по индексу
        Node prew = null;//предыдущий элемент равен null
        while (current != null) {
            if (current.key.equals(key)) {//если ключи совали
                if (prew != null) {//если prew не равен null, то есть мы хоти удалить не первый элемент в односвязном списке
                    prew.next = current.next;//предыдущй элемент ссылается на следующй
                } else {//если prew равен null, то есть хотим удалить первый элемент
                    table[index] = current.next;//элемент по индексу равен следующему элементу в односвязном списке
                }                               // если в ячейке один элемент, то он становится равен null
                size--;//уменьшаем размер на 1
                re//вен null
//                size--;//уменьшаем размер на 1
//                return;
//            }
//            prew = current;//предыдущий элемент равен текущему
//            current = current.next;//текущй элемент равен следующему
//        }
//        throw new IndexOutOfBoundsException("Некорректный ключ");//если нужного ключа не существует, выдаем исключение
//    }
//
//    public String get(String key) {// функция, которая возвращает значение элемента по ключу
//        int index = hash(key) % capacity;//считаем индекс искомого элемента
//        Node current = table[index];//текущий элемент равен элементу таблицы по индексу
//        while (current != null) {
//            if (current.key.equals(key)) {//если ключи совали
//                return current.value;//возвращаем значение элемента
//            }
//            current = current.next;//идем к следующему элементу списка
//        }
//        throw new IndexOutOfBoundsException("Некорректный ключ");//если нужного ключа не существует, выдаем исключение
//    }
//
//    public void display() {//функция, которая выводит таблицу на экран
//        System.out.println("____Hash Table____");//выводит шапку таблицы
//        String[] var1 = keys();// создаем            System.out.println(key + " | " + get(key));//выводим в одну строку ключ и значение элемента по этому ключу, используя метод get
        }
    }

    public String[] keys() {//функция, которая возвращает все ключи из таблицы
        String[] keys = new String[size];//создаем новый массив размера равного размеру таблицы
        int index = 0;//индекс элемента в массиве ключей
        for (Node node : table) {// перебираем каждый элемент таблицы
            Node current = node;//текущий элемент равен рассматриваемому элементу
            while (current != null){
                keys[index] = current.key;//в массив ключей по индексу добавляем ключ текущего элемента
                index++;// увеличиваем индекс на 1
                current = current.next;//шагаем на следующий элемент
        }
    }
        return keys;//возвращаем массив ключей
    }
}
