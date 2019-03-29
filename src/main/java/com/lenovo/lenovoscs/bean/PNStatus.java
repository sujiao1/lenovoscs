package com.lenovo.lenovoscs.bean;

import java.math.BigDecimal;

public class PNStatus {

    private Integer id;

    private Integer pnnumber;

    private Integer number;

    private String pnDes;

    private String category;

    private String unit;

    private BigDecimal price;

    private Integer pnQuantity;

    private String partsAmount;

    private Integer flag;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPnnumber() {
        return pnnumber;
    }

    public void setPnnumber(Integer pnnumber) {
        this.pnnumber = pnnumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPnDes() {
        return pnDes;
    }

    public void setPnDes(String pnDes) {
        this.pnDes = pnDes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getPnQuantity() {
        return pnQuantity;
    }

    public void setPnQuantity(Integer pnQuantity) {
        this.pnQuantity = pnQuantity;
    }

    public String getPartsAmount() {
        return partsAmount;
    }

    public void setPartsAmount(String partsAmount) {
        this.partsAmount = partsAmount;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
