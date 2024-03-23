import com.project.calculate;
import org.junit.Test;

public class calculate_test {
    @Test
    public  void cal_test(){
        String ste;
        ste = calculate.Simplify(16,8);//测试能化简成整数
        System.out.println(ste);
        ste = calculate.Simplify(20,8);//测试化简成真分数
        System.out.println(ste);
        ste = calculate.numberCalculate("3/8","1'1/8","+" );//测试两分数
        System.out.println(ste);
        ste = calculate.numberCalculate("3","1'1/8","÷" );//测试一整数一分数
        System.out.println(ste);
        ste = calculate.numberCalculate("1","1'1/8","-" );//测试出现负数
        System.out.println(ste);
        ste = calculate.numberCalculate("3","1'1/3","×" );//测试乘法
        System.out.println(ste);

    }

}
