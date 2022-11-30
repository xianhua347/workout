package com.example.workout.controller;

import com.example.workout.dto.ExerciseDto;
import com.example.workout.entity.Exercise;
import com.example.workout.exception.BizException;
import com.example.workout.result.AjaxResult;
import com.example.workout.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public AjaxResult save(@RequestBody ExerciseDto eventDto) {
        try {
            final Exercise event = exerciseService.save(eventDto);
            return AjaxResult.success(event);
        } catch (RuntimeException | ClassNotFoundException e) {
            return AjaxResult.error();
        }
    }

    @PostMapping("/all")
    public AjaxResult save(@RequestBody List<Exercise> exercises) {
        try {
            final List<Exercise> event = exerciseService.save(exercises);
            return AjaxResult.success(event);
        } catch (RuntimeException | ClassNotFoundException e) {
            return AjaxResult.error();
        }
    }

    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable String id) {
        try {
            exerciseService.delete(id);
            return AjaxResult.success();
        }catch (BizException exception){
            return AjaxResult.error(exception.getCode(),"操作错误");
        }
    }

    @DeleteMapping("/all")
    public AjaxResult delete() {
        return AjaxResult.success("删除成功");
    }

    @GetMapping("/{id}")
    public AjaxResult findById(@PathVariable String id) {
        try {
            return AjaxResult.success(exerciseService.find(id));
        }catch (BizException exception){
            return AjaxResult.error(exception.getMessage());
        }
    }


    @PutMapping("/{id}")
    public AjaxResult update(@PathVariable String id,ExerciseDto eventDto){
        final Boolean result = exerciseService.update(id, eventDto);
        return result ? AjaxResult.success() : AjaxResult.error();
    }
}
