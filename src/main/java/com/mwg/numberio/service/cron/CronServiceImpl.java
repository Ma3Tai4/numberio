package com.mwg.numberio.service.cron;

import com.mwg.numberio.service.source.NumberSourceService;
import com.mwg.numberio.strategy.OperationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Configuration
@EnableScheduling
@Service
public class CronServiceImpl implements CronService {

    @Autowired
    @Qualifier("apiSource")
    private NumberSourceService<Integer> apiSource;
    @Autowired
    @Qualifier("simpleSource")
    private NumberSourceService<Integer> simpleSource;
    @Autowired
    @Qualifier("dbSource")
    private NumberSourceService<Integer> dbSource;

    @Autowired
    private OperationStrategy<Integer> strategy;

    @Scheduled(fixedRate = 2000)
    @Override
    public void performOperation() {
        Integer result = strategy.perform(
                simpleSource.getNumber(),
                apiSource.getNumber(),
                dbSource.getNumber());
        System.out.println("Addition result: " + result);
    }
}
