package com.findme.model.vo;

public class Lostitem {
	private int lId;
	private String lDate;
	private String lAddress;
	private String lContent;
	private String lPicture;
	private String lHashtag;
	private String lUpDate;
	private int lDone;
	private String writer;

	public Lostitem(String lDate, String lAddress, String lContent, String lPicture,
			String lHashtag, String writer) {
		this.lDate = lDate;
		this.lAddress = lAddress;
		this.lContent = lContent;
		this.lPicture = lPicture;
		this.lHashtag = lHashtag;
		this.writer = writer;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getlDate() {
		return lDate;
	}

	public void setlDate(String lDate) {
		this.lDate = lDate;
	}

	public String getlAddress() {
		return lAddress;
	}

	public void setlAddress(String lAddress) {
		this.lAddress = lAddress;
	}

	public String getlContent() {
		return lContent;
	}

	public void setlContent(String lContent) {
		this.lContent = lContent;
	}

	public String getlPicture() {
		return lPicture;
	}

	public void setlPicture(String lPicture) {
		this.lPicture = lPicture;
	}

	public String getlHashtag() {
		return lHashtag;
	}

	public void setlHashtag(String lHashtag) {
		this.lHashtag = lHashtag;
	}

	public String getlUpDate() {
		return lUpDate;
	}

	public void setlUpDate(String lUpDate) {
		this.lUpDate = lUpDate;
	}

	public int getlDone() {
		return lDone;
	}

	public void setlDone(int lDone) {
		this.lDone = lDone;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Lostitem [lId=" + lId + ", lDate=" + lDate + ", lAddress=" + lAddress + ", lContent=" + lContent
				+ ", lPicture=" + lPicture + ", lHashtag=" + lHashtag + ", lUpDate=" + lUpDate + ", lDone=" + lDone
				+ ", writer=" + writer + "]";
	}
}
