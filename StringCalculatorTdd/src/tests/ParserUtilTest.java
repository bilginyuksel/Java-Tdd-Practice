package tests;

import calculator.ParserUtil;
import calculator.StringCalculator;
import org.junit.Test;

import javax.swing.text.html.parser.Parser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParserUtilTest {

    @Test
    public void testIsNumber_EmptyString() {
        String content = "";
        assertFalse(ParserUtil.isPositiveNumber(content));
    }

    @Test
    public void testIsNumber_CorrectNumber() {
        String content = "689";
        assertTrue(ParserUtil.isPositiveNumber(content));
    }

    @Test
    public void testIsNumber_NotNumber() {
        String content = "6a5l";
        assertFalse(ParserUtil.isPositiveNumber(content));
    }

    @Test
    public void testParseExpression_2Numbers3Delimiters() {
        String expression = "3,,5";
        List<String> expected = Arrays.asList("3", "5");
        assertEquals(ParserUtil.parseExpression(expression), expected);
    }

    @Test
    public void testParseExpression_2Numbers2Delimiters() {
        String expression = "3,5";
        List<String> expected = Arrays.asList("3", "5");
        assertEquals(ParserUtil.parseExpression(expression), expected);
    }

    @Test(expected = ParserUtil.InvalidExpressionException.class)
    public void testParseExpression_InvalidExpression() {
        String expression = "3,,a,b,";
        ParserUtil.parseExpression(expression);
    }

    @Test
    public void testParseExpression_CustomLongExpression() {
        String expression = ",,5,10,,5,,,,,7,1,,,,,,8,2,,,,";
        List<String> expected = Arrays.asList("5", "10", "5", "7", "1", "8", "2");
        assertEquals(ParserUtil.parseExpression(expression), expected);
    }

    @Test
    public void testParseExpression_TwoDifferentDelimitersValidExpression() {
        assertEquals(ParserUtil.parseExpression(",,3,,-5--"), Arrays.asList("3", "5"));
    }

    @Test
    public void testParseExpression_MultipleDelimitersValidExpression() {
        assertEquals(ParserUtil.parseExpression(",+*_3+'.,=5-"), Arrays.asList("3", "5"));
    }
}