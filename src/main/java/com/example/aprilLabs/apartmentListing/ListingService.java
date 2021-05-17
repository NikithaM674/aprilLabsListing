package com.example.aprilLabs.apartmentListing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    @Autowired
    public ListingService(ListingRepository listingRepository){
        this.listingRepository=listingRepository;
    }


    /***The listings are returned as lists of listings.***/
    public List<Listing> getListing(Integer id){
        return listingRepository.findById(id);
    }

    public void addNewListing(Listing listing) {

        /**The listing is added into the db by checking if there already exists an address in the db.**/
        Optional<Listing> listingOptional = listingRepository.findListingByAddress(listing.getAddress());
        /**If the address already exists, then throw an exception stating that the address is already listed.**/
        if(listingOptional.isPresent()){
            throw new IllegalStateException("Address already listed");
        }
        /**Otherwise, save the address listing in the db.**/
        listingRepository.save(listing); 
    }

    public void deleteListing(Integer listingId) {
        /**Check if the listing exists by using the id of the listing.**/
        boolean exists=listingRepository.existsById(listingId);
        /**If the listingId does not exist then throw an exception stating that such a listing does not exist.**/
        if(!exists){
            throw new IllegalStateException("Listing Id:" + listingId +" does not exist");
        }
        /**Otherwise, delete the listing by using the listingId.**/
        listingRepository.deleteById(listingId);

    }
}
