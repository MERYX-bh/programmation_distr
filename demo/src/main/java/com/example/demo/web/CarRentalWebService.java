package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CarRentalWebService {
    Logger logger = LoggerFactory.getLogger(CarRentalWebService.class);

    // ✅ Message de test
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, welcome to the Car Rental Service!";
    }

    // ✅ Récupérer le nombre total de locations (log uniquement)
    @GetMapping("/cars/rentalCount")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void getRentalCount() {
        logger.info("Rental count requested");
    }

    // ✅ Récupérer les détails d'une voiture spécifique
    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getCarDetails(@PathVariable("plateNumber") String plateNumber) {
        logger.info("Requested car details: " + plateNumber);
        return "{ \"plateNumber\": \"" + plateNumber + "\", \"brand\": \"Ferrari\", \"price\": 100 }";
    }

    // ✅ Louer une voiture
    @PutMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentCar(
        @PathVariable("plateNumber") String plateNumber,
        @RequestParam(value = "rent", required = true) boolean rent,
        @RequestBody(required = false) RentalPeriod rentalPeriod
    ) {
        if (rent) {
            logger.info("Car " + plateNumber + " rented from " + rentalPeriod.getBegin() + " t
