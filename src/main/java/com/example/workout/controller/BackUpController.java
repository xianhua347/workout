package com.example.workout.controller;

import com.example.workout.entity.BackUp;
import com.example.workout.service.BackUpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/backUp")
public class BackUpController {

    private final BackUpService backUpService;

    public BackUpController(BackUpService backUpService) {
        this.backUpService = backUpService;
    }

    public BackUp backUpdate(String id){
        return backUpService.backUpdate(id).get();
    }
}
