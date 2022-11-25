package com.example.workout.controller;

import com.example.workout.dto.EventDto;
import com.example.workout.entity.Event;
import com.example.workout.result.AjaxResult;
import com.example.workout.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public AjaxResult save(@RequestBody EventDto eventDto) {
        try {
            final Event event = eventService.save(eventDto);
            return AjaxResult.success(event);
        } catch (RuntimeException e) {
            return AjaxResult.error();
        }
    }

    @PostMapping("/all")
    public AjaxResult save(@RequestBody List<EventDto> eventDtos) {
        try {
            final List<Event> event = eventService.save(eventDtos);
            return AjaxResult.success(event);
        } catch (RuntimeException e) {
            return AjaxResult.error();
        }
    }

    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable String id) {
        return eventService.deleteById(id) ? AjaxResult.success("删除成功") : AjaxResult.error();
    }

    @DeleteMapping("/all")
    public AjaxResult delete() {
        return AjaxResult.success("删除成功");
    }

    @GetMapping("/{id}")
    public AjaxResult findById(@PathVariable String id) {
        return eventService.findById(id).equals(null) ? AjaxResult.error("查找失败") : AjaxResult.success("查找成功", eventService.findById(id));
    }

    @GetMapping("/all")
    public AjaxResult findAllEvent(){
        return eventService.findAll().equals(null) ? AjaxResult.error("查找失败") : AjaxResult.success("查找成功", eventService.findAll());
    }

    @PutMapping("/{id}")
    public AjaxResult update(@PathVariable String id,EventDto eventDto){
        final Boolean result = eventService.update(id, eventDto);
        return result ? AjaxResult.success() : AjaxResult.error();
    }

}
