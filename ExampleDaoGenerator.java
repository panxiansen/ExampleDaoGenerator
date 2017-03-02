package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ExampleDaoGenerator {

    public static void main(String[] args) throws  Exception{
        //创建了一个用于添加实体(Entity)的模式(Schema)对象.
        //两个参数分别代表：数据库版本号与自动生成代码的包路径。
        Schema schema = new Schema(1, "me.itangqi.greendao");
        //另外一种方法，分别指定生成的Bean与Dao类所在的目录，只要如下所示：
        //Schema schema = new Sechema(1, "me.itangqi.bean");
        //schema.setDefaultJavaPackageDao("me.itangqi.dao");

        //一旦拥有了一个Schema对象后，便可以使用它添加实体(Entities)了。
        addNote(schema);

        //最后我们将使用DAOGenerator类的generateAll()方法自动生成代码，此处你需要根据自己的情况更改输出目录(就是之前创建的java-gen)。
        //其实，输出目录的路口井可以在build.gradle中设置的，有兴趣的可以自行搜索。
        new DaoGenerator().generateAll(schema, "/Users/com/example/administrator/GreenDaoDemo01/app/src/main/java-gen");

    }

    private static void addNote(Schema schema){
        //一个实体(类)就关联到数据库中的一张表，此处表格命名为[Note](即类名)
        Entity note = schema.addEntity("Note");
        //可以重新给表格命名
        //note.setTableName("NODE");

        //greenDao会自动根据实体类的属性值来创建表字段，并赋予默认值
        //接下来便可以设置表中的字段;
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        //与在Java中使用驼峰命名法不同，默认数据库中的命名是使用大写和下划线来分割单词的。
        //For example,a property called "creationDate" will become a database colum "CREATION_DATE"
        note.addStringProperty("comment");
        note.addDateProperty("date");

    }

}
