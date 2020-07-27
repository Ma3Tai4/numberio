package com.mwg.numberio.service.source.impl;


import com.mwg.numberio.entity.IntegerNumber;
import com.mwg.numberio.repository.IntegerNumberRepository;
import com.mwg.numberio.service.source.NumberSourceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("dbSource")
public class DbSourceService implements NumberSourceService<Integer> {

    private IntegerNumberRepository repository;
    private Random random;

    public DbSourceService(IntegerNumberRepository repository) {
        this.repository = repository;
        random = new Random();
    }

    @Override
    public Integer getNumber() {
        final List<IntegerNumber> list = repository.findAll();
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.get(random.nextInt(list.size())).getValue();
        }
    }
}
