package login.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 无名氏
 * @date 2021/9/5
 */
//Converter<String, Date> : String代表转换之前的类型,Date代表转换之后的类型(Spring-mvc.xml)
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
