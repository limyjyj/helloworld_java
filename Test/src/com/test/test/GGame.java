package com.test.test;

import java.util.Scanner;

public class GGame {
	Card[] card = new Card[100];
	int score;
	int input;
	int cardcount;
	
	Scanner scanner = new Scanner(System.in);
	
	public GGame(){
		
		for(int i=0;i<100;i++){
			card[i]=new Card();
			card[i].num=i;
			card[i].card=true;
		}
		score=0;
		input=0;
		cardcount=0;
	}
	
	void reset(int a){
		for(int i=a;i<100;i++){
			card[i].card=false;
		}
	}
	
	int showCard(GGame player,int cardNum){
		return player.card[cardNum].num;
	}
	
	boolean checkCard(int cardNum){
		if(this.card[cardNum].card==false)
			return true;
		return false;
	}
	
	void flag(GGame player){//낸 카드를 안보이게 하는 것
		this.card[input].card=false;
		player.card[player.input].card=false;
	}
	
	boolean checkVictory(GGame player){
		if(this.input>player.input){
			this.score++;
			flag(player);
			return true;
		}
		return false;
	}
	
	boolean drawCard(){
		input=scanner.nextInt();
		if(input>=101)
			return true;
		else if(checkCard(input))
			return true;
		return false;
	}
	
	boolean victoryGame(GGame player){
		if(this.score>player.score)
			return true;
		return false;
	}
	
	void clear(){
		for(int i=0;i<15;i++)
			System.out.println("");
	}
	
}