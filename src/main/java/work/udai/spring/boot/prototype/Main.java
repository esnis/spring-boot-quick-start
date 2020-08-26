package work.udai.spring.boot.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Bootstrap class.
 * <p/>
 * Created by fuqiangwang on 6/23/15.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,"classpath*:/spring/*.xml");

    }

}
