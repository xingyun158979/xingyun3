import com.project.checkAnswer;
import org.testng.annotations.Test;

public class checkAnswer_test {

    @Test
    public void checkAnswerTest()
    {
        checkAnswer.checkA("../../src/txtFile/Exercises.txt",
                "../../src/txtFile/Answers.txt","../../src/txtFile/Grade.txt");
    }
}
