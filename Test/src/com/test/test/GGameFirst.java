package com.test.test;

public class GGameFirst extends GGame implements initailReverse, reverse, checkVictory, checkCard{
	
	public GGameFirst(int score){
		super();
		this.setScore(score);
		System.out.println(getScore());
	}
	
	public void reverse(GGame player){
		this.setCardReverse(getInput(),false);
		player.setCardReverse(player.getInput(),false);
	}
	@Override
	public void initailReverse(int a){
		for(int i=a;i<TOTAL_CARD;i++){
			this.setCardReverse(i,false);
		}
	}
	public boolean checkCard(int cardnum){
		if(this.isCardReverse(cardnum))
			return false;
		return true;
	}
	
	public boolean checkVictory(GGame player){
		if(this.getScore()<1)
			return false;
		if(this.getInput()>player.getInput() ){
			this.setScore(this.getScore()-1);
			reverse(player);
			return true;
		}
		return false;
	}
	
	

}
