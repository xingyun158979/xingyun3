import com.project.generate;
import org.junit.Test;

public class generate_test {
    @Test
    public void generate_Test()
    {
       generate.repeat(10,20,"aaa", "bbb");//测试文件不存在
        System.out.println("\n");
       generate.repeat(10,20,"../../src/txtFile/Exercises.txt", "../../src/txtFile/Answers.txt");

    }
}