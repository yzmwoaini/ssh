package com.yccz.action;



import org.apache.log4j.Logger;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.yccz.bean.Users;
import com.yccz.biz.UserBiz;


@Component("UserAction")
@Scope("prototype")
public class UserAction extends ActionSupport{


	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(UserAction.class);
	private static final long serialVersionUID = 4032245704681491414L;

	
	@Autowired
	private UserBiz biz;
	private Users user;
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}


	
	@Override
	public String execute() throws Exception {
		System.out.println("name:"+user.getLoginName());
		if(biz.login(user)){
			System.out.println("回来");
			return "success";
		}
		else{
			System.out.println("回来1");
			return "error";	
		}
	}
	
	
}
