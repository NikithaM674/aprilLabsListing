package com.example.aprilLabs.apartmentListing;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long>{

    /**To find the listing and return it by using the address. */
    @Query("SELECT l FROM Listing l WHERE l.address=?1")
    Optional<Listing> findListingByAddress(String address);
}
