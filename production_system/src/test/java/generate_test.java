import cn.hutool.core.io.FileUtil;
import com.project.InfixExpression;
import com.project.generate;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
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


             string = generate.listToString(i,list);
             System.out.println(string+" = "+result);

            File file1 = FileUtil.file("D:/project3/production_system/src/txtFile/Exercises.txt");//表达式文件
            FileUtil.appendUtf8String(string,file1);
            FileUtil.appendUtf8String("\n",file1);

            File file2 = FileUtil.file("D:/project3/production_system/src/txtFile/Answers.txt");//答案文件
            FileUtil.appendUtf8String(result,file2);
            FileUtil.appendUtf8String("\n",file2);


        }

    }



}