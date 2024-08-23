package riwi.aarfee.event_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import riwi.aarfee.event_manager.entities.Event;
import riwi.aarfee.event_manager.repositories.EventRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(UUID id) {
        return eventRepository.findById(id).orElse(null);
    }

    public boolean saveOrUpdateEvent(Event event) {
        Event theEvent = eventRepository.save(event);
        return eventRepository.existsById(theEvent.getId());
    }

    public boolean deleteEventById(UUID id) {
        eventRepository.deleteById(id);
        return eventRepository.existsById(id);
    }

}
