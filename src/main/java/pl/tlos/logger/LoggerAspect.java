package pl.tlos.logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	@Before("execution(* *(..)) && @annotation(pl.tlos.logger.Loggable)")
	public void logEntry(JoinPoint point) {
		Logger logger = LoggerFactory.getLogger(point);

		String methodName = point.getSignature().getName();
		Object[] args = point.getArgs();

		Class<?> className = point.getTarget().getClass();

		logger.warn("entry [" + methodName + "] args:" + Arrays.toString(args) + " class: " + className.getName());
	}

	@AfterReturning(pointcut = "execution(* *(..)) && @annotation(pl.tlos.logger.Loggable)", returning = "result")
	public void logExit(JoinPoint point, Object result) {
		Logger logger = LoggerFactory.getLogger(point);
		String methodName = point.getSignature().getName();

		logger.warn("exit [" + methodName + "] result->[" + result + "]");
	}

}
