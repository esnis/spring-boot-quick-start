package work.udai.spring.boot.prototype.services;

import work.udai.spring.boot.prototype.vo.HelloValue;
import org.springframework.stereotype.Service;

/**
 * Created by yuebing on 2019-11-18.
 */
@Service
public class HelloService {
    public HelloValue hello(){
        return new HelloValue();
    }
}
