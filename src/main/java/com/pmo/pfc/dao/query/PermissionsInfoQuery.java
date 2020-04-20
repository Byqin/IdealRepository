package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class PermissionsInfoQuery {

	private List<Criteria> values = Lists.newLinkedList();
	private String id = "id";
	private String createBy = "create_by";
	private String createDate = "create_date";
	private String updateBy = "update_by";
	private String updateDate = "update_date";
	private String ver = "ver";
	private String isDelete = "is_delete";
	private String pName = "p_name";
	private String pCode = "p_code";
	private String parentCode = "parent_code";
	private String completeCode = "complete_code";
	private String requestUrl = "request_url";
	private String requestPage = "request_page";
	private String extensionOne = "extension_one";
	private String extensionTwo = "extension_two";
	private String extensionThree = "extension_three";
	private String extensionFour = "extension_four";

	public List<Criteria> getValues() {
        return values;
    }

    public PermissionsInfoQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public PermissionsInfoQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public PermissionsInfoQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public PermissionsInfoQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public PermissionsInfoQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public PermissionsInfoQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public PermissionsInfoQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public PermissionsInfoQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public PermissionsInfoQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public PermissionsInfoQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public PermissionsInfoQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public PermissionsInfoQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public PermissionsInfoQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public PermissionsInfoQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public PermissionsInfoQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public PermissionsInfoQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public PermissionsInfoQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public PermissionsInfoQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public PermissionsInfoQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public PermissionsInfoQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public PermissionsInfoQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public PermissionsInfoQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public PermissionsInfoQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public PermissionsInfoQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public PermissionsInfoQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public PermissionsInfoQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public PermissionsInfoQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public PermissionsInfoQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public PermissionsInfoQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public PermissionsInfoQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public PermissionsInfoQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public PermissionsInfoQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public PermissionsInfoQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public PermissionsInfoQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public PermissionsInfoQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public PermissionsInfoQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public PermissionsInfoQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public PermissionsInfoQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public PermissionsInfoQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public PermissionsInfoQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public PermissionsInfoQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public PermissionsInfoQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public PermissionsInfoQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public PermissionsInfoQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public PermissionsInfoQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public PermissionsInfoQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public PermissionsInfoQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public PermissionsInfoQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public PermissionsInfoQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public PermissionsInfoQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public PermissionsInfoQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public PermissionsInfoQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public PermissionsInfoQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public PermissionsInfoQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public PermissionsInfoQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public PermissionsInfoQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public PermissionsInfoQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public PermissionsInfoQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public PermissionsInfoQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public PermissionsInfoQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public PermissionsInfoQuery pNameEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,pName));
        return this;
    }
    
    public PermissionsInfoQuery pNameNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,pName));
        return this;
    }

    public PermissionsInfoQuery pNameLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,pName));
        return this;
    }

    public PermissionsInfoQuery pNameLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,pName));
        return this;
    }

    public PermissionsInfoQuery pNameLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,pName));
        return this;
    }

    public PermissionsInfoQuery pNameLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,pName));
        return this;
    }

    public PermissionsInfoQuery pNameIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,pName));
        return this;
    }

    public PermissionsInfoQuery pNameNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,pName));
        return this;
    }

    public PermissionsInfoQuery pNameLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,pName));
        return this;
    }

    public PermissionsInfoQuery pNameNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,pName));
        return this;
    }
    
   public PermissionsInfoQuery pNameIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,pName));
        return this;
    }
    
    public PermissionsInfoQuery pNameNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,pName));
        return this;
    }

	public PermissionsInfoQuery pCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,pCode));
        return this;
    }
    
    public PermissionsInfoQuery pCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,pCode));
        return this;
    }

    public PermissionsInfoQuery pCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,pCode));
        return this;
    }
    
   public PermissionsInfoQuery pCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,pCode));
        return this;
    }
    
    public PermissionsInfoQuery pCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,pCode));
        return this;
    }

	public PermissionsInfoQuery parentCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,parentCode));
        return this;
    }
    
    public PermissionsInfoQuery parentCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,parentCode));
        return this;
    }

    public PermissionsInfoQuery parentCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,parentCode));
        return this;
    }
    
   public PermissionsInfoQuery parentCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,parentCode));
        return this;
    }
    
    public PermissionsInfoQuery parentCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,parentCode));
        return this;
    }

	public PermissionsInfoQuery completeCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,completeCode));
        return this;
    }
    
    public PermissionsInfoQuery completeCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,completeCode));
        return this;
    }

    public PermissionsInfoQuery completeCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,completeCode));
        return this;
    }
    
   public PermissionsInfoQuery completeCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,completeCode));
        return this;
    }
    
    public PermissionsInfoQuery completeCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,completeCode));
        return this;
    }

	public PermissionsInfoQuery requestUrlEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,requestUrl));
        return this;
    }
    
    public PermissionsInfoQuery requestUrlNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,requestUrl));
        return this;
    }

    public PermissionsInfoQuery requestUrlNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,requestUrl));
        return this;
    }
    
   public PermissionsInfoQuery requestUrlIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,requestUrl));
        return this;
    }
    
    public PermissionsInfoQuery requestUrlNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,requestUrl));
        return this;
    }

	public PermissionsInfoQuery requestPageEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,requestPage));
        return this;
    }
    
    public PermissionsInfoQuery requestPageNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,requestPage));
        return this;
    }

    public PermissionsInfoQuery requestPageNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,requestPage));
        return this;
    }
    
   public PermissionsInfoQuery requestPageIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,requestPage));
        return this;
    }
    
    public PermissionsInfoQuery requestPageNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,requestPage));
        return this;
    }

	public PermissionsInfoQuery extensionOneEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionOne));
        return this;
    }
    
    public PermissionsInfoQuery extensionOneNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionOne));
        return this;
    }

    public PermissionsInfoQuery extensionOneNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionOne));
        return this;
    }
    
   public PermissionsInfoQuery extensionOneIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionOne));
        return this;
    }
    
    public PermissionsInfoQuery extensionOneNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionOne));
        return this;
    }

	public PermissionsInfoQuery extensionTwoEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionTwo));
        return this;
    }
    
    public PermissionsInfoQuery extensionTwoNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionTwo));
        return this;
    }

    public PermissionsInfoQuery extensionTwoNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionTwo));
        return this;
    }
    
   public PermissionsInfoQuery extensionTwoIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionTwo));
        return this;
    }
    
    public PermissionsInfoQuery extensionTwoNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionTwo));
        return this;
    }

	public PermissionsInfoQuery extensionThreeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionThree));
        return this;
    }
    
    public PermissionsInfoQuery extensionThreeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionThree));
        return this;
    }

    public PermissionsInfoQuery extensionThreeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionThree));
        return this;
    }
    
   public PermissionsInfoQuery extensionThreeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionThree));
        return this;
    }
    
    public PermissionsInfoQuery extensionThreeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionThree));
        return this;
    }

	public PermissionsInfoQuery extensionFourEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionFour));
        return this;
    }
    
    public PermissionsInfoQuery extensionFourNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionFour));
        return this;
    }

    public PermissionsInfoQuery extensionFourNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionFour));
        return this;
    }
    
   public PermissionsInfoQuery extensionFourIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionFour));
        return this;
    }
    
    public PermissionsInfoQuery extensionFourNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionFour));
        return this;
    }
}