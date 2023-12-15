/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

// import java.nio.channels.Channel;
import java.util.Random;

import com.github.javafaker.Faker;

import model.CustomerManagement.ChannelCatalog;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.CustomerManagement.MarketCatalog;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

import model.CustomerManagement.ChannelCatalog;
import model.MarketModel.Channel;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  static int upperPriceLimit = 50;
  static int lowerPriceLimit = 10;
  static int range = 5;
  static int productMaxQuantity = 5;

  public static Business createABusinessAndLoadALotOfData(String name, int supplierCount, int productCount,
      int customerCount, int orderCount, int itemCount) {
    Business business = new Business(name);

    // Add Suppliers +
    loadSuppliers(business, supplierCount);

    // Add Products +
    loadProducts(business, productCount);

    // Add Customers
    loadCustomers(business, customerCount);

    // Add Order
    // loadOrders(business, orderCount, itemCount);

    return business;
  }

  public static void loadSuppliers(Business b, int supplierCount) {
    Faker faker = new Faker();

    SupplierDirectory supplierDirectory = b.getSupplierDirectory();
    for (int index = 1; index <= supplierCount; index++) {
      supplierDirectory.newSupplier(faker.company().name());
    }
  }

  static void loadProducts(Business b, int productCount) {
    SupplierDirectory supplierDirectory = b.getSupplierDirectory();

    for (Supplier supplier : supplierDirectory.getSupplierList()) {

      int randomProductNumber = getRandom(1, productCount);
      ProductCatalog productCatalog = supplier.getProductCatalog();

      for (int index = 1; index <= randomProductNumber; index++) {

        String productName = "Product #" + index + " from " + supplier.getName();
        int randomFloor = getRandom(lowerPriceLimit, lowerPriceLimit + range);
        int randomCeiling = getRandom(upperPriceLimit - range, upperPriceLimit);
        int randomTarget = getRandom(randomFloor, randomCeiling);

        productCatalog.newProduct(productName, randomFloor, randomCeiling, randomTarget);
      }
    }
  }

  static int getRandom(int lower, int upper) {
    Random r = new Random();

    // nextInt(n) will return a number from zero to 'n'. Therefore e.g. if I want
    // numbers from 10 to 15
    // I will have result = 10 + nextInt(5)
    int randomInt = lower + r.nextInt(upper - lower);
    return randomInt;
  }

  static void loadCustomers(Business b, int customerCount) {
    CustomerDirectory customerDirectory = b.getCustomerDirectory();
    PersonDirectory personDirectory = b.getPersonDirectory();

    MarketCatalog marketcatalog = b.getMarketcatalog();
    ChannelCatalog channelcatalog = b.getChannelcatalog();
    SolutionOfferCatalog solutionOfferCatalog = b.getSolutionoffercatalog();

    SupplierDirectory sd = b.getSupplierDirectory();

    Faker faker = new Faker();

    // Array of possible characteristics
    String[] characteristicsOptions = { "students", "educators", "workers", "professionals", "entrepreneurs" };
    String[] channelTypes = { "web", "social media", "tv", "radio" };
    String[] webChannelNames = { "Google", "YouTube", "LinkedIn", "Wikipedia", "Reddit", "Yahoo", "Netflix" };
    String[] socialMediaChannelNames = { "Snapchat", "Pinterest", "Tumblr", "LinkedIn", "WhatsApp", "Reddit",
        "Twitch" };
    String[] tvChannelNames = { "CNN", "ESPN", "Discovery", "National Geographic", "HBO", "History Channel", "MTV" };
    String[] radioChannelNames = { "NPR", "BBC Radio", "iHeartRadio" };
    Random random = new Random();

    for (int index = 1; index <= customerCount; index++) {
      Person newPerson = personDirectory.newPerson(faker.name().fullName());
      // Get a random characteristic from the array
      String randomCharacteristic = characteristicsOptions[random.nextInt(characteristicsOptions.length)];
      Market market = marketcatalog.newMarket(randomCharacteristic);

      // Create a new Channel for the Market
      String randomChannelType = channelTypes[random.nextInt(channelTypes.length)];
      String randomChannelName = null;
      int adPrice = 0;

      // Get randomChannelName
      if ("web".equals(randomChannelType)) {
        randomChannelName = webChannelNames[random.nextInt(webChannelNames.length)];
        adPrice = 1;
      } else if ("social media".equals(randomChannelType)) {
        randomChannelName = socialMediaChannelNames[random.nextInt(socialMediaChannelNames.length)];
        adPrice = 2;
      } else if ("tv".equals(randomChannelType)) {
        randomChannelName = tvChannelNames[random.nextInt(tvChannelNames.length)];
        adPrice = 3;
      } else if ("radio".equals(randomChannelType)) {
        randomChannelName = radioChannelNames[random.nextInt(radioChannelNames.length)];
        adPrice = 4;
      } else {
        // Handle the case where the channel type is not recognized
        randomChannelName = "DefaultChannel"; // You can provide a default name or handle it according to your needs
      }

      // Create a new Channel by the randomChannelName and randomChannelType
      Channel channel = channelcatalog.newChannel(randomChannelName, randomChannelType, adPrice);

      // Create a new MarketChannelAssignment for the Market and Channel
      MarketChannelAssignment marketChannelAssignment = new MarketChannelAssignment(market, channel);

      // Create a new SolutionOffer for the Market
      SolutionOffer solutionOffer = solutionOfferCatalog.newSolutionOffer(marketChannelAssignment);

      // Add 5 products for each SolutionOffer and get the price
      int price = 0;
      for (int itemIndex = 0; itemIndex < 5; itemIndex++) {
        Supplier randomSupplier = sd.pickRandomSupplier();
        if (randomSupplier == null) {
          System.out.println("Cannot generate orders. No supplier in the supplier directory.");
          return;
        }
        ProductCatalog pc = randomSupplier.getProductCatalog();
        Product randomProduct = pc.pickRandomProduct();
        if (randomProduct == null) {
          System.out.println("Cannot generate orders. No products in the product catalog.");
          return;
        }
        solutionOffer.addProduct(randomProduct);
        price = price + randomProduct.getTargetPrice();
      }

      // "students", "educators", "workers", "professionals", "entrepreneurs

      if (market.getCharacteristic() == "students") {
        price = (int) Math.round(price * 0.8);
      } else if (market.getCharacteristic() == "educators") {
        price = (int) Math.round(price * 0.8);
      } else if (market.getCharacteristic() == "workers") {
        price = (int) Math.round(price * 0.8);
      } else if (market.getCharacteristic() == "professionals") {
        price = (int) Math.round(price * 0.9);
      } else if (market.getCharacteristic() == "entrepreneurs") {
        price = (int) Math.round(price * 1);
      } else {
        price = (int) Math.round(price * 1);
      }

      // Add price for each SolutionOffer
      solutionOffer.setPrice(price);

      // Set MarketChannelAssignment, SolutionOffer for the Market
      market.setMarketChannelAssignment(marketChannelAssignment);
      market.setSolutionOffer(solutionOffer);

      customerDirectory.newCustomerProfile(newPerson, market);
    }

  }

  static void loadOrders(Business b, int orderCount, int itemCount) {

    // reach out to masterOrderList
    MasterOrderList mol = b.getMasterOrderList();

    // pick a random customer (reach to customer directory)
    CustomerDirectory cd = b.getCustomerDirectory();
    SupplierDirectory sd = b.getSupplierDirectory();

    for (int index = 0; index < orderCount; index++) {

      CustomerProfile randomCustomer = cd.pickRandomCustomer();
      if (randomCustomer == null) {
        System.out.println("Cannot generate orders. No customers in the customer directory.");
        return;
      }

      // create an order for that customer
      Order randomOrder = mol.newOrder(randomCustomer);

      // add order items
      // -- pick a supplier first (randomly)
      // -- pick a product (randomly)
      // -- actual price, quantity

      int randomItemCount = getRandom(1, itemCount);
      for (int itemIndex = 0; itemIndex < randomItemCount; itemIndex++) {

        Supplier randomSupplier = sd.pickRandomSupplier();
        if (randomSupplier == null) {
          System.out.println("Cannot generate orders. No supplier in the supplier directory.");
          return;
        }
        ProductCatalog pc = randomSupplier.getProductCatalog();
        Product randomProduct = pc.pickRandomProduct();
        if (randomProduct == null) {
          System.out.println("Cannot generate orders. No products in the product catalog.");
          return;
        }

        int randomPrice = getRandom(randomProduct.getFloorPrice(), randomProduct.getCeilingPrice());
        int randomQuantity = getRandom(1, productMaxQuantity);

        randomOrder.newOrderItem(randomProduct, randomPrice, randomQuantity);
      }
    }
    // Make sure order items are connected to the order

  }

}
