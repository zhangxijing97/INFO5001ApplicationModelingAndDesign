package examples;

import java.util.ArrayList;

public class JavaExamples {
    // Static method
    public static void runJavaExamples() {

        System.out.println("------------------- Java Examples ---------------------");
        System.out.println();

        /*
         * Print output to the console.
         * 
         * System.out.print() , System.out.println()
         * 
         * `print` will stay on same line after output, `println` will go to the next
         * line AFTER output.
         */

        System.out.print("There will be not `new line` after this print statement.");
        System.out.print("As a result, this output will be on SAME line.");

        System.out.println("This goes to next line after printing this.");
        System.out.println("As a result, this output will be on NEXT line.");

        // boolean variables & operations

        boolean isTrue = true; // isTrue is set to true

        // `!` stands for `not` and reverses the value - !false equals true, !true equal
        // false;

        boolean isFalse = !true;

        /*
         * You can combine multiple booleans (or conditions) using AND, OR operators.
         * AND is `&&` , OR is `||`;
         */

        boolean trueAndTrue = isTrue && isTrue; // this will result true;
        boolean trueAndFalse = isTrue && isFalse; // this will result false;
        boolean falseAndFalse = isFalse && isFalse; // this will result false;

        boolean trueOrTrue = isTrue || isTrue; // this will result true;
        boolean trueOrFalse = isTrue || isFalse; // this will result true;
        boolean falseOrFalse = isFalse || isFalse; // this will result false;

        /*
         * You can combine more than two boolean variables or conditions and use
         * parenthesis.
         * When evaluated, the rule will be similar to math, first the expression inside
         * the parenthesis will be evaluated
         */

        boolean moreThanOneBoolean = ((isTrue || isTrue) && (isTrue && isFalse)) || isTrue; // the result will be true

        // if - else statements

        // 1. if with multiple lines (inside curly braces) that should be execute under
        // the condition

        int x = 10;

        if ((x > 0) || (x < 20)) { // when x equal 10, (x > 0) equal true and (x < 20) equals true as well,
                                   // therefore (true || true) equals true.
            System.out.println("x equals " + x);
            System.out.println("x is more than 0 and less than 20");
        }

        // 2. When there are no curly braces after `if` only the next expression will be
        // affected.
        if (x > 5)
            System.out.println("Yes! x is more than 5");
        System.out.println("This output is not part of if statement.");

        // 3. `if` statement can have an `else` clause.
        System.out.println("x equals " + x);
        if (x > 20) {
            System.out.println("x is more than 20");
        } else {
            System.out.println("x is less than 20");
            System.out.println("This is a second line inside else clause.");
        }

        if (x > 20) {
            System.out.println("x is more than 20");
        } else
            System.out.println("x is less than 20");
        System.out.println("This output is not part of else clause.");

        /*
         * ArrayList: You have to create a new instance of ArrayList using keyword
         * `new`.
         * You have to add an `import java.util.ArrayList;` statement in the beginning
         * of your java file where you use ArrayList.
         * The type of the elements inside the array are defined inside `< >` braces.
         * 
         */

        /*
         * Creating an ArrayList and adding some elements.
         * The type of elements in this case is String and that is why it stands as
         * `ArrayList<String>`;
         */

        ArrayList<String> colors = new ArrayList<String>();
        colors.add("red"); // 0
        colors.add("yellow"); // 1
        colors.add("white"); // 2
        colors.add("green");
        colors.add("blue");
        colors.add("purple");

        String elementNo5 = colors.get(5); // numbering elements starts with 0
        System.out.println("Element #5 is " + elementNo5);

        /*
         * Loops can run same lines of code multiple times, in a loop.
         * We can use `for` and `while` loops
         */

        /*
         * `for` loop with an `index` variable. You see three sections inside
         * parenthesis
         * 1. int index = 0; Declare and set starter value for index
         * 2. index < 10; This loop will run when this condition is true. Once this
         * becomes false, the loop will end
         * 3. index++; This expression is shorthand for index = index + 1; This runs
         * after each iteration and increments `index`.
         */

        for (int index = 0; index < 10; index++) {
            System.out.println("Iteration number: " + index);
        }

        // You can run loop backwards as well.
        for (int index = 50; index > 0; index--) {
            System.out.println("Iteration number: " + (10 - index) + " index equals " + index);
        }

        // You can use index to get i`th element from ArrayList
        for (int i = 0; i < 5; i++) {
            System.out.println(colors.get(i));
        }

        /*
         * `for` loop without an index variable, can loop through List (incl. ArrayList
         * elements).
         * Syntax inside parethesis:
         * 1. String eachColor - type and variable name that will become each element
         * from ArrayList.
         * 2. `:` - colon character is a separator between sections.
         * 3. colors - ArrayList where we draw elements from.
         */

        for (String eachColor : colors) {
            System.out.println(eachColor);
        }

        /*
         * We can still find what the index of each element is.
         */

        for (String eachColor : colors) {
            System.out.println("Element # " + colors.indexOf(eachColor) + " is " + eachColor);
        }

        /*
         * `while` uses a boolean expression of variable to check if it should still
         * run.
         */

        boolean shouldRun = true;

        while (shouldRun) {
            System.out.println("This is a printout from `while` loop.");
            shouldRun = false; // if we don't change shouldRun, it will run forever;
        }

        int indexForWhile = 0;

        while (indexForWhile < 10) {
            System.out.println("This is a printout from `while` loop. Index is equals to " + indexForWhile);
            indexForWhile++; // We increase indexForWhile by 1;
        }

        /*
         * The expression/variable inside print() or println() should be string.
         * Or smth than can be converted to string.
         * 
         * In the example below `+` does concatinate (or simply glues) the text
         * fragments together.
         */

        System.out.println("Hey this is a concatenation of string, integer and boolean:" + 5 + true);

        /*
         * If you try to print an instance of an object, e.g. instance of Address class,
         * you will only get {packageName}.{className}@{hashNumber}.
         * 
         */

        AddressClassExample nuAddress = new AddressClassExample(360, "Huntington Ave", "02115", "42.3400375,-71.0888419");
        System.out.println(nuAddress);

        /*
         * Because Java doesn't know how to `translate` you instance to a string. So it
         * uses this default
         * representation {packageName}.{className}@{hashNumber}.
         * 
         * To fix this you can implement your own method (e.g. getDisplayString) and
         * return a String that represents the instance.
         */

        System.out.println(nuAddress.getDisplayString());

        /*
         * Please check out the code inside Address class for more examples.
         * 
         */
    }
}
