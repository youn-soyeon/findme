package com.findme.model.dao;

import java.util.ArrayList;

import com.findme.model.vo.Lostitem;

public interface LostitemDAO {
	// C
	public int writeLostitem(Lostitem lostitem);

	// R
	public int lostitemCountAll();

	public ArrayList<Lostitem> getLostitemList();

	public ArrayList<Lostitem> getDoneLostitem();

	public ArrayList<Lostitem> getLostitemByAddress(String Address);

	// U

	// D
}
