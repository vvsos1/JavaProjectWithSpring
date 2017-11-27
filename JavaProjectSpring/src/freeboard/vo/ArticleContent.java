package freeboard.vo;

/**
 * <pre>
 * org.dimigo.vo |_ FreeArticleContent
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 16.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ArticleContent {
	private int number;
	private String content;

	public ArticleContent() {
		super();
	}

	public ArticleContent(int number, String content) {
		super();
		this.number = number;
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "FreeArticleContent [number=" + number + ", content=" + content + "]";
	}
}
