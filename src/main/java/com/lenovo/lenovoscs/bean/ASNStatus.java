package com.lenovo.lenovoscs.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ASNStatus {

    private Integer id;

    private Integer ponumber;

    private Integer asnnumber;

    private Integer pnnumber;

    private Integer pnQuantity;

    private String payment;

    private String shipTo;

    private String soldTo;

    private String orderType;

    private String exchangeProvisionItem;

    private String conditionItem;

    private String remark;

    private String carrier;

    private String customer;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date netDueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date poDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date deliveryDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date dropOrderTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date targetDate;

    private String createdBy;

    private String lastModifiedBy;

    private Integer flag;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPonumber() {
        return ponumber;
    }

    public void setPonumber(Integer ponumber) {
        this.ponumber = ponumber;
    }

    public Integer getAsnnumber() {
        return asnnumber;
    }

    public void setAsnnumber(Integer asnnumber) {
        this.asnnumber = asnnumber;
    }

    public Integer getPnnumber() {
        return pnnumber;
    }

    public void setPnnumber(Integer pnnumber) {
        this.pnnumber = pnnumber;
    }

    public Integer getPnQuantity() {
        return pnQuantity;
    }

    public void setPnQuantity(Integer pnQuantity) {
        this.pnQuantity = pnQuantity;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public String getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(String soldTo) {
        this.soldTo = soldTo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getExchangeProvisionItem() {
        return exchangeProvisionItem;
    }

    public void setExchangeProvisionItem(String exchangeProvisionItem) {
        this.exchangeProvisionItem = exchangeProvisionItem;
    }

    public String getConditionItem() {
        return conditionItem;
    }

    public void setConditionItem(String conditionItem) {
        this.conditionItem = conditionItem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getNetDueDate() {
        return netDueDate;
    }

    public void setNetDueDate(Date netDueDate) {
        this.netDueDate = netDueDate;
    }

    public Date getPoDate() {
        return poDate;
    }

    public void setPoDate(Date poDate) {
        this.poDate = poDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getDropOrderTime() {
        return dropOrderTime;
    }

    public void setDropOrderTime(Date dropOrderTime) {
        this.dropOrderTime = dropOrderTime;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
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
