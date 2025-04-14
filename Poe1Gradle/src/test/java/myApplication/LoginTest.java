package myApplication;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;




public class LoginTest {

    @Test
    public void testUsernameValid() {
        assertTrue(Login.checkUsername("kyl_1"));  // valid
    }

    @Test
    public void testUsernameTooLong() {
        assertFalse(Login.checkUsername("kyle!!!!!!"));  // too long
    }

    @Test
    public void testUsernameNoUnderscore() {
        assertFalse(Login.checkUsername("um12"));  // missing underscore
    }

    @Test
    public void testPasswordMeetsComplexity() {
        assertTrue(Login.checkPasswordComplexity("Ch&8sec@eg99!")); // meets all requirements
    }

    @Test
    public void testPasswordTooShort() {
        assertFalse(Login.checkPasswordComplexity("Ch&9sec"));  // less than 8
    }

    @Test
    public void testPasswordMissingUppercase() {
        assertFalse(Login.checkPasswordComplexity("ch&8sec@eg9"));  // no uppercase
    }

    @Test
    public void testPasswordMissingDigit() {
        assertFalse(Login.checkPasswordComplexity("Ch&seceg@!"));  // no digit
    }

    @Test
    public void testPasswordMissingSpecialChar() {
        assertFalse(Login.checkPasswordComplexity("password"));  // no special char
    }

    @Test
    public void testValidPhoneNumber() {
        assertTrue(Login.checkCellphoneNumber("+27838968976"));  // valid SA international format
    }

    @Test
    public void testInvalidPhoneNumberTooShort() {
        assertFalse(Login.checkCellphoneNumber("08966553"));  // invalid
    }

    @Test
    public void testInvalidPhoneNumberMissingCode() {
        assertFalse(Login.checkCellphoneNumber("0839569876"));  // no +27
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        assertEquals("A successful login", Login.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatusFailure() {
        assertEquals("A failed login", Login.returnLoginStatus(false));
    }
}

