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
        System.out.println(p.getId());
        System.out.println(p.toString());
        Address add = new Address("Derech Shlomo Hamelech", 100);

        p.setId(123456789);

        Person Alexa = new Person ("Alexa", 987654321, 63, true, add);
        System.out.println(Alexa.toString());


        System.out.println("Is person like Alexa? " + p.equals(Alexa));

        Person Alexa2 = new Person ("Alexa", 341318079, 63, false, new Address("Rehov", 5));

        System.out.println("Does Alexa like Alexa2? " + Alexa.equals(Alexa2));
    }
}
