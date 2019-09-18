package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {

    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        // 创建一个 Hello 的字符串，拷贝 4 份，存储在 list 中
        List<StringAddress> list = new ArrayList<>(
                Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        // 创建一个 World 的字符串，拷贝 4 份，存储在 list 中
        // fill 方法只能替换已经在 List 中存在的元素，
        // 所以 list 中原本的 4 个 Hello 字符串会被替换成 World。
        Collections.fill(list, new StringAddress("World"));
        System.out.println(list);
    }
}

/*

输出：

[chapter17.StringAddress@74a14482 Hello, chapter17.StringAddress@74a14482 Hello, chapter17.StringAddress@74a14482 Hello, chapter17.StringAddress@74a14482 Hello]
[chapter17.StringAddress@1540e19d World, chapter17.StringAddress@1540e19d World, chapter17.StringAddress@1540e19d World, chapter17.StringAddress@1540e19d World]

 */