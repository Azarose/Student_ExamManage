package stu.gx.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import stu.gx.bean.admin;
import stu.gx.jdbc.C3P0Util;

  /**
  *  admin����ɾ�Ĳ�
  */
public interface AdminDao {
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	public boolean add(admin admin);

	public boolean delete(int admin_id) ;

	
	public boolean update(admin admin) ;

	//�����û�����ѯ����
	public admin getPassword(String username) ;
	
	public admin getAdminId(String username);
	
	//��ѯ����ȫ����Ϣ
	public List<admin> getAllAdmins() ;
	
	public admin getAdmin(int admin_id);

}
