import com.project.checkAnswer;
import org.testng.annotations.Test;

public class checkAnswer_test {

    @Test
    public void checkAnswerTest()
    {
        checkAnswer.checkA("D:/project3/production_system/src/txtFile/Exercises.txt",
                "D:/project3/production_system/src/txtFile/Answers.txt");

    }
}
