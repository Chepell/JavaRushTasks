package com.javarush.task.task29.task2908;

import java.util.concurrent.*;

/* Argument and Value are generic types*/
public class CacheComputeManager<Argument, Value> implements Computable<Argument, Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Computable<Argument, Value> computable;

    public CacheComputeManager(Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg);
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHaveToComputeValue(arg);
            cache.putIfAbsent(arg, ft);
            f = ft;
            ft.run();
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }

    public FutureTask<Value> createFutureTaskForNewArgumentThatHaveToComputeValue(final Argument arg) {
        FutureTask<Value> valueFutureTask = new FutureTask<>(new Callable<Value>() {
            @Override
            public Value call() throws Exception {
                return computable.compute(arg);
            }
        });
        return valueFutureTask;
    }
}

// Кеширование
//В CacheComputeManager реализуй логику пустого метода.
//Догадайся, что он должен делать по названию метода и по логике класса.
//
//
//Требования:
//1. Метод createFutureTaskForNewArgumentThatHaveToComputeValue должен создавать и возвращать объект типа FutureTask.
//2. В методе createFutureTaskForNewArgumentThatHaveToComputeValue должен
// создаваться объект анонимного класса, реализующего интерфейс Callable.
//3. Внутри метода createFutureTaskForNewArgumentThatHaveToComputeValue должна
// встречаться строка "return computable.compute(arg);".
//4. Программа должна выводить текст указанный в комментариях в классе Solution.
