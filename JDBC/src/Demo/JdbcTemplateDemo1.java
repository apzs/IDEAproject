package Demo;

import org.springframework.jdbc.core.JdbcTemplate;
import utls.DruidUtils;

/**
  *@Data:2021/6/13
  */public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDateSource());
        //3.调用方法
        String sql = "insert into user(id, username, password) values (null,?,?)";
        int i = template.update(sql, "123456789", "123456789");
        System.out.println(i);
    }
}
