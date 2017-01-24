package com.test.test;

import java.util.Scanner;

public class GGame {
	static final int TOTAL_CARD=100;
	
	private Card[] card = new Card[TOTAL_CARD];
	private int score;
	private int input;

	public void setScore(int score){
		this.score = score;
	}
	
	public void setInput(int input){
		this.input= input;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getInput(){
		return input;
	}
	
	public int getCardNum(int index){
		return card[index].getNum();
	}
	
	public boolean isCardReverse(int index){
		return card[index].isReverse();
	}
	public void setCardNum(int index,int num){
		card[index].setNum(num);
	}
	
	public void setCardReverse(int index,boolean reverse){
		card[index].setReverse(reverse);
	}
	
	public GGame(){
		for(int i=0;i<TOTAL_CARD;i++){
			card[i]=new Card();
			card[i].setNum(i);
			card[i].setReverse(true);
		}
		score=0;
		input=0;
	}
	
	void initailReverse(int a){
		for(int i=a;i<TOTAL_CARD;i++){
			card[i].setReverse(false);
		}
	}
	
	
	boolean checkCard(int cardnum){
		if(card[cardnum].isReverse())
			return false;
		return true;
	}
	
	void reverse(GGame player){
		this.card[input].setReverse(false);
		player.card[player.input].setReverse(false);
	}
	
	boolean checkVictory(GGame player){
		if(this.input>player.input){
			this.score++;
			reverse(player);
			return true;
		}
		return false;
	}
	
	boolean drawCard(int input){
		this.input=input;
		if(checkCard(input))
			return true;
		return false;
	}
	
	boolean victoryGame(GGame player){
		if(this.score>player.score)
			return true;
		return false;
	}
	
}