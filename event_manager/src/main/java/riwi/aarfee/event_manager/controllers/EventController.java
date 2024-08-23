package riwi.aarfee.event_manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import riwi.aarfee.event_manager.entities.Event;
import riwi.aarfee.event_manager.services.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping
    public Event getEventById(@RequestBody UUID id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public boolean saveOrUpdateEvent(@RequestBody Event event) {
        return eventService.saveOrUpdateEvent(event);
    }

    @DeleteMapping
    public boolean deleteEventById(@RequestBody UUID id) {
        return eventService.deleteEventById(id);
    }
}
