package com.findme.model.dao;

import java.util.ArrayList;

import com.findme.model.vo.Finditem;

public interface FinditemDAO {
	// C
	public boolean writeFinditem(Finditem finditem);

	// R
	public int finditemCountAll();

	public ArrayList<Finditem> getFinditemList();

	public ArrayList<Finditem> getDoneFinditem();

	public ArrayList<Finditem> getFinditemByAddress(String address);

	// U

	// D
}