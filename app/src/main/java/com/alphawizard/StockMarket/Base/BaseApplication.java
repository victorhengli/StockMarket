package com.alphawizard.StockMarket.Base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用程序的入口
 * Created by victor on 2018/3/16
 *
 */
public class BaseApplication extends Application {

	private static Context  context;         // 上下文环境

	private static Thread	mainThread;      // 主线程对象
	private static long		mainThreadId;    // 主线程线程Id
	private static Looper   mainLooper;      // 主线程轮询器
	private static Handler  mainHandler;     // 创建主线程的handler

	public List<Activity>   allActivies;     // 所有的Activity的集合

	/**
	 * 所有的前台Activity或者后台都会走这个方法,在应用程序入口提供全局的工具
	 */
	@Override
	public void onCreate() {
		super.onCreate();

		context = this;                             // 方式1
		//this.context = getApplicationContext();   // 方式2

		mainThread = Thread.currentThread();

		mainThreadId = android.os.Process.myTid(); // 方式1
		// mMainThreadId = mMainThread.getId();    // 方式2

		mainLooper = getMainLooper();

		mainHandler = new Handler();

		allActivies = new ArrayList<>();
	}

	public static Context getContext() {
		return context;
	}

	public static Thread getMainThread() {
		return mainThread;
	}

	public static long getMainThreadId() {
		return mainThreadId;
	}

	public static Looper getMainThreadLooper() {
		return mainLooper;
	}

	public static Handler getMainHandler() {
		return mainHandler;
	}

}
