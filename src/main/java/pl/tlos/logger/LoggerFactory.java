package pl.tlos.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LoggerFactory {
	static Logger getLogger(JoinPoint point) {
		Class<?> clazz = point.getTarget().getClass();
		return Logger.getLogger(clazz);
	}
}
