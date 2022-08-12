package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String,String> tags = new HashMap<>();
        /*tags.put("name","Ivanov");
        tags.put("country","Ukraine");*/
        System.out.println(getQuery(tags));

    }

    public static String getQuery(Map<String, String> params) {

        StringBuilder queryBuilder = new StringBuilder();
        for (String s : params.keySet()) {
            String value = params.get(s);
            if (value == null) {
                continue;
            }
            if (queryBuilder.toString().length() != 0) {
                queryBuilder.append(" and ");
            }
            queryBuilder.append(s + " = '" + value + "'");
        }
        return queryBuilder.toString();
    }


      /* if(params.isEmpty())
           return "";
        StringBuilder query = new StringBuilder();
        for (Map.Entry<String,String> param: params.entrySet()) {
            if(param.getKey()==null || param.getValue()==null)
                continue;
            query.append(param.getKey()).append(" = ").append("'").append(param.getValue()).append("' ");
            query.append("and ");

        }
        query.replace(query.lastIndexOf("and "),query.length()-1,"");
        return query.toString().trim();
    }*/
}
