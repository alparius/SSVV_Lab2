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
    public void tc_1_AddStudent_ExistingID() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.save(new Student("2", "Cseke Alpar", 932, "csekealpar12@gmail.com","Craciun Florin"));
    }

    @Test(expected = ValidationException.class)
    public void tc_2_AddStudent_NoEmail() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.save(new Student("2294", "Cseke Alpar", 932, "","Craciun Florin"));
    }

}
