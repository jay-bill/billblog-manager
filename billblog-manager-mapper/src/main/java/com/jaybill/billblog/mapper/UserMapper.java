package com.jaybill.billblog.mapper;

import com.jaybill.billblog.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateForeignHeadImage(User record);

    int updateByPrimaryKeySelective(User record);
    
    int updateUserHeadImage(User record);
    
    int updateByPrimaryKey(User record);
    
    User selectByUserAccount(String userAccount);
    
    /**
     * 登录时，用于判断账号、密码
     * @param inUser
     * @return
     */
    User selectByAccountAndPword(User inUser);

	User selectByNickname(String userNickname);
}