package org.sversh.chat.service.impl;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.MapMaker;

/**
 * @author Sergey Vershinin
 *
 */
public class ProgressStorage {
	
	private static Object dummy = new Object();
	
	private static ConcurrentMap<String, Object> actives = new MapMaker().expiration(4, TimeUnit.SECONDS).makeMap();

	public static Set<String> getActive() {
		return actives.keySet();
	}

	public static void put(String sessionId) {
		actives.put(sessionId, dummy);
	}
	
}
