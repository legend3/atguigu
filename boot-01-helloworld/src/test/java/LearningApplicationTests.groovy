import com.atguigu.boot.bean.Student
import com.atguigu.boot.config.SpringContextUtil
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class LearningApplicationTests {
    @Test
    void contextLoads() {
        def student = SpringContextUtil.getBean(Student.class)
        println(student)
    }
}