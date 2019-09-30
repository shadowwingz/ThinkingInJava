package chapter20.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        String[] strings = {"chapter20.database.Member"};
        args = strings;
        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            // 获取 Class 的 DBTable 注解
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            // 数据库名字
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                // 字段注解
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                if (anns[0] instanceof SQLInteger)  {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    // 没有给 name 赋值
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(sString.name() + " VARCHAR(" + sString.value() + ")"
                            + getConstraints(sString.constraints()));
                }
            }
            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n " + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("Table Creation SQL for " + className + " is :\n" + tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
