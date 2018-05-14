package cn.synu.domain;

public class OrderLine {
	private String id;
	private String bookid;
	private Integer cont;
	private Double price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public Integer getCont() {
		return cont;
	}
	public void setCont(Integer cont) {
		this.cont = cont;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", bookid=" + bookid + ", cont=" + cont
				+ ", price=" + price + "]";
	}
}
