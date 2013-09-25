/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gethotelinfo;

/**
 *
 * @author WIN7
 */
public class Hotel {
    private int id;
    private String name;
    private String description;
    private double price;
    private String location;

    public Hotel(String name, String description, double price, String location) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.location = location;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", location=" + location + '}';
    }
}
