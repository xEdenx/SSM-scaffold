package common;

import org.omg.CORBA.portable.ApplicationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Ajax请求返回消息信封类
 */
public class ResEnv<T> {
    private boolean succ = true;
    private String msg;

    private T content;

    private final Map<String, Object> options;

    public static <T> ResEnv<T> success(String msg, T object) {
        return new ResEnv<>(true, msg, object);
    }

    public static <T> ResEnv<T> success(T object) {
        return new ResEnv<>(true, Constant.DEF_SUCC_MSG, object);
    }

    public static <T> ResEnv<T> success(String msg) {
        return new ResEnv<>(true, msg, null);
    }

    public static <T> ResEnv<T> success() {
        return success(Constant.DEF_SUCC_MSG);
    }

    public static <T> ResEnv<T> fail(String msg) {
        return new ResEnv<>(false, msg, null);
    }

    public static <T> ResEnv<T> fail() {
        return fail(Constant.DEF_FAIL_MSG);
    }

    public static <T> ResEnv<T> fail(String msg, Exception e) {
        if (e instanceof ApplicationException
                || e instanceof IllegalArgumentException) {
            return new ResEnv<>(false, e.getMessage(), null);
        } else {
            return fail(msg);
        }
    }

    public static <T> ResEnv<T> fail(Exception e) {
        return fail(Constant.DEF_FAIL_MSG, e);
    }

    public ResEnv() {
        options = new HashMap<>();
    }

    public ResEnv(boolean succ) {
        this();
        this.succ = succ;
    }

    public ResEnv(boolean succ, String msg) {
        this(succ);
        this.msg = msg;
    }

    public ResEnv(boolean succ, String msg, T content) {
        this(succ, msg);
        this.content = content;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public ResEnv addOption(String key, Object value) {
        options.put(key, value);
        return this;
    }

    public <T> T getOption(String key) {
        return (T) options.get(key);
    }

    public boolean hasOption(String key) {
        return options.containsKey(key);
    }
}
