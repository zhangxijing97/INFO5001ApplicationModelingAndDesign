/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Business.Business;
import model.Business.ConfigureABusiness;
import model.CustomerManagement.ChannelCatalog;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.CustomerManagement.MarketCatalog;
import model.MarketModel.Channel;
import model.MarketModel.Market;
import model.MarketModel.MarketChannelAssignment;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.MasterOrderReport;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductsReport;
import model.ProductManagement.SolutionOffer;
import model.ProductManagement.SolutionOfferCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class DigitalMarketingApplication {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // 1. Populate the model
    Business business = ConfigureABusiness.createABusinessAndLoadALotOfData("Amazon", 50, 10, 100, 100, 10);
    MarketCatalog marketCatalog = business.getMarketcatalog();
    ChannelCatalog channelCatalog = business.getChannelcatalog();
    SolutionOfferCatalog solutionOfferCatalog = business.getSolutionoffercatalog();

    // 2. Interaction with the user (optional)
    Scanner sc = new Scanner(System.in);
    boolean exitQuestion01 = false;

    while (!exitQuestion01) {
      System.out.println("Welcome to Digital Marketing Application!");
      System.out.println("Choose your role:");
      System.out.println("1. Customer");
      System.out.println("2. Management");
      System.out.println("3. Exit");
      System.out.print("Enter your choice (1 or 2 or 3): ");

      String input = sc.next();

      if ("1".equals(input)) {
        addNewCustomer(business, sc);
        exitQuestion01 = true;
      } else if ("2".equals(input)) {

        // sales revenues by market
        // marketCatalog.generateMarketReportByCharacteristic();

        // sales revenues by channel types
        // String[] channelTypes = { "web", "social media", "tv", "radio" };
        // for (String channelType : channelTypes) {
        // solutionOfferCatalog.generateChannelTypeReport(channelType);
        // }

        // sales revenues by channel
        // String[] channels = { "Google", "YouTube", "LinkedIn", "Wikipedia", "Reddit",
        // "Yahoo", "Netflix", "Snapchat",
        // "Pinterest", "Tumblr", "LinkedIn", "WhatsApp", "Reddit",
        // "Twitch", "CNN", "ESPN", "Discovery", "National Geographic", "HBO", "History
        // Channel", "MTV", "NPR",
        // "BBC Radio", "iHeartRadio" };
        // for (String channelType : channels) {
        // solutionOfferCatalog.generateChannelReport(channelType);
        // }

        // sales revenues by solution bundles
        marketCatalog.generateMarketReport();

        // exitQuestion01 = true;
      } else if ("3".equals(input)) {
        exitQuestion01 = true;
      } else {
        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
      }
    }

    System.out.println("Thank you, have a nice day.");
    sc.close();

    CustomerDirectory customers = business.getCustomerDirectory();
    CustomerProfile customer = customers.pickLastCustomer();
    System.out.println(customer.getCustomerId());

    Market market = customer.getMarket();
    System.out.println(market.getCharacteristic());

    ChannelCatalog cc = business.getChannelcatalog();
    Channel c = cc.pickRandomChannel();
    System.out.println(c.getPrice());

  }

  private static void addNewCustomer(Business business, Scanner scanner) {
    // Collect user input for customer details
    System.out.print("Enter customer name: ");
    String customerName = scanner.next();

    System.out.println("Choose characteristic:");
    System.out.println("1. Students");
    System.out.println("2. Educators");
    System.out.println("3. Workers");
    System.out.println("4. Professionals");
    System.out.println("5. Entrepreneurs");
    System.out.print("Enter your choice (1-5): ");
    int characteristicChoice = scanner.nextInt();
    String characteristic = getCharacteristicByChoice(characteristicChoice);

    System.out.println("Choose channel type:");
    System.out.println("1. Web");
    System.out.println("2. Social Media");
    System.out.println("3. TV");
    System.out.println("4. Radio");
    System.out.print("Enter your choice (1-4): ");
    int channelTypeChoice = scanner.nextInt();

    // Create channelType channelName and adPrice
    String channelType = getChannelTypeByChoice(channelTypeChoice);
    String randomChannelName = "NA";
    int adPrice = 0;

    CustomerDirectory customerDirectory = business.getCustomerDirectory();
    PersonDirectory personDirectory = business.getPersonDirectory();
    MarketCatalog marketcatalog = business.getMarketcatalog();
    ChannelCatalog channelcatalog = business.getChannelcatalog();
    SolutionOfferCatalog solutionOfferCatalog = business.getSolutionoffercatalog();
    SupplierDirectory sd = business.getSupplierDirectory();

    // Create Person
    Person newPerson = personDirectory.newPerson(customerName);

    // Create Market
    Market market = marketcatalog.newMarket(characteristic);

    // Array of possible characteristics
    String[] characteristicsOptions = { "students", "educators", "workers", "professionals", "entrepreneurs" };
    String[] channelTypes = { "web", "social media", "tv", "radio" };
    String[] webChannelNames = { "Google", "YouTube", "LinkedIn", "Wikipedia", "Reddit", "Yahoo", "Netflix" };
    String[] socialMediaChannelNames = { "Snapchat", "Pinterest", "Tumblr", "LinkedIn", "WhatsApp", "Reddit",
        "Twitch" };
    String[] tvChannelNames = { "CNN", "ESPN", "Discovery", "National Geographic", "HBO", "History Channel", "MTV" };
    String[] radioChannelNames = { "NPR", "BBC Radio", "iHeartRadio" };
    Random random = new Random();

    if ("web".equals(channelType)) {
      randomChannelName = webChannelNames[random.nextInt(webChannelNames.length)];
      adPrice = 1;
    } else if ("social media".equals(channelType)) {
      randomChannelName = socialMediaChannelNames[random.nextInt(socialMediaChannelNames.length)];
      adPrice = 2;
    } else if ("tv".equals(channelType)) {
      randomChannelName = tvChannelNames[random.nextInt(tvChannelNames.length)];
      adPrice = 3;
    } else if ("radio".equals(channelType)) {
      randomChannelName = radioChannelNames[random.nextInt(radioChannelNames.length)];
      adPrice = 4;
    } else {
      // Handle the case where the channel type is not recognized
      randomChannelName = "DefaultChannel"; // You can provide a default name or handle it according to your needs
    }

    // Create a new Channel by the randomChannelName and randomChannelType
    Channel channel = channelcatalog.newChannel(randomChannelName, channelType, adPrice);

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

    double multiple01 = 0.8;
    double multiple02 = 0.9;
    double multiple03 = 1;

    if (market.getCharacteristic() == "students") {
      price = (int) Math.round(price * multiple01);
    } else if (market.getCharacteristic() == "educators") {
      price = (int) Math.round(price * multiple01);
    } else if (market.getCharacteristic() == "workers") {
      price = (int) Math.round(price * multiple01);
    } else if (market.getCharacteristic() == "professionals") {
      price = (int) Math.round(price * multiple02);
    } else if (market.getCharacteristic() == "entrepreneurs") {
      price = (int) Math.round(price * multiple03);
    } else {
      price = (int) Math.round(price * 1);
    }

    // Add price for each SolutionOffer
    solutionOffer.setPrice(price);

    // Set MarketChannelAssignment, SolutionOffer for the Market
    market.setMarketChannelAssignment(marketChannelAssignment);
    market.setSolutionOffer(solutionOffer);
    customerDirectory.newCustomerProfile(newPerson, market);

    System.out.println("Hello! As a " + characteristic
        + ", you qualify for a special offer. Enjoy a selection tailored to your needs:");

    // Get the list of products in the special offer
    ArrayList<Product> products = solutionOffer.getProducts();

    // Check if there are products in the special offer
    if (!products.isEmpty()) {
      // Output information about each product
      System.out.println("Special Offer Products:");
      for (Product product : products) {
        System.out.println("Name: " + product.getName());
        System.out.println("Price: $" + product.getTargetPrice());
      }
      System.out.println("Special Offer Total Price: $" + price);
      System.out.println("--------------------------");
    } else {
      System.out.println("No products in the special offer.");
    }
  }

  private static String getCharacteristicByChoice(int choice) {
    switch (choice) {
      case 1:
        return "students";
      case 2:
        return "educators";
      case 3:
        return "workers";
      case 4:
        return "professionals";
      case 5:
        return "entrepreneurs";
      default:
        return "";
    }
  }

  private static String getChannelTypeByChoice(int choice) {
    switch (choice) {
      case 1:
        return "web";
      case 2:
        return "social media";
      case 3:
        return "tv";
      case 4:
        return "radio";
      default:
        return "";
    }
  }
}