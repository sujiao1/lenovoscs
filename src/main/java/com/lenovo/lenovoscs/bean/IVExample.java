package com.lenovo.lenovoscs.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IVExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IVExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIvnumberIsNull() {
            addCriterion("ivnumber is null");
            return (Criteria) this;
        }

        public Criteria andIvnumberIsNotNull() {
            addCriterion("ivnumber is not null");
            return (Criteria) this;
        }

        public Criteria andIvnumberEqualTo(Integer value) {
            addCriterion("ivnumber =", value, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberNotEqualTo(Integer value) {
            addCriterion("ivnumber <>", value, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberGreaterThan(Integer value) {
            addCriterion("ivnumber >", value, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ivnumber >=", value, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberLessThan(Integer value) {
            addCriterion("ivnumber <", value, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberLessThanOrEqualTo(Integer value) {
            addCriterion("ivnumber <=", value, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberIn(List<Integer> values) {
            addCriterion("ivnumber in", values, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberNotIn(List<Integer> values) {
            addCriterion("ivnumber not in", values, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberBetween(Integer value1, Integer value2) {
            addCriterion("ivnumber between", value1, value2, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andIvnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ivnumber not between", value1, value2, "ivnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberIsNull() {
            addCriterion("pnnumber is null");
            return (Criteria) this;
        }

        public Criteria andPnnumberIsNotNull() {
            addCriterion("pnnumber is not null");
            return (Criteria) this;
        }

        public Criteria andPnnumberEqualTo(Integer value) {
            addCriterion("pnnumber =", value, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberNotEqualTo(Integer value) {
            addCriterion("pnnumber <>", value, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberGreaterThan(Integer value) {
            addCriterion("pnnumber >", value, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pnnumber >=", value, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberLessThan(Integer value) {
            addCriterion("pnnumber <", value, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberLessThanOrEqualTo(Integer value) {
            addCriterion("pnnumber <=", value, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberIn(List<Integer> values) {
            addCriterion("pnnumber in", values, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberNotIn(List<Integer> values) {
            addCriterion("pnnumber not in", values, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberBetween(Integer value1, Integer value2) {
            addCriterion("pnnumber between", value1, value2, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pnnumber not between", value1, value2, "pnnumber");
            return (Criteria) this;
        }

        public Criteria andPnQuantityIsNull() {
            addCriterion("pn_quantity is null");
            return (Criteria) this;
        }

        public Criteria andPnQuantityIsNotNull() {
            addCriterion("pn_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andPnQuantityEqualTo(Integer value) {
            addCriterion("pn_quantity =", value, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityNotEqualTo(Integer value) {
            addCriterion("pn_quantity <>", value, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityGreaterThan(Integer value) {
            addCriterion("pn_quantity >", value, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("pn_quantity >=", value, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityLessThan(Integer value) {
            addCriterion("pn_quantity <", value, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("pn_quantity <=", value, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityIn(List<Integer> values) {
            addCriterion("pn_quantity in", values, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityNotIn(List<Integer> values) {
            addCriterion("pn_quantity not in", values, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityBetween(Integer value1, Integer value2) {
            addCriterion("pn_quantity between", value1, value2, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPnQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("pn_quantity not between", value1, value2, "pnQuantity");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(String value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(String value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(String value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(String value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(String value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLike(String value) {
            addCriterion("payment like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotLike(String value) {
            addCriterion("payment not like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<String> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<String> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(String value1, String value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(String value1, String value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andShipToIsNull() {
            addCriterion("ship_to is null");
            return (Criteria) this;
        }

        public Criteria andShipToIsNotNull() {
            addCriterion("ship_to is not null");
            return (Criteria) this;
        }

        public Criteria andShipToEqualTo(String value) {
            addCriterion("ship_to =", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotEqualTo(String value) {
            addCriterion("ship_to <>", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToGreaterThan(String value) {
            addCriterion("ship_to >", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToGreaterThanOrEqualTo(String value) {
            addCriterion("ship_to >=", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLessThan(String value) {
            addCriterion("ship_to <", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLessThanOrEqualTo(String value) {
            addCriterion("ship_to <=", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToLike(String value) {
            addCriterion("ship_to like", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotLike(String value) {
            addCriterion("ship_to not like", value, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToIn(List<String> values) {
            addCriterion("ship_to in", values, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotIn(List<String> values) {
            addCriterion("ship_to not in", values, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToBetween(String value1, String value2) {
            addCriterion("ship_to between", value1, value2, "shipTo");
            return (Criteria) this;
        }

        public Criteria andShipToNotBetween(String value1, String value2) {
            addCriterion("ship_to not between", value1, value2, "shipTo");
            return (Criteria) this;
        }

        public Criteria andSoldToIsNull() {
            addCriterion("sold_to is null");
            return (Criteria) this;
        }

        public Criteria andSoldToIsNotNull() {
            addCriterion("sold_to is not null");
            return (Criteria) this;
        }

        public Criteria andSoldToEqualTo(String value) {
            addCriterion("sold_to =", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToNotEqualTo(String value) {
            addCriterion("sold_to <>", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToGreaterThan(String value) {
            addCriterion("sold_to >", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToGreaterThanOrEqualTo(String value) {
            addCriterion("sold_to >=", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToLessThan(String value) {
            addCriterion("sold_to <", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToLessThanOrEqualTo(String value) {
            addCriterion("sold_to <=", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToLike(String value) {
            addCriterion("sold_to like", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToNotLike(String value) {
            addCriterion("sold_to not like", value, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToIn(List<String> values) {
            addCriterion("sold_to in", values, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToNotIn(List<String> values) {
            addCriterion("sold_to not in", values, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToBetween(String value1, String value2) {
            addCriterion("sold_to between", value1, value2, "soldTo");
            return (Criteria) this;
        }

        public Criteria andSoldToNotBetween(String value1, String value2) {
            addCriterion("sold_to not between", value1, value2, "soldTo");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemIsNull() {
            addCriterion("exchange_provision_item is null");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemIsNotNull() {
            addCriterion("exchange_provision_item is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemEqualTo(String value) {
            addCriterion("exchange_provision_item =", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemNotEqualTo(String value) {
            addCriterion("exchange_provision_item <>", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemGreaterThan(String value) {
            addCriterion("exchange_provision_item >", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemGreaterThanOrEqualTo(String value) {
            addCriterion("exchange_provision_item >=", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemLessThan(String value) {
            addCriterion("exchange_provision_item <", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemLessThanOrEqualTo(String value) {
            addCriterion("exchange_provision_item <=", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemLike(String value) {
            addCriterion("exchange_provision_item like", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemNotLike(String value) {
            addCriterion("exchange_provision_item not like", value, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemIn(List<String> values) {
            addCriterion("exchange_provision_item in", values, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemNotIn(List<String> values) {
            addCriterion("exchange_provision_item not in", values, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemBetween(String value1, String value2) {
            addCriterion("exchange_provision_item between", value1, value2, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andExchangeProvisionItemNotBetween(String value1, String value2) {
            addCriterion("exchange_provision_item not between", value1, value2, "exchangeProvisionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemIsNull() {
            addCriterion("condition_item is null");
            return (Criteria) this;
        }

        public Criteria andConditionItemIsNotNull() {
            addCriterion("condition_item is not null");
            return (Criteria) this;
        }

        public Criteria andConditionItemEqualTo(String value) {
            addCriterion("condition_item =", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemNotEqualTo(String value) {
            addCriterion("condition_item <>", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemGreaterThan(String value) {
            addCriterion("condition_item >", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemGreaterThanOrEqualTo(String value) {
            addCriterion("condition_item >=", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemLessThan(String value) {
            addCriterion("condition_item <", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemLessThanOrEqualTo(String value) {
            addCriterion("condition_item <=", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemLike(String value) {
            addCriterion("condition_item like", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemNotLike(String value) {
            addCriterion("condition_item not like", value, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemIn(List<String> values) {
            addCriterion("condition_item in", values, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemNotIn(List<String> values) {
            addCriterion("condition_item not in", values, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemBetween(String value1, String value2) {
            addCriterion("condition_item between", value1, value2, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andConditionItemNotBetween(String value1, String value2) {
            addCriterion("condition_item not between", value1, value2, "conditionItem");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCarrierIsNull() {
            addCriterion("carrier is null");
            return (Criteria) this;
        }

        public Criteria andCarrierIsNotNull() {
            addCriterion("carrier is not null");
            return (Criteria) this;
        }

        public Criteria andCarrierEqualTo(String value) {
            addCriterion("carrier =", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierNotEqualTo(String value) {
            addCriterion("carrier <>", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierGreaterThan(String value) {
            addCriterion("carrier >", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierGreaterThanOrEqualTo(String value) {
            addCriterion("carrier >=", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierLessThan(String value) {
            addCriterion("carrier <", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierLessThanOrEqualTo(String value) {
            addCriterion("carrier <=", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierLike(String value) {
            addCriterion("carrier like", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierNotLike(String value) {
            addCriterion("carrier not like", value, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierIn(List<String> values) {
            addCriterion("carrier in", values, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierNotIn(List<String> values) {
            addCriterion("carrier not in", values, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierBetween(String value1, String value2) {
            addCriterion("carrier between", value1, value2, "carrier");
            return (Criteria) this;
        }

        public Criteria andCarrierNotBetween(String value1, String value2) {
            addCriterion("carrier not between", value1, value2, "carrier");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNull() {
            addCriterion("customer is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNotNull() {
            addCriterion("customer is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEqualTo(String value) {
            addCriterion("customer =", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotEqualTo(String value) {
            addCriterion("customer <>", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThan(String value) {
            addCriterion("customer >", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("customer >=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThan(String value) {
            addCriterion("customer <", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThanOrEqualTo(String value) {
            addCriterion("customer <=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLike(String value) {
            addCriterion("customer like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotLike(String value) {
            addCriterion("customer not like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerIn(List<String> values) {
            addCriterion("customer in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotIn(List<String> values) {
            addCriterion("customer not in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerBetween(String value1, String value2) {
            addCriterion("customer between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotBetween(String value1, String value2) {
            addCriterion("customer not between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andNetDueDateIsNull() {
            addCriterion("net_due_date is null");
            return (Criteria) this;
        }

        public Criteria andNetDueDateIsNotNull() {
            addCriterion("net_due_date is not null");
            return (Criteria) this;
        }

        public Criteria andNetDueDateEqualTo(Date value) {
            addCriterion("net_due_date =", value, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateNotEqualTo(Date value) {
            addCriterion("net_due_date <>", value, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateGreaterThan(Date value) {
            addCriterion("net_due_date >", value, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("net_due_date >=", value, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateLessThan(Date value) {
            addCriterion("net_due_date <", value, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateLessThanOrEqualTo(Date value) {
            addCriterion("net_due_date <=", value, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateIn(List<Date> values) {
            addCriterion("net_due_date in", values, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateNotIn(List<Date> values) {
            addCriterion("net_due_date not in", values, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateBetween(Date value1, Date value2) {
            addCriterion("net_due_date between", value1, value2, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andNetDueDateNotBetween(Date value1, Date value2) {
            addCriterion("net_due_date not between", value1, value2, "netDueDate");
            return (Criteria) this;
        }

        public Criteria andPoDateIsNull() {
            addCriterion("po_date is null");
            return (Criteria) this;
        }

        public Criteria andPoDateIsNotNull() {
            addCriterion("po_date is not null");
            return (Criteria) this;
        }

        public Criteria andPoDateEqualTo(Date value) {
            addCriterion("po_date =", value, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateNotEqualTo(Date value) {
            addCriterion("po_date <>", value, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateGreaterThan(Date value) {
            addCriterion("po_date >", value, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateGreaterThanOrEqualTo(Date value) {
            addCriterion("po_date >=", value, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateLessThan(Date value) {
            addCriterion("po_date <", value, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateLessThanOrEqualTo(Date value) {
            addCriterion("po_date <=", value, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateIn(List<Date> values) {
            addCriterion("po_date in", values, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateNotIn(List<Date> values) {
            addCriterion("po_date not in", values, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateBetween(Date value1, Date value2) {
            addCriterion("po_date between", value1, value2, "poDate");
            return (Criteria) this;
        }

        public Criteria andPoDateNotBetween(Date value1, Date value2) {
            addCriterion("po_date not between", value1, value2, "poDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Date value) {
            addCriterion("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Date value) {
            addCriterion("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Date value) {
            addCriterion("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Date value) {
            addCriterion("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Date> values) {
            addCriterion("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Date> values) {
            addCriterion("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeIsNull() {
            addCriterion("drop_order_time is null");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeIsNotNull() {
            addCriterion("drop_order_time is not null");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeEqualTo(Date value) {
            addCriterion("drop_order_time =", value, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeNotEqualTo(Date value) {
            addCriterion("drop_order_time <>", value, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeGreaterThan(Date value) {
            addCriterion("drop_order_time >", value, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("drop_order_time >=", value, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeLessThan(Date value) {
            addCriterion("drop_order_time <", value, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("drop_order_time <=", value, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeIn(List<Date> values) {
            addCriterion("drop_order_time in", values, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeNotIn(List<Date> values) {
            addCriterion("drop_order_time not in", values, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeBetween(Date value1, Date value2) {
            addCriterion("drop_order_time between", value1, value2, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andDropOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("drop_order_time not between", value1, value2, "dropOrderTime");
            return (Criteria) this;
        }

        public Criteria andTargetDateIsNull() {
            addCriterion("target_date is null");
            return (Criteria) this;
        }

        public Criteria andTargetDateIsNotNull() {
            addCriterion("target_date is not null");
            return (Criteria) this;
        }

        public Criteria andTargetDateEqualTo(Date value) {
            addCriterion("target_date =", value, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateNotEqualTo(Date value) {
            addCriterion("target_date <>", value, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateGreaterThan(Date value) {
            addCriterion("target_date >", value, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateGreaterThanOrEqualTo(Date value) {
            addCriterion("target_date >=", value, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateLessThan(Date value) {
            addCriterion("target_date <", value, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateLessThanOrEqualTo(Date value) {
            addCriterion("target_date <=", value, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateIn(List<Date> values) {
            addCriterion("target_date in", values, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateNotIn(List<Date> values) {
            addCriterion("target_date not in", values, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateBetween(Date value1, Date value2) {
            addCriterion("target_date between", value1, value2, "targetDate");
            return (Criteria) this;
        }

        public Criteria andTargetDateNotBetween(Date value1, Date value2) {
            addCriterion("target_date not between", value1, value2, "targetDate");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("created_by is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("created_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("created_by =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("created_by <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("created_by >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("created_by >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("created_by <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("created_by <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("created_by like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("created_by not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("created_by in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("created_by not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("created_by between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("created_by not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByIsNull() {
            addCriterion("last_modified_by is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByIsNotNull() {
            addCriterion("last_modified_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByEqualTo(String value) {
            addCriterion("last_modified_by =", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotEqualTo(String value) {
            addCriterion("last_modified_by <>", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByGreaterThan(String value) {
            addCriterion("last_modified_by >", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByGreaterThanOrEqualTo(String value) {
            addCriterion("last_modified_by >=", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByLessThan(String value) {
            addCriterion("last_modified_by <", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByLessThanOrEqualTo(String value) {
            addCriterion("last_modified_by <=", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByLike(String value) {
            addCriterion("last_modified_by like", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotLike(String value) {
            addCriterion("last_modified_by not like", value, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByIn(List<String> values) {
            addCriterion("last_modified_by in", values, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotIn(List<String> values) {
            addCriterion("last_modified_by not in", values, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByBetween(String value1, String value2) {
            addCriterion("last_modified_by between", value1, value2, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andLastModifiedByNotBetween(String value1, String value2) {
            addCriterion("last_modified_by not between", value1, value2, "lastModifiedBy");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}