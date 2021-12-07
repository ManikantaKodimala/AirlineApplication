package com.everest.airline.DTO;

import com.everest.airline.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BookingDTO {
    @Autowired
    FlightDTO flightDTO;

    public void selectedFLight(List<Flight> searchData) throws IOException {
        searchData.stream().forEach(flight ->flight.setAvailableSeats());
        updateFlightData(searchData);
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
