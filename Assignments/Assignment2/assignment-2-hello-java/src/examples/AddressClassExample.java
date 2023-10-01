// Declaration of the package

package examples;

// Import statements (if any). e.g. coubld be `import java.util.ArrayList;`

/* 
* Declaration of the class. 
* You see three parts here:
* 1. `public` is a special keyword and makes this class accessible. e.g. in MainClass we are able to import and use is.
* 2. `class` is also a keyword.
* 3. `NameOfTheClass` should start with a capital letter.
*/

public class AddressClassExample { // Contents of the class and out inside curly braces, they start here.

    /*
     * List of attributes (or properties)
     */

    int streetNum;
    String streetName;
    String zip;
    String gps;

    // Constructor - method has same name as the class. Does not need a 'type' (e.g.
    // void, String) between `public` and `className`

    public AddressClassExample(int streetNum, String streetName, String zip, String gps) {
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.zip = zip;
        this.gps = gps;
    }

    // Method with a String return type

    public String getDisplayString() {
        return streetNum + " " + streetName + ", " + zip;
    }

    // Method with a void return type (doesn't return anything just does whatever it
    // should)

    public void printToConsole() {
        // You can call other methods from the same class. e.g.
        String outputText = getDisplayString();
        System.out.println(outputText);
    }

    // `private` method can only be used inside the class. 
    // You can NOT call it from MainClass. e.g. nuAddress.getGps() will give you an error.

    private String getGps() {
        return gps;
    }

} // Contents of the class end here.
