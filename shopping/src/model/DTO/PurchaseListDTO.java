package model.DTO;

public class PurchaseListDTO {
	String purchaseNum;
	String prodNum;
	String purchaseQty;
	String purchasePrice;
	
	
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public String getPurchaseQty() {
		return purchaseQty;
	}
	public void setPurchaseQty(String purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
	public String getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
}
