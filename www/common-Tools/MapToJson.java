package com.HopeRun.ListenerAndFilter.CommonUtils;

import java.util.HashMap;
import java.util.Map;

public class MapToJson {
    public static String toJson(boolean success,String key,String val){
        Map<String,String> jsonMap = new HashMap<String,String>();
        jsonMap.put(key,val);
        return toJson(success,jsonMap);
    }

    public static String toJson(boolean success,Map<String,String> jsonMap){
        StringBuffer buffer = new StringBuffer();
        if (success){
            buffer.append("{\"success\":true,\"data\":[");
        }else{
            buffer.append("{\"success\":false}");
        }
        if (jsonMap.size() >0){
            for (String key:jsonMap.keySet()){
                if(!key.equals(("class"))){
                    buffer.append("{"+'"'+key+'"' + ":"+'"'+jsonMap.get(key)+'"'+"},");
                }
            }
            buffer.deleteCharAt(buffer.length()-1);
            buffer.append("]}");
        }
//        buffer.append("}");
        return buffer.toString();
    }

}
