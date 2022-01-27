//package com.everest.airline.DTO;
//
//import com.everest.airline.model.Flight;
//import com.everest.airline.model.SortFlights;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.text.ParseException;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Component
//public class FileHandler {
//
//    @Autowired
//    private FlightDTO flightDTO;
//
//    private final String path = "/Users/kodimalamanikanta/IdeaProjects/airlines/src/main/java/com/everest/airline/database/flightsdata";
//    public List<Flight> readDataFromFolder() {
//        List<Flight> flightsList = new ArrayList<>();
//        File folder = new File(path);
//        List<File> listOfFilesInDirectory = List.of(folder.listFiles());
//        for (File file : listOfFilesInDirectory) {
//            Stream<String> lines;
//            try {
//                lines = Files.lines(Path.of(path + "/" + file.getName()));
//                lines.map(line -> {
//                    try {
//                        flightsList.add(flightDTO.getFlightInstance(line));
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                    return line;
//                }).collect(Collectors.toList());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        flightsList.sort(new SortFlights());
//        return flightsList;
//    }
//
//    public Flight readFlight(long number) {
//        List<Flight> flightList = readDataFromFolder();
//        try {
//            for (Flight flight : flightList) {
//                if (flight.getNumber() == number)
//                    return flight;
//            }
//            throw new Exception();
//        } catch (Exception e) {
//            System.out.println("No flights with given flight number.");
//        }
//        return null;
//    }
//
//    public long readLastFlight(Flight flight) throws ParseException, IOException {
//        List<Flight> flights=readDataFromFolder();
//        long number=flights.get(flights.size()-1).getNumber()+1;
//        writeFileInFolder(flight,number);
//        return number;
//    }
//
//    public Flight updateFlight(Flight flight) throws IOException, ParseException {
//        writeFileInFolder(flight,flight.getNumber());
//        return readFlight(flight.getNumber());
//    }
//
//    private void writeFileInFolder(Flight newFlight,long number) throws IOException, ParseException {
//        File file=new File(path);
//        file.createNewFile();
//        Files.writeString(Path.of(path + "/" + Long.parseLong(String.valueOf(number)) + ".txt"),flightDTO.getFlightDetails(newFlight));
//    }
//
//    public boolean deleteFlight(long number) {
//        File folder=new File(path);
//        for (File fileEntry : folder.listFiles()) {
//            if (fileEntry.getName().equalsIgnoreCase(number + ".txt")) {
//                return fileEntry.delete();
//            }
//        }
//        return false;
//    }
//}
