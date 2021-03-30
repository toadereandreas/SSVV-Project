import domain.Student;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import repository.StudentFileRepository;
import repository.StudentRepository;
import repository.StudentXMLRepository;
import service.Service;
import validation.StudentValidator;
import validation.ValidationException;
import validation.Validator;

public class AppTest {

    private StudentXMLRepository studentXMLRepository;

    @Test
    public void tc_2students(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));
        studentXMLRepository.save(new Student("2","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());
        assertEquals("2",studentXMLRepository.findOne("2").getID());

    }

    @Test
    public void tc_1student(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","student-test-1",111));

        assertEquals("1",studentXMLRepository.findOne("1").getID());

    }

    @Test
    public void tc_1(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("1","Wayne",937));

        assertEquals("1",studentXMLRepository.findOne("1").getID());

    }

    @Test
    public void tc_2(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        studentXMLRepository.save(new Student("100","Wayne",937));
        studentXMLRepository.save(new Student("100","Bruce",937));

        assertEquals("Wayne",studentXMLRepository.findOne("100").getNume());
    }

    @Test
    public void tc_3(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("","Wayne",937)));
    }

    @Test
    public void tc_4(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("111","",937)));
    }

    @Test
    public void tc_5(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("111","",-1)));
    }

    @Test
    public void tc_6(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        assertEquals(null,studentXMLRepository.save(new Student("111","",-1)));
    }


    @Test
    public void bva_2(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student(" ","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_3(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("a","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_4(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("111","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_5(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("a1b2c3","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_6(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("z","wayne",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_7(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","",937);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_8(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1"," ",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_9(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","a",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_10(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","1",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_11(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","a1b2c3",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_12(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","z",937);

        assertEquals(student,studentXMLRepository.save(student));
    }

    @Test
    public void bva_13(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne",-1);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_14(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne",0);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_15(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","a1b2c3",1);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_16(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne", Integer.MAX_VALUE);

        assertEquals(null,studentXMLRepository.save(student));
    }

    @Test
    public void bva_17(){

        Validator<Student> studentValidator = new StudentValidator();

        studentXMLRepository = new StudentXMLRepository(studentValidator, "studentitest.xml");

        Student student = new Student("id1","Wayne",Integer.MIN_VALUE);

        assertEquals(null,studentXMLRepository.save(student));
    }
}
