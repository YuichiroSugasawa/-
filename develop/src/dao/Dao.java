package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.book;

public class Dao {

	private Connection con;
	private String sql;
	
	/**
	 * コンストラクタ
	 * @throws SQLException
	 */
	public Dao() throws SQLException{
		// DBを指定
		String url= "jdbc:mysql://localhost:3306/webapi?serverTimezone=UTC";
		// ログイン情報
		String user = "root";
		String pass = "root";
		// DBへ接続
		con = DriverManager.getConnection(url, user, pass);
		System.out.println("Connection success!");
	}
	
	/**
	 * DBとの接続を閉じる
	 */
	public void close() {
		try {
			// 接続を閉じる
			if(con != null) con.close(); 
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//
	public ArrayList<book> Own(String title , String writer , String company) throws SQLException{
		// SQL
		sql = "select * from books where title like ? and writer like ? and company like ?";
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		//  Listメソッドの作成　メソッドにはsqlの？入れるカラム名が入る
		ArrayList<book> list = new ArrayList<book>();
		
		try {
			// プレースホルダを設定
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+title+"%");
			ps.setString(2, "%"+writer+"%");
			ps.setString(3, "%"+company+"%");

			// SQL実行
			rs = ps.executeQuery();
			//検索したデータがすべて表示されるまで繰り返し取り出す
			while(rs.next()) {
				//itemメソッドの作成
				book item = new book();
				// 本のタイトルを取得してitemへ格納
				item.setTitle(rs.getString("title"));
				//本の著者を取得、itemへ
				item.setWriter(rs.getString("writer"));
				//本の出版社を取得、itemへ
				item.setCompany(rs.getString("company"));
				
				item.setId(rs.getInt("book_id"));
				//itemメソッドに格納
				list.add(item);
			}
			rs.close();
		}finally {
			ps.close();
		}
		//呼び出し元の上記listメソッドに返す
		return list;
	}
	
	/**
	 * お気に入り店舗を追加
	 * @param accountId:アカウントID
	 * @param shopId:店舗ID
	 * @return 実行結果
	 * @throws SQLException
	 */
	public int insertbook(String bookTitleInput , String bookWriterInput , String bookCompanyInput) throws SQLException{
		// SQL
		String sql = "INSERT INTO books(title, writer , company) VALUES (?, ? , ?) ";
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			// プレースホルダを設定
			ps = con.prepareStatement(sql);
			ps.setString(1, bookTitleInput);
			ps.setString(2, bookWriterInput);
			ps.setString(3, bookCompanyInput);
			
			// SQL実行、追加したデータの数を足す
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		
		return n;
	}
	
	/**
	 * お気に入り店舗を削除
	 * @param accountId:アカウントID
	 * @param shopId:店舗ID
	 * @return 実行結果
	 * @throws SQLException
	 */
	public int deletebook(int id) throws SQLException{
		// SQL
		String sql = "delete from books where book_id = ?";
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			// プレースホルダを設定
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			// SQL実行
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		
		return n;
	}
	
	/**
	 * アカウントを検索して取得
	 * @param accountId:アカウントID
	 * @param passWord:パスワード
	 * @return　検索結果
	 * @throws SQLException
	 */
	public int getAccount(String accountId, String passWord) throws SQLException{
		// SQL
		sql = "select * from account where account_id = ? and password = ?";
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		int result = 0;
		
		try {
			// プレースホルダを設定
			ps = con.prepareStatement(sql);
			ps.setString(1, accountId);
			ps.setString(2, passWord);

			// SQL実行
			rs = ps.executeQuery();
			// 結果のカーソルを最後へ移動
			rs.next();
			// 結果取得
			result = rs.getRow();
			// ResultSetを閉じる
			rs.close();
		}finally {
			ps.close();
		}
		
		return result;
	}

	public int purchaseplan(String bookTitlePlan, String bookWriterPlan, String bookCompanyPlan) throws SQLException {
		// TODO Auto-generated method stub
		//SQLでの処理を記入
		String sql = "INSERT INTO purchaseplan (title, writer , company) VALUES (?, ? , ?) ";
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			// プレースホルダを設定
			ps = con.prepareStatement(sql);
			ps.setString(1, bookTitlePlan);
			ps.setString(2, bookWriterPlan);
			ps.setString(3, bookCompanyPlan);
			
			// SQL実行、追加したデータの数を足す
			n = ps.executeUpdate();
		}finally {
			ps.close();
		}
		
		return n;
	}
}
