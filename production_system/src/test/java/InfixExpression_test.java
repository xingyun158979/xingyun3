import com.project.InfixExpression;
import com.project.checkAnswer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> a=new ArrayList<>();
        a.add("1: 16 - (1'1/13 ÷ 1/3) + 1'3/11");
        String[] temp;
        temp=a.get(0).split(" ");
        List<String> infix=new ArrayList<>();
        for (String item : temp) {
            infix.add(item);
        }
        infix.remove(0);
        StringBuilder infixTemp= new StringBuilder();
        for (String s : infix) {
            infixTemp.append(s);
        }
        List<String> infix2= checkAnswer.getInfixExpression(infixTemp.toString());

        System.out.println(Arrays.toString(temp));
        System.out.println(infix);
        System.out.println(infixTemp);
        System.out.println(infix2);
    }

}
