package com.everest.airline.DTO;

import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FlightDTO {
    public List<Flight> getFlights(String source, String destination) throws IOException {
        List<Flight>  flightsList=new ArrayList<>();
            Stream<String> lines = Files.lines(Path.of("/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/data.txt"));
            lines.filter(flightData ->{
                        List<String> flightDataList= List.of(flightData.split("[,]", 0));
                        return flightDataList.get(1).equals(source) && flightDataList.get(2).equals(destination);
            }).forEach(flightData -> {
                    Flight flight= null;
                try {
                    flight = getAFlight(flightData);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                flightsList.add(flight);
                });
        return flightsList;
    }

    private Flight getAFlight(String flightData) throws ParseException {
        List<String> flightDataList= List.of(flightData.split("[,]", 0));
        Calendar departureDateTime= getDateAndTime(flightDataList.get(3));
        Calendar arrivalDateTime= getDateAndTime(flightDataList.get(4));
        return new Flight(Integer.parseInt(flightDataList.get(0)),flightDataList.get(1),flightDataList.get(2),departureDateTime,arrivalDateTime,Integer.parseInt(flightDataList.get(5)),Integer.parseInt(flightDataList.get(6)));
    }

    private Calendar getDateAndTime(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(s);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public void updateFlightData(List<Flight> searchData) throws IOException {
        searchData.stream().forEach(flight-> {
            try {
                updateFile(flight);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
       ;
    }

    private void updateFile(Flight flight) throws IOException {
        Stream<String> lines = Files.lines(Path.of("/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/data.txt"));
        List<String> updatedData = lines.map(
                (line) -> {
                    if(line.startsWith(String.valueOf(flight.getNumber())))
                    {
                        line = flight.getFlightDetails();
                    }
                    return line;
                }).collect(Collectors.toList());
        Files.write(Path.of("/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/data.txt"),updatedData);
        lines.close();
        System.out.println("updated in file for"+flight.getNumber());
    }
}
