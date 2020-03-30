package vvssLab2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vvssLab2.Domain.Student;
import vvssLab2.Domain.Teme;
import vvssLab2.Repository.StudentRepo;
import vvssLab2.Repository.TemeRepo;
import vvssLab2.Validator.StudentValidator;
import vvssLab2.Validator.TemeValidator;
import vvssLab2.Validator.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private StudentRepo studentRepo;
    private TemeRepo temeRepo;

    @Before
    public void init() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.delete("1");
        studentRepo.delete("2");
        studentRepo.delete("2294");
        studentRepo.save(new Student("1", "Roman Ionut", 222, "riir3478@scs.ubbcluj.ro","Plesu Andrei"));
        studentRepo.save(new Student("2", "Gorea Andra", 931, "gaie1234@scs.ubbcluj.ro","Lovin Andrei"));

        temeRepo = new TemeRepo(new TemeValidator(),"teme.xml");
        temeRepo.delete(1);
        temeRepo.delete(2);
        temeRepo.delete(3);
        temeRepo.delete(6);
        temeRepo.save(new Teme(1, "Suma a+b", 10, 11));
        temeRepo.save(new Teme(2, "Calculati a!", 10, 11));
        temeRepo.save(new Teme(3, "Backtracking", 12, 13));
    }

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
    public void tc_3_AddAssignment() {
        temeRepo = new TemeRepo(new TemeValidator(),"teme.xml");
        temeRepo.save(new Teme(6, "description", 10, 14));
        assertEquals(4, temeRepo.size());
    }

    @Test
    public void tc_4_AddAssignment_UsedUpID() {
        temeRepo = new TemeRepo(new TemeValidator(),"teme.xml");
        temeRepo.save(new Teme(3, "description", 10, 14));
        assertEquals(3, temeRepo.size());
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
