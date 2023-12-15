/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.Random;

import model.MarketModel.Channel;

/**
 *
 * @author kal bugrara
 */
public class ChannelCatalog {

    ArrayList<Channel> channels;

    public ChannelCatalog() {
        channels = new ArrayList<Channel>();
    }

    public Channel newChannel(String n, String t, int p) {
        Channel c = new Channel(n, t, p);
        channels.add(c);
        return c;
    }

    public Channel pickRandomChannel() {
        if (channels.size() == 0)
            return null;
        Random r = new Random();
        int randomIndex = r.nextInt(channels.size());
        return channels.get(randomIndex);
    }

    public void generateChannelReport() {
        System.out.println("Channel Report:");

        for (Channel channel : channels) {
            System.out.println("Channel Name: " + channel.getName() +
                    ", Channel Type: " + channel.getChannelType() +
                    ", Price: " + channel.getPrice());
        }
    }

}
