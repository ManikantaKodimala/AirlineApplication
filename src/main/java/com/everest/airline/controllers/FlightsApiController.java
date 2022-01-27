    package com.everest.airline.controllers;

    //import com.everest.airline.DTO.FileHandler;
    import com.everest.airline.model.Flight;
//    import com.everest.airline.repositories.IFlightRepository;
    import com.everest.airline.model.FlightRowMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
    import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
    import org.springframework.jdbc.core.namedparam.SqlParameterSource;
    import org.springframework.web.bind.annotation.*;

    import java.util.Map;

    @RestController
    public class FlightsApiController {
//        @Autowired
//        private IFlightRepository flightRepository;

        @Autowired
        private NamedParameterJdbcTemplate jdbcTemplate;

        @GetMapping("/flights")
        public Iterable<Flight> getAllFlights() {

                return jdbcTemplate.query("SELECT * from flight f inner join economicClassSeats ecs on f.`number` =ecs .`number` \n" +
                        "\t\t\t\t\t   inner join firstClassSeats fcs on f.`number` =fcs.`number` \n" +
                        "\t\t\t\t\t   inner join secondClassSeats scs on f.`number` =scs .`number`", new FlightRowMapper());
//            return flightRepository.findAll();
        }

        @GetMapping("/flight/{number}")
        public Flight getAFlight(@PathVariable("number") long number) {
            String sql = "SELECT * from flight f inner join economicClassSeats ecs on f.`number`=:number and f.`number` =ecs .`number` \n" +
                    "\t\t\t\t\t   inner join firstClassSeats fcs on f.`number` =fcs.`number` \n" +
                    "\t\t\t\t\t   inner join secondClassSeats scs on f.`number` =scs .`number`";

            SqlParameterSource param = new MapSqlParameterSource("number", number);
            return jdbcTemplate.queryForObject(sql, param, new FlightRowMapper());
        }

        @PostMapping("/flight")
        public long createAFlight(@RequestBody Flight flight) {
            FlightRowMapper flightRowMapper= new FlightRowMapper();
            Map<String, Object> stringObjectMap = flightRowMapper.mapObject(flight);
            jdbcTemplate.update("INSERT  into flight(number,source,destination,departureDateTime,arrivalDateTime,numberOfTotalSeats) values(:number,:source,:destination,:departureDateTime,:arrivalDateTime,:numberOfTotalSeats);",stringObjectMap);
            jdbcTemplate.update("INSERT into economicClassSeats(`number`,totalNumberOfEconomicClassSeats,numberOfAvailableEconomicClassSeats,EconomicClassBasePrice) values(:number,:totalNumberOfEconomicClassSeats,:numberOfAvailableEconomicClassSeats,:EconomicClassBasePrice)",stringObjectMap);
            jdbcTemplate.update("INSERT into firstClassSeats(`number`,totalNumberOfFirstClassSeats,numberOfAvailableFirstClassSeats,FirstClassBasePrice) values(:number,:totalNumberOfFirstClassSeats,:numberOfAvailableFirstClassSeats,:FirstClassBasePrice)",stringObjectMap);
            jdbcTemplate.update("insert into secondClassSeats (`number`,totalNumberOfSecondClassSeats,numberOfAvailableSecondClassSeats,SecondClassBasePrice) values(:number,:totalNumberOfSecondClassSeats,:numberOfAvailableSecondClassSeats,:SecondClassBasePrice)",stringObjectMap);
            return getAFlight(flight.getNumber()).getNumber();
        }

        @PutMapping("/flight/{number}")
        public int update(@RequestBody Flight flight)  {
            FlightRowMapper flightRowMapper= new FlightRowMapper();
            Map<String, Object> stringObjectMap = flightRowMapper.mapObject(flight);
            jdbcTemplate.update("UPDATE flight SET `number` = :number,arrivalDateTime =:arrivalDateTime,departureDateTime=:departureDateTime ,destination =:destination ,source =:source ,numberOfTotalSeats =:numberOfTotalSeats WHERE `number` =:number",stringObjectMap);
            jdbcTemplate.update("UPDATE economicClassSeats SET totalNumberOfEconomicClassSeats =:totalNumberOfEconomicClassSeats ,numberOfAvailableEconomicClassSeats =:numberOfAvailableEconomicClassSeats ,EconomicClassBasePrice =:EconomicClassBasePrice WHERE `number` =:number",stringObjectMap);
            jdbcTemplate.update("UPDATE firstClassSeats SET totalNumberOfFirstClassSeats =:totalNumberOfFirstClassSeats ,numberOfAvailableFirstClassSeats =:numberOfAvailableFirstClassSeats ,FirstClassBasePrice =:FirstClassBasePrice where `number` =:number",stringObjectMap);
            return jdbcTemplate.update("UPDATE secondClassSeats SET totalNumberOfSecondClassSeats =:totalNumberOfSecondClassSeats , numberOfAvailableSecondClassSeats =:numberOfAvailableSecondClassSeats ,SecondClassBasePrice =:SecondClassBasePrice  where `number` =:number",stringObjectMap);
        }
    //
        @DeleteMapping("/flight/{number}")
        public int deleteFlight(@PathVariable("number") long number){
            SqlParameterSource param = new MapSqlParameterSource("number", number);
            return jdbcTemplate.update("delete from flight where flight.`number`=:number",param);

        }

    }
