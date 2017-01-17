package com.test.test;

import java.util.Scanner;

public class GGameRun {

	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);

		do {
			GGame p1 = new GGame();
			GGame p2 = new GGame();
			System.out.println("카드를 몇 장 사용하시겠습니까?");
			System.out.println("(최대 100장)");
			int cardNum = scanner.nextInt();
			p1.reset(cardNum);
			p2.reset(cardNum);
			for (int j = 0; j < cardNum; j++) {
				System.out.println("플레이어 p1의 카드");
				for (int i = 0; i < cardNum; i++) {
					if (!p1.checkCard(i)) {
						System.out.print(p1.card[i].num + " ");
					}
				}//gghh
				while (true) {
					if (p1.drawCard())
						System.out.println("없는 숫자를 입력하셨습니다. 다시입력하세요.");
					else
						break;
				}
				p1.clear();
				System.out.println("플레이어 p2의 카드");
				for (int i = 0; i < cardNum; i++) {
					if (!p2.checkCard(i)) {
						System.out.print(p2.card[i].num + " ");
					}
				}
				while (true) {
					if (p2.drawCard())
						System.out.println("입력된 숫자를 입력하셨습니다. 다시입력하세요.");
					else
						break;
				}

				if (p1.checkVictory(p2)) {
					System.out.println("p1이 이겼습니다.");
					System.out.println("p1score :" + p1.score);
					System.out.println("p2score :" + p2.score);
				} else if (p2.checkVictory(p1)) {
					System.out.println("p2가 이겼습니다.");
					System.out.println("p1score :" + p1.score);
					System.out.println("p2score :" + p2.score);
				} else {
					p1.flag(p2);
					System.out.println("비겼습니다.");
					System.out.println("p1score :" + p1.score);
					System.out.println("p2score :" + p2.score);
				}
			}
			if (p1.victoryGame(p2)) {
				System.out.println("p1이 " + p1.score + " 대 " + p2.score + "로 이겼습니다.");
			} else if (p2.victoryGame(p1))
				System.out.println("p2가 " + p1.score + " 대 " + p2.score + "로 이겼습니다.");
			else
				System.out.println("비겼네요 ㅠㅠ");
			System.out.println("고만 하시겠습니까?(y/n)");
		} while (!scanner.next().equals("y"));
	}
}