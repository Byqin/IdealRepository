package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class UserPermissionsQuery {

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
	private String requsetPage = "requset_page";
	private String extensionOne = "extension_one";
	private String extensionTwo = "extension_two";
	private String extensionThree = "extension_three";
	private String extensionFour = "extension_four";

	public List<Criteria> getValues() {
        return values;
    }

    public UserPermissionsQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public UserPermissionsQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public UserPermissionsQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public UserPermissionsQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public UserPermissionsQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public UserPermissionsQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public UserPermissionsQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public UserPermissionsQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public UserPermissionsQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public UserPermissionsQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public UserPermissionsQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public UserPermissionsQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public UserPermissionsQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public UserPermissionsQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public UserPermissionsQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public UserPermissionsQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public UserPermissionsQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public UserPermissionsQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public UserPermissionsQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public UserPermissionsQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public UserPermissionsQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public UserPermissionsQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public UserPermissionsQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public UserPermissionsQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public UserPermissionsQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public UserPermissionsQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public UserPermissionsQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public UserPermissionsQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public UserPermissionsQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public UserPermissionsQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public UserPermissionsQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public UserPermissionsQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public UserPermissionsQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public UserPermissionsQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public UserPermissionsQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public UserPermissionsQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public UserPermissionsQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public UserPermissionsQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public UserPermissionsQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public UserPermissionsQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public UserPermissionsQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public UserPermissionsQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public UserPermissionsQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public UserPermissionsQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public UserPermissionsQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public UserPermissionsQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public UserPermissionsQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public UserPermissionsQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public UserPermissionsQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public UserPermissionsQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public UserPermissionsQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public UserPermissionsQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public UserPermissionsQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public UserPermissionsQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public UserPermissionsQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public UserPermissionsQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public UserPermissionsQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public UserPermissionsQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public UserPermissionsQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public UserPermissionsQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public UserPermissionsQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public UserPermissionsQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public UserPermissionsQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public UserPermissionsQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public UserPermissionsQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public UserPermissionsQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public UserPermissionsQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public UserPermissionsQuery pNameEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,pName));
        return this;
    }
    
    public UserPermissionsQuery pNameNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,pName));
        return this;
    }

    public UserPermissionsQuery pNameLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,pName));
        return this;
    }

    public UserPermissionsQuery pNameLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,pName));
        return this;
    }

    public UserPermissionsQuery pNameLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,pName));
        return this;
    }

    public UserPermissionsQuery pNameLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,pName));
        return this;
    }

    public UserPermissionsQuery pNameIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,pName));
        return this;
    }

    public UserPermissionsQuery pNameNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,pName));
        return this;
    }

    public UserPermissionsQuery pNameLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,pName));
        return this;
    }

    public UserPermissionsQuery pNameNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,pName));
        return this;
    }
    
   public UserPermissionsQuery pNameIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,pName));
        return this;
    }
    
    public UserPermissionsQuery pNameNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,pName));
        return this;
    }

	public UserPermissionsQuery pCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,pCode));
        return this;
    }
    
    public UserPermissionsQuery pCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,pCode));
        return this;
    }

    public UserPermissionsQuery pCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,pCode));
        return this;
    }
    
   public UserPermissionsQuery pCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,pCode));
        return this;
    }
    
    public UserPermissionsQuery pCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,pCode));
        return this;
    }

	public UserPermissionsQuery parentCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,parentCode));
        return this;
    }
    
    public UserPermissionsQuery parentCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,parentCode));
        return this;
    }

    public UserPermissionsQuery parentCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,parentCode));
        return this;
    }
    
   public UserPermissionsQuery parentCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,parentCode));
        return this;
    }
    
    public UserPermissionsQuery parentCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,parentCode));
        return this;
    }

	public UserPermissionsQuery completeCodeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,completeCode));
        return this;
    }
    
    public UserPermissionsQuery completeCodeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,completeCode));
        return this;
    }

    public UserPermissionsQuery completeCodeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,completeCode));
        return this;
    }
    
   public UserPermissionsQuery completeCodeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,completeCode));
        return this;
    }
    
    public UserPermissionsQuery completeCodeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,completeCode));
        return this;
    }

	public UserPermissionsQuery requestUrlEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,requestUrl));
        return this;
    }
    
    public UserPermissionsQuery requestUrlNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,requestUrl));
        return this;
    }

    public UserPermissionsQuery requestUrlNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,requestUrl));
        return this;
    }
    
   public UserPermissionsQuery requestUrlIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,requestUrl));
        return this;
    }
    
    public UserPermissionsQuery requestUrlNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,requestUrl));
        return this;
    }

	public UserPermissionsQuery requsetPageEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,requsetPage));
        return this;
    }
    
    public UserPermissionsQuery requsetPageNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,requsetPage));
        return this;
    }

    public UserPermissionsQuery requsetPageNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,requsetPage));
        return this;
    }
    
   public UserPermissionsQuery requsetPageIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,requsetPage));
        return this;
    }
    
    public UserPermissionsQuery requsetPageNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,requsetPage));
        return this;
    }

	public UserPermissionsQuery extensionOneEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionOne));
        return this;
    }
    
    public UserPermissionsQuery extensionOneNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionOne));
        return this;
    }

    public UserPermissionsQuery extensionOneNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionOne));
        return this;
    }
    
   public UserPermissionsQuery extensionOneIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionOne));
        return this;
    }
    
    public UserPermissionsQuery extensionOneNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionOne));
        return this;
    }

	public UserPermissionsQuery extensionTwoEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionTwo));
        return this;
    }
    
    public UserPermissionsQuery extensionTwoNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionTwo));
        return this;
    }

    public UserPermissionsQuery extensionTwoNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionTwo));
        return this;
    }
    
   public UserPermissionsQuery extensionTwoIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionTwo));
        return this;
    }
    
    public UserPermissionsQuery extensionTwoNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionTwo));
        return this;
    }

	public UserPermissionsQuery extensionThreeEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionThree));
        return this;
    }
    
    public UserPermissionsQuery extensionThreeNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionThree));
        return this;
    }

    public UserPermissionsQuery extensionThreeNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionThree));
        return this;
    }
    
   public UserPermissionsQuery extensionThreeIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionThree));
        return this;
    }
    
    public UserPermissionsQuery extensionThreeNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionThree));
        return this;
    }

	public UserPermissionsQuery extensionFourEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,extensionFour));
        return this;
    }
    
    public UserPermissionsQuery extensionFourNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,extensionFour));
        return this;
    }

    public UserPermissionsQuery extensionFourNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,extensionFour));
        return this;
    }
    
   public UserPermissionsQuery extensionFourIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,extensionFour));
        return this;
    }
    
    public UserPermissionsQuery extensionFourNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,extensionFour));
        return this;
    }
}