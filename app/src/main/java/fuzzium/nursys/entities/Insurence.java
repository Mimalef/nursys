package fuzzium.nursys.entities;

import com.orm.SugarRecord;


public class Insurence extends SugarRecord<Insurence> {
    private String insurenceType;
    private int discount;

    public Insurence(){

    }
    public Insurence(String insurenceType, int discount) {
        this.insurenceType = insurenceType;
        this.discount = discount;
    }

    public String getInsurenceType() {
        return insurenceType;
    }

    public void setInsurenceType(String insurenceType) {
        this.insurenceType = insurenceType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
   public String toString(){

        return getInsurenceType();
    }
}
