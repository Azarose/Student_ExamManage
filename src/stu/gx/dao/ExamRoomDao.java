package stu.gx.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import stu.gx.bean.*;
import stu.gx.jdbc.C3P0Util;

/**
 *  Exam_room����ɾ�Ĳ�
 */
public interface ExamRoomDao{
	DataSource ds = C3P0Util.getDataSource();	
	QueryRunner qr = new QueryRunner(ds);
	
	public boolean add(exam_room exam_room) ;

	public boolean delete(int room_id);

	public boolean update(exam_room exam_room);

	//���ݿ����Ų�ѯ������Ϣ
	public exam_room getRoomInfo(int room_id);
	
	//���ݿ��ԺŲ�ѯ������Ϣ
	public List<exam_room> getRoomInfobyEI(int exam_id);
	
	//��ѯ����ȫ����Ϣ
	public List<exam_room> getAllexam_rooms() ;
	
	//��ѯ���ڴ�ĳһ�е�ĳһ�е���Ϣ
	public List<exam_room> getAll(int startIndex, int pageSize);

}
