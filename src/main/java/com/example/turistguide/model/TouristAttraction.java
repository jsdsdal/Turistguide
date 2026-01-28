package com.example.turistguide.model;

public class TouristAttraction {
    //Test indhold

    private String name;
    private String description;

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description;
    }


}
