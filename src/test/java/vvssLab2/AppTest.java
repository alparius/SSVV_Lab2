package vvssLab2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import vvssLab2.Domain.Student;
import vvssLab2.Repository.StudentRepo;
import vvssLab2.Validator.StudentValidator;
import vvssLab2.Validator.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private StudentRepo studentRepo;

    @Test
    public void tc_1_AddStudent() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.save(new Student("2294", "Cseke Alpar", 932, "csekealpar12@gmail.com","Craciun Florin"));
        assertEquals("Cseke Alpar", studentRepo.findOne("2294").getNume());
    }

    @Test(expected = ValidationException.class)
    public void tc_2_AddStudent_NoEmail() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.save(new Student("2294", "Cseke Alpar", 932, "","Craciun Florin"));
    }

    @Test
    public void tc_4_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_5_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_6_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_7_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_8_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_9_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_10_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_11_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_12_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

    @Test
    public void tc_13_() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
    }

}
