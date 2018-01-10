package com.mmnttech.ma.merchant.server.database.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantExample() {
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

        public Criteria andCpyNameIsNull() {
            addCriterion("cpy_name is null");
            return (Criteria) this;
        }

        public Criteria andCpyNameIsNotNull() {
            addCriterion("cpy_name is not null");
            return (Criteria) this;
        }

        public Criteria andCpyNameEqualTo(String value) {
            addCriterion("cpy_name =", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameNotEqualTo(String value) {
            addCriterion("cpy_name <>", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameGreaterThan(String value) {
            addCriterion("cpy_name >", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameGreaterThanOrEqualTo(String value) {
            addCriterion("cpy_name >=", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameLessThan(String value) {
            addCriterion("cpy_name <", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameLessThanOrEqualTo(String value) {
            addCriterion("cpy_name <=", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameLike(String value) {
            addCriterion("cpy_name like", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameNotLike(String value) {
            addCriterion("cpy_name not like", value, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameIn(List<String> values) {
            addCriterion("cpy_name in", values, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameNotIn(List<String> values) {
            addCriterion("cpy_name not in", values, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameBetween(String value1, String value2) {
            addCriterion("cpy_name between", value1, value2, "cpyName");
            return (Criteria) this;
        }

        public Criteria andCpyNameNotBetween(String value1, String value2) {
            addCriterion("cpy_name not between", value1, value2, "cpyName");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNull() {
            addCriterion("industry_code is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNotNull() {
            addCriterion("industry_code is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeEqualTo(String value) {
            addCriterion("industry_code =", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotEqualTo(String value) {
            addCriterion("industry_code <>", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThan(String value) {
            addCriterion("industry_code >", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_code >=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThan(String value) {
            addCriterion("industry_code <", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThanOrEqualTo(String value) {
            addCriterion("industry_code <=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLike(String value) {
            addCriterion("industry_code like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotLike(String value) {
            addCriterion("industry_code not like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIn(List<String> values) {
            addCriterion("industry_code in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotIn(List<String> values) {
            addCriterion("industry_code not in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeBetween(String value1, String value2) {
            addCriterion("industry_code between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotBetween(String value1, String value2) {
            addCriterion("industry_code not between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNull() {
            addCriterion("category_code is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNotNull() {
            addCriterion("category_code is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeEqualTo(String value) {
            addCriterion("category_code =", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotEqualTo(String value) {
            addCriterion("category_code <>", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThan(String value) {
            addCriterion("category_code >", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("category_code >=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThan(String value) {
            addCriterion("category_code <", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("category_code <=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLike(String value) {
            addCriterion("category_code like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotLike(String value) {
            addCriterion("category_code not like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIn(List<String> values) {
            addCriterion("category_code in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotIn(List<String> values) {
            addCriterion("category_code not in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeBetween(String value1, String value2) {
            addCriterion("category_code between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("category_code not between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameIsNull() {
            addCriterion("cpy_legal_name is null");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameIsNotNull() {
            addCriterion("cpy_legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameEqualTo(String value) {
            addCriterion("cpy_legal_name =", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameNotEqualTo(String value) {
            addCriterion("cpy_legal_name <>", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameGreaterThan(String value) {
            addCriterion("cpy_legal_name >", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("cpy_legal_name >=", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameLessThan(String value) {
            addCriterion("cpy_legal_name <", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameLessThanOrEqualTo(String value) {
            addCriterion("cpy_legal_name <=", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameLike(String value) {
            addCriterion("cpy_legal_name like", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameNotLike(String value) {
            addCriterion("cpy_legal_name not like", value, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameIn(List<String> values) {
            addCriterion("cpy_legal_name in", values, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameNotIn(List<String> values) {
            addCriterion("cpy_legal_name not in", values, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameBetween(String value1, String value2) {
            addCriterion("cpy_legal_name between", value1, value2, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyLegalNameNotBetween(String value1, String value2) {
            addCriterion("cpy_legal_name not between", value1, value2, "cpyLegalName");
            return (Criteria) this;
        }

        public Criteria andCpyAddressIsNull() {
            addCriterion("cpy_address is null");
            return (Criteria) this;
        }

        public Criteria andCpyAddressIsNotNull() {
            addCriterion("cpy_address is not null");
            return (Criteria) this;
        }

        public Criteria andCpyAddressEqualTo(String value) {
            addCriterion("cpy_address =", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressNotEqualTo(String value) {
            addCriterion("cpy_address <>", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressGreaterThan(String value) {
            addCriterion("cpy_address >", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cpy_address >=", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressLessThan(String value) {
            addCriterion("cpy_address <", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressLessThanOrEqualTo(String value) {
            addCriterion("cpy_address <=", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressLike(String value) {
            addCriterion("cpy_address like", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressNotLike(String value) {
            addCriterion("cpy_address not like", value, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressIn(List<String> values) {
            addCriterion("cpy_address in", values, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressNotIn(List<String> values) {
            addCriterion("cpy_address not in", values, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressBetween(String value1, String value2) {
            addCriterion("cpy_address between", value1, value2, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andCpyAddressNotBetween(String value1, String value2) {
            addCriterion("cpy_address not between", value1, value2, "cpyAddress");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXIsNull() {
            addCriterion("address_coor_x is null");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXIsNotNull() {
            addCriterion("address_coor_x is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXEqualTo(BigDecimal value) {
            addCriterion("address_coor_x =", value, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXNotEqualTo(BigDecimal value) {
            addCriterion("address_coor_x <>", value, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXGreaterThan(BigDecimal value) {
            addCriterion("address_coor_x >", value, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("address_coor_x >=", value, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXLessThan(BigDecimal value) {
            addCriterion("address_coor_x <", value, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXLessThanOrEqualTo(BigDecimal value) {
            addCriterion("address_coor_x <=", value, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXIn(List<BigDecimal> values) {
            addCriterion("address_coor_x in", values, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXNotIn(List<BigDecimal> values) {
            addCriterion("address_coor_x not in", values, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address_coor_x between", value1, value2, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorXNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address_coor_x not between", value1, value2, "addressCoorX");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYIsNull() {
            addCriterion("address_coor_y is null");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYIsNotNull() {
            addCriterion("address_coor_y is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYEqualTo(BigDecimal value) {
            addCriterion("address_coor_y =", value, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYNotEqualTo(BigDecimal value) {
            addCriterion("address_coor_y <>", value, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYGreaterThan(BigDecimal value) {
            addCriterion("address_coor_y >", value, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("address_coor_y >=", value, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYLessThan(BigDecimal value) {
            addCriterion("address_coor_y <", value, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYLessThanOrEqualTo(BigDecimal value) {
            addCriterion("address_coor_y <=", value, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYIn(List<BigDecimal> values) {
            addCriterion("address_coor_y in", values, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYNotIn(List<BigDecimal> values) {
            addCriterion("address_coor_y not in", values, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address_coor_y between", value1, value2, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andAddressCoorYNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("address_coor_y not between", value1, value2, "addressCoorY");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpecialIsNull() {
            addCriterion("special is null");
            return (Criteria) this;
        }

        public Criteria andSpecialIsNotNull() {
            addCriterion("special is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialEqualTo(String value) {
            addCriterion("special =", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotEqualTo(String value) {
            addCriterion("special <>", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialGreaterThan(String value) {
            addCriterion("special >", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialGreaterThanOrEqualTo(String value) {
            addCriterion("special >=", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialLessThan(String value) {
            addCriterion("special <", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialLessThanOrEqualTo(String value) {
            addCriterion("special <=", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialLike(String value) {
            addCriterion("special like", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotLike(String value) {
            addCriterion("special not like", value, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialIn(List<String> values) {
            addCriterion("special in", values, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotIn(List<String> values) {
            addCriterion("special not in", values, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialBetween(String value1, String value2) {
            addCriterion("special between", value1, value2, "special");
            return (Criteria) this;
        }

        public Criteria andSpecialNotBetween(String value1, String value2) {
            addCriterion("special not between", value1, value2, "special");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andSvrTelIsNull() {
            addCriterion("svr_tel is null");
            return (Criteria) this;
        }

        public Criteria andSvrTelIsNotNull() {
            addCriterion("svr_tel is not null");
            return (Criteria) this;
        }

        public Criteria andSvrTelEqualTo(String value) {
            addCriterion("svr_tel =", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelNotEqualTo(String value) {
            addCriterion("svr_tel <>", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelGreaterThan(String value) {
            addCriterion("svr_tel >", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelGreaterThanOrEqualTo(String value) {
            addCriterion("svr_tel >=", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelLessThan(String value) {
            addCriterion("svr_tel <", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelLessThanOrEqualTo(String value) {
            addCriterion("svr_tel <=", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelLike(String value) {
            addCriterion("svr_tel like", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelNotLike(String value) {
            addCriterion("svr_tel not like", value, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelIn(List<String> values) {
            addCriterion("svr_tel in", values, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelNotIn(List<String> values) {
            addCriterion("svr_tel not in", values, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelBetween(String value1, String value2) {
            addCriterion("svr_tel between", value1, value2, "svrTel");
            return (Criteria) this;
        }

        public Criteria andSvrTelNotBetween(String value1, String value2) {
            addCriterion("svr_tel not between", value1, value2, "svrTel");
            return (Criteria) this;
        }

        public Criteria andAuthStepIsNull() {
            addCriterion("auth_step is null");
            return (Criteria) this;
        }

        public Criteria andAuthStepIsNotNull() {
            addCriterion("auth_step is not null");
            return (Criteria) this;
        }

        public Criteria andAuthStepEqualTo(String value) {
            addCriterion("auth_step =", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepNotEqualTo(String value) {
            addCriterion("auth_step <>", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepGreaterThan(String value) {
            addCriterion("auth_step >", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepGreaterThanOrEqualTo(String value) {
            addCriterion("auth_step >=", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepLessThan(String value) {
            addCriterion("auth_step <", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepLessThanOrEqualTo(String value) {
            addCriterion("auth_step <=", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepLike(String value) {
            addCriterion("auth_step like", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepNotLike(String value) {
            addCriterion("auth_step not like", value, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepIn(List<String> values) {
            addCriterion("auth_step in", values, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepNotIn(List<String> values) {
            addCriterion("auth_step not in", values, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepBetween(String value1, String value2) {
            addCriterion("auth_step between", value1, value2, "authStep");
            return (Criteria) this;
        }

        public Criteria andAuthStepNotBetween(String value1, String value2) {
            addCriterion("auth_step not between", value1, value2, "authStep");
            return (Criteria) this;
        }

        public Criteria andComStatIsNull() {
            addCriterion("com_stat is null");
            return (Criteria) this;
        }

        public Criteria andComStatIsNotNull() {
            addCriterion("com_stat is not null");
            return (Criteria) this;
        }

        public Criteria andComStatEqualTo(String value) {
            addCriterion("com_stat =", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatNotEqualTo(String value) {
            addCriterion("com_stat <>", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatGreaterThan(String value) {
            addCriterion("com_stat >", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatGreaterThanOrEqualTo(String value) {
            addCriterion("com_stat >=", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatLessThan(String value) {
            addCriterion("com_stat <", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatLessThanOrEqualTo(String value) {
            addCriterion("com_stat <=", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatLike(String value) {
            addCriterion("com_stat like", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatNotLike(String value) {
            addCriterion("com_stat not like", value, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatIn(List<String> values) {
            addCriterion("com_stat in", values, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatNotIn(List<String> values) {
            addCriterion("com_stat not in", values, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatBetween(String value1, String value2) {
            addCriterion("com_stat between", value1, value2, "comStat");
            return (Criteria) this;
        }

        public Criteria andComStatNotBetween(String value1, String value2) {
            addCriterion("com_stat not between", value1, value2, "comStat");
            return (Criteria) this;
        }

        public Criteria andAuthReasonIsNull() {
            addCriterion("auth_reason is null");
            return (Criteria) this;
        }

        public Criteria andAuthReasonIsNotNull() {
            addCriterion("auth_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAuthReasonEqualTo(String value) {
            addCriterion("auth_reason =", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonNotEqualTo(String value) {
            addCriterion("auth_reason <>", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonGreaterThan(String value) {
            addCriterion("auth_reason >", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonGreaterThanOrEqualTo(String value) {
            addCriterion("auth_reason >=", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonLessThan(String value) {
            addCriterion("auth_reason <", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonLessThanOrEqualTo(String value) {
            addCriterion("auth_reason <=", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonLike(String value) {
            addCriterion("auth_reason like", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonNotLike(String value) {
            addCriterion("auth_reason not like", value, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonIn(List<String> values) {
            addCriterion("auth_reason in", values, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonNotIn(List<String> values) {
            addCriterion("auth_reason not in", values, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonBetween(String value1, String value2) {
            addCriterion("auth_reason between", value1, value2, "authReason");
            return (Criteria) this;
        }

        public Criteria andAuthReasonNotBetween(String value1, String value2) {
            addCriterion("auth_reason not between", value1, value2, "authReason");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("stat is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("stat is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("stat like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("stat not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andClrActIsNull() {
            addCriterion("clr_act is null");
            return (Criteria) this;
        }

        public Criteria andClrActIsNotNull() {
            addCriterion("clr_act is not null");
            return (Criteria) this;
        }

        public Criteria andClrActEqualTo(String value) {
            addCriterion("clr_act =", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActNotEqualTo(String value) {
            addCriterion("clr_act <>", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActGreaterThan(String value) {
            addCriterion("clr_act >", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActGreaterThanOrEqualTo(String value) {
            addCriterion("clr_act >=", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActLessThan(String value) {
            addCriterion("clr_act <", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActLessThanOrEqualTo(String value) {
            addCriterion("clr_act <=", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActLike(String value) {
            addCriterion("clr_act like", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActNotLike(String value) {
            addCriterion("clr_act not like", value, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActIn(List<String> values) {
            addCriterion("clr_act in", values, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActNotIn(List<String> values) {
            addCriterion("clr_act not in", values, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActBetween(String value1, String value2) {
            addCriterion("clr_act between", value1, value2, "clrAct");
            return (Criteria) this;
        }

        public Criteria andClrActNotBetween(String value1, String value2) {
            addCriterion("clr_act not between", value1, value2, "clrAct");
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