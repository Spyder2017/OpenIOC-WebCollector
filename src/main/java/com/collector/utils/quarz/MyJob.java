package com.collector.utils.quarz;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.collector.main.Main;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public class MyJob implements Job{
	private static int count =0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		//执行定时器任务

		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		System.out.println(arg0.getJobDetail().getKey().getName()+"\t"+Calendar.getInstance());

		count++;
		new Main().process();
		System.out.println("时间="+new Date()+"执行了"+count+"次");
	}

}
