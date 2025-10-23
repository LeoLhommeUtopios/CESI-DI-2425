package org.example.Service;

import org.example.Util.EventFullException;
import org.example.Util.PlaceTYpe;
import org.example.model.Billet;
import org.example.model.Customer;
import org.example.model.Event;

import java.util.List;

public class BilletService {

    private EventService eventService;
    private CustomerService customerService;

    public BilletService(EventService eventService, CustomerService customerService) {
        this.eventService = eventService;
        this.customerService = customerService;
    }

    public Billet addBillet (int idCustomer, int idEvent, PlaceTYpe placeTYpe){
        eventService.eventStillHavePlace(idEvent);

        Customer customer = customerService.getById(idCustomer);
        Event event = eventService.getById(idEvent);

        Billet billet = new Billet(event.getBillets().size()+1,customer,event,placeTYpe);

        event.addBillet(billet);
        customer.addBillet(billet);

        return billet;
    }

    public List<Billet> getCustomerBillet (int idCustomer){
        return customerService.getById(idCustomer).getBillets();
    }
    public List<Billet> getEventBillet (int idEvent){
        return eventService.getById(idEvent).getBillets();
    }

}
