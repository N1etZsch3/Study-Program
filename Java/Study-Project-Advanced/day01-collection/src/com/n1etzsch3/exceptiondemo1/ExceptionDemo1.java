package com.n1etzsch3.exceptiondemo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo1 {
    public static void main(String[] args) throws ParseException {
        show();
    }

    public static void show() throws ParseException {
        String time = "2025-06-14 14:06:29";
        // 将字符串解析为时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(time);
        System.out.println(date);
    }
}
