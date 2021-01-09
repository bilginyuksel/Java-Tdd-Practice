package calculator;

import java.util.ArrayList;
import java.util.List;

public class ParserUtil {

    private ParserUtil() {
    }

    public static boolean isPositiveNumber(String content) {

        for (int i = 0; i < content.length(); i++) {
            int currAsciiValue = content.charAt(i);
            boolean isDigit = 48 <= currAsciiValue && currAsciiValue <= 57;
            if (!isDigit) return false;
        }

        return !content.isEmpty();
    }

    public static List<String> parseExpression(String expression) throws InvalidExpressionException {
        String[] splittedExpression = expression.split("[,-.+*_'=]");
        List<String> necessaryContent = new ArrayList<>();
        for (String token : splittedExpression) {
            if(token.isEmpty()) continue;
            if (!ParserUtil.isPositiveNumber(token)) throw new InvalidExpressionException();
            necessaryContent.add(token);
        }
        return necessaryContent;
    }

    public static class InvalidExpressionException extends RuntimeException {
    }
}
