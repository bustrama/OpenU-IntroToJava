/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver {
    public static void main (String [] args) {
        Person p = new Person ();
        //this will use the default constructor
        System.out.println(p.getIdentification());
        System.out.println(p.toString());

        p.setIdentification(123456789);

        Person Alexa = new Person ("Alexa", 987654321, 63, "female");
        System.out.println(Alexa.toString());


        System.out.println(p.equals(Alexa));

        Person Alexa2 = new Person ("Alexa", 341318079, 63, "female");

        System.out.println(Alexa.equals(Alexa2));
    }
}
