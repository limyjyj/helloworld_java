package com.test.test;

import java.util.Scanner;

public class GGameExam {
	public static void main(String argc[]) {

		Scanner scanner = new Scanner(System.in);

		do {
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

				if (p1.victoryGame()) {
					System.out.println("p1이 이겼습니다.!!!");
					System.out.println("p1score :" + p1.getScore());
					System.out.println("p2score :" + p2.getScore());
					break;
				} else if (p2.victoryGame()) {
					System.out.println("p2가 이겼습니다.!!!");
					System.out.println("p1score :" + p1.getScore());
					System.out.println("p2score :" + p2.getScore());
					break;
				} else {
					if (p1.checkVictory(p2)) {
						System.out.println("p1이 이겼습니다.");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
					} else if (p2.checkVictory(p1)) {
						System.out.println("p2가 이겼습니다.");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
					} else {
						p1.reverse(p2);
						System.out.println("비겼습니다.");
						System.out.println("p1score :" + p1.getScore());
						System.out.println("p2score :" + p2.getScore());
					}
				}
			}
			System.out.println("그만 하시겠습니까?(y/n)");
		} while (!scanner.next().equals("y"));
		System.out.println("***************");
		System.out.println("***다음에 또 만나요***");
		System.out.println("***************");
	}

	static void clear() {
		for (int i = 0; i < 15; i++)
			System.out.println("");
	}
}