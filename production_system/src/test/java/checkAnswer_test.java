import com.project.checkAnswer;
import org.testng.annotations.Test;

public class checkAnswer_test {

    @Test
    public void checkAnswerTest()
    {

        checkAnswer.checkA("aaa",
            "bbb","../../src/txtFile/Grade.txt");//测试文件不存在

        checkAnswer.checkA("../../src/txtFile/Exercises.txt",
                "../../src/txtFile/Answers.txt","../../src/txtFile/Grade.txt");
         //测试正常判断对错




    }
}
