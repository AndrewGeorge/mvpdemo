package com.example.mvpdemo.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/22 0022.
 */

public class FormateParamsUils {
    public static Map<String ,String> getParam(Object obj){
        Map<String ,String> params=new HashMap<>();
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field f : fields) {
                String name = f.getName();
                StringBuilder sb = new StringBuilder();
                sb.append("get");
                sb.append(name.substring(0, 1).toUpperCase());
                sb.append(name.substring(1));
                Method m = obj.getClass().getMethod(sb.toString());
                String value = (String) m.invoke(obj);
                params.put(name, value);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return params;
    }
}
