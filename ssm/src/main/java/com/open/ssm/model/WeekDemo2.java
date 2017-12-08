package com.open.ssm.model;
	/**
	 * 枚举常量的定义和使用
	 * */
	public class WeekDemo2 {
		/**
		 * 做什么事情
		 * */
		public void doWhat(Week day){
			//使用枚举
			switch(day){
				case MON:
				case TUE:
				case WED:
				case THU:
				case FRI:
					System.out.println("工作日，努力写代码！");
					break;
				case SAT:
					System.out.println("星期六，休息！看电影！");
					break;
				case SUN:
					System.out.println("星期日，休息！看电影！");
					break;
				default:
					System.out.println("地球上的一个星期就7天");
			}
		}
		
		public static void main(String[] args){
			WeekDemo2 wd=new WeekDemo2();
			wd.doWhat(Week.MON);
		}
	}
