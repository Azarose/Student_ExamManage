package stu.gx.dao;

import stu.gx.bean.Page;
import stu.gx.bean.exam;
import stu.gx.bean.exam_room;
import stu.gx.bean.signup;

public interface PageDao{
//	ȫ������
	public Page<exam> findAllexamWithPage(int pageNum,int pageSize);
//	ȫ������
	public Page<exam_room> findAllexam_roomWithPage(int pageNum,int pageSize);
//	ȫ������
	public Page<signup> findAllsignupWithPage(int pageNum,int pageSize);
	
//	ÿ������id��������
	public Page<signup> findSpecialsignupWithPage(int pageNum,int pageSize, int exam_id);
}