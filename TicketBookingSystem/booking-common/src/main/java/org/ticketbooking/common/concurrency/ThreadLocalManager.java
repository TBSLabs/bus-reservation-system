package org.ticketbooking.common.concurrency;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

@SuppressWarnings("rawtypes") 
public class ThreadLocalManager {
	private static final Logger LOGGER = Logger.getLogger(ThreadLocalManager.class);
	
	Map<Long, ThreadLocal> threadLocals = new LinkedHashMap<Long, ThreadLocal>();
	private static final Object THREAD_LOCK = new Object();
	private static Long COUNT=0L;
	private static final ThreadLocal<ThreadLocalManager> THREAD_LOCAL_MANAGER = new ThreadLocal<ThreadLocalManager>(){
		protected ThreadLocalManager initialValue() {
			ThreadLocalManager localManager = new ThreadLocalManager();
			return localManager;
		};
	};
	
	public static void addThreadLocal(ThreadLocal threadLocal){
		Long position;
		synchronized (THREAD_LOCK) {
			++COUNT;
			position=COUNT;
		}
		THREAD_LOCAL_MANAGER.get().threadLocals.put(position, threadLocal);
	}
	
	public static <T> ThreadLocal<T> createThreadLocal(final Class<T> type){
		ThreadLocal<T> threadLocal = new ThreadLocal<T>(){
			protected T initialValue() {
				try {
					return type.newInstance();
				} catch (InstantiationException e) {
					LOGGER.error(e);
				} catch (IllegalAccessException e) {
					LOGGER.error(e);
				}
				return null;
			};
			public void set(T value) {
				super.set(value);
			};
		};
		return threadLocal;
	}
	
	public static void remove(){
		for (Entry<Long, ThreadLocal> entry: THREAD_LOCAL_MANAGER.get().threadLocals.entrySet()) {
			entry.getValue().remove();
		}
		THREAD_LOCAL_MANAGER.get().threadLocals.clear();
		THREAD_LOCAL_MANAGER.remove();
	}
	
}
