package pl.tlos.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class Loggers {
	static final Logger forAspect(JoinPoint point) {
		Class<?> clazz = point.getTarget().getClass();
		return Logger.getLogger(clazz);
	}

	public static final Logger forThis() {
		try {
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			StackTraceElement stackTraceElement = stackTrace[2];
			String className = stackTraceElement.getClassName();
			return Logger.getLogger(className);
		} catch (Exception e) {
			return Logger.getRootLogger();
		}
	}
}
