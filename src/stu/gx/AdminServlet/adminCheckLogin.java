package stu.gx.AdminServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stu.gx.bean.admin;
import stu.gx.dao.AdminDao;
import stu.gx.dao.impl.AdminDaoImpl;

/**
 * Servlet implementation class adminCheckLogin
 */
public class adminCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminCheckLogin() {
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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");//�Ƿ�ѡ���ס����
		String usernamee;
		String passwordd;
		System.out.println("����Ա������û���Ϊ��" + username);
		System.out.println("����Ա���������Ϊ��" +password);
		
		AdminDao admin = new AdminDaoImpl();
		List<admin> allAdmins = admin.getAllAdmins();
		
		boolean flag = false;
		
		for(admin admin1 : allAdmins) {
			usernamee = admin1.getUsername();
		    passwordd = admin1.getPassword();
			System.out.println("name:" + usernamee);
			System.out.println("pass:" + passwordd);
			if(username.equals(usernamee)) {
				flag = true;
				break;
			}
		}
		//System.out.println("flag:" + flag);
		    
		   if(flag == true) {//������û�������
			admin pass = admin.getPassword(username);
			String password2 = pass.getPassword();
			
			if(password.equals(password2)) {
				//�ж��Ƿ�ѡ���˼�ס����
				if(remember.equals("true"))
				{
					Cookie ck1 = new  Cookie("username", username);
					System.out.println("��ס�û����˺ţ�" + username);
					ck1.setMaxAge(1000);	
					response.addCookie(ck1);
					Cookie ck2 = new  Cookie("password", password);
					System.out.println("��ס�û������룺" + password);
					ck2.setMaxAge(1000);	
					response.addCookie(ck2);
				}
				else//ȡ����ס�û�������
				{
					Cookie ck1 = new  Cookie("username", "");
					ck1.setMaxAge(0);	
					response.addCookie(ck1);
					Cookie ck2 = new  Cookie("password", "");
					ck2.setMaxAge(0);	
					response.addCookie(ck2);
				}
				
				System.out.println("����Ա�û�����" + username);
				
				AdminDao admind = new AdminDaoImpl();
				admin admin1 = admind.getAdminId(username);
				int rank = admin1.getRank();
				System.out.println(rank);
				
				HttpSession  session= request.getSession();
		        //�����ݴ洢��session��
				session.setAttribute("admin", username);
				session.setAttribute("admin_id", admin1.getAdmin_id());
				session.setAttribute("rank", rank);

				out.write("1");//��¼�ɹ�
				
			}
			else if(password.equals("")){
				out.write("4");//����Ϊ��
			}
			else {
				out.write("3");//�������
			}
		  }
		
		else if(flag == false)//�û���������
		{
			
		    if(username.equals("")) {//�û���δ����
					out.write("-1");
			}else {//�û������벻����
				out.write("2");
			}
			
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
