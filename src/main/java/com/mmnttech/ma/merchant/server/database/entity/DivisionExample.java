package com.mmnttech.ma.merchant.server.database.entity;

import java.util.ArrayList;
import java.util.List;

public class DivisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DivisionExample() {
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

        public Criteria andDivCodeIsNull() {
            addCriterion("div_code is null");
            return (Criteria) this;
        }

        public Criteria andDivCodeIsNotNull() {
            addCriterion("div_code is not null");
            return (Criteria) this;
        }

        public Criteria andDivCodeEqualTo(String value) {
            addCriterion("div_code =", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeNotEqualTo(String value) {
            addCriterion("div_code <>", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeGreaterThan(String value) {
            addCriterion("div_code >", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeGreaterThanOrEqualTo(String value) {
            addCriterion("div_code >=", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeLessThan(String value) {
            addCriterion("div_code <", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeLessThanOrEqualTo(String value) {
            addCriterion("div_code <=", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeLike(String value) {
            addCriterion("div_code like", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeNotLike(String value) {
            addCriterion("div_code not like", value, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeIn(List<String> values) {
            addCriterion("div_code in", values, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeNotIn(List<String> values) {
            addCriterion("div_code not in", values, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeBetween(String value1, String value2) {
            addCriterion("div_code between", value1, value2, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivCodeNotBetween(String value1, String value2) {
            addCriterion("div_code not between", value1, value2, "divCode");
            return (Criteria) this;
        }

        public Criteria andDivNameIsNull() {
            addCriterion("div_name is null");
            return (Criteria) this;
        }

        public Criteria andDivNameIsNotNull() {
            addCriterion("div_name is not null");
            return (Criteria) this;
        }

        public Criteria andDivNameEqualTo(String value) {
            addCriterion("div_name =", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameNotEqualTo(String value) {
            addCriterion("div_name <>", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameGreaterThan(String value) {
            addCriterion("div_name >", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameGreaterThanOrEqualTo(String value) {
            addCriterion("div_name >=", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameLessThan(String value) {
            addCriterion("div_name <", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameLessThanOrEqualTo(String value) {
            addCriterion("div_name <=", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameLike(String value) {
            addCriterion("div_name like", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameNotLike(String value) {
            addCriterion("div_name not like", value, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameIn(List<String> values) {
            addCriterion("div_name in", values, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameNotIn(List<String> values) {
            addCriterion("div_name not in", values, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameBetween(String value1, String value2) {
            addCriterion("div_name between", value1, value2, "divName");
            return (Criteria) this;
        }

        public Criteria andDivNameNotBetween(String value1, String value2) {
            addCriterion("div_name not between", value1, value2, "divName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
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