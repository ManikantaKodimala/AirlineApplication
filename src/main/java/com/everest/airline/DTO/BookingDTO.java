package com.everest.airline.DTO;

import com.everest.airline.model.Flight;
import com.everest.airline.model.FlightRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookingDTO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void updateFlightData(Flight bookedFlight) {
        FlightRowMapper flightRowMapper= new FlightRowMapper();
        Map<String, Object> stringObjectMap = flightRowMapper.mapObject(bookedFlight);
        jdbcTemplate.update("UPDATE secondClassSeats SET totalNumberOfSecondClassSeats =:totalNumberOfSecondClassSeats , numberOfAvailableSecondClassSeats =:numberOfAvailableSecondClassSeats ,SecondClassBasePrice =:SecondClassBasePrice  where `number` =:number",stringObjectMap);
        jdbcTemplate.update("UPDATE economicClassSeats SET totalNumberOfEconomicClassSeats =:totalNumberOfEconomicClassSeats ,numberOfAvailableEconomicClassSeats =:numberOfAvailableEconomicClassSeats ,EconomicClassBasePrice =:EconomicClassBasePrice WHERE `number` =:number",stringObjectMap);
        jdbcTemplate.update("UPDATE firstClassSeats SET totalNumberOfFirstClassSeats =:totalNumberOfFirstClassSeats ,numberOfAvailableFirstClassSeats =:numberOfAvailableFirstClassSeats ,FirstClassBasePrice =:FirstClassBasePrice where `number` =:number",stringObjectMap);
    }


}
