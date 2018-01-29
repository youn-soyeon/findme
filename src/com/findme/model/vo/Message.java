package com.findme.model.vo;

public class Message {
	private int msgId;
	private String receiver;
	private String msgContent;
	private String msgDate;
	private int reDelFlag;
	private int seDelFlag;
	private String sender;

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

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", receiver=" + receiver + ", msgContent=" + msgContent + ", msgDate="
				+ msgDate + ", reDelFlag=" + reDelFlag + ", seDelFlag=" + seDelFlag + ", sender=" + sender + "]";
	}
}
