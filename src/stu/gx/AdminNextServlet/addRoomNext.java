package stu.gx.AdminNextServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.gx.bean.*;
import stu.gx.dao.*;
import stu.gx.dao.impl.*;
import stu.gx.dao.ExamRoomDao;
import stu.gx.dao.impl.ExamRoomDaoImpl;

/**
 * ���ӿ���
 */
public class addRoomNext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRoomNext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String exam_room_name = request.getParameter("exam_room_name");
		int exam_room_num = Integer.parseInt(request.getParameter("exam_room_num"));
		String exam_room_address = request.getParameter("exam_room_address");
		
		ExamRoomDao Edao = new ExamRoomDaoImpl();

			List<exam_room> el = Edao.getAllexam_rooms();
			boolean b = true;
			for (exam_room el1 : el) {
				if (el1.getRoom_name().equals(exam_room_name)) {
					b = false;
				}
			}
			if (b) {
//				����ѡ�Ŀ������Ƶõ����Ժ�
				int exam_id = Integer.parseInt(request.getParameter("exam_name"));
				exam_room er = new exam_room(exam_id, exam_room_name, exam_room_address, exam_room_num);
				Edao.add(er);
				out.print(
						"<script language='javascript'>alert('��ӳɹ���');window.location.href='/GradeMan/adminNext/manageExamRoom.jsp';</script>");
			} else {
				out.print(
						"<script language='javascript'>alert('���ʧ�ܣ��ÿ������Ѵ��ڣ���������д��������');window.location.href='/GradeMan/adminNext/addExamRoom.jsp';</script>");
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
