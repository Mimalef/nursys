package fuzzium.nursys.entities;
import com.orm.SugarRecord;

import java.util.List;


public class Patient extends SugarRecord<Patient> {


    private String fname;
    private String lname;
    private String address;
    private long regDate;//unixTimestamp

    // Forein keys
    public Insurence insurance;

    public Patient(){
        this.regDate =System.currentTimeMillis()/1000L;
    }

    public Patient( String name,String family, String address,int insurance) {
        super();

        this.fname= name;
        this.lname=family;
        this.address = address;
        this.regDate =System.currentTimeMillis()/1000L;
    }

    public List<Telephone> getphone(){
        return Telephone.find(Telephone.class, "patient = ?", String.valueOf(this.getId()));
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }

    public String getAddress() {
        return address;
    }

    public long getRegDate() {
        return regDate;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String toString() {
        List<Telephone>  tellPhones=getphone();
        String tellstring="";
        for(int i=0;i<tellPhones.size();i++)
            tellstring+=tellPhones.get(i).getTell();
        return  lname +" "+ fname + " "+tellstring;
    }



}
