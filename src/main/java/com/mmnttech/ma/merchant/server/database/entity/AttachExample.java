package com.mmnttech.ma.merchant.server.database.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttachExample() {
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

        public Criteria andRecIdIsNull() {
            addCriterion("rec_id is null");
            return (Criteria) this;
        }

        public Criteria andRecIdIsNotNull() {
            addCriterion("rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecIdEqualTo(String value) {
            addCriterion("rec_id =", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotEqualTo(String value) {
            addCriterion("rec_id <>", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThan(String value) {
            addCriterion("rec_id >", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThanOrEqualTo(String value) {
            addCriterion("rec_id >=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThan(String value) {
            addCriterion("rec_id <", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThanOrEqualTo(String value) {
            addCriterion("rec_id <=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLike(String value) {
            addCriterion("rec_id like", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotLike(String value) {
            addCriterion("rec_id not like", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdIn(List<String> values) {
            addCriterion("rec_id in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotIn(List<String> values) {
            addCriterion("rec_id not in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdBetween(String value1, String value2) {
            addCriterion("rec_id between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotBetween(String value1, String value2) {
            addCriterion("rec_id not between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNull() {
            addCriterion("master_id is null");
            return (Criteria) this;
        }

        public Criteria andMasterIdIsNotNull() {
            addCriterion("master_id is not null");
            return (Criteria) this;
        }

        public Criteria andMasterIdEqualTo(String value) {
            addCriterion("master_id =", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotEqualTo(String value) {
            addCriterion("master_id <>", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThan(String value) {
            addCriterion("master_id >", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdGreaterThanOrEqualTo(String value) {
            addCriterion("master_id >=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThan(String value) {
            addCriterion("master_id <", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLessThanOrEqualTo(String value) {
            addCriterion("master_id <=", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdLike(String value) {
            addCriterion("master_id like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotLike(String value) {
            addCriterion("master_id not like", value, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdIn(List<String> values) {
            addCriterion("master_id in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotIn(List<String> values) {
            addCriterion("master_id not in", values, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdBetween(String value1, String value2) {
            addCriterion("master_id between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andMasterIdNotBetween(String value1, String value2) {
            addCriterion("master_id not between", value1, value2, "masterId");
            return (Criteria) this;
        }

        public Criteria andSeriNoIsNull() {
            addCriterion("seri_no is null");
            return (Criteria) this;
        }

        public Criteria andSeriNoIsNotNull() {
            addCriterion("seri_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeriNoEqualTo(Integer value) {
            addCriterion("seri_no =", value, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoNotEqualTo(Integer value) {
            addCriterion("seri_no <>", value, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoGreaterThan(Integer value) {
            addCriterion("seri_no >", value, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("seri_no >=", value, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoLessThan(Integer value) {
            addCriterion("seri_no <", value, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoLessThanOrEqualTo(Integer value) {
            addCriterion("seri_no <=", value, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoIn(List<Integer> values) {
            addCriterion("seri_no in", values, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoNotIn(List<Integer> values) {
            addCriterion("seri_no not in", values, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoBetween(Integer value1, Integer value2) {
            addCriterion("seri_no between", value1, value2, "seriNo");
            return (Criteria) this;
        }

        public Criteria andSeriNoNotBetween(Integer value1, Integer value2) {
            addCriterion("seri_no not between", value1, value2, "seriNo");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAttachUrlIsNull() {
            addCriterion("attach_url is null");
            return (Criteria) this;
        }

        public Criteria andAttachUrlIsNotNull() {
            addCriterion("attach_url is not null");
            return (Criteria) this;
        }

        public Criteria andAttachUrlEqualTo(String value) {
            addCriterion("attach_url =", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotEqualTo(String value) {
            addCriterion("attach_url <>", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlGreaterThan(String value) {
            addCriterion("attach_url >", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlGreaterThanOrEqualTo(String value) {
            addCriterion("attach_url >=", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLessThan(String value) {
            addCriterion("attach_url <", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLessThanOrEqualTo(String value) {
            addCriterion("attach_url <=", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlLike(String value) {
            addCriterion("attach_url like", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotLike(String value) {
            addCriterion("attach_url not like", value, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlIn(List<String> values) {
            addCriterion("attach_url in", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotIn(List<String> values) {
            addCriterion("attach_url not in", values, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlBetween(String value1, String value2) {
            addCriterion("attach_url between", value1, value2, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andAttachUrlNotBetween(String value1, String value2) {
            addCriterion("attach_url not between", value1, value2, "attachUrl");
            return (Criteria) this;
        }

        public Criteria andComMemoIsNull() {
            addCriterion("com_memo is null");
            return (Criteria) this;
        }

        public Criteria andComMemoIsNotNull() {
            addCriterion("com_memo is not null");
            return (Criteria) this;
        }

        public Criteria andComMemoEqualTo(String value) {
            addCriterion("com_memo =", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoNotEqualTo(String value) {
            addCriterion("com_memo <>", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoGreaterThan(String value) {
            addCriterion("com_memo >", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoGreaterThanOrEqualTo(String value) {
            addCriterion("com_memo >=", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoLessThan(String value) {
            addCriterion("com_memo <", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoLessThanOrEqualTo(String value) {
            addCriterion("com_memo <=", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoLike(String value) {
            addCriterion("com_memo like", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoNotLike(String value) {
            addCriterion("com_memo not like", value, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoIn(List<String> values) {
            addCriterion("com_memo in", values, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoNotIn(List<String> values) {
            addCriterion("com_memo not in", values, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoBetween(String value1, String value2) {
            addCriterion("com_memo between", value1, value2, "comMemo");
            return (Criteria) this;
        }

        public Criteria andComMemoNotBetween(String value1, String value2) {
            addCriterion("com_memo not between", value1, value2, "comMemo");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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