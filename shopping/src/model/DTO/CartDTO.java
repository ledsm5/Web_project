package model.DTO;

public class CartDTO {
	String memId;
	String prodNum;
	String cartQty;
	Integer cartPrice;
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getCartQty() {
		return cartQty;
	}
	public void setCartQty(String cartQty) {
		this.cartQty = cartQty;
	}
	public Integer getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(Integer cartPrice) {
		this.cartPrice = cartPrice;
	}
	
}
