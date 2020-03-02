package com.pmo.pfc.dao.query;

import com.google.common.collect.Lists;
import com.pmo.pfc.common.enu.OperatorEnum;
import java.util.List;
import java.util.Date;

public class UserInfoQuery {

	private List<Criteria> values = Lists.newLinkedList();
	private String id = "id";
	private String createBy = "create_by";
	private String createDate = "create_date";
	private String updateBy = "update_by";
	private String updateDate = "update_date";
	private String ver = "ver";
	private String isDelete = "is_delete";
	private String userId = "user_id";
	private String userNameCn = "user_name_cn";
	private String userNameEn = "user_name_en";
	private String sex = "sex";
	private String userAge = "user_age";
	private String email = "email";
	private String userPhone = "user_phone";
	private String headPortrait = "head_portrait";
	private String birthday = "birthday";

	public List<Criteria> getValues() {
        return values;
    }

    public UserInfoQuery beforeBracket(){
        values.add(Criteria.custom(" ( "));
        return this;
    }

    public UserInfoQuery afterBracket(){
        values.add(Criteria.custom(" ) "));
        return this;
    }

    public UserInfoQuery and(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" and "));
        return this;
    }

    public UserInfoQuery or(){
        if(values == null || values.isEmpty()){
            return this;
        }
        values.add(Criteria.custom(" or "));
        return this;
    }
		

	public UserInfoQuery idEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,id));
        return this;
    }
    
    public UserInfoQuery idNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,id));
        return this;
    }

    public UserInfoQuery idLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,id));
        return this;
    }

    public UserInfoQuery idLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,id));
        return this;
    }

    public UserInfoQuery idLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,id));
        return this;
    }

    public UserInfoQuery idLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,id));
        return this;
    }

    public UserInfoQuery idIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,id));
        return this;
    }

    public UserInfoQuery idNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,id));
        return this;
    }

    public UserInfoQuery idLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,id));
        return this;
    }

    public UserInfoQuery idNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,id));
        return this;
    }
    
   public UserInfoQuery idIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,id));
        return this;
    }
    
    public UserInfoQuery idNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,id));
        return this;
    }

	public UserInfoQuery createByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,createBy));
        return this;
    }
    
    public UserInfoQuery createByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,createBy));
        return this;
    }

    public UserInfoQuery createByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,createBy));
        return this;
    }

    public UserInfoQuery createByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,createBy));
        return this;
    }

    public UserInfoQuery createByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,createBy));
        return this;
    }

    public UserInfoQuery createByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,createBy));
        return this;
    }

    public UserInfoQuery createByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,createBy));
        return this;
    }

    public UserInfoQuery createByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,createBy));
        return this;
    }

    public UserInfoQuery createByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,createBy));
        return this;
    }

    public UserInfoQuery createByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,createBy));
        return this;
    }
    
   public UserInfoQuery createByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,createBy));
        return this;
    }
    
    public UserInfoQuery createByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,createBy));
        return this;
    }

	public UserInfoQuery createDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,createDate));
        return this;
    }
    
    public UserInfoQuery createDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,createDate));
        return this;
    }

    public UserInfoQuery createDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,createDate));
        return this;
    }

    public UserInfoQuery createDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,createDate));
        return this;
    }

    public UserInfoQuery createDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,createDate));
        return this;
    }

    public UserInfoQuery createDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,createDate));
        return this;
    }

    public UserInfoQuery createDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,createDate));
        return this;
    }

    public UserInfoQuery createDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,createDate));
        return this;
    }

    public UserInfoQuery createDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,createDate));
        return this;
    }

    public UserInfoQuery createDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,createDate));
        return this;
    }
    
   public UserInfoQuery createDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,createDate));
        return this;
    }
    
    public UserInfoQuery createDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,createDate));
        return this;
    }

	public UserInfoQuery updateByEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,updateBy));
        return this;
    }
    
    public UserInfoQuery updateByNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,updateBy));
        return this;
    }

    public UserInfoQuery updateByLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,updateBy));
        return this;
    }

    public UserInfoQuery updateByLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,updateBy));
        return this;
    }

    public UserInfoQuery updateByLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,updateBy));
        return this;
    }

    public UserInfoQuery updateByLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,updateBy));
        return this;
    }

    public UserInfoQuery updateByIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,updateBy));
        return this;
    }

    public UserInfoQuery updateByNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,updateBy));
        return this;
    }

    public UserInfoQuery updateByLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,updateBy));
        return this;
    }

    public UserInfoQuery updateByNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,updateBy));
        return this;
    }
    
   public UserInfoQuery updateByIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,updateBy));
        return this;
    }
    
    public UserInfoQuery updateByNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,updateBy));
        return this;
    }

	public UserInfoQuery updateDateEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,updateDate));
        return this;
    }
    
    public UserInfoQuery updateDateNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,updateDate));
        return this;
    }

    public UserInfoQuery updateDateLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,updateDate));
        return this;
    }

    public UserInfoQuery updateDateLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,updateDate));
        return this;
    }

    public UserInfoQuery updateDateLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,updateDate));
        return this;
    }

    public UserInfoQuery updateDateLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,updateDate));
        return this;
    }

    public UserInfoQuery updateDateIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,updateDate));
        return this;
    }

    public UserInfoQuery updateDateNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,updateDate));
        return this;
    }

    public UserInfoQuery updateDateLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,updateDate));
        return this;
    }

    public UserInfoQuery updateDateNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,updateDate));
        return this;
    }
    
   public UserInfoQuery updateDateIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,updateDate));
        return this;
    }
    
    public UserInfoQuery updateDateNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,updateDate));
        return this;
    }

	public UserInfoQuery verEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,ver));
        return this;
    }
    
    public UserInfoQuery verNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,ver));
        return this;
    }

    public UserInfoQuery verLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,ver));
        return this;
    }

    public UserInfoQuery verLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,ver));
        return this;
    }

    public UserInfoQuery verLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,ver));
        return this;
    }

    public UserInfoQuery verLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,ver));
        return this;
    }

    public UserInfoQuery verIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,ver));
        return this;
    }

    public UserInfoQuery verNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,ver));
        return this;
    }

    public UserInfoQuery verLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,ver));
        return this;
    }

    public UserInfoQuery verNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,ver));
        return this;
    }
    
   public UserInfoQuery verIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,ver));
        return this;
    }
    
    public UserInfoQuery verNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,ver));
        return this;
    }

	public UserInfoQuery isDeleteEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,isDelete));
        return this;
    }
    
    public UserInfoQuery isDeleteNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,isDelete));
        return this;
    }

    public UserInfoQuery isDeleteNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,isDelete));
        return this;
    }
    
   public UserInfoQuery isDeleteIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,isDelete));
        return this;
    }
    
    public UserInfoQuery isDeleteNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,isDelete));
        return this;
    }

	public UserInfoQuery userIdEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,userId));
        return this;
    }
    
    public UserInfoQuery userIdNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,userId));
        return this;
    }

    public UserInfoQuery userIdLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,userId));
        return this;
    }

    public UserInfoQuery userIdLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,userId));
        return this;
    }

    public UserInfoQuery userIdLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,userId));
        return this;
    }

    public UserInfoQuery userIdLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,userId));
        return this;
    }

    public UserInfoQuery userIdIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,userId));
        return this;
    }

    public UserInfoQuery userIdNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,userId));
        return this;
    }

    public UserInfoQuery userIdLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,userId));
        return this;
    }

    public UserInfoQuery userIdNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,userId));
        return this;
    }
    
   public UserInfoQuery userIdIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,userId));
        return this;
    }
    
    public UserInfoQuery userIdNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,userId));
        return this;
    }

	public UserInfoQuery userNameCnEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,userNameCn));
        return this;
    }
    
    public UserInfoQuery userNameCnNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,userNameCn));
        return this;
    }

    public UserInfoQuery userNameCnNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,userNameCn));
        return this;
    }
    
   public UserInfoQuery userNameCnIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,userNameCn));
        return this;
    }
    
    public UserInfoQuery userNameCnNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,userNameCn));
        return this;
    }

	public UserInfoQuery userNameEnEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,userNameEn));
        return this;
    }
    
    public UserInfoQuery userNameEnNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,userNameEn));
        return this;
    }

    public UserInfoQuery userNameEnNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,userNameEn));
        return this;
    }
    
   public UserInfoQuery userNameEnIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,userNameEn));
        return this;
    }
    
    public UserInfoQuery userNameEnNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,userNameEn));
        return this;
    }

	public UserInfoQuery sexEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,sex));
        return this;
    }
    
    public UserInfoQuery sexNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,sex));
        return this;
    }

    public UserInfoQuery sexLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,sex));
        return this;
    }

    public UserInfoQuery sexLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,sex));
        return this;
    }

    public UserInfoQuery sexLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,sex));
        return this;
    }

    public UserInfoQuery sexLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,sex));
        return this;
    }

    public UserInfoQuery sexIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,sex));
        return this;
    }

    public UserInfoQuery sexNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,sex));
        return this;
    }

    public UserInfoQuery sexLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,sex));
        return this;
    }

    public UserInfoQuery sexNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,sex));
        return this;
    }
    
   public UserInfoQuery sexIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,sex));
        return this;
    }
    
    public UserInfoQuery sexNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,sex));
        return this;
    }

	public UserInfoQuery userAgeEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.EQ,userAge));
        return this;
    }
    
    public UserInfoQuery userAgeNotEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NEQ,userAge));
        return this;
    }

    public UserInfoQuery userAgeLg(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LG,userAge));
        return this;
    }

    public UserInfoQuery userAgeLgEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LGE,userAge));
        return this;
    }

    public UserInfoQuery userAgeLt(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LT,userAge));
        return this;
    }

    public UserInfoQuery userAgeLtEqual(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LTE,userAge));
        return this;
    }

    public UserInfoQuery userAgeIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.IN,userAge));
        return this;
    }

    public UserInfoQuery userAgeNotIn(List<Integer> lists){
        values.add(Criteria.custom(lists,"INTEGER",OperatorEnum.NOT_IN,userAge));
        return this;
    }

    public UserInfoQuery userAgeLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.LIKE,userAge));
        return this;
    }

    public UserInfoQuery userAgeNotLike(Integer value){
        values.add(Criteria.custom(value,"INTEGER", OperatorEnum.NOT_LIKE,userAge));
        return this;
    }
    
   public UserInfoQuery userAgeIsEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_EMPTY,userAge));
        return this;
    }
    
    public UserInfoQuery userAgeNotEmpty(){
        values.add(Criteria.custom("","INTEGER", OperatorEnum.IS_NOT_EMPTY,userAge));
        return this;
    }

	public UserInfoQuery emailEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,email));
        return this;
    }
    
    public UserInfoQuery emailNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,email));
        return this;
    }

    public UserInfoQuery emailLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,email));
        return this;
    }

    public UserInfoQuery emailLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,email));
        return this;
    }

    public UserInfoQuery emailLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,email));
        return this;
    }

    public UserInfoQuery emailLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,email));
        return this;
    }

    public UserInfoQuery emailIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,email));
        return this;
    }

    public UserInfoQuery emailNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,email));
        return this;
    }

    public UserInfoQuery emailLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,email));
        return this;
    }

    public UserInfoQuery emailNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,email));
        return this;
    }
    
   public UserInfoQuery emailIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,email));
        return this;
    }
    
    public UserInfoQuery emailNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,email));
        return this;
    }

	public UserInfoQuery userPhoneEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.EQ,userPhone));
        return this;
    }
    
    public UserInfoQuery userPhoneNotEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NEQ,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneLg(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LG,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneLgEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LGE,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneLt(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LT,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneLtEqual(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LTE,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.IN,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneNotIn(List<String> lists){
        values.add(Criteria.custom(lists,"VARCHAR",OperatorEnum.NOT_IN,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.LIKE,userPhone));
        return this;
    }

    public UserInfoQuery userPhoneNotLike(String value){
        values.add(Criteria.custom(value,"VARCHAR", OperatorEnum.NOT_LIKE,userPhone));
        return this;
    }
    
   public UserInfoQuery userPhoneIsEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_EMPTY,userPhone));
        return this;
    }
    
    public UserInfoQuery userPhoneNotEmpty(){
        values.add(Criteria.custom("","VARCHAR", OperatorEnum.IS_NOT_EMPTY,userPhone));
        return this;
    }

	public UserInfoQuery headPortraitEqual(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.EQ,headPortrait));
        return this;
    }
    
    public UserInfoQuery headPortraitNotEqual(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.NEQ,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitLg(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.LG,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitLgEqual(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.LGE,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitLt(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.LT,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitLtEqual(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.LTE,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitIn(List<byte[]> lists){
        values.add(Criteria.custom(lists,"BLOB",OperatorEnum.IN,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitNotIn(List<byte[]> lists){
        values.add(Criteria.custom(lists,"BLOB",OperatorEnum.NOT_IN,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitLike(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.LIKE,headPortrait));
        return this;
    }

    public UserInfoQuery headPortraitNotLike(byte[] value){
        values.add(Criteria.custom(value,"BLOB", OperatorEnum.NOT_LIKE,headPortrait));
        return this;
    }
    
   public UserInfoQuery headPortraitIsEmpty(){
        values.add(Criteria.custom("","BLOB", OperatorEnum.IS_EMPTY,headPortrait));
        return this;
    }
    
    public UserInfoQuery headPortraitNotEmpty(){
        values.add(Criteria.custom("","BLOB", OperatorEnum.IS_NOT_EMPTY,headPortrait));
        return this;
    }

	public UserInfoQuery birthdayEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.EQ,birthday));
        return this;
    }
    
    public UserInfoQuery birthdayNotEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NEQ,birthday));
        return this;
    }

    public UserInfoQuery birthdayLg(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LG,birthday));
        return this;
    }

    public UserInfoQuery birthdayLgEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LGE,birthday));
        return this;
    }

    public UserInfoQuery birthdayLt(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LT,birthday));
        return this;
    }

    public UserInfoQuery birthdayLtEqual(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LTE,birthday));
        return this;
    }

    public UserInfoQuery birthdayIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.IN,birthday));
        return this;
    }

    public UserInfoQuery birthdayNotIn(List<Date> lists){
        values.add(Criteria.custom(lists,"DATE",OperatorEnum.NOT_IN,birthday));
        return this;
    }

    public UserInfoQuery birthdayLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.LIKE,birthday));
        return this;
    }

    public UserInfoQuery birthdayNotLike(Date value){
        values.add(Criteria.custom(value,"DATE", OperatorEnum.NOT_LIKE,birthday));
        return this;
    }
    
   public UserInfoQuery birthdayIsEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_EMPTY,birthday));
        return this;
    }
    
    public UserInfoQuery birthdayNotEmpty(){
        values.add(Criteria.custom("","DATE", OperatorEnum.IS_NOT_EMPTY,birthday));
        return this;
    }
}