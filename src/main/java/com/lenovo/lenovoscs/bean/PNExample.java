package com.lenovo.lenovoscs.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PNExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PNExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Integer value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Integer value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Integer value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Integer> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andPnDesIsNull() {
            addCriterion("pn_des is null");
            return (Criteria) this;
        }

        public Criteria andPnDesIsNotNull() {
            addCriterion("pn_des is not null");
            return (Criteria) this;
        }

        public Criteria andPnDesEqualTo(String value) {
            addCriterion("pn_des =", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesNotEqualTo(String value) {
            addCriterion("pn_des <>", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesGreaterThan(String value) {
            addCriterion("pn_des >", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesGreaterThanOrEqualTo(String value) {
            addCriterion("pn_des >=", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesLessThan(String value) {
            addCriterion("pn_des <", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesLessThanOrEqualTo(String value) {
            addCriterion("pn_des <=", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesLike(String value) {
            addCriterion("pn_des like", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesNotLike(String value) {
            addCriterion("pn_des not like", value, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesIn(List<String> values) {
            addCriterion("pn_des in", values, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesNotIn(List<String> values) {
            addCriterion("pn_des not in", values, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesBetween(String value1, String value2) {
            addCriterion("pn_des between", value1, value2, "pnDes");
            return (Criteria) this;
        }

        public Criteria andPnDesNotBetween(String value1, String value2) {
            addCriterion("pn_des not between", value1, value2, "pnDes");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andPartsAmountIsNull() {
            addCriterion("parts_amount is null");
            return (Criteria) this;
        }

        public Criteria andPartsAmountIsNotNull() {
            addCriterion("parts_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPartsAmountEqualTo(String value) {
            addCriterion("parts_amount =", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountNotEqualTo(String value) {
            addCriterion("parts_amount <>", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountGreaterThan(String value) {
            addCriterion("parts_amount >", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountGreaterThanOrEqualTo(String value) {
            addCriterion("parts_amount >=", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountLessThan(String value) {
            addCriterion("parts_amount <", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountLessThanOrEqualTo(String value) {
            addCriterion("parts_amount <=", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountLike(String value) {
            addCriterion("parts_amount like", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountNotLike(String value) {
            addCriterion("parts_amount not like", value, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountIn(List<String> values) {
            addCriterion("parts_amount in", values, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountNotIn(List<String> values) {
            addCriterion("parts_amount not in", values, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountBetween(String value1, String value2) {
            addCriterion("parts_amount between", value1, value2, "partsAmount");
            return (Criteria) this;
        }

        public Criteria andPartsAmountNotBetween(String value1, String value2) {
            addCriterion("parts_amount not between", value1, value2, "partsAmount");
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