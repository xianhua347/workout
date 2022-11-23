package com.example.workout.controller;

import com.example.workout.entity.WorkOut;
import com.example.workout.result.AjaxResult;
import com.example.workout.service.WorkOutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workout")
public class WorkOutController {
    private final WorkOutService workOutService;

    public WorkOutController(WorkOutService workOutService) {
        this.workOutService = workOutService;
    }

    @GetMapping("/{id}")
    public AjaxResult findById(@PathVariable String id){
        final Optional<WorkOut> byId = workOutService.findById(id);
        return AjaxResult.success(byId);
    }

    @GetMapping
    public AjaxResult findAll(){
        return workOutService.findAllWorkOut().isEmpty() ?
                AjaxResult.error("数据库查不到数据") :
                AjaxResult.success(workOutService.findAllWorkOut());
    }

    @PostMapping()
    public AjaxResult save(@RequestBody WorkOut workOut){
        final WorkOut result = workOutService.save(workOut);
        return AjaxResult.success(result);
    }

    @PostMapping("/all")
    public AjaxResult saveAll(@RequestBody List<WorkOut> workOuts){
        final List<WorkOut> result = workOutService.save(workOuts);
        return AjaxResult.success("添加成功", result);
    }

    @DeleteMapping
    public AjaxResult delete(@RequestBody WorkOut workOut){
        workOutService.delete(workOut);
        return AjaxResult.success();
    }

    @DeleteMapping("delall")
    public AjaxResult delete(){
        workOutService.deleteAll();
        return AjaxResult.success();
    }
}
