import com.project.InfixExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InfixExpression_test {

    @Test
    public void Infix_test()
    {
        List<String> expressions = new ArrayList<>();
        expressions.add("(");
        expressions.add("3/8");
        expressions.add("+");
        expressions.add("1'1/8");
        expressions.add(")");
        expressions.add("×");
        expressions.add("3");

        List<String> houZui = InfixExpression.getSuffixExpressions(expressions);
        System.out.println(houZui);
        String result =InfixExpression.resultCal(houZui);
        System.out.println(result);

    }

}
