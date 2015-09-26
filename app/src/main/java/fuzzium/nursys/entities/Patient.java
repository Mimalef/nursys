package fuzzium.nursys.entities;
import com.orm.SugarRecord;

public class Patient extends SugarRecord<Patient> {

    private int pid;
    private String name;
    private String address;
    private int regDate;
    private int insurance;

    public Patient(){

    }

    public Patient(int pid, String name, String address, int regDate, int insurance) {

        this.pid = pid;
        this.name = name;
        this.address = address;
        this.regDate = regDate;
        this.insurance = insurance;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getRegDate() {
        return regDate;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegDate(int regDate) {
        this.regDate = regDate;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }
    public String toString() {
        return  pid+" "+name;

    }



}
