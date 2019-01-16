package stu.gx.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stu.gx.bean.user;
import stu.gx.dao.UserDao;
import stu.gx.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class userCheckLogin
 */
public class userCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userCheckLogin() {
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
		System.out.println("�û�������û���Ϊ��" + username);
		System.out.println("�û����������Ϊ��" +password);
		System.out.println(remember);
		
		UserDao user = new UserDaoImpl();
		List<user> allUsers = user.getAllUser();
		
		boolean flag = false;
		
		for(user user1 : allUsers) {
			usernamee = user1.getUsername();
			System.out.println("name:" + usernamee);
			if(username.equals(usernamee)) {
				flag = true;
				break;
			}
		}
		    
		   if(flag == true) {//������û�������
			user pass = user.getPassword(username);
			String password2 = pass.getPassword();
			System.out.println("pass:" + password2);
			
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
				
				//���û���¼��Ϣ������session��
	            HttpSession session = request.getSession();
	            session.setAttribute("loginName", username);
	            
				
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
