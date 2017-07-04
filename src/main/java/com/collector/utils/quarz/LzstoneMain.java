package com.collector.utils.quarz;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class LzstoneMain {
	private static  Scheduler scheduler;

	public static void run(){
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group").build();
			Calendar calendar = Calendar.getInstance();

	        int year = calendar.get(Calendar.YEAR);
	        int month = calendar.get(Calendar.MONTH);
	        int day = calendar.get(Calendar.DAY_OF_MONTH);
	        //定制每天的 23:00:00 执行

	        calendar.set(year, month, day,15,27,00);
	        Date date = calendar.getTime();
	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group").startAt(date).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(24).repeatForever().repeatForever()).build();
	        try {
				scheduler = new StdSchedulerFactory().getScheduler();
				scheduler.scheduleJob(jobDetail, trigger);
			    scheduler.start();
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public static void stop(){
		try {
			scheduler.shutdown(true);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String [] args){
		LzstoneMain.run();
	}
}
