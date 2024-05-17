package com.devops.myproject;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public int userLogin(String user,String pass) {
    	ResourceBundle rb = ResourceBundle.getBundle("config");
    	String userName = rb.getString("username");
    	String passWord = rb.getString("password");
    	if(user.equals(userName) && pass.equals(passWord))
    		return 1;
    	else 
    		return 0;
    }
}
