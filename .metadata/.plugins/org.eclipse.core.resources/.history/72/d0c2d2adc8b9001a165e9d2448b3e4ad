package PurchagePlan;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servers.InputBookDBAccess;
import servers.OwnDBAccess;
import servers.PurchasePlanDBAccess;

/**
 * Servlet implementation class PurchasePlan
 */
@WebServlet("/PurchasePlan")
public class PurchasePlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchasePlan() {
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
	//purchasePlans.jspから送られてきた変数を
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//InputBooks.jspから受け取った変数をString型に変換
		String bookTitlePlan = request.getParameter("bookTitlePlan");
		String bookWriterPlan = request.getParameter("bookWriterPlan");
		String bookCompanyPlan = request.getParameter("bookCompanyPlan");
		
		doGet(request, response);
		//例外処理
		try {
			//PurchasePlanDBAccess.javaのInsertメソッドにデータの型を指定した変数を送る
			PurchasePlanDBAccess.Insert(bookTitlePlan,bookWriterPlan,bookCompanyPlan);
		} catch (SQLException e1) {
			//実際に例外が発生した場合の処理
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}

	}
}
