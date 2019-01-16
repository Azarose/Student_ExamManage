package stu.gx.dao;

import java.util.List;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import stu.gx.bean.exam;
import stu.gx.jdbc.C3P0Util;

/**
 * Servlet implementation class examDao
 */
public interface ExamDao {

	DataSource ds = C3P0Util.getDataSource();
	QueryRunner qr = new QueryRunner(ds);

	public boolean add(exam exam);

	public boolean delete(int exam_id);

	public boolean update(exam exam);

	// �����п���
	public List<exam> getAllExam();

	// ��һ���ض�id�Ŀ�����Ϣ
	public exam getOneExam(int exam_id);

	public exam getOneExam(String exam_name);
	
	//���ݿ��Ե�״̬��ɸѡ����
	public List<exam> getStatusExam(String status);

	// ��ѯ���ڴ�ĳһ�е�ĳһ�е���Ϣ�����ڷ�ҳ��ʹ��
	public List<exam> getAll(int startIndex, int pageSize);
	
	//���±����ɹ�������
	public boolean updateNum(int exam_id, int num);
	
	//���±���������
	public boolean updateAllNum(int exam_id, int num);
	
	//���ݹ���Աid�ҵ������������Ŀ���
	public List<exam> getAllAdmin(int admin_id);

}
