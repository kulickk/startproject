package dev.kulick.startproject.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ApiInvocationCounterService {

    private final ConcurrentMap<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();

    public int incrementAndGet(String key) {
        return counterMap
                .computeIfAbsent(key, k -> new AtomicInteger(0))
                .incrementAndGet();
    }

    public int get(String key) {
        AtomicInteger counter = counterMap.get(key);
        return (counter == null) ? 0 : counter.get();
    }
}