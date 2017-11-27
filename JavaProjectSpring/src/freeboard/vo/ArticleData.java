package freeboard.vo;

/**
 * <pre>
 * org.dimigo.vo |_ FreeArticleData
 *
 * 1. 개요 : 2. 작성일 : 2017. 11. 16.
 * 
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class ArticleData {
	private Article article;
	private ArticleContent articleContent;
	private int previousNumber;
	private int nextNumber;

	public ArticleData(Article article, ArticleContent articleContent, int previousNumber, int nextNumber) {
		super();
		this.article = article;
		this.articleContent = articleContent;
		this.previousNumber = previousNumber;
		this.nextNumber = nextNumber;
	}

	public int getPreviousNumber() {
		return previousNumber;
	}

	public void setPreviousNumber(int previousNumber) {
		this.previousNumber = previousNumber;
	}

	public int getNextNumber() {
		return nextNumber;
	}

	public void setNextNumber(int nextNumber) {
		this.nextNumber = nextNumber;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleContent getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(ArticleContent articleContent) {
		this.articleContent = articleContent;
	}

}
