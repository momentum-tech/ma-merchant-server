package com.mmnttech.ma.merchant.server.database.entity;

import java.util.ArrayList;
import java.util.List;

public class PlatParaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlatParaExample() {
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

        public Criteria andPlatNoIsNull() {
            addCriterion("plat_no is null");
            return (Criteria) this;
        }

        public Criteria andPlatNoIsNotNull() {
            addCriterion("plat_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlatNoEqualTo(String value) {
            addCriterion("plat_no =", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoNotEqualTo(String value) {
            addCriterion("plat_no <>", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoGreaterThan(String value) {
            addCriterion("plat_no >", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoGreaterThanOrEqualTo(String value) {
            addCriterion("plat_no >=", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoLessThan(String value) {
            addCriterion("plat_no <", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoLessThanOrEqualTo(String value) {
            addCriterion("plat_no <=", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoLike(String value) {
            addCriterion("plat_no like", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoNotLike(String value) {
            addCriterion("plat_no not like", value, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoIn(List<String> values) {
            addCriterion("plat_no in", values, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoNotIn(List<String> values) {
            addCriterion("plat_no not in", values, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoBetween(String value1, String value2) {
            addCriterion("plat_no between", value1, value2, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNoNotBetween(String value1, String value2) {
            addCriterion("plat_no not between", value1, value2, "platNo");
            return (Criteria) this;
        }

        public Criteria andPlatNameIsNull() {
            addCriterion("plat_name is null");
            return (Criteria) this;
        }

        public Criteria andPlatNameIsNotNull() {
            addCriterion("plat_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlatNameEqualTo(String value) {
            addCriterion("plat_name =", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameNotEqualTo(String value) {
            addCriterion("plat_name <>", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameGreaterThan(String value) {
            addCriterion("plat_name >", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameGreaterThanOrEqualTo(String value) {
            addCriterion("plat_name >=", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameLessThan(String value) {
            addCriterion("plat_name <", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameLessThanOrEqualTo(String value) {
            addCriterion("plat_name <=", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameLike(String value) {
            addCriterion("plat_name like", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameNotLike(String value) {
            addCriterion("plat_name not like", value, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameIn(List<String> values) {
            addCriterion("plat_name in", values, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameNotIn(List<String> values) {
            addCriterion("plat_name not in", values, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameBetween(String value1, String value2) {
            addCriterion("plat_name between", value1, value2, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatNameNotBetween(String value1, String value2) {
            addCriterion("plat_name not between", value1, value2, "platName");
            return (Criteria) this;
        }

        public Criteria andPlatStatIsNull() {
            addCriterion("plat_stat is null");
            return (Criteria) this;
        }

        public Criteria andPlatStatIsNotNull() {
            addCriterion("plat_stat is not null");
            return (Criteria) this;
        }

        public Criteria andPlatStatEqualTo(String value) {
            addCriterion("plat_stat =", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatNotEqualTo(String value) {
            addCriterion("plat_stat <>", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatGreaterThan(String value) {
            addCriterion("plat_stat >", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatGreaterThanOrEqualTo(String value) {
            addCriterion("plat_stat >=", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatLessThan(String value) {
            addCriterion("plat_stat <", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatLessThanOrEqualTo(String value) {
            addCriterion("plat_stat <=", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatLike(String value) {
            addCriterion("plat_stat like", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatNotLike(String value) {
            addCriterion("plat_stat not like", value, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatIn(List<String> values) {
            addCriterion("plat_stat in", values, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatNotIn(List<String> values) {
            addCriterion("plat_stat not in", values, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatBetween(String value1, String value2) {
            addCriterion("plat_stat between", value1, value2, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatStatNotBetween(String value1, String value2) {
            addCriterion("plat_stat not between", value1, value2, "platStat");
            return (Criteria) this;
        }

        public Criteria andPlatDateIsNull() {
            addCriterion("plat_date is null");
            return (Criteria) this;
        }

        public Criteria andPlatDateIsNotNull() {
            addCriterion("plat_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlatDateEqualTo(String value) {
            addCriterion("plat_date =", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateNotEqualTo(String value) {
            addCriterion("plat_date <>", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateGreaterThan(String value) {
            addCriterion("plat_date >", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateGreaterThanOrEqualTo(String value) {
            addCriterion("plat_date >=", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateLessThan(String value) {
            addCriterion("plat_date <", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateLessThanOrEqualTo(String value) {
            addCriterion("plat_date <=", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateLike(String value) {
            addCriterion("plat_date like", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateNotLike(String value) {
            addCriterion("plat_date not like", value, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateIn(List<String> values) {
            addCriterion("plat_date in", values, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateNotIn(List<String> values) {
            addCriterion("plat_date not in", values, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateBetween(String value1, String value2) {
            addCriterion("plat_date between", value1, value2, "platDate");
            return (Criteria) this;
        }

        public Criteria andPlatDateNotBetween(String value1, String value2) {
            addCriterion("plat_date not between", value1, value2, "platDate");
            return (Criteria) this;
        }

        public Criteria andPreDateIsNull() {
            addCriterion("pre_date is null");
            return (Criteria) this;
        }

        public Criteria andPreDateIsNotNull() {
            addCriterion("pre_date is not null");
            return (Criteria) this;
        }

        public Criteria andPreDateEqualTo(String value) {
            addCriterion("pre_date =", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotEqualTo(String value) {
            addCriterion("pre_date <>", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateGreaterThan(String value) {
            addCriterion("pre_date >", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateGreaterThanOrEqualTo(String value) {
            addCriterion("pre_date >=", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLessThan(String value) {
            addCriterion("pre_date <", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLessThanOrEqualTo(String value) {
            addCriterion("pre_date <=", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateLike(String value) {
            addCriterion("pre_date like", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotLike(String value) {
            addCriterion("pre_date not like", value, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateIn(List<String> values) {
            addCriterion("pre_date in", values, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotIn(List<String> values) {
            addCriterion("pre_date not in", values, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateBetween(String value1, String value2) {
            addCriterion("pre_date between", value1, value2, "preDate");
            return (Criteria) this;
        }

        public Criteria andPreDateNotBetween(String value1, String value2) {
            addCriterion("pre_date not between", value1, value2, "preDate");
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