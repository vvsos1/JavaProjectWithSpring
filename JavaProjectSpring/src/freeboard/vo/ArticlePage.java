package freeboard.vo;

import java.util.List;

/**
 * <pre>
 * org.dimigo.vo |_ FreeArticlePage
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 20.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ArticlePage {
	private int totalPage;
	private int currentPage;
	private List<Article> article;

	public ArticlePage(int totalPage, int currentPage, List<Article> article) {
		super();
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.article = article;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<Article> getArticle() {
		return article;
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

}
