package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.service.InfoService;
import ru.hogwarts.school.service.InfoServiceInt;

@RestController
public class InfoController {
    private final InfoServiceInt infoServiceInt;


    public InfoController(InfoServiceInt infoServiceInt) {
        this.infoServiceInt = infoServiceInt;
    }

    @GetMapping("/port")
    public int getPort() {
        return infoServiceInt.getPort();
    }
}
