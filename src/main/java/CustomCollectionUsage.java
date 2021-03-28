import java.util.Arrays;
import java.util.Iterator;

import static java.lang.System.out;

public class CustomCollectionUsage {
    public static void main(final String[] args) {
        MyCollection<Integer> myCollection = new MyCollection<>();
        // add
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(null);
        myCollection.add(3);
        //myCollection.add(null); вот это вот всё поломает
        // size
        out.println("Размер коллекции");
        out.println(myCollection.size());
        // isEmpty
        MyCollection<Integer> emptyCollection = new MyCollection<>();
        out.println("Проверка на пустоту");
        out.println(emptyCollection.isEmpty());
        out.println(myCollection.isEmpty());
        // iterator
        out.println("Итерация");
        for (Object item : myCollection) {
            if (item == null) {
                out.println("null");
            } else {
                out.println(item);
            }
        }
        // int.remove
        out.println("Убрать при итерации 3");
        Iterator<Integer> it = myCollection.iterator();
        while (it.hasNext()) {
            Integer el = it.next();
            if (Integer.valueOf(3).equals(el)) {
                it.remove();
            }
        }
        // contains
        out.println("Вхождение");
        out.println(myCollection.contains(2));
        out.println(myCollection.contains(10));
        // toArray of objects
        out.println("массив объектов");
        out.println(Arrays.toString(myCollection.toArray()));
        // toArray of Strings
        out.println("типизированный массив");
        Integer[] intList = new Integer[2];
        myCollection.toArray(intList);
        out.println(Arrays.toString(intList));
        Integer[] intList2 = new Integer[30];
        myCollection.toArray(intList2);
        out.println(Arrays.toString(intList2));
        // contains all
        out.println("вхождение коллекции");
        MyCollection<Integer> findCollection = new MyCollection<>();
        findCollection.add(1);
        findCollection.add(2);
        out.println(myCollection.containsAll(findCollection));
        findCollection.add(10);
        out.println(myCollection.containsAll(findCollection));
        // addAll
        out.println("слияние коллекций");
        myCollection.addAll(findCollection);
        out.println(Arrays.toString(myCollection.toArray()));
        // remove
        out.println("удаление");
        myCollection.remove(2);
        out.println(Arrays.toString(myCollection.toArray()));
        myCollection.remove(10);
        out.println(Arrays.toString(myCollection.toArray()));
        // removeAll
        out.println("удаление всех едениц и двоек");
        MyCollection<Integer> removeCollection = new MyCollection<>();
        removeCollection.add(1);
        removeCollection.add(2);
        myCollection.removeAll(removeCollection);
        out.println(Arrays.toString(myCollection.toArray()));
        // retainAll
        out.println("убрать всех кроме 1, 2, 10");
        myCollection.add(1);
        myCollection.add(2);
        myCollection.add(2);
        myCollection.add(5);
        myCollection.add(5);
        myCollection.add(10);
        out.println(Arrays.toString(myCollection.toArray()));
        myCollection.retainAll(findCollection);
        out.println(Arrays.toString(myCollection.toArray()));
        // reverse
        out.println("переворот");
        myCollection.reverse();
        out.println(Arrays.toString(myCollection.toArray()));
        // clear
        out.println("очистка");
        myCollection.clear();
        out.println(Arrays.toString(myCollection.toArray()));


    }
}
