package work.udai.spring.boot.prototype.common;

import org.springframework.stereotype.Service;

@Service
public class Auditor {
    public Auditor(){}
    public void audit(String someone, String dothing, String something){
        //output audit log ...
    }
}
