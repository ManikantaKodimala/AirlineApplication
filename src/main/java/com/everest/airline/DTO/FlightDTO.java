package com.everest.airline.DTO;

import com.everest.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

@Component
public class FlightDTO {

    public List<Flight> getFlights(String source, String destination) {
        List<Flight> flightsList = new ArrayList<>();
        String path = "/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/flightsdata";
        File folder = new File(path);
        List<File> listOfFilesInDirectory = List.of(folder.listFiles());
        listOfFilesInDirectory.stream().forEach(file -> {
            Stream<String> lines = null;
            try {
                lines = Files.lines(Path.of(path + "/" + file.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<Flight> flights = readFlightsData(lines, source, destination);
            flights.forEach(flight -> flightsList.add(flight));
        });
        return flightsList;
    }

    private List<Flight> readFlightsData(Stream<String> lines, String source, String destination) {
        List<Flight> flightsList = new ArrayList<>();
        lines.filter(flightData -> {
            List<String> flightDataList = List.of(flightData.split("[,]", 0));
            return flightDataList.get(1).equals(source) && flightDataList.get(2).equals(destination);
        }).forEach(flightData -> {
            Flight flight = null;
            try {
                flight = getFlightInstance(flightData);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            flightsList.add(flight);
        });
        return flightsList;
    }

    public Flight getFlightInstance(String flightData) throws ParseException {
        List<String> flightDataList = List.of(flightData.split("[,]", 0));
        Calendar departureDateTime = getDateAndTime(flightDataList.get(3));
        Calendar arrivalDateTime = getDateAndTime(flightDataList.get(4));
        int businessClassSeats = Integer.parseInt(flightDataList.get(7));
        int firstClassSeats = Integer.parseInt(flightDataList.get(8));
        int secondClassSeats = Integer.parseInt(flightDataList.get(9));
        int economicClassSeats = Integer.parseInt(flightDataList.get(10));
        return new Flight(Integer.parseInt(flightDataList.get(0)), flightDataList.get(1), flightDataList.get(2), departureDateTime, arrivalDateTime, Integer.parseInt(flightDataList.get(5)), Integer.parseInt(flightDataList.get(6)), businessClassSeats, firstClassSeats, secondClassSeats, economicClassSeats);
    }

    public Calendar getDateAndTime(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date date = formatter.parse(s);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public String getFlightDetails(Flight flight) {
        StringBuilder sb = new StringBuilder();
        sb.append(flight.getNumber() + ",");
        sb.append(flight.getSource() + ",");
        sb.append(flight.getDestination() + ",");
        sb.append(flight.getDepartureDate() + " " + flight.getDepartureTime() + ",");
        sb.append(flight.getArrivalDate() + " " + flight.getArrivalTime() + ",");
        sb.append(flight.getNumberOfTotalSeats() + ",");
        sb.append(flight.getAvailableSeats() + ",");
        sb.append(flight.getAvailableBusinessClassSeats() + ",");
        sb.append(flight.getAvailableFirstClassSeats() + ",");
        sb.append(flight.getAvailableSecondClassSeats() + ",");
        sb.append(flight.getAvailableEconomicClassSeats());
        return sb.toString();
    }

    public void upDateSeats(Flight flight, String selectedClassType, int numberOfPassengers) {
        switch (selectedClassType) {
            case "businessClass":
                flight.upDateBusinessClassSeats(numberOfPassengers);
                break;
            case "firstClass":
                flight.upDateFirstClassSeats(numberOfPassengers);
                break;
            case "secondClass":
                flight.upDateSecondClassSeats(numberOfPassengers);
                break;
            case "economicClass":
                flight.upDateEconomicClassSeats(numberOfPassengers);
                break;
        }
    }

    public int getCostOfSeat(String classType, Flight flight) {
        switch (classType) {
            case "businessClass":
                return flight.getBusinessClassTicketCost();

            case "firstClass":
                return flight.getFirstClassTicketCost();

            case "secondClass":
                return flight.getSecondClassTicketCost();

            case "economicClass":
                return flight.getEconomicClassTicketCost();
            default:
                return 0;
        }
    }
}
