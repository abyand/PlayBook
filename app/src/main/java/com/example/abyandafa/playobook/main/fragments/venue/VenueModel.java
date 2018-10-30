package com.example.abyandafa.playobook.main.fragments.venue;

/**
 * Created by Abyan Dafa on 30/10/2018.
 */

public class VenueModel {
    private String venueName;
    private String venueAddress;
    private String venueFee;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueFee() {
        return venueFee;
    }

    public void setVenueFee(String venueFee) {
        this.venueFee = venueFee;
    }

    public VenueModel(String venueName, String venueAddress, String venueFee) {

        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.venueFee = venueFee;
    }
}
