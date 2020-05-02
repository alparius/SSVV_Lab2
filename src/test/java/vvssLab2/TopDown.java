package vvssLab2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vvssLab2.Domain.Nota;
import vvssLab2.Domain.Student;
import vvssLab2.Domain.Teme;
import vvssLab2.Repository.NoteRepo;
import vvssLab2.Repository.StudentRepo;
import vvssLab2.Repository.TemeRepo;
import vvssLab2.Validator.NotaValidator;
import vvssLab2.Validator.StudentValidator;
import vvssLab2.Validator.TemeValidator;

import java.util.AbstractMap;

/**
 * Unit test for simple App.
 */
public class TopDown
{
    private TemeRepo temeRepo;
    private StudentRepo studentRepo;
    private NoteRepo noteRepo;

    @Before
    public void init() {
        studentRepo = new StudentRepo(new StudentValidator(),"studenti.xml");
        studentRepo.delete("1");
        studentRepo.delete("2");
        studentRepo.delete("6");
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

        noteRepo = new NoteRepo(new NotaValidator());
        noteRepo.delete(new AbstractMap.SimpleEntry<>("6", 6));
        noteRepo.delete(new AbstractMap.SimpleEntry<>("2", 3));
    }

    @Test
    public void tc_1_AddStudent() {
        assertEquals(2, studentRepo.size());
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com","Test Prof"));
        assertEquals("Test Student", studentRepo.findOne("6").getNume());
        assertEquals(3, studentRepo.size());
    }

    @Test
    public void tc_2_Half() {
        // checking preconditions
        assertEquals(2, studentRepo.size());
        assertEquals(3, temeRepo.size());

        // actual operations
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com","Test Prof"));
        temeRepo.save(new Teme(6, "test", 4, 8));

        // checking postconditions
        assertEquals("Test Student", studentRepo.findOne("6").getNume());
        assertEquals(3, studentRepo.size());
        assertEquals("test", temeRepo.findOne(6).getDescriere());
        assertEquals(4, temeRepo.size());
    }

    @Test
    public void tc_3_Full() {
        // checking preconditions
        assertEquals(2, studentRepo.size());
        assertEquals(3, temeRepo.size());

        // actual operations
        studentRepo.save(new Student("6", "Test Student", 932, "test@email.com","Test Prof"));
        temeRepo.save(new Teme(6, "test", 4, 8));
        Student st = studentRepo.findOne("6");
        Teme tm = temeRepo.findOne(6);
        noteRepo.save(new Nota(new AbstractMap.SimpleEntry<>("6", 6),st,tm,8,6),"good enough");

        // checking postconditions
        assertEquals("Test Student", studentRepo.findOne("6").getNume());
        assertEquals(3, studentRepo.size());
        assertEquals("test", temeRepo.findOne(6).getDescriere());
        assertEquals(4, temeRepo.size());
        assertEquals(8, (int)noteRepo.findOne(new AbstractMap.SimpleEntry<>("6", 6)).getVal());
    }
}

