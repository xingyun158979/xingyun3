import com.project.generate;
import org.junit.Test;

public class generate_test {

    @Test
    public void generate_Test()
    {
        String string;
        int count=10;
        for (int i = 0; i <count;i++)
        { string = generate.generateExpress(19);
        System.out.println(string+" = ");}

    }

}