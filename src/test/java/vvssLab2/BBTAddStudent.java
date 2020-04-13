package vvssLab2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vvssLab2.Domain.Student;
import vvssLab2.Repository.StudentRepo;
import vvssLab2.Validator.StudentValidator;
import vvssLab2.Validator.ValidationException;

/**
 * Unit test for simple App.
 */
public class BBTAddStudent
{
    private StudentRepo studentRepo;

    @Before
    public void init() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.delete("1");
        studentRepo.delete("2");
        studentRepo.delete("6");
        studentRepo.save(new Student("1", "Roman Ionut", 222, "riir3478@scs.ubbcluj.ro","Plesu Andrei"));
        studentRepo.save(new Student("2", "Gorea Andra", 931, "gaie1234@scs.ubbcluj.ro","Lovin Andrei"));
    }

    @Test
    public void tc_1_AddStudent() {
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com","Test Prof"));
        assertEquals("Test Student", studentRepo.findOne("6").getNume());
    }

    @Test(expected = NullPointerException.class)
    public void tc_2_AddStudent_NullEmail() {
        studentRepo.save(new Student("6", "Test Student", 932, null,"Test Prof"));
    }

    @Test(expected = ValidationException.class)
    public void tc_3_AddStudent_EmptyEmail() {
        studentRepo.save(new Student("6", "Test Student", 932, "","Test Prof"));
    }

    @Test(expected = ValidationException.class)
    public void tc_4_AddStudent_NoAtEmail() {
        studentRepo.save(new Student("6", "Test Student", 932, "testemail.com","Test Prof"));
    }

    @Test(expected = ValidationException.class)
    public void tc_5_AddStudent_EmptyId() {
        studentRepo.save(new Student("", "Test Student", 932, "test@email.com","Test Prof"));
    }

    @Test(expected = ValidationException.class)
    public void tc_6_AddStudent_NullId() {
        studentRepo.save(new Student(null, "Test Student", 932, "test@email.com","Test Prof"));
    }

    @Test(expected = ValidationException.class)
    public void tc_7_AddStudent_BadName() {
        studentRepo.save(new Student("6", "1234567", 932, "test@email.com","Test Prof"));
    }

    @Test(expected = NullPointerException.class)
    public void tc_8_AddStudent_NullName() {
        studentRepo.save(new Student("6", null, 932, "test@email.com","Test Prof"));
    }

    @Test(expected = ValidationException.class)
    public void tc_9_AddStudent_EmptyName() {
        studentRepo.save(new Student("6", "", 932, "test@email.com","Test Prof"));
    }

    @Test(expected = NullPointerException.class)
    public void tc_10_AddStudent_NullProfName() {
        studentRepo.save(new Student("6", "", 932, "test@email.com",null));
    }

    @Test(expected = ValidationException.class)
    public void tc_11_AddStudent_BadProfName() {
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com","1234567"));
    }

    @Test(expected = ValidationException.class)
    public void tc_12_AddStudent_EmptyProfName() {
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com",""));
    }

    @Test
    public void tc_13_AddStudent_UsedUpId() {
        assertEquals(2, studentRepo.size());
        studentRepo.save(new Student("1", "Test Student", 932, "test@email.com","Test Prof"));
        assertEquals(2, studentRepo.size());
    }

    @Test
    public void tc_14_AddStudent_Len1Name() {
        studentRepo.save(new Student("6", "a", 932, "test@email.com","Test Prof"));
        assertEquals("a", studentRepo.findOne("6").getNume());
    }

    @Test
    public void tc_15_AddStudent_Len1ProfName() {
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com","a"));
        assertEquals("a", studentRepo.findOne("6").getProfesor());
    }

//    @Test
//    public void tc_16_AddStudent_Len1Email() {
//        studentRepo.save(new Student("6", "Test Student", 932, "a","Test Prof"));
//    }

//    @Test
//    public void tc_17_AddStudent_GroupBoundary1() {
//        studentRepo.save(new Student("6", "Test Student", Integer.MAX_VALUE, "test@email.com","Test Prof"));
//    }

    @Test(expected = ValidationException.class)
    public void tc_18_AddStudent_GroupBoundary2() {
        studentRepo.save(new Student("6", "Test Student", Integer.MAX_VALUE+1, "test@email.com","Test Prof"));
    }

//    @Test
//    public void tc_19_AddStudent_GroupBoundary3() {
//        studentRepo.save(new Student("6", "Test Student", Integer.MAX_VALUE-1, "test@email.com","Test Prof"));
//    }

//    @Test
//    public void tc_20_AddStudent_GroupBoundary4() {
//        studentRepo.save(new Student("6", "Test Student", Integer.MIN_VALUE, "test@email.com","Test Prof"));
//    }

//    @Test
//    public void tc_21_AddStudent_GroupBoundary5() {
//        studentRepo.save(new Student("6", "Test Student", Integer.MIN_VALUE+1, "test@email.com","Test Prof"));
//    }

    @Test(expected = ValidationException.class)
    public void tc_22_AddStudent_GroupBoundary6() {
        studentRepo.save(new Student("6", "Test Student", Integer.MIN_VALUE-1, "test@email.com","Test Prof"));
    }

}
