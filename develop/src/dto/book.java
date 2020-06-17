package dto;

import java.io.Serializable;

/**
 * 
 * 本クラス
 * 本情報を格納するクラスです
 *
 */
public class book implements Serializable{
	private static final long serialVersionUID = 1L;
	

	
	// タイトル
	public String title;
	// 著名
	public String writer;
	// 出版社
	public String company;
	
	// ゲッター/セッター
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company =company ;
	}
	
	
}