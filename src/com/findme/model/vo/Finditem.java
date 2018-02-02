package com.findme.model.vo;

public class Finditem {
	private int fId;
	private String fDate;
	private String fAddress;
	private String fContent;
	private String fPicture;
	private String fHashtag;
	private String fUpDate;
	private int fDone;
	private String writer;
	private String fModiDate;

	public String getfModiDate() {
		return fModiDate;
	}

	public void setfModiDate(String fModiDate) {
		this.fModiDate = fModiDate;
	}

	public Finditem(String fDate, String fAddress, String fContent, String fPicture, String fHashtag, String writer) {
		this.fDate = fDate;
		this.fAddress = fAddress;
		this.fContent = fContent;
		this.fPicture = fPicture;
		this.fHashtag = fHashtag;
		this.writer = writer;
	}

/*	public Finditem(int fId, String fDate, String fAddress, String fContent, String fPicture, String fHashtag,
			String fUpDate, int fDone, String writer) {
		this.fId = fId;
		this.fDate = fDate;
		this.fAddress = fAddress;
		this.fContent = fContent;
		this.fPicture = fPicture;
		this.fHashtag = fHashtag;
		this.fUpDate = fUpDate;
		this.fDone = fDone;
		this.writer = writer;
	}*/
	
	public Finditem(int fId, String fDate, String fAddress, String fContent, String fPicture, String fHashtag,
			String fUpDate, int fDone, String writer, String fModiDate) {
		super();
		this.fId = fId;
		this.fDate = fDate;
		this.fAddress = fAddress;
		this.fContent = fContent;
		this.fPicture = fPicture;
		this.fHashtag = fHashtag;
		this.fUpDate = fUpDate;
		this.fDone = fDone;
		this.writer = writer;
		this.fModiDate = fModiDate;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getfDate() {
		return fDate;
	}

	public void setfDate(String fDate) {
		this.fDate = fDate;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public String getfPicture() {
		return fPicture;
	}

	public void setfPicture(String fPicture) {
		this.fPicture = fPicture;
	}

	public String getfHashtag() {
		return fHashtag;
	}

	public void setfHashtag(String fHashtag) {
		this.fHashtag = fHashtag;
	}

	public String getfUpDate() {
		return fUpDate;
	}

	public void setfUpDate(String fUpDate) {
		this.fUpDate = fUpDate;
	}

	public int getfDone() {
		return fDone;
	}

	public void setfDone(int fDone) {
		this.fDone = fDone;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Finditem [fId=" + fId + ", fDate=" + fDate + ", fAddress=" + fAddress + ", fContent=" + fContent
				+ ", fPicture=" + fPicture + ", fHashtag=" + fHashtag + ", fUpDate=" + fUpDate + ", fDone=" + fDone
				+ ", writer=" + writer + ", fModiDate=" + fModiDate + "]";
	}

}