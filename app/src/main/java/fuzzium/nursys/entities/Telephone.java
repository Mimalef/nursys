package fuzzium.nursys.entities;

import com.orm.SugarRecord;

public class Telephone extends SugarRecord<Telephone> {

    private String tell;
    public  Patient patient;

    public Telephone(){

    }
    public Telephone(String tell) {

        this.tell = tell;
    }
    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        this.tell = tell;
    }
}
