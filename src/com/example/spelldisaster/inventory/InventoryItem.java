package com.example.spelldisaster.inventory;

/**
 * @author horodysk
 */
public class InventoryItem {

    private int _id;

    private int _icon;

    private String _name;

    private double _weight;

    /***/
    public InventoryItem(int id, int icon, String name, double weight) {
        super();
        _id = id;
        _icon = icon;
        _name = name;
        _weight = weight;
    }

    /***/
    public int getIcon() {
        return _icon;
    }

    /***/
    public void setIcon(int icon) {
        this._icon = icon;
    }

    /***/
    public String getName() {
        return _name;
    }

    /***/
    public void setName(String name) {
        this._name = name;
    }

    /***/
    public double getWeight() {
        return _weight;
    }

    /***/
    public void setWeight(double weight) {
        this._weight = weight;
    }

    /***/
    public int getId() {
        return _id;
    }

}
