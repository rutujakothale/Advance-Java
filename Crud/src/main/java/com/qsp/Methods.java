package com.qsp;

public interface Methods {
	public void save();
	public void update(int id) throws Customized;
	public void delete(int id);
	public void getbyid(int id);
	public void getalldata();
}
