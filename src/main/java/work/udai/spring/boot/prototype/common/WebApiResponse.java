package work.udai.spring.boot.prototype.common;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class WebApiResponse<T> {
    private T data;
    private int code;
    private String msg;
    public WebApiResponse(T data, int code){
        this.data = data;
    }
    public T getData(){
        return data;
    }
    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
