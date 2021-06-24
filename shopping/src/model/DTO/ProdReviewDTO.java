package model.DTO;

import java.util.Date;

public class ProdReviewDTO { // memId 만들라고
	String ProdNum;
	String memId;
	String reviewContent;
	String reviewImg;
	Date reviewDate;
	
	
	public String getProdNum() {
		return ProdNum;
	}
	public void setProdNum(String prodNum) {
		ProdNum = prodNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewImg() {
		return reviewImg;
	}
	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	 
}
