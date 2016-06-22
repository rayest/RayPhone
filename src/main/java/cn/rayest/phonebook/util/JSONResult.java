package cn.rayest.phonebook.util;

import cn.rayest.phonebook.domain.Person;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/23.
 */
public class JSONResult {

    public static JSONObject response(final String key, final List data) {
        return new JSONObject() {{
            put("code", "0000");
            put("message", "Response Successfully");
            put(key, data);
        }};
    }

    public static Object success() {
        return new JSONObject() {{
            put("code", "0000");
            put("message", "Response Successfully");
        }};
    }



    public static JSONObject response(final String key, final Person data) {
        return new JSONObject() {{
            put("code", "0000");
            put("message", "Response Successfully");
            put(key, data);
        }};
    }
}
