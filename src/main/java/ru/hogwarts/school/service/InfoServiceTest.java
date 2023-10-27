package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!production")
public class InfoServiceTest implements InfoServiceInt {
    private final Logger logger = LoggerFactory.getLogger(InfoServiceTest.class);




    @Override
    public int getPort() {
        logger.debug("Found test port");
        return 8081;
    }

}
