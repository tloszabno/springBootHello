package pl.tlos.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private static final String LOGGABLE_POINTCUT = "execution(* *(..)) && @annotation(" + Loggable.LOGGABLE_ANNOTATION
			+ ")";

	@Before(LOGGABLE_POINTCUT)
	public void logEntry(JoinPoint point) {
		Logger logger = Loggers.forAspect(point);

		String methodName = point.getSignature().getName();
		Object[] args = point.getArgs();

		Loggers.traceEntry(logger, methodName, args);
	}

	@AfterReturning(pointcut = LOGGABLE_POINTCUT, returning = "result")
	public void logExit(JoinPoint point, Object result) {
		Logger logger = Loggers.forAspect(point);
		String methodName = point.getSignature().getName();

		Loggers.traceExit(logger, methodName, result);
	}
}
