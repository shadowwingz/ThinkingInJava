package chapter20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target 用来定义你的注解将应用于什么地方，比如一个方法或者一个域
@Target(ElementType.METHOD)
// @Retention 用来定义该注解在哪一个级别可用，
// 在源代码中(SOURCE)，类文件中（CLASS），或者运行时（RUNTIME）
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public int id();

    public String description() default "no description";
}
