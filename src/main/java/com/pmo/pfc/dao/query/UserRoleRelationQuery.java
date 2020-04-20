package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class UserRoleRelationQuery {

	private List<Criteria> values = Lists.newLinkedList();
	private String id = "id";
	private String createBy = "create_by";
	private String createDate = "create_date";
	private String updateBy = "update_by";
	private String updateDate = "update_date";
	private String ver = "ver";
	private String isDelete = "is_delete";
	private String roleId = "role_id";
	private String userId = "user_id";

	public List<Criteria> getValues() {
        return values;
    }

    public UserRoleRelationQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public UserRoleRelationQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public UserRoleRelationQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public UserRoleRelationQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public UserRoleRelationQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public UserRoleRelationQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public UserRoleRelationQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public UserRoleRelationQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public UserRoleRelationQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public UserRoleRelationQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public UserRoleRelationQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public UserRoleRelationQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public UserRoleRelationQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public UserRoleRelationQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public UserRoleRelationQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public UserRoleRelationQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public UserRoleRelationQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public UserRoleRelationQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public UserRoleRelationQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public UserRoleRelationQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public UserRoleRelationQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public UserRoleRelationQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public UserRoleRelationQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public UserRoleRelationQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public UserRoleRelationQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public UserRoleRelationQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public UserRoleRelationQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public UserRoleRelationQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public UserRoleRelationQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public UserRoleRelationQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public UserRoleRelationQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public UserRoleRelationQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public UserRoleRelationQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public UserRoleRelationQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public UserRoleRelationQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public UserRoleRelationQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public UserRoleRelationQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public UserRoleRelationQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public UserRoleRelationQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public UserRoleRelationQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public UserRoleRelationQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public UserRoleRelationQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public UserRoleRelationQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public UserRoleRelationQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public UserRoleRelationQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public UserRoleRelationQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public UserRoleRelationQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public UserRoleRelationQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public UserRoleRelationQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public UserRoleRelationQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public UserRoleRelationQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public UserRoleRelationQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public UserRoleRelationQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public UserRoleRelationQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public UserRoleRelationQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public UserRoleRelationQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public UserRoleRelationQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public UserRoleRelationQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public UserRoleRelationQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public UserRoleRelationQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public UserRoleRelationQuery roleIdEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,roleId));
        return this;
    }
    
    public UserRoleRelationQuery roleIdNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,roleId));
        return this;
    }

    public UserRoleRelationQuery roleIdNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,roleId));
        return this;
    }
    
   public UserRoleRelationQuery roleIdIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,roleId));
        return this;
    }
    
    public UserRoleRelationQuery roleIdNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,roleId));
        return this;
    }

	public UserRoleRelationQuery userIdEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,userId));
        return this;
    }
    
    public UserRoleRelationQuery userIdNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,userId));
        return this;
    }

    public UserRoleRelationQuery userIdLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,userId));
        return this;
    }

    public UserRoleRelationQuery userIdLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,userId));
        return this;
    }

    public UserRoleRelationQuery userIdLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,userId));
        return this;
    }

    public UserRoleRelationQuery userIdLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,userId));
        return this;
    }

    public UserRoleRelationQuery userIdIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,userId));
        return this;
    }

    public UserRoleRelationQuery userIdNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,userId));
        return this;
    }

    public UserRoleRelationQuery userIdLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,userId));
        return this;
    }

    public UserRoleRelationQuery userIdNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,userId));
        return this;
    }
    
   public UserRoleRelationQuery userIdIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,userId));
        return this;
    }
    
    public UserRoleRelationQuery userIdNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,userId));
        return this;
    }
}