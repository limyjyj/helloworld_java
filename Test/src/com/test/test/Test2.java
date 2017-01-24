package com.test.test;

class Singleton {
	private static Singleton single = new Singleton(); //static:인스턴스 생성안해도 되는것
	
	//private Singleton() {} //외부에서는 안됨
	
	public static Singleton getInstance(){ //한번 생성된 것을 재활용 
		return single;
	}
	public void hello(){
		
	}
}
class Singleton2 extends Singleton{
	
	@Override
	public void hello(){
		
	}
}

public class Test2 {


	public static void main(String[] args) {

//		Singleton single1 = new Singleton();
//		Singleton single2 = new Singleton();
		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		if(single1 == single2){
			System.out.println("Same");
		}

		
		/*
		 * private int arr[] = new int[10];
		public void setArr(int arr[]){	//XXXXXXXXXXXX안돼
			this.arr = arr;
		}
		public arr[] getArr(){
			return this.arr;
		}
		
		public void addElement(int value)
		public void modifyElement(int index)
		public int getElement(int index)
		public void removeElement(int index);
		*/
	}

}
