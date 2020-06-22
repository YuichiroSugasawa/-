package Input;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servers.InputBookDBAccess;
import servers.OwnDBAccess;

/**
 * Servlet implementation class Input
 */
@WebServlet("/Input")
public class Input extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Input() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
			
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/InputComplete.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//InoutBooks.jspからdoPostメソッドへ
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//InputBooks.jspから受け取った変数をString型に変換
		String bookTitleInput = request.getParameter("bookTitleInput");
		String bookWriterInput= request.getParameter("bookWriterInput");
		String bookCompanyInput= request.getParameter("bookCompanyInput");
		//
		doGet(request, response);
	
		try {
			InputBookDBAccess.Insert(bookTitleInput,bookWriterInput,bookCompanyInput);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}

}
