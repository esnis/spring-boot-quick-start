package work.udai.spring.boot.prototype.vo;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by fuqiangwang on 6/23/15.
 */
@ResponseBody
public class HelloValue {
    private String name = "darren";
    private Date now = new Date();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HelloValue that = (HelloValue) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return !(now != null ? !now.equals(that.now) : that.now != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (now != null ? now.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HelloValue{" +
                "name='" + name + '\'' +
                ", now=" + now +
                '}';
    }
}
