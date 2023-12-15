/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.MarketModel;

import java.util.ArrayList;

import model.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {

    Market market;
    Channel channel;

    public Market getMarket() {
        return market;
    }

    public Channel getChannel() {
        return channel;
    }

    public MarketChannelAssignment(Market market, Channel channel) {
        this.market = market;
        this.channel = channel;
    }

}
