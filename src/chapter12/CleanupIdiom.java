package chapter12;

/**
 * Created by shadowwingz on 2018-06-24 12:08
 */
class NeedsCleanup {

    private static long counter = 1;

    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {

}

class NeedsCleanup2 extends NeedsCleanup {
    public NeedsCleanup2() throws ConstructionException {
    }
}

public class CleanupIdiom {
    public static void main(String[] args) {
        /**
         * NeedsCleanup 的构造方法没有抛异常，所以不需要 catch，
         * NeedsCleanup nc1 = new NeedsCleanup() 这句代码一定会执行成功，
         * 一定可以进入 try 语句中，既然可以进入 try 语句，
         * 那 finally 语句也一定可以进入，所以为了清理 nc1，
         * 我们可以直接在 finally 语句中调用 nc1.dispose()
         */
        NeedsCleanup nc1 = new NeedsCleanup();
        try {

        } finally {
            nc1.dispose();
        }

        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {

        } finally {
            nc3.dispose();
            nc2.dispose();
        }

        try {
            /**
             * NeedsCleanup 的构造方法会抛异常，所以
             * NeedsCleanup2 nc4 = new NeedsCleanup2() 这句代码可能会执行失败，
             * 如果执行失败，那 nc4 对象就创建失败，那 nc4 也就没有清理的必要了，
             * 所以直接进入 catch 语句，不需要调用 nc4.dispose()
             *
             * 如果执行成功，那 nc4 对象就创建成功，那 nc4 就需要清理了，
             * 接着会进入 try 语句，既然可以进入 try 语句，
             * 那 finally 语句也一定可以进入，所以为了清理 nc4，
             * 我们可以直接在 finally 语句中调用 nc4.dispose()
             *
             * nc5 同理
             */
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {

                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        } catch (ConstructionException e) {
            System.out.println(e);
        }
    }
}

/*
输出：

NeedsCleanup 1 disposed
NeedsCleanup 3 disposed
NeedsCleanup 2 disposed
NeedsCleanup 5 disposed
NeedsCleanup 4 disposed

 */
