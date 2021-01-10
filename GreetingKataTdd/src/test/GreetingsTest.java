package test;

import greeting.Greetings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingsTest {
    Greetings greetings = new Greetings();

    @Test
    public void testGreet_1Name() {
        assertEquals(greetings.greet("Bob"), "Hello, Bob.");
        assertEquals(greetings.greet("Jerry"), "Hello, Jerry.");
    }

    @Test
    public void testGreet_NullOrNoName() {
        assertEquals(greetings.greet(), "Hello, my friend.");
        assertEquals(greetings.greet(null), "Hello, my friend.");
    }

    @Test
    public void testGreet_1NameAllUppercase() {
        assertEquals(greetings.greet("JERRY"), "HELLO JERRY!");
        assertEquals(greetings.greet("BOB"), "HELLO BOB!");
    }

    @Test
    public void testGreet_2Name() {
        assertEquals(greetings.greet("Jill", "Jane"), "Hello, Jill and Jane.");
        assertEquals(greetings.greet("Bob", "Jerry"), "Hello, Bob and Jerry.");
    }

    @Test
    public void testGreet_3Name() {
        assertEquals(greetings.greet("Amy", "Brian", "Charlotte"), "Hello, Amy, Brian and Charlotte.");
        assertEquals(greetings.greet("Lacin", "Yuksel", "Fatma"), "Hello, Lacin, Yuksel and Fatma.");
    }

    @Test
    public void testGreet_3Name1OfThemIsUppercase() {
        assertEquals(greetings.greet("Amy", "BRIAN", "Charlotte"), "Hello, Amy and Charlotte. AND HELLO BRIAN!");
        assertEquals(greetings.greet("BRIAN", "Amy", "Charlotte"), "Hello, Amy and Charlotte. AND HELLO BRIAN!");
    }

    @Test
    public void testGreet_MultipleNameMultipleUppercase() {
        assertEquals(greetings.greet("Yuksel", "LACIN", "Fatma", "Kaan", "GOKCE"), "Hello, Yuksel, Fatma and Kaan. AND HELLO LACIN! AND HELLO GOKCE!");
        assertEquals(greetings.greet("Yuksel", "Lacin", "FATMA", "KAAN", "GOKCE"), "Hello, Yuksel and Lacin. AND HELLO FATMA! AND HELLO KAAN! AND HELLO GOKCE!");
    }

    @Test
    public void testGreet_MultipleNameUppercase() {
        assertEquals(greetings.greet("LACIN", "FATMA", "YUKSEL"), "HELLO LACIN! AND HELLO FATMA! AND HELLO YUKSEL!");
    }

    @Test
    public void testGreet_MultipleNamesAtLeastOneOfThemConsists2OrMoreName() {
        assertEquals(greetings.greet("Yuksel", "Fatma, Lacin"), "Hello, Yuksel, Fatma and Lacin.");
        assertEquals(greetings.greet("Yuksel", "Fatma, Lacin, Kaan", "Husniye", "LEVENT"), "Hello, Yuksel, Fatma, Lacin, Kaan and Husniye. AND HELLO LEVENT!");
    }

    @Test
    public void testGreet_MultipleNamesAndCompoundName() {
        assertEquals(greetings.greet("Hasan", "Bilgin", "\"Yuksel, Kaan\""), "Hello, Hasan, Bilgin and Yuksel, Kaan.");
    }

    @Test
    public void testGreet_ComplexExample() {
        assertEquals(greetings.greet("Kaan", "LACIN", "Fatma", "HUSNIYE", "Sefiye, Galip", "\"Yuksel, Bilgin\""),
                "Hello, Kaan, Fatma, Sefiye, Galip and Yuksel, Bilgin. AND HELLO LACIN! AND HELLO HUSNIYE!");
    }
}