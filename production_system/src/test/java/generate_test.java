import com.project.InfixExpression;
import com.project.generate;
import org.junit.Test;

import java.util.List;

public class generate_test {

    @Test
    public void generate_Test()
    {
        String string,result;
        int count=10,max=20;
        for (int i = 0; i <count;i++)
        {   List<String> list;

                list=generate.generateExpress(max);
                 result= InfixExpression.resultCal(InfixExpression.getSuffixExpressions(list));
             while (result==null){
                 list=generate.generateExpress(max);
                 result= InfixExpression.resultCal(InfixExpression.getSuffixExpressions(list));
             }


            string = generate.listToString(list);

        System.out.println(i+1+": "+string+" = "+result);
        }

    }



}