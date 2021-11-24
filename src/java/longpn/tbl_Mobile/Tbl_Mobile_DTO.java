/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.tbl_Mobile;

/**
 *
 * @author tunbe
 */
public class Tbl_Mobile_DTO {

    private String mobileID;
    private String mobilename;
    private String description;
    private int price;

    public Tbl_Mobile_DTO() {
    }

    public Tbl_Mobile_DTO(String mobileID, String mobilename, String description, int price) {
        this.mobileID = mobileID;
        this.mobilename = mobilename;
        this.description = description;
        this.price = price;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getMobilename() {
        return mobilename;
    }

    public void setMobilename(String mobilename) {
        this.mobilename = mobilename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
