package services;

import exceptions.InvalidGateException;
import models.Gate;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;

    public TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber, VehicleType vehicleType) throws InvalidGateException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gate Id");
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());

        //TODO
        // Create a Vehicle Repository and check if the vehicle is present in the DB or not.
        // If Vehicle is present then get the vehicle else create the vehicle in DB and save.

        return null;
    }

}
