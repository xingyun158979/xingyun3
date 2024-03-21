import com.project.calculate;
import org.junit.Test;

public class calculat_test {
    @Test
    public  void cal_test(){
        String ste;
        ste = calculate.Simplify(16,8);
        System.out.println(ste);
        ste = calculate.numberCalculate("3/8","1'1/8","+" );
        System.out.println(ste);
    }

}
