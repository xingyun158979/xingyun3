import com.project.calculate;
import org.junit.Test;

public class calculat_test {
    @Test
    public  void cal_test(){
        String ste;
        ste = calculate.Simplify(16,8);
        System.out.println(ste);
        ste = calculate.numberCalculate("4'2/3","3'1/3","-" );
        System.out.println(ste);
    }

}
