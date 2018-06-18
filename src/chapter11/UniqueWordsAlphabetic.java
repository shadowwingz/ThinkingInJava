package chapter11;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import mindview.util.TextFile;

/**
 * Created by shadowwingz on 2018/6/18 0018.
 *
 * 按照字母序排序
 */
public class UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        // 获取当前文件夹的路径
        File directory = new File("");
        words.addAll(new TextFile(directory.getAbsolutePath() +
                "\\src\\chapter11\\SetOperations.java", "\\W+"));
        System.out.println(words);

    }
}

/*
输出：

[0018, 18, 2018, 6, A, add, addAll, added, args, B, by, C, chapter11,
class, Collections, contains, containsAll, Created, D, E, F, from,
G, H, HashSet, I, import, in, J, java, K, L, M, main, N, new, on,
out, package, println, public, remove, removeAll, removed, Set,
set1, set2, SetOperations, shadowwingz, split, static, String,
System, to, util, void, X, Y, Z]

 */