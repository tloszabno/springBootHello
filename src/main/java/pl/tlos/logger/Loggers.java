package pl.tlos.logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class Loggers {

	private static final Object[] EMPTY_ARRAY = new Object[] {};

	public static final void entry(Object... args) {
		StackTraceElement stackTraceElement = getCallerStacktraceElement();
		Logger logger = getLogger(stackTraceElement);
		String methodName = stackTraceElement.getMethodName();

		traceEntry(logger, methodName, args);
	}

	public static final void entry() {
		entry(EMPTY_ARRAY);
	}

	public static final void exit(Object result) {
		StackTraceElement stackTraceElement = getCallerStacktraceElement();
		Logger logger = getLogger(stackTraceElement);
		String methodName = stackTraceElement.getMethodName();

		traceExit(logger, methodName, result);
	}

	public static final void exit() {
		exit(null);
	}

	public static final Logger forThis() {
		try {
			return getLogger(getCallerStacktraceElement());
		} catch (Exception e) {
			return Logger.getRootLogger();
		}
	}

	static final Logger forAspect(JoinPoint point) {
		Class<?> clazz = point.getTarget().getClass();
		return Logger.getLogger(clazz);
	}

	static void traceEntry(Logger logger, String methodName, Object... args) {
		// FIXME: WARN -> trace
		if (logger.isWarnEnabled()) {
			logger.warn("entry [" + methodName + "] with args: " + Arrays.asList(args));
		}
	}

	static void traceExit(Logger logger, String methodName, Object result) {
		// FIXME: WARN -> trace
		if (logger.isWarnEnabled()) {
			logger.warn("exit [" + methodName + "] with result: [" + result + "]");
		}
	}

	private static Logger getLogger(StackTraceElement stackTraceElement) {
		String className = stackTraceElement.getClassName();
		Logger logger = Logger.getLogger(className);
		return logger;
	}

	private static StackTraceElement getCallerStacktraceElement() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		StackTraceElement stackTraceElement = stackTrace[3];
		return stackTraceElement;
	}

}
