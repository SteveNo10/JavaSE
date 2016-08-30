package com.ifnoelse.linux.server;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloWorld {
	
	private static Logger log = Logger.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		try {
			// log4j.properties变量的值在脚本bin/run.sh 中读取
			String config = System.getProperty("log4j.properties");
			if (config != null) {
				PropertyConfigurator.configure(config);
			}
			log.info("HelloWorld");

			Thread thread = new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep(5 * 1000);
							log.info("每隔5秒打印一下日志");
						} catch (InterruptedException e) {
							e.printStackTrace();
							log.error(e.getMessage());
						}
					}
				}
			};
			thread.run();
		} catch (Exception e) {
			log.error("[X]启动失败:" + e.getMessage());
			System.exit(1);
		}
	}

}
