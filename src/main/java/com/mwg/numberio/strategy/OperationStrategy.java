package com.mwg.numberio.strategy;

public interface OperationStrategy<T> {
    T perform(T... args);
}
