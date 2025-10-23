package org.example.Service;

import org.example.Util.EventFullException;
import org.example.Util.NotFoundException;
import org.example.model.Address;
import org.example.model.Customer;
import org.example.model.Event;
import org.example.model.Place;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    private List<Event> events;

    public EventService() {
        events = new ArrayList<>();
    }

    public void addEvent(String eventName, Place place, LocalDateTime dateTime,int numberOfPlace){
        events.add(new Event(eventName,place,dateTime,numberOfPlace));
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public List<Event> getAllEvent (){
        return events;
    }

    public boolean deleteEvent (int index){
        try{
            events.remove(index);
            return true;
        }catch (IndexOutOfBoundsException ex){
            throw new NotFoundException("CustomerNotFound");
        }
    }

    public Event getById (int index){
        try{
            return events.get(index);
        }catch (IndexOutOfBoundsException ex){
            throw new NotFoundException("CustomerNotFound");
        }
    }

    public Event update (int index, String eventName, Place place, LocalDateTime dateTime,int numberOfPlace){
        try{
            Event eventfound = events.get(index);
            eventfound.setEventName(eventName);
            eventfound.setPlace(place);
            eventfound.setDateTime(dateTime);
            eventfound.setNumberOfPlace(numberOfPlace);
            return eventfound;
        }catch (IndexOutOfBoundsException ex){
            throw new NotFoundException("CustomerNotFound");
        }
    }

    public boolean eventStillHavePlace (int index){
        Event event = getById(index);
        if (event.getNumberOfPlace()<= event.getBillets().size()){
            throw new EventFullException("event is full");
        }
        return true;
    }
}
