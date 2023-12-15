/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class Channel {

    String name;
    String channelType;
    int price;

    public Channel(String n, String t, int p) {
        name = n;
        channelType = t;
        price = p;
    }

    public String getName() {
        return name;
    }

    public String getChannelType() {
        return channelType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
