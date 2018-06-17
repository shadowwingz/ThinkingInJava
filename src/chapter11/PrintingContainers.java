package chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by shadowwingz on 2018/6/17 0017.
 *
 * ArrayList 和 LinkedList 都是 List 类型，
 * 它们都按照被添加的顺序保存元素，
 * 它们可以保存重复元素，比如本例中的 dog，
 *
 * HashSet，TreeSet，LinkedHashSet 都是 Set 类型，
 * 每个相同的项只保存一次，因此不保存重复元素，
 * HashSet 不保证有序，也不保证无序，
 * TreeSet 按照比较结果的升序保存元素，
 * LinkedHashSet 按照被添加的顺序保存元素，
 *
 * HashMap，TreeMap，LinkedHashMap 都是 Map 类型，
 * 它们保存键值对，对于每个键，Map 只存储一次，
 * HashMap 不保证有序，也不保证无序，
 * TreeMap 按照比较结果的升序保存元素，
 * LinkedHashMap 按照被添加的顺序保存元素。
 */
public class PrintingContainers {

    static Collection<String> fill(Collection<String> collections) {
        collections.add("rat");
        collections.add("cat");
        collections.add("dog");
        collections.add("dog");
        return collections;
    }

    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList");
        System.out.println(fill(new ArrayList<>()));
        System.out.println("LinkedList");
        System.out.println(fill(new LinkedList<>()));
        System.out.println("HashSet");
        System.out.println(fill(new HashSet<>()));
        System.out.println("TreeSet");
        System.out.println(fill(new TreeSet<>()));
        System.out.println("LinkedHashSet");
        System.out.println(fill(new LinkedHashSet<>()));
        System.out.println("HashMap");
        System.out.println(fill(new HashMap<>()));
        System.out.println("TreeMap");
        System.out.println(fill(new TreeMap<>()));
        System.out.println("LinkedHashMap");
        System.out.println(fill(new LinkedHashMap<>()));
    }
}

/*
输出：

ArrayList
[rat, cat, dog, dog]
LinkedList
[rat, cat, dog, dog]
HashSet
[rat, cat, dog]
TreeSet
[cat, dog, rat]
LinkedHashSet
[rat, cat, dog]
HashMap
{rat=Fuzzy, cat=Rags, dog=Spot}
TreeMap
{cat=Rags, dog=Spot, rat=Fuzzy}
LinkedHashMap
{rat=Fuzzy, cat=Rags, dog=Spot}

 */