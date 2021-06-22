package model.DTO;

public class PurchaseDTO {
	
	String purchaseNum;
	String memId;
	String purchaseTotPrice;
	String purchaseAddr;
	String purchaseMethod;
	String purchaseRequest;
	String purchaseDate;
	String receiverName;
	String receiverPhone;
	
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPurchaseTotPrice() {
		return purchaseTotPrice;
	}
	public void setPurchaseTotPrice(String purchaseTotPrice) {
		this.purchaseTotPrice = purchaseTotPrice;
	}
	public String getPurchaseAddr() {
		return purchaseAddr;
	}
	public void setPurchaseAddr(String purchaseAddr) {
		this.purchaseAddr = purchaseAddr;
	}
	public String getPurchaseMethod() {
		return purchaseMethod;
	}
	public void setPurchaseMethod(String purchaseMethod) {
		this.purchaseMethod = purchaseMethod;
	}
	public String getPurchaseRequest() {
		return purchaseRequest;
	}
	public void setPurchaseRequest(String purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	
}
