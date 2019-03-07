package com.lenovo.lenovoscs.bean;

import java.math.BigDecimal;

public class PN {
    private Long id;

    private Integer pnnumber;

    private Integer number;

    private String pnDes;

    private String category;

    private String unit;

    private BigDecimal price;

    private Integer pnQuantity;

    private String partsAmount;

    private Integer flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        this.pnDes = pnDes == null ? null : pnDes.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
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
        this.partsAmount = partsAmount == null ? null : partsAmount.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}