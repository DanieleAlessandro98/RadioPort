package model;

public interface IUserModel {
	public int getID();
	public String getName();
	public String getSurname();
	public int getDayCurrentSells();
	public int getHalfYearMaxSells();
	
	public void setDayCurrentSells(int numSells);
}
