import com.project.InfixExpression;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InfixExpression_test {

    @Test
    public void Infix_test()
    {
        List<String> expressions = new ArrayList<>();
        expressions.add("(");expressions.add("3/8");expressions.add("+");expressions.add("3/8");expressions.add(")");
        expressions.add("×");expressions.add("3");
        expressions.add("÷");expressions.add("4");


        List<String> houZui = InfixExpression.getSuffixExpressions(expressions);
        System.out.println(houZui);//测试后缀表达式的生成
        String result =InfixExpression.resultCal(houZui);
        System.out.println(result);//测试结果

    }

}
