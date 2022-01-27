package com.everest.airline.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FlightRowMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flight flight= new Flight(rs.getLong("number"), rs.getString("source"), rs.getString("destination"),rs.getTimestamp("departureDateTime").toLocalDateTime(), rs.getTimestamp("arrivalDateTime").toLocalDateTime(),rs.getInt("numberOfTotalSeats"));

            EconomicClassSeat economicClassSeat = new EconomicClassSeat(rs.getInt("totalNumberOfEconomicClassSeats"), rs.getInt("numberOfAvailableEconomicClassSeats"), rs.getInt("EconomicClassBasePrice"));
            FirstClassSeat firstClassSeat = new FirstClassSeat(rs.getInt("totalNumberOfFirstClassSeats"), rs.getInt("numberOfAvailableFirstClassSeats"), rs.getInt("FirstClassBasePrice"));
            SecondClassSeats secondClassSeats = new SecondClassSeats(rs.getInt("totalNumberOfSecondClassSeats"), rs.getInt("numberOfAvailableSecondClassSeats"), rs.getInt("SecondClassBasePrice"));
            Seats seats = new Seats(economicClassSeat, secondClassSeats, firstClassSeat);
            flight.setSeats(seats);

        return flight;
    }

    public Map<String,Object> mapObject(Flight flight){
        Map<String ,Object> params= new HashMap<String,Object>();
        params.put("number",flight.getNumber());
        params.put("source",flight.getSource());
        params.put("destination",flight.getDestination());
        params.put("departureDateTime",flight.getDepartureDateTime());
        params.put("arrivalDateTime",flight.getArrivalDateTime());
        params.put("numberOfTotalSeats",flight.getNumberOfTotalSeats());
        params.put("totalNumberOfEconomicClassSeats",flight.getSeats().getTotalNumberOfSeats("economicClass"));
        params.put("numberOfAvailableEconomicClassSeats",flight.getSeats().getNumberOfAvailableSeats("economicClass"));
        params.put("EconomicClassBasePrice",flight.getSeats().getBasePrice("economicClass"));
        params.put("totalNumberOfFirstClassSeats",flight.getSeats().getTotalNumberOfSeats("firstClass"));
        params.put("numberOfAvailableFirstClassSeats",flight.getSeats().getNumberOfAvailableSeats("firstClass"));
        params.put("FirstClassBasePrice",flight.getSeats().getBasePrice("firstClass"));
        params.put("totalNumberOfSecondClassSeats",flight.getSeats().getTotalNumberOfSeats("secondClass"));
        params.put("numberOfAvailableSecondClassSeats",flight.getSeats().getNumberOfAvailableSeats("secondClass"));
        params.put("SecondClassBasePrice",flight.getSeats().getBasePrice("secondClass"));
       return params;
    }
}
