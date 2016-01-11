package c3_5_02_web_Student_Server;

import java.io.Serializable;

/**
 * Created by vero on 2015/12/9.
 */
public class Student implements Serializable {
    private String sid;
    private String name;
    private int age;

    public Student() {

    }
    public Student(String sid, String name, int age) {
        this.sid = sid;
        this.age = age;
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
