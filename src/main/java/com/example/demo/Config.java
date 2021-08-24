package com.example.demo;

import com.example.demo.entities.Hospede;
import com.example.demo.entities.Hotel;
import com.example.demo.repositories.HospedeRepository;
import com.example.demo.repositories.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Config implements CommandLineRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Override
    public void run(String... args) throws Exception {
        Hotel h1 = new Hotel(null, "Hotelll", "1", 5);
        Hotel h2 = new Hotel(null, "Hotel", "2", 3);
        Hotel h3 = new Hotel(null, "Hotel 3", "4", 4);

        hotelRepository.save(h1);
        hotelRepository.save(h2);
        hotelRepository.save(h3);
    }
}
