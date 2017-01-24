package com.test.collection_exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class PersonInfo{
	String name;
	String tel;
	PersonInfo(){
		name = ""; 
		tel = "";
	}
	public void setName(String name){ this.name = name; }
	public String getName(){ return this.name; }
	public void setTel(String tel){ this.tel = tel;}
	public String getTel(){ return this.tel; }
}
public class CollectionExam {
	public static final int MAX = 10;
	public static void main(String []args){
		//-
		String[] name = new String[MAX];
		String[] tel = new String[MAX];
		//-
		PersonInfo[] addressBook = new PersonInfo[MAX];
		//-
		ArrayList<PersonInfo> addressBook2 = new ArrayList<PersonInfo>();
		
		// 1. 데이터 저장
		int index = 0;
		while(true){
			if(index < MAX){
				name[index] = "김우성";
				tel[index] = "01011112222";
			
				addressBook[index] = new PersonInfo();
				addressBook[index].setName("박초롱");
				addressBook[index].setTel("01099998888");
				index++;
				//
				PersonInfo info = new PersonInfo();
				info.setName("컬렉션마스터"+addressBook2.size());
				info.setTel("01022223333");
				addressBook2.add(info);
			}else{
				break;
			}
			
		}
		// 2. 데이터 조회
		for(int i = 0; i < MAX; i++){
			System.out.println(name[i] + "," + tel[i]);		
		}
		for(int i = 0; i < MAX; i++){
			System.out.println(addressBook[i].getName() + "," + addressBook[i].getTel());		
		}
		for(int i = 0; i < addressBook2.size(); i++){
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName() + "," + info.getTel());		
		}
		
		// 3. 데이터를 섞는다
		System.out.println("--------------------------------");
		PersonInfo[] shuffleBook = new PersonInfo[10];
		for(int i = 0; i < MAX; i++){
			while(true){
				int targetIndex = (int)(Math.random()*MAX);
				if (shuffleBook[targetIndex] == null) {
					shuffleBook[targetIndex] = addressBook[i];
					break;
				}
			}
		}
		addressBook = shuffleBook;
		for(int i = 0; i < MAX; i++){
			System.out.println(addressBook[i].getName() + "," + addressBook[i].getTel());		
		}
		
		//
		Collections.shuffle(addressBook2);
		for(int i = 0; i < addressBook2.size(); i++){
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName() + "," + info.getTel());	
			
		}
		System.out.println("---------------------1");
		
		// 4. 다시 정렬
		//초롱쓰
		for(int i = 0; i < MAX-1; i++){
			for(int j = i+1; j< MAX; j++){
				int cond = addressBook[i].getName().compareTo(addressBook[j].getName());
				if(cond > 0){
					PersonInfo temp = addressBook[i];
					addressBook[i] = addressBook[j];
					addressBook[j] = temp;
				}
			}
		}
		for(int i = 0; i < MAX; i++){
			System.out.println(addressBook[i].getName() + "," + addressBook[i].getTel());		
		}
		System.out.println("---------------------2");
		//컬렉션마스터
		Collections.sort(addressBook2, new Comparator<PersonInfo>() {
			public int compare(PersonInfo obj1, PersonInfo obj2){
				
				int cond = obj1.getName().compareTo(obj2.getName());
				return(cond < 0 ? -1 : (cond > 0 ? 1:0));
			}
		});
		
		for(int i = 0; i < addressBook2.size(); i++){
			PersonInfo info = addressBook2.get(i);
			System.out.println(info.getName() + "," + info.getTel());		
		}
		
		// 5. 중복제거
		
		  for(int i=0; i<MAX; i++){ //ver.3
		  addressBook2.add(addressBook2.get(i)); //중복데이터 생성
		   }
		   System.out.println(addressBook2.size());
		   
		   //Set을 이용하요 중복제거
		   Set<PersonInfo> set = new HashSet<PersonInfo>(addressBook2); 
		   //Set을 ArrayList로 변경
		   addressBook2 = new ArrayList(set);
		   System.out.println(addressBook2.size());
		   
		   
		   //6.삭제한다.
		   for(int i=0; i<MAX; i++){
		      addressBook[i] = null;
		   }
		   addressBook2.clear();
		
		
	}
}
