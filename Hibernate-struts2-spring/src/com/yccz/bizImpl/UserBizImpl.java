package com.yccz.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yccz.bean.Users;
import com.yccz.biz.UserBiz;
import com.yccz.dao.UserDAO;
@Service
public class UserBizImpl implements UserBiz {
	 @Autowired
	 private UserDAO userDao;
	@Override
	public boolean login(Users user) {
	
		boolean flag=false;
	List<Users> list=userDao.search();
	for(Users li:list){
		if(user.getLoginName().equals(li.getLoginName())&&user.getLoginPwd().equals(li.getLoginPwd())){
			flag=true;
			break;
		}
	}
		
		return flag;
		
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	







}
