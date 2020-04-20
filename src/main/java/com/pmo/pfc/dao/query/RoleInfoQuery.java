package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class RoleInfoQuery {

	private List<Criteria> values = Lists.newLinkedList();
	private String id = "id";
	private String createBy = "create_by";
	private String createDate = "create_date";
	private String updateBy = "update_by";
	private String updateDate = "update_date";
	private String ver = "ver";
	private String isDelete = "is_delete";
	private String roleName = "role_name";

	public List<Criteria> getValues() {
        return values;
    }

    public RoleInfoQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public RoleInfoQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public RoleInfoQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public RoleInfoQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public RoleInfoQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public RoleInfoQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public RoleInfoQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public RoleInfoQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public RoleInfoQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public RoleInfoQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public RoleInfoQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public RoleInfoQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public RoleInfoQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public RoleInfoQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public RoleInfoQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public RoleInfoQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public RoleInfoQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public RoleInfoQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public RoleInfoQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public RoleInfoQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public RoleInfoQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public RoleInfoQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public RoleInfoQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public RoleInfoQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public RoleInfoQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public RoleInfoQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public RoleInfoQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public RoleInfoQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public RoleInfoQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public RoleInfoQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public RoleInfoQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public RoleInfoQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public RoleInfoQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public RoleInfoQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public RoleInfoQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public RoleInfoQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public RoleInfoQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public RoleInfoQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public RoleInfoQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public RoleInfoQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public RoleInfoQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public RoleInfoQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public RoleInfoQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public RoleInfoQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public RoleInfoQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public RoleInfoQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public RoleInfoQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public RoleInfoQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public RoleInfoQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public RoleInfoQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public RoleInfoQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public RoleInfoQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public RoleInfoQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public RoleInfoQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public RoleInfoQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public RoleInfoQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public RoleInfoQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public RoleInfoQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public RoleInfoQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public RoleInfoQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public RoleInfoQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public RoleInfoQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public RoleInfoQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public RoleInfoQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public RoleInfoQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public RoleInfoQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public RoleInfoQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public RoleInfoQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public RoleInfoQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public RoleInfoQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public RoleInfoQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public RoleInfoQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public RoleInfoQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public RoleInfoQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public RoleInfoQuery roleNameEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,roleName));
        return this;
    }
    
    public RoleInfoQuery roleNameNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,roleName));
        return this;
    }

    public RoleInfoQuery roleNameLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,roleName));
        return this;
    }

    public RoleInfoQuery roleNameLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,roleName));
        return this;
    }

    public RoleInfoQuery roleNameLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,roleName));
        return this;
    }

    public RoleInfoQuery roleNameLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,roleName));
        return this;
    }

    public RoleInfoQuery roleNameIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,roleName));
        return this;
    }

    public RoleInfoQuery roleNameNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,roleName));
        return this;
    }

    public RoleInfoQuery roleNameLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,roleName));
        return this;
    }

    public RoleInfoQuery roleNameNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,roleName));
        return this;
    }
    
   public RoleInfoQuery roleNameIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,roleName));
        return this;
    }
    
    public RoleInfoQuery roleNameNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,roleName));
        return this;
    }
}