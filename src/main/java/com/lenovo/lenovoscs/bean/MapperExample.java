package com.lenovo.lenovoscs.bean;

import java.util.ArrayList;
import java.util.List;

public class MapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MapperExample() {
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

        public Criteria andPonumberIsNull() {
            addCriterion("ponumber is null");
            return (Criteria) this;
        }

        public Criteria andPonumberIsNotNull() {
            addCriterion("ponumber is not null");
            return (Criteria) this;
        }

        public Criteria andPonumberEqualTo(Integer value) {
            addCriterion("ponumber =", value, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberNotEqualTo(Integer value) {
            addCriterion("ponumber <>", value, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberGreaterThan(Integer value) {
            addCriterion("ponumber >", value, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ponumber >=", value, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberLessThan(Integer value) {
            addCriterion("ponumber <", value, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberLessThanOrEqualTo(Integer value) {
            addCriterion("ponumber <=", value, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberIn(List<Integer> values) {
            addCriterion("ponumber in", values, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberNotIn(List<Integer> values) {
            addCriterion("ponumber not in", values, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberBetween(Integer value1, Integer value2) {
            addCriterion("ponumber between", value1, value2, "ponumber");
            return (Criteria) this;
        }

        public Criteria andPonumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ponumber not between", value1, value2, "ponumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberIsNull() {
            addCriterion("asnnumber is null");
            return (Criteria) this;
        }

        public Criteria andAsnnumberIsNotNull() {
            addCriterion("asnnumber is not null");
            return (Criteria) this;
        }

        public Criteria andAsnnumberEqualTo(Integer value) {
            addCriterion("asnnumber =", value, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberNotEqualTo(Integer value) {
            addCriterion("asnnumber <>", value, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberGreaterThan(Integer value) {
            addCriterion("asnnumber >", value, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("asnnumber >=", value, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberLessThan(Integer value) {
            addCriterion("asnnumber <", value, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberLessThanOrEqualTo(Integer value) {
            addCriterion("asnnumber <=", value, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberIn(List<Integer> values) {
            addCriterion("asnnumber in", values, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberNotIn(List<Integer> values) {
            addCriterion("asnnumber not in", values, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberBetween(Integer value1, Integer value2) {
            addCriterion("asnnumber between", value1, value2, "asnnumber");
            return (Criteria) this;
        }

        public Criteria andAsnnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("asnnumber not between", value1, value2, "asnnumber");
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