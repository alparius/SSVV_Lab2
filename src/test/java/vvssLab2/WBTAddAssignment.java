package vvssLab2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import vvssLab2.Domain.Teme;
import vvssLab2.Repository.TemeRepo;
import vvssLab2.Validator.TemeValidator;
import vvssLab2.Validator.ValidationException;

/**
 * Unit test for simple App.
 */
public class WBTAddAssignment
{
    private TemeRepo temeRepo;

    @Before
    public void init() {
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
    public void tc_1_AddAssignment() {
        temeRepo.save(new Teme(6, "test", 4, 8));
        assertEquals(4, temeRepo.size());
    }

    @Test(expected = ValidationException.class)
    public void tc_2_AddAssignment_TooLittleId() {
        temeRepo.save(new Teme(0, "test", 4, 8));
    }

    @Test(expected = ValidationException.class)
    public void tc_3_AddAssignment_NullId() {
        temeRepo.save(new Teme(null, "test", 4, 8));
    }

    @Test(expected = ValidationException.class)
    public void tc_4_AddAssignment_TooLittleDeadline() {
        temeRepo.save(new Teme(6, "test", 4, 0));
    }

    @Test(expected = ValidationException.class)
    public void tc_5_AddAssignment_TooBigDeadline() {
        temeRepo.save(new Teme(6, "test", 4, 20));
    }

    @Test(expected = ValidationException.class)
    public void tc_6_AddAssignment_DeadlineBeforeReceived() {
        temeRepo.save(new Teme(6, "test", 4, 3));
    }

    @Test(expected = ValidationException.class)
    public void tc_7_AddAssignment_TooLittleReceived() {
        temeRepo.save(new Teme(6, "test", 0, 8));
    }

    @Test(expected = ValidationException.class)
    public void tc_8_AddAssignment_TooBigReceived() {
        temeRepo.save(new Teme(6, "test", 20, 8));
    }

    @Test(expected = ValidationException.class)
    public void tc_9_AddAssignment_BadIdAndDeadline() {
        temeRepo.save(new Teme(0, "test", 4, 0));
    }

    @Test(expected = ValidationException.class)
    public void tc_10_AddAssignment_BadIdAndReceived() {
        temeRepo.save(new Teme(0, "test", 0, 8));
    }

    @Test(expected = ValidationException.class)
    public void tc_11_AddAssignment_BadDeadlineAndReceived() {
        temeRepo.save(new Teme(6, "test", 0, 0));
    }

    @Test(expected = ValidationException.class)
    public void tc_12_AddAssignment_BadEverything() {
        temeRepo.save(new Teme(0, "test", 0, 0));
    }

    @Test
    public void tc_13_AddAssignment_UsedUpID() {
        assertEquals(3, temeRepo.size());
        temeRepo.save(new Teme(1, "description", 4, 8));
        assertEquals(3, temeRepo.size());
    }

}
