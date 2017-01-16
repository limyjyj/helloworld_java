package com.test.quiz2;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
		
		
		System.out.print("숫자를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
	
		while(true){
			if(num==1){
				for(int i=0;i<6;i++){
										
					for(int j=0;j<i;j++){
						System.out.print("*");
					}
					for(int j=0;j<i-1;j++){
						System.out.print("*");
					}
					System.out.println(" ");
				
				}
				
				break;
			}else if(num==2){
				
				for(int i=1;i<6;i++){
					for(int j=i;j<6;j++){
						System.out.print(" ");
					}
					System.out.println("*");
				}break;
			}else if(num ==3){
				
			}else {
				
			}
				
		
			}
		
	}

	

}
