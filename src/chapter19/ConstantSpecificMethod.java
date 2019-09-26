package chapter19;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {

    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },

    CLASSPATH {
      String getInfo() {
          return System.getenv("PATH");
      }
    },

    VERSION {
      String getInfo() {
          return System.getProperty("java.version");
      }
    };

    // getInfo 是 ConstantSpecificMethod 中的抽象方法，
    // 也是 ConstantSpecificMethod 中的枚举对象必须要实现的方法
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod method : values()) {
            // 调用 ConstantSpecificMethod 的 getInfo 方法会
            // 调用枚举对象的 getInfo 方法
            System.out.println(method.getInfo());
        }
    }
}
