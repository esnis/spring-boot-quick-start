package work.udai.spring.boot.prototype.controllers;

import com.codahale.metrics.annotation.Timed;
import work.udai.spring.boot.prototype.common.Auditor;
import work.udai.spring.boot.prototype.common.WebApiResponse;
import work.udai.spring.boot.prototype.services.HelloService;
import work.udai.spring.boot.prototype.vo.HelloValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * A Web API endpoint sample controller
 * <p>
 * Created by yuebing on 2019-11-18.
 */
@RestController
public class HelloController {

    final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private HelloService helloService;

    @Autowired
    private Auditor auditor;


    @RequestMapping("/")
    public void index0(String body, WebRequest request, HttpServletResponse response) {

        auditor.audit("someone", "do", "something");

        logger.info("print headers...");
        Iterator<String> iter = request.getHeaderNames();
        while (iter.hasNext()) {
            String key = iter.next();
            logger.info("{}:{}", key, request.getHeader(key));
        }


        logger.info("print body as string...");
        logger.info("body=" + body);


        response.setStatus(200);
    }


    @Timed(name = "hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public WebApiResponse<HelloValue> index() {
        return new WebApiResponse(helloService.hello(), 0);
    }


    @RequestMapping(value = "/fuck", method = RequestMethod.GET)
    public void mockException() {
        throw new RuntimeException("for test purpose");
    }


    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public HelloValue hello2() {
        return helloService.hello();
    }

    @RequestMapping("/callback")
    public void callback(@RequestBody Object body) {
        System.out.println("body=" + body);
    }

    @RequestMapping(value = "/api/v1.1/{endpoint}", method = RequestMethod.POST)
    public HelloValue endpointApi(@PathVariable("endpoint") String endpoint, String arg, Integer num) {
        logger.info("endpoint={}, arg={}, num={}", endpoint, arg, num);
        return new HelloValue();
    }
}
