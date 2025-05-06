package dev.kulick.startproject.aspect;

import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import dev.kulick.startproject.config.ApiConfigProperties;
import dev.kulick.startproject.exception.ApiRateLimitExceededException;
import dev.kulick.startproject.service.ApiInvocationCounterService;

@Aspect
@Component
public class RateLimitAspect {

    private final ApiInvocationCounterService counterService;
    private final ApiConfigProperties config;

    public RateLimitAspect(ApiInvocationCounterService counterService,
            ApiConfigProperties config) {
        this.counterService = counterService;
        this.config = config;
    }

    @Around("@annotation(dev.kulick.startproject.aspect.CountedApi)")
    public Object aroundCountedApi(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodKey = signature.getDeclaringTypeName() + signature.getMethod().getName();

        int current = counterService.incrementAndGet(methodKey);
        if (current > config.getMaxRequests()) {
            throw new ApiRateLimitExceededException(String.valueOf(config.getMaxRequests()));
        }

        return pjp.proceed();
    }
}
