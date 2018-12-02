import com.sobytylnik.InMemoryProfileRepository;
import com.sobytylnik.Profile;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ProfileControllerTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testWrongNameProfileHasStringWithSpace() {

        Profile friendWrongName = new Profile("Sergey A", "Apalko", 29);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongName);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testWrongNameProfileIsEmptyString() {

        Profile friendWrongName = new Profile(" ", "Apalko", 29);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongName);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void testTooBigAgeProfile() {

        Profile friendWrongAge = new Profile("Max", "Luchenko", 1000);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongAge);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testTooSmallAgeProfile() {

        Profile friendWrongAge = new Profile("Max", "Luchenko", -1110);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongAge);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testCorrectAgeProfile() {

        Profile friendCorrectAge = new Profile("Max", "Luchenko", 25);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendCorrectAge);
        assertTrue(violations.isEmpty());
    }
}
