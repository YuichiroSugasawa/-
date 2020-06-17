package servers; 

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;
import dao.Dao;
import dto.book;

public class OwnDBAccess {

		// TODO Auto-generated constructor stub
		//Selectメソッドの作成
		public static ArrayList<book> Select(String bookTitleSerch , String bookWriterSerch , String bookCompanySerch) throws SQLException {
			//Daoファイルのdao変数にはなにも入れない
			Dao dao = null;
			ArrayList<book> result = null;
			
			try {
				dao = new Dao();
				
				result = dao.Own(bookTitleSerch , bookWriterSerch , bookCompanySerch);
			}finally {
				if(dao != null) dao.close();
			}
			
			return result;
		}

}
