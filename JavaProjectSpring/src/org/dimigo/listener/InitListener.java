package org.dimigo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import nettyInActionWebSocket.ChatServer;

/**
 * <pre>
 * org.dimigo.listener
 * 	 |_ InitListener
 *
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 27.
 * <pre>
 *
 * @author : 박명규(로컬계정)
 * @version : 1.0
 */
public class InitListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent ctx) {
	}

	@Override
	public void contextInitialized(ServletContextEvent ctx) {
		startWebSocketServer();
		
	}

	private void startWebSocketServer() {
		final Thread thread = new Thread(() -> {ChatServer.main(new String[]{"9000"});});
		thread.start();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			thread.interrupt();
		}));
	}


}
