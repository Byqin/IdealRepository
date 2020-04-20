package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class OrganizationInfoQuery {

	private List<Criteria> values = Lists.newLinkedList();
	private String id = "id";
	private String createBy = "create_by";
	private String createDate = "create_date";
	private String updateBy = "update_by";
	private String updateDate = "update_date";
	private String ver = "ver";
	private String isDelete = "is_delete";
	private String orgName = "org_name";
	private String orgCode = "org_code";

	public List<Criteria> getValues() {
        return values;
    }

    public OrganizationInfoQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public OrganizationInfoQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public OrganizationInfoQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public OrganizationInfoQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public OrganizationInfoQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public OrganizationInfoQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public OrganizationInfoQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public OrganizationInfoQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public OrganizationInfoQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public OrganizationInfoQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public OrganizationInfoQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public OrganizationInfoQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public OrganizationInfoQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public OrganizationInfoQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public OrganizationInfoQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public OrganizationInfoQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public OrganizationInfoQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public OrganizationInfoQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public OrganizationInfoQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public OrganizationInfoQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public OrganizationInfoQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public OrganizationInfoQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public OrganizationInfoQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public OrganizationInfoQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public OrganizationInfoQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public OrganizationInfoQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public OrganizationInfoQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public OrganizationInfoQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public OrganizationInfoQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public OrganizationInfoQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public OrganizationInfoQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public OrganizationInfoQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public OrganizationInfoQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public OrganizationInfoQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public OrganizationInfoQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public OrganizationInfoQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public OrganizationInfoQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public OrganizationInfoQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public OrganizationInfoQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public OrganizationInfoQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public OrganizationInfoQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public OrganizationInfoQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public OrganizationInfoQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public OrganizationInfoQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public OrganizationInfoQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public OrganizationInfoQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public OrganizationInfoQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public OrganizationInfoQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public OrganizationInfoQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public OrganizationInfoQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public OrganizationInfoQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public OrganizationInfoQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public OrganizationInfoQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public OrganizationInfoQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public OrganizationInfoQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public OrganizationInfoQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public OrganizationInfoQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public OrganizationInfoQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public OrganizationInfoQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public OrganizationInfoQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public OrganizationInfoQuery orgNameEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,orgName));
        return this;
    }
    
    public OrganizationInfoQuery orgNameNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,orgName));
        return this;
    }

    public OrganizationInfoQuery orgNameNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,orgName));
        return this;
    }
    
   public OrganizationInfoQuery orgNameIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,orgName));
        return this;
    }
    
    public OrganizationInfoQuery orgNameNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,orgName));
        return this;
    }

	public OrganizationInfoQuery orgCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,orgCode));
        return this;
    }
    
    public OrganizationInfoQuery orgCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,orgCode));
        return this;
    }

    public OrganizationInfoQuery orgCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,orgCode));
        return this;
    }
    
   public OrganizationInfoQuery orgCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,orgCode));
        return this;
    }
    
    public OrganizationInfoQuery orgCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,orgCode));
        return this;
    }
}