package hotel;

import baeume.ComparableContent;

import java.util.ArrayList;

public class Standort implements ComparableContent<Standort> {
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

    private double getScore() {
        double sum = 0;
        for (Hotel hotel : hotels) {
            sum += hotel.getBewertungszahl();
        }
        return sum / hotels.size();
    }

    @Override
    public boolean isGreater(Standort pContent) {
        return pContent.getScore() > getScore();
    }

    @Override
    public boolean isEqual(Standort pContent) {
        return pContent.getScore() == getScore();
    }

    @Override
    public boolean isLess(Standort pContent) {
        return pContent.getScore() < getScore();
    }
}
