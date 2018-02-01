package com.findme.model.vo;

public class Message {
	private int msgId;
	private String receiver;
	private String msgContent;
	private String msgDate;
	private int reDelFlag;
	private int seDelFlag;
	private String sender;
	private String msgTitle;

	public Message(String receiver, String msgContent, String sender, String msgTitle) {
		super();
		this.receiver = receiver;
		this.msgContent = msgContent;
		this.sender = sender;
		this.msgTitle = msgTitle;
	}

	public Message(int msgId, String receiver, String msgContent, String msgDate, int reDelFlag, int seDelFlag,
			String sender, String msgTitle) {
		this.msgId = msgId;
		this.receiver = receiver;
		this.msgContent = msgContent;
		this.msgDate = msgDate;
		this.reDelFlag = reDelFlag;
		this.seDelFlag = seDelFlag;
		this.sender = sender;
		this.msgTitle = msgTitle;
	}

	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}

	public int getReDelFlag() {
		return reDelFlag;
	}

	public void setReDelFlag(int reDelFlag) {
		this.reDelFlag = reDelFlag;
	}

	public int getSeDelFlag() {
		return seDelFlag;
	}

	public void setSeDelFlag(int seDelFlag) {
		this.seDelFlag = seDelFlag;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", receiver=" + receiver + ", msgContent=" + msgContent + ", msgDate="
				+ msgDate + ", reDelFlag=" + reDelFlag + ", seDelFlag=" + seDelFlag + ", sender=" + sender + "]";
	}
}