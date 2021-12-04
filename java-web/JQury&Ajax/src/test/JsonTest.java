package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * @author 无名氏
 * @Data:2021/6/14
 */
public class JsonTest {

    @Test
    public void test1() throws Exception {
//        1.创建Person对象
        Person person = new Person("张三",23,"男");
        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*
         *转换方法
              *writeValue(参数1,obj);
                 *参数1:
                     File:将obj对象转换为JSON字符串,并保存到指定文件中
                     Writer:将obj对象转换为JSON字符串,并将json数据填充到字符输出流中
                     OutputStream:将obj对象转换为JSON字符串,并将json数据填充到字节输出流中
              *writeValueAsString(obj):将对象转换为json字符串
         */
        //{"name":"张三","age":23,"gender":"男"}
        mapper.writeValue(new File("d://1.txt"),person);

        mapper.writeValue(new FileWriter("d://1.txt"),person);

        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void test2() throws Exception {
//        1.创建Person对象
        Person person = new Person("张三", 23, "男");
        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        person.setBirthday(new Date());
        String json = mapper.writeValueAsString(person);
        //Date类有两种处理方式
        //默认方式birthday为毫秒数 {"name":"张三","age":23,"gender":"男","birthday":1623681624127}
        //1。在birthday字段加@JsonIgnore注解,忽略该字段 {"name":"张三","age":23,"gender":"男"}
        //2.在birthday字段加@JsonFormat注解，格式化Date对象 {"name":"张三","age":23,"gender":"男","birthday":"2021-06-14"}
        System.out.println(json);
    }

    @Test
    public void test3() throws Exception {
//        1.创建Person对象
        Person p1 = new Person("张三", 23, "男");
        p1.setBirthday(new Date());
        Person p2 = new Person("李四", 18, "男");
        p2.setBirthday(new Date());
        Person p3 = new Person("王五", 21, "女");
        p3.setBirthday(new Date());
        //创建List集合
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        /*
          [{"name":"张三","age":23,"gender":"男","birthday":"2021-06-14"},
          {"name":"李四","age":18,"gender":"男","birthday":"2021-06-14"},
          {"name":"王五","age":21,"gender":"女","birthday":"2021-06-14"}]
         */
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    @Test
    public void test4() throws Exception {
        //创建map对象,和person对象格式一样
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");
        //2.创建Jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"gender":"男","name":"张三","age":23}
        System.out.println(json);
    }

    @Test
    public void test5() throws Exception{
//        1.初始化Json字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
//        2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
//        3.转换为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);
        //Person{name='张三', age=23, gender='男'}
        System.out.println(person);

    }

}
