package com.offcn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //字符串转日期
    public Date stringToDate(String str){

        Date date = null;

        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    //把日期转成字符串
    public static String dateToString(Date date){
        return sdf.format(date);
    }
}
