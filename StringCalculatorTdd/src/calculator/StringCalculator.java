package calculator;

import java.util.List;

public class StringCalculator {

    public int add(String expression) {
        if (expression.isEmpty())
            throw new ParserUtil.InvalidExpressionException();

        List<String> tokens = ParserUtil.parseExpression(expression);
        if(tokens.size() < 2) throw new ParserUtil.InvalidExpressionException();
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }

}
