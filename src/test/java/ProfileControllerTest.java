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


public class ProfileControllerTest {

    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testWrongNameProfile() {

        Profile friendWrongName = new Profile("Sergey123", "Apalko", 29);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongName);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void testWrongAgeProfile() {

        Profile friendWrongAge = new Profile("Max", "Luchenko", 129);

        Set<ConstraintViolation<Profile>> violations = validator.validate(friendWrongAge);
        assertFalse(violations.isEmpty());
    }
}
