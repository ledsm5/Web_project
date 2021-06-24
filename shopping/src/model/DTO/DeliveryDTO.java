package model.DTO;

public class DeliveryDTO {
	String purchaseNum;
	String deliveryCom;
	String deliveryDelFree;
	String deliveryNum;
	String arrivalExpDate;
	String deliveryExpDate;
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getDeliveryCom() {
		return deliveryCom;
	}
	public void setDeliveryCom(String deliveryCom) {
		this.deliveryCom = deliveryCom;
	}

	public String getDeliveryDelFree() {
		return deliveryDelFree;
	}
	public void setDeliveryDelFree(String deliveryDelFree) {
		this.deliveryDelFree = deliveryDelFree;
	}
	public String getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public String getArrivalExpDate() {
		return arrivalExpDate;
	}
	public void setArrivalExpDate(String arrivalExpDate) {
		this.arrivalExpDate = arrivalExpDate;
	}
	public String getDeliveryExpDate() {
		return deliveryExpDate;
	}
	public void setDeliveryExpDate(String deliveryExpDate) {
		this.deliveryExpDate = deliveryExpDate;
	}
}
