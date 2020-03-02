package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class RolePermissionsRelationQuery {

	private List<Criteria> values = Lists.newLinkedList();
	private String id = "id";
	private String createBy = "create_by";
	private String createDate = "create_date";
	private String updateBy = "update_by";
	private String updateDate = "update_date";
	private String ver = "ver";
	private String isDelete = "is_delete";
	private String roleId = "role_id";
	private String permissId = "permiss_id";

	public List<Criteria> getValues() {
        return values;
    }

    public RolePermissionsRelationQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public RolePermissionsRelationQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public RolePermissionsRelationQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public RolePermissionsRelationQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public RolePermissionsRelationQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public RolePermissionsRelationQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public RolePermissionsRelationQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public RolePermissionsRelationQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public RolePermissionsRelationQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public RolePermissionsRelationQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public RolePermissionsRelationQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public RolePermissionsRelationQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public RolePermissionsRelationQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public RolePermissionsRelationQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public RolePermissionsRelationQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public RolePermissionsRelationQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public RolePermissionsRelationQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public RolePermissionsRelationQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public RolePermissionsRelationQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public RolePermissionsRelationQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public RolePermissionsRelationQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public RolePermissionsRelationQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public RolePermissionsRelationQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public RolePermissionsRelationQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public RolePermissionsRelationQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public RolePermissionsRelationQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public RolePermissionsRelationQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public RolePermissionsRelationQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public RolePermissionsRelationQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public RolePermissionsRelationQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public RolePermissionsRelationQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public RolePermissionsRelationQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public RolePermissionsRelationQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public RolePermissionsRelationQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public RolePermissionsRelationQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public RolePermissionsRelationQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public RolePermissionsRelationQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public RolePermissionsRelationQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public RolePermissionsRelationQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public RolePermissionsRelationQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public RolePermissionsRelationQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public RolePermissionsRelationQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public RolePermissionsRelationQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public RolePermissionsRelationQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public RolePermissionsRelationQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public RolePermissionsRelationQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public RolePermissionsRelationQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public RolePermissionsRelationQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public RolePermissionsRelationQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public RolePermissionsRelationQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public RolePermissionsRelationQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public RolePermissionsRelationQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public RolePermissionsRelationQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public RolePermissionsRelationQuery roleIdEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,roleId));
        return this;
    }
    
    public RolePermissionsRelationQuery roleIdNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,roleId));
        return this;
    }

    public RolePermissionsRelationQuery roleIdNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,roleId));
        return this;
    }
    
   public RolePermissionsRelationQuery roleIdIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,roleId));
        return this;
    }
    
    public RolePermissionsRelationQuery roleIdNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,roleId));
        return this;
    }

	public RolePermissionsRelationQuery permissIdEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,permissId));
        return this;
    }
    
    public RolePermissionsRelationQuery permissIdNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,permissId));
        return this;
    }

    public RolePermissionsRelationQuery permissIdNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,permissId));
        return this;
    }
    
   public RolePermissionsRelationQuery permissIdIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,permissId));
        return this;
    }
    
    public RolePermissionsRelationQuery permissIdNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,permissId));
        return this;
    }
}