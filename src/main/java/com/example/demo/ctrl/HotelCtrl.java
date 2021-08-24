package com.example.demo.ctrl;

import java.util.List;

import com.example.demo.business.HotelBusiness;
import com.example.demo.entities.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hotel")
public class HotelCtrl {

    @Autowired
    HotelBusiness business;

    @GetMapping
    public ResponseEntity<List<Hotel>> findAll() {
        List<Hotel> list = business.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Integer id) {
        Hotel hotel = business.findById(id);
        return ResponseEntity.ok(hotel);
    }

    @PostMapping
    public ResponseEntity<Hotel> insert(@RequestBody Hotel h) {
        Hotel insertedHotel = this.business.insert(h);
        return ResponseEntity.status(201).body(insertedHotel);
    }

    @PutMapping
    public ResponseEntity<Hotel> update(@RequestBody Hotel h) {
        Hotel updatedHotel = this.business.insert(h);
        return ResponseEntity.status(201).body(updatedHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.business.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
