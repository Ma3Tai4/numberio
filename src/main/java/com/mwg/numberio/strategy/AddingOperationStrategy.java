package com.mwg.numberio.strategy;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AddingOperationStrategy implements OperationStrategy<Integer> {
    @Override
    public Integer perform(Integer... args) {
        return Stream.of(args).reduce(0, (i, j) -> i + j);
    }
}
