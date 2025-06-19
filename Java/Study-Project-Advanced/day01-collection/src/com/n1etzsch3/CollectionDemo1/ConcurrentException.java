package com.n1etzsch3.CollectionDemo1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentException {
    public static void main(String[] args) {
        // 并发修改异常示例
        List<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("Java进阶");
        list.add("Java高级");
        list.add("Java实战");
        list.add("枸杞养生");
        list.add("CSAPP");
        list.add("数据结构与算法");
        list.add("计算机网络");
        System.out.println(list);

        // 错误示例1：删除全部Java相关书籍
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).contains("Java")) {
                list.remove(list.get(i));
            }
        }
        // 由于每删掉一个元素，索引就会变化，导致下一个元素的索引可能会被跳过。
        // 例如，删除第0个元素后，原本的第1个元素现在变成了第0个元素，
        // 但循环会继续从原来的第1个元素开始检查，这样就会跳过原来的第1个元素。
        // 这会导致并发修改异常，因为在遍历过程中修改了集合的结构。

        // 解决方案一、每次删除元素后，索引减1
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).contains("Java")) {
                list.remove(list.get(i));
                i--;  // 删除元素后，索引减1
            }
        }

        // 解决方案二、倒序遍历
        for(int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i).contains("Java")) {
                list.remove(i);  // 倒序删除元素，不会影响未遍历的元素索引
            }
        }

        // 错误示例2：使用增强for循环删除元素
        for(String book : list) {
            if(book.contains("Java")) {
                list.remove(book);  // 这行代码会抛出ConcurrentModificationException异常
            }
        }
        // 增强for循环在遍历时不允许修改集合的结构，
        // 如果尝试在循环中删除元素，会抛出ConcurrentModificationException异常。


        // 错误示例3：使用迭代器删除元素
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String book = it.next();
            if(book.contains("Java")) {
                list.remove(book);  // 这行代码会抛出ConcurrentModificationException异常
            }
        }
        // Java的Iterator在遍历时不允许直接修改集合的结构，因为其会维护一个修改计数器，
        // 就是防止可能出现的并发修改异常。

        // 正确的方法是使用Iterator的remove方法来删除元素：
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String book = iterator.next();
            if (book.contains("Java")) {
                iterator.remove();  // 使用Iterator的remove方法删除元素
            }
        }

        // 错误示例4：使用forEach删除元素
        list.forEach(book -> {
            if (book.contains("Java")) {
                list.remove(book);  // 这行代码会抛出ConcurrentModificationException异常
                // forEach方法在遍历时不允许修改集合的结构，因为底层也是基于迭代器实现的。
                // 如果尝试在Lambda表达式中删除元素，会抛出ConcurrentModificationException异常。
            }
        });

        // 正确的方法是使用List的removeIf方法，它允许使用Lambda表达式删除元素：
        list.removeIf(book -> book.contains("Java"));  // 这行代码是正确的，使用Lambda表达式删除元素

        System.out.println(list);

        // 总结：在遍历集合时，如果需要删除元素，应该使用Iterator的remove方法或List的removeIf方法，
        // 避免直接使用集合的remove方法或在增强for循环中删除元素，以防止抛出ConcurrentModificationException异常。
        // 如果集合支持索引，可以使用for循环遍历，然后每删除一个元素，索引减1；或倒序遍历来避免并发修改异常。

        // 注意：增强for循环和forEach方法在遍历时不允许修改集合的结构，
        // 因为它们底层使用的是迭代器，而迭代器在遍历时维护了一个修改计数器。
    }
}
