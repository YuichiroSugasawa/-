package Own;

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

import dto.book;
import servers.OwnDBAccess;

/**
 * Servlet implementation class Own
 */
@WebServlet("/Own")
public class Own extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Own() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ownBook.jspで受けとった３つのデータの型を指定
		String bookTitleSerch = request.getParameter("bookTitleSearch");
		String bookWriterSerch= request.getParameter("bookWriterSearch");
		String bookCompanySerch= request.getParameter("bookCompanySearch");
		
		//book型のownBookList変数を作成
		ArrayList<book> ownBooksList = new ArrayList<book>();
		try {
			// リストを取得	
			ownBooksList = 	OwnDBAccess.Select(bookTitleSerch, bookWriterSerch , bookCompanySerch);
			//例外処理　フロント側には何も表示されない
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// リクエストに設定　
		request.setAttribute("ownBookList", ownBooksList);
		
		//リクエストしたsetAttributeを表示したいjspファイルの指定
		ServletContext context = getServletContext();
		RequestDispatcher dis = context.getRequestDispatcher("/OwnReslut.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);

	}

}
