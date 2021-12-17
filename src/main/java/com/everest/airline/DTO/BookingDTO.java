package com.everest.airline.DTO;

import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingDTO {

    @Autowired
    public FlightDTO flightDTO;

    public void updateFlightData(Flight searchData) throws IOException {
            try {
                updateFile(searchData);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void updateFile(Flight flight) throws IOException {
        String path = "/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/flightsdata/"+flight.getNumber()+".txt";
        Path filePath = Path.of(path);
        Files.write(filePath, List.of(flightDTO.getFlightDetails(flight)));
    }

    public Flight getFlight(int flightNum) throws IOException, ParseException {
        String path = "/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/flightsdata/"+flightNum+".txt";
        Path filePath = Path.of(path);
        List<String> lines = Files.readAllLines(filePath);;
        Flight flightInstance=flightDTO.getFlightInstance(lines.get(0));
        return flightInstance;
    }
}
