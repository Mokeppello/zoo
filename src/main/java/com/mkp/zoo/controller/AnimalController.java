package com.mkp.zoo.controller;

import com.mkp.zoo.entity.Animal;
import com.mkp.zoo.services.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("animal")
@CrossOrigin
public class AnimalController {
    @Autowired
    private AnimalService animalService;


    @PostMapping("")
    private ResponseEntity<Object> createAnimal(@Valid @RequestBody Animal animalNew) {


        Animal animal = animalService.createAnimal(animalNew);

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @GetMapping("")
    private ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animalList = animalService.getAllAnimals();

        return new ResponseEntity<>(animalList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Animal> getAnimalById(@PathVariable("id") String id) {
        Animal animal = animalService.getAnimalById(Long.parseLong(id));

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    private ResponseEntity<Object> updateAnimal(@PathVariable("id") String id, @Valid @RequestBody Animal animal) {


        animalService.updateAnimal(Long.parseLong(id), animal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Animal> deleteAnimal(@PathVariable("id") String id) {
        animalService.deleteAnimal(Long.parseLong(id));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
