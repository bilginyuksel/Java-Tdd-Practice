package tests;

import calculator.ParserUtil;
import calculator.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void testAdd_TwoNumbersDelimiterComma() {
        Assert.assertEquals(calculator.add("2,3"), 5);
    }

    @Test
    public void testAdd_TwoNumbers2DelimiterComma() {
        Assert.assertEquals(calculator.add("5,7"), 12);
    }

    @Test(expected = ParserUtil.InvalidExpressionException.class)
    public void testAdd_ANumber() {
        calculator.add("3");
    }

    @Test(expected = ParserUtil.InvalidExpressionException.class)
    public void testAdd_RandomCharacters() {
        calculator.add("asdadas");
    }

    @Test(expected = ParserUtil.InvalidExpressionException.class)
    public void testAdd_RandomCharactersWithDelimiters() {
        calculator.add("sa,as");
    }

    @Test
    public void testAdd_ThreeNumbers2DelimiterComma() {
        assertEquals(calculator.add("5,7,2"), 14);
    }

    @Test
    public void testAdd_2Number3Delimiter() {
        assertEquals(calculator.add("5,,7,"), 12);
    }

    @Test(expected = ParserUtil.InvalidExpressionException.class)
    public void testAdd_EmptyString(){
        calculator.add("");
    }

    @Test
    public void testAdd_CustomLongExpression() {
        assertEquals(calculator.add(",,5,10,,5,,,,,7,1,,,,,,8,2,,,,"), 38);
    }

    @Test
    public void testAdd_MultipleDelimitersValidExpression() {
        assertEquals(calculator.add("3-+5,7..'8''1==10=_+4"), 38);
    }
}