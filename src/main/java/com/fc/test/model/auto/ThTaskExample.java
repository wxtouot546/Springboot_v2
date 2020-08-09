package com.fc.test.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  ThTaskExample
 * @author ssss_自动生成
 * @email ssss@qq.com
 * @date 2020-08-09 13:18:53
 */
public class ThTaskExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThTaskExample() {
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

        public Criteria andIdLike(Integer value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(Integer value) {
            addCriterion("id not like", value, "id");
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
        
			
        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andTypeEqualTo(Character value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Character value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Character value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Character value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Character value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Character value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(Character value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(Character value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Character> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Character> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Character value1, Character value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Character value1, Character value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andNumberLike(Integer value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(Integer value) {
            addCriterion("number not like", value, "number");
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
        
			
        public Criteria andOldNumberIsNull() {
            addCriterion("old_number is null");
            return (Criteria) this;
        }

        public Criteria andOldNumberIsNotNull() {
            addCriterion("old_number is not null");
            return (Criteria) this;
        }

        public Criteria andOldNumberEqualTo(Integer value) {
            addCriterion("old_number =", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberNotEqualTo(Integer value) {
            addCriterion("old_number <>", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberGreaterThan(Integer value) {
            addCriterion("old_number >", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_number >=", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberLessThan(Integer value) {
            addCriterion("old_number <", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberLessThanOrEqualTo(Integer value) {
            addCriterion("old_number <=", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberLike(Integer value) {
            addCriterion("old_number like", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberNotLike(Integer value) {
            addCriterion("old_number not like", value, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberIn(List<Integer> values) {
            addCriterion("old_number in", values, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberNotIn(List<Integer> values) {
            addCriterion("old_number not in", values, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberBetween(Integer value1, Integer value2) {
            addCriterion("old_number between", value1, value2, "oldNumber");
            return (Criteria) this;
        }

        public Criteria andOldNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("old_number not between", value1, value2, "oldNumber");
            return (Criteria) this;
        }
        
			
        public Criteria andUserIdsIsNull() {
            addCriterion("user_ids is null");
            return (Criteria) this;
        }

        public Criteria andUserIdsIsNotNull() {
            addCriterion("user_ids is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdsEqualTo(String value) {
            addCriterion("user_ids =", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotEqualTo(String value) {
            addCriterion("user_ids <>", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsGreaterThan(String value) {
            addCriterion("user_ids >", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("user_ids >=", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLessThan(String value) {
            addCriterion("user_ids <", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLessThanOrEqualTo(String value) {
            addCriterion("user_ids <=", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLike(String value) {
            addCriterion("user_ids like", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotLike(String value) {
            addCriterion("user_ids not like", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsIn(List<String> values) {
            addCriterion("user_ids in", values, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotIn(List<String> values) {
            addCriterion("user_ids not in", values, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsBetween(String value1, String value2) {
            addCriterion("user_ids between", value1, value2, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotBetween(String value1, String value2) {
            addCriterion("user_ids not between", value1, value2, "userIds");
            return (Criteria) this;
        }
        
			
        public Criteria andDuscussIdsIsNull() {
            addCriterion("duscuss_ids is null");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsIsNotNull() {
            addCriterion("duscuss_ids is not null");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsEqualTo(String value) {
            addCriterion("duscuss_ids =", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsNotEqualTo(String value) {
            addCriterion("duscuss_ids <>", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsGreaterThan(String value) {
            addCriterion("duscuss_ids >", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsGreaterThanOrEqualTo(String value) {
            addCriterion("duscuss_ids >=", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsLessThan(String value) {
            addCriterion("duscuss_ids <", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsLessThanOrEqualTo(String value) {
            addCriterion("duscuss_ids <=", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsLike(String value) {
            addCriterion("duscuss_ids like", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsNotLike(String value) {
            addCriterion("duscuss_ids not like", value, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsIn(List<String> values) {
            addCriterion("duscuss_ids in", values, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsNotIn(List<String> values) {
            addCriterion("duscuss_ids not in", values, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsBetween(String value1, String value2) {
            addCriterion("duscuss_ids between", value1, value2, "duscussIds");
            return (Criteria) this;
        }

        public Criteria andDuscussIdsNotBetween(String value1, String value2) {
            addCriterion("duscuss_ids not between", value1, value2, "duscussIds");
            return (Criteria) this;
        }
        
			
        public Criteria andUserGroupIdIsNull() {
            addCriterion("user_group_id is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNotNull() {
            addCriterion("user_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdEqualTo(Integer value) {
            addCriterion("user_group_id =", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotEqualTo(Integer value) {
            addCriterion("user_group_id <>", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThan(Integer value) {
            addCriterion("user_group_id >", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_group_id >=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThan(Integer value) {
            addCriterion("user_group_id <", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_group_id <=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLike(Integer value) {
            addCriterion("user_group_id like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotLike(Integer value) {
            addCriterion("user_group_id not like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIn(List<Integer> values) {
            addCriterion("user_group_id in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotIn(List<Integer> values) {
            addCriterion("user_group_id not in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("user_group_id between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_group_id not between", value1, value2, "userGroupId");
            return (Criteria) this;
        }
        
			
        public Criteria andDiscussGroupIdIsNull() {
            addCriterion("discuss_group_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdIsNotNull() {
            addCriterion("discuss_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdEqualTo(Integer value) {
            addCriterion("discuss_group_id =", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdNotEqualTo(Integer value) {
            addCriterion("discuss_group_id <>", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdGreaterThan(Integer value) {
            addCriterion("discuss_group_id >", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("discuss_group_id >=", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdLessThan(Integer value) {
            addCriterion("discuss_group_id <", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("discuss_group_id <=", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdLike(Integer value) {
            addCriterion("discuss_group_id like", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdNotLike(Integer value) {
            addCriterion("discuss_group_id not like", value, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdIn(List<Integer> values) {
            addCriterion("discuss_group_id in", values, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdNotIn(List<Integer> values) {
            addCriterion("discuss_group_id not in", values, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("discuss_group_id between", value1, value2, "discussGroupId");
            return (Criteria) this;
        }

        public Criteria andDiscussGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("discuss_group_id not between", value1, value2, "discussGroupId");
            return (Criteria) this;
        }
        
			
        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(Integer value) {
            addCriterion("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(Integer value) {
            addCriterion("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(Integer value) {
            addCriterion("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(Integer value) {
            addCriterion("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(Integer value) {
            addCriterion("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLike(Integer value) {
            addCriterion("start like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotLike(Integer value) {
            addCriterion("start not like", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<Integer> values) {
            addCriterion("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<Integer> values) {
            addCriterion("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(Integer value1, Integer value2) {
            addCriterion("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(Integer value1, Integer value2) {
            addCriterion("start not between", value1, value2, "start");
            return (Criteria) this;
        }
        
			
        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(Integer value) {
            addCriterion("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(Integer value) {
            addCriterion("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(Integer value) {
            addCriterion("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(Integer value) {
            addCriterion("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(Integer value) {
            addCriterion("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLike(Integer value) {
            addCriterion("end like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotLike(Integer value) {
            addCriterion("end not like", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<Integer> values) {
            addCriterion("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<Integer> values) {
            addCriterion("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(Integer value1, Integer value2) {
            addCriterion("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(Integer value1, Integer value2) {
            addCriterion("end not between", value1, value2, "end");
            return (Criteria) this;
        }
        
			
        public Criteria andIsdelIsNull() {
            addCriterion("isdel is null");
            return (Criteria) this;
        }

        public Criteria andIsdelIsNotNull() {
            addCriterion("isdel is not null");
            return (Criteria) this;
        }

        public Criteria andIsdelEqualTo(Character value) {
            addCriterion("isdel =", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotEqualTo(Character value) {
            addCriterion("isdel <>", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThan(Character value) {
            addCriterion("isdel >", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelGreaterThanOrEqualTo(Character value) {
            addCriterion("isdel >=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThan(Character value) {
            addCriterion("isdel <", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLessThanOrEqualTo(Character value) {
            addCriterion("isdel <=", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelLike(Character value) {
            addCriterion("isdel like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotLike(Character value) {
            addCriterion("isdel not like", value, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelIn(List<Character> values) {
            addCriterion("isdel in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotIn(List<Character> values) {
            addCriterion("isdel not in", values, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelBetween(Character value1, Character value2) {
            addCriterion("isdel between", value1, value2, "isdel");
            return (Criteria) this;
        }

        public Criteria andIsdelNotBetween(Character value1, Character value2) {
            addCriterion("isdel not between", value1, value2, "isdel");
            return (Criteria) this;
        }
        
			
        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(Date value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(Date value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
        
			
        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(Date value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(Date value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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