package com.mwg.numberio.service.source.impl;

import com.mwg.numberio.service.source.NumberSourceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("simpleSource")
public class SimpleSourceService implements NumberSourceService<Integer> {

    @Value("#{new Integer('${java.random.max}')}")
    private Integer max;
    private Random random;

    public SimpleSourceService() {
        this.random = new Random();
    }

    @Override
    public Integer getNumber() {
        return random.nextInt(max);
    }
}
