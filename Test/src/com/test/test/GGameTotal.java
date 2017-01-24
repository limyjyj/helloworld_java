package com.test.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class Person implements Serializable{
	private String name;
	private int win;
	private int lose;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
}
public class GGameTotal {
	public static void main(String argc[]) {

		Scanner scanner = new Scanner(System.in);
		String P1 = new String();
		String P2 = new String();
		ArrayList<Person> playerRecord= new ArrayList<Person>();
		playerRecord = readRecord();
		do {
			System.out.println("1.Up 2.Down 3.end");
			int selectMenu  = scanner.nextInt();
			if(selectMenu==1){
//				GGame p1 = new GGame();
//				GGame p2 = new GGame();
				GGame[] players = {new GGame(), new GGame()};				
				
				System.out.println("카드를 몇 장 사용하시겠습니까?");
				System.out.println("(최대 100장)");
				int cardnum = scanner.nextInt();
//				p1.initailReverse(cardnum);
//				p2.initailReverse(cardnum);
				players[0].initailReverse(cardnum);
				players[1].initailReverse(cardnum);
				System.out.print("p1의 이름: ");
				String p1 = scanner.next();
				System.out.print("p2의 이름: ");
				String p2 = scanner.next();
				
				for (int j = 0; j < cardnum; j++) {
					for(int k = 0; k < 2; k++){
						System.out.println("플레이어 p"+(k+1)+"의 카드");
						for (int i = 0; i < cardnum; i++) {
							if (!players[0].checkCard(i)) {
								System.out.print(players[0].getCardNum(i) + " ");
							}
						}
						while (true) {
							int select = scanner.nextInt();
							if (players[0].drawCard(select))
								System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
							else
								break;
						}
						clear();
					}
						
					/*System.out.println("플레이어 p2의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!p2.checkCard(i)) {
							System.out.print(p2.getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (p2.drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}*/
					if (players[0].checkVictory(players[1])) {
						System.out.println("p1이 이겼습니다.");
						System.out.println("p1score :" + players[0].getScore());
						System.out.println("p2score :" + players[1].getScore());
					} else if (players[1].checkVictory(players[0])) {
						System.out.println("p2가 이겼습니다.");
						System.out.println("p1score :" + players[0].getScore());
						System.out.println("p2score :" + players[1].getScore());
					} else {
						players[0].reverse(players[1]);
						System.out.println("비겼습니다.");
						System.out.println("p1score :" + players[0].getScore());
						System.out.println("p2score :" + players[1].getScore());
					}
					
				}
				if (players[0].victoryGame(players[1])) {
					System.out.println("p1이 " + players[0].getScore() + " 대 " + players[1].getScore() + "로 이겼습니다.");
				} else if (players[1].victoryGame(players[0]))
					System.out.println("p2가 " + players[0].getScore() + " 대 " + players[1].getScore() + "로 이겼습니다.");
				else
					System.out.println("비겼네요 ㅠㅠ");
			}
			else if(selectMenu==2){
				System.out.println("몇 점으로 하시겠습니까?");
				int maxscore = scanner.nextInt();
				System.out.println(maxscore);
				GGameSecond p1 = new GGameSecond(maxscore);
				GGameSecond p2 = new GGameSecond(maxscore);
				System.out.println("카드를 몇 장 사용하시겠습니까?");
				System.out.println("(최대 100장)");
				int cardnum = scanner.nextInt();
				p1.initailReverse(cardnum);
				p2.initailReverse(cardnum);
				for (int j = 0; j < cardnum; j++) {
					System.out.println("플레이어 p1의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!p1.checkCard(i)) {
							System.out.print(p1.getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (p1.drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}
					clear();
					System.out.println("플레이어 p2의 카드");
					for (int i = 0; i < cardnum; i++) {
						if (!p2.checkCard(i)) {
							System.out.print(p2.getCardNum(i) + " ");
						}
					}
					while (true) {
						int select = scanner.nextInt();
						if (p2.drawCard(select))
							System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
						else
							break;
					}
					if (p1.checkVictory(p2)) {
						System.out.println("p1이 점수를 땃습니다.");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
						if (p1.victoryGame()) {
							System.out.println("p1이 게임에서 이겼습니다.");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						} else if (p2.victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						}
					} else if (p2.checkVictory(p1)) {
						System.out.println("p2가 점수를 땄습니다");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
						if (p1.victoryGame()) {
							System.out.println("p1이 게임에서 이겼습니다");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						} else if (p2.victoryGame()) {
							System.out.println("p2가 게임에서 이겼습니다.");
							System.out.println("p1score :" + p1.getScore());
							System.out.println("p2score :" + p2.getScore());
							break;
						}
					} 
				}
			}
			else if(selectMenu==3)
				System.out.println("");
			System.out.println("그만 하시겠습니까?(y/n)");
			
		} while (!scanner.next().equals("y"));
		System.out.println("***************");
		System.out.println("***다음에 또 만나요***");
		System.out.println("***************");
		
	
		
	}
	
	
	 static ArrayList<Person> readRecord(){
		ArrayList<Person> player= new ArrayList<Person>();
		try {
			FileInputStream fis = new FileInputStream("score.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			player =  (ArrayList<Person>)ois.readObject();	
			ois.close(); fis.close();
		} catch (Exception e) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("ranking.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(player);
				oos.flush();
				oos.close();
				fos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return player;
	}
	
	static void clear() {
		for (int i = 0; i < 15; i++)
			System.out.println("");
	}
}
