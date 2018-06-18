package chapter11;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import mindview.util.TextFile;

/**
 * Created by shadowwingz on 2018/6/18 0018.
 *
 * 按照字典序排序
 */
public class UniqueWords {
    public static void main(String[] args) {
        // 获取当前文件夹的路径
        File directory = new File("");
        Set<String> words = new TreeSet<>(
                new TextFile(directory.getAbsolutePath() +
                        "\\src\\chapter11\\SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}

/*
输出：

[0018, 18, 2018, 6, A, B, C, Collections, Created, D, E, F, G, H, HashSet,
 I, J, K, L, M, N, Set, SetOperations, String, System, X, Y, Z, add, addAll,
 added, args, by, chapter11, class, contains, containsAll, from, import, in,
 java, main, new, on, out, package, println, public, remove, removeAll,
 removed, set1, set2, shadowwingz, split, static, to, util, void]

 */