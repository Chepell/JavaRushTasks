package com.javarush.task.task25.task2509;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

// интерфейс в котором два метода для реализациии
public interface CancellableTask<T> extends Callable<T> {
    void cancel();

    RunnableFuture<T> newTask();
}