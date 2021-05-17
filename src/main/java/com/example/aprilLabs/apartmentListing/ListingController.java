package com.example.aprilLabs.apartmentListing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/listings")
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping(path="/{id}")
    public List<Listing> getListing(@Valid @PathVariable Integer id){
        return listingService.getListing(id);
    }

    @PostMapping
    public void createListing(@RequestBody Listing listing){
        listingService.addNewListing(listing);
    }

    @DeleteMapping(path="{listingId}")
    public void deleteListing(@PathVariable("listingId") Integer listingId){
        listingService.deleteListing(listingId);
    }
}
