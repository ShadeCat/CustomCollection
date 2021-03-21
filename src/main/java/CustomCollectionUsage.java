import java.util.Arrays;

public class CustomCollectionUsage {
    public static void main(String[] args) {
        MyCollection<Integer> myCollection = new MyCollection<>();
        // add
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(2);
        myCollection.add(3);
        //myCollection.add(null); вот это вот всё поломает
        // size
        System.out.println("Размер коллекции");
        System.out.println(myCollection.size());
        // isEmpty
        MyCollection<Integer> emptyCollection = new MyCollection<>();
        System.out.println("Проверка на пустоту");
        System.out.println(emptyCollection.isEmpty());
        System.out.println(myCollection.isEmpty());
        // iterator
        System.out.println("Итерация");
        for (int item : myCollection)
            System.out.println(item);
        // contains
        System.out.println("Вхождение");
        System.out.println(myCollection.contains(2));
        System.out.println(myCollection.contains(10));
        // toArray of objects
        System.out.println("массив объектов");
        System.out.println(Arrays.toString(myCollection.toArray()));
        // toArray of Strings
        System.out.println("типизированный массив");
        Integer[] intList = new Integer[2];
        myCollection.toArray(intList);
        System.out.println(Arrays.toString(intList));
        Integer[] intList2 = new Integer[30];
        myCollection.toArray(intList2);
        System.out.println(Arrays.toString(intList2));
        // contains all
        System.out.println("вхождение коллекции");
        MyCollection<Integer> findCollection = new MyCollection<>();
        findCollection.add(1);
        findCollection.add(2);
        System.out.println(myCollection.containsAll(findCollection));
        findCollection.add(10);
        System.out.println(myCollection.containsAll(findCollection));
        // addAll
        System.out.println("слияние коллекций");
        myCollection.addAll(findCollection);
        System.out.println(Arrays.toString(myCollection.toArray()));
        // remove
        System.out.println("удаление");
        myCollection.remove(2);
        System.out.println(Arrays.toString(myCollection.toArray()));
        myCollection.remove(10);
        System.out.println(Arrays.toString(myCollection.toArray()));
        // removeAll
        System.out.println("удаление всех едениц и двоек");
        MyCollection<Integer> removeCollection = new MyCollection<>();
        removeCollection.add(1);
        removeCollection.add(2);
        myCollection.removeAll(removeCollection);
        System.out.println(Arrays.toString(myCollection.toArray()));
        // retainAll
        System.out.println("убрать всех кроме 1, 2, 10");
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(2);
        myCollection.add(5);
        myCollection.add(5);
        myCollection.add(10);
        System.out.println(Arrays.toString(myCollection.toArray()));
        myCollection.retainAll(findCollection);
        System.out.println(Arrays.toString(myCollection.toArray()));
        // reverse
        System.out.println("переворот");
        myCollection.reverse();
        System.out.println(Arrays.toString(myCollection.toArray()));
        // clear
        System.out.println("очистка");
        myCollection.clear();
        System.out.println(Arrays.toString(myCollection.toArray()));



    }
}
