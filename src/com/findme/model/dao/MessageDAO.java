package com.findme.model.dao;

import java.util.ArrayList;

import com.findme.model.vo.Message;

public interface MessageDAO {
	// C
	public int sendMessmage(Message message);

	// R
	public ArrayList<Message> getMsgListBySender(String sender);

	public ArrayList<Message> getMsgListByReceiver(String receiver);

	// U

	// D
	public int delete(String memId);
}