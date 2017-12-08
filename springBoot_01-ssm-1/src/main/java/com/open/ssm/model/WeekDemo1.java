package com.open.ssm.model;


public class WeekDemo1 {
	/**
	 * 做什么事情
	 * */
	public void doWhat(int day){
		//使用条件判断
		if(day>7 || day<1){
			System.out.println("参数错误，应在1-7之间");
			return;
		}
		switch(day){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("工作日，努力写代码！");
				break;
			case 6:
				System.out.println("星期六，休息！看电影！");
				break;
			case 7:
				System.out.println("星期日，休息！看电影！");
				break;
			default:
				System.out.println("地球上的一个星期就7天");
		}
	}
	
	public static void main(String[] args){
		WeekDemo1 wd=new WeekDemo1();
		wd.doWhat(5);
		wd.doWhat(10);
		
		
		
	}
}
