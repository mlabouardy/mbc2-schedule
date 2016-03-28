package com.labouardy.service;

import com.labouardy.model.Show;

public class ShowSetMapper{

	public Show mapFieldSet(String[] data) {
		Show show=new Show();
		show.setImage(data[3]);
		show.setKsa(data[1]);
		show.setEg(data[2]);
		show.setDescription(data[4]);
		show.setName(data[0]);
		return show;
	}

}
