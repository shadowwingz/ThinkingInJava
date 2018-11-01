package chapter15;

/**
 * Created by shadowwingz on 2018-10-17 23:10
 * <p>
 * 在编译期，T[] 是 Integer[]，
 * 在运行期，T[] 是 Object[]
 * <p>
 * 编译期是指 编译器将源代码翻译为机器能识别的代码，java 为编译为 jvm 认识的字节码文件。也就是我们常用的 javac 命令
 * 运行期是指 java 代码的运行过程。也就是我们常用的 java 命令。
 */
public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
//        Integer[] ia = gai.rep();
        Object[] oa = gai.rep();
    }
}
