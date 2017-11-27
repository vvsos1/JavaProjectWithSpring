package freeboard.vo;

import java.util.Date;

import user.vo.UserVo;

/**
 * <pre>
 * org.dimigo.vo |_ FreeArticle
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 16.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class Article {
	private UserVo writer;
	private int number;
	private String title;
	private Date regDate;
	private int readCount;

	public Article() {
		super();
	}

	public Article(UserVo writer, int number, String title, Date regDate, int readCount) {
		super();
		this.writer = writer;
		this.number = number;
		this.title = title;
		this.regDate = regDate;
		this.readCount = readCount;
	}

	public UserVo getWriter() {
		return writer;
	}

	public void setWriter(UserVo writer) {
		this.writer = writer;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "FreeArticle [writer=" + writer + ", number=" + number + ", title=" + title + ", regDate=" + regDate
				+ ", readCount=" + readCount + "]";
	}
}
