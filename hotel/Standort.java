package hotel;

import baeume.ComparableContent;

import java.util.ArrayList;

public class Standort implements ComparableContent {
    private String name;
    private String land;
    private ArrayList<Hotel> hotels;

    public Standort(String name, ArrayList<Hotel> hotels) {
        this.name = name;
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void fuegeHotelHinzu(Hotel hotel) {
        hotels.add(hotel);
    }

    public Hotel getHotel(String name) {
        for(Hotel h : hotels) {
            if(h.getName().equals(name))return h;
        }
        return null;
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void loescheHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    @Override
    public boolean isGreater(Object pContent) {
        return false;
    }

    @Override
    public boolean isEqual(Object pContent) {
        return false;
    }

    @Override
    public boolean isLess(Object pContent) {
        return false;
    }
}
