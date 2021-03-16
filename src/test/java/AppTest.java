import domain.Student;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import repository.StudentFileRepository;
import repository.StudentRepository;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.Validator;

public class AppTest {

    private StudentXMLRepository studentXMLRepository;

    @Test
    public void tc_2students(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studenti.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));
        studentXMLRepository.save(new Student("2","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());
        assertEquals("2",studentXMLRepository.findOne("2").getID());

    }

    @Test
    public void tc_1student(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studenti.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());

    }

}
