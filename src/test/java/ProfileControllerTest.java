import com.sobytylnik.Profile;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
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

        Profile friendWrongName = new Profile("A", "Apalko", "Paris, France", LocalDate.of(1991,12,12),
                "Page", "Page", "Page", "Username");

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongName);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testWrongNameProfileIsEmptyString() {

        Profile friendWrongName = new Profile(" ", "Apalko", "Paris, France", LocalDate.of(1991,12,12),
                "Page", "Page", "Page", "Username");

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongName);
        assertFalse(violations.isEmpty());
    }

}
