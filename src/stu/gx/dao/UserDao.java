package stu.gx.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import stu.gx.jdbc.C3P0Util;
import stu.gx.bean.user;

/**
 * ��user�������ɾ�Ĳ�
 */
public interface UserDao{
	
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);	

	public boolean add(user user) ;

	public boolean delete(String username) ;

	
	public boolean update(user user) ;

	
	//�õ�ĳ���û�������
	public user getPassword(String username) ;
	
	//�õ�ȫ���û�
	public List<user> getAllUser() ;
	
	//�õ�ĳ���û�
	public user getUserbyUN(String username);
	
	public user getUserbyID(int user_id);
	
}
