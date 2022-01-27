package com.everest.airline.DTO;

import com.everest.airline.model.Flight;
import com.everest.airline.model.FlightRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class FlightDTO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Flight> getFlights(String from, String to, String departureDate, String classType, int numberOfTickets) {
        Map<String ,Object> params= new HashMap<String,Object>();
        params.put("source",from);
        params.put("destination",to);
        params.put("departureDateTime", departureDate);
        params.put("numberOfTickets",numberOfTickets);
        System.out.println("nnumber of tickeys"+params.get("numberOfTickets"));
        return jdbcTemplate.query("SELECT * from flight f join economicClassSeats ecs on  f.source =:source and f.destination =:destination and f.`number` =ecs .`number` and DATE(f.departureDateTime)=:departureDateTime and ecs.numberOfAvailableEconomicClassSeats>=:numberOfTickets\n" +
                "\t\t\t\t\t    join firstClassSeats fcs on f.`number` =fcs.`number` and fcs.numberOfAvailableFirstClassSeats>=:numberOfTickets \n" +
                "\t\t\t\t\t    join secondClassSeats scs on f.`number` =scs .`number` and scs.numberOfAvailableSecondClassSeats>=:numberOfTickets ", params,new FlightRowMapper());
    }

    public Flight getFlightByNumber(int number) {
        Map<String ,Object> params= new HashMap<String,Object>();
        params.put("number",number);
        return jdbcTemplate.queryForObject("SELECT * from flight f inner join economicClassSeats ecs on f.`number` =:number and f.`number` =ecs .`number`\n" +
                "\t\t\t\t\t   inner join firstClassSeats fcs on f.`number` =fcs.`number`\n" +
                "\t\t\t\t\t   inner join secondClassSeats scs on f.`number` =scs .`number`", params,new FlightRowMapper());
    }

    public void upDateSeats(Flight bookedFlight, String selectedClassType, int noOfTickets) {
        bookedFlight.getSeats().upDateSeats(selectedClassType,noOfTickets);
    }
}
