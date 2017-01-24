package com.test.test;

public class Card {
	private int num;
	private boolean reverse;
	
	public Card(){
		num=0;
		reverse=true;
	}
	
	public void setNum(int num){
		this.num=num;
	}
	
	public void setReverse(boolean reverse){
		this.reverse=reverse;
	}
	
	public int getNum(){
		return num;
	}
	
	public boolean isReverse(){
		return reverse;
	}
}
