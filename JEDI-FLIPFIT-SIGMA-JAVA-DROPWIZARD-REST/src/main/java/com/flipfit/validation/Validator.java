package com.flipfit.validation;

// TODO: Auto-generated Javadoc
/**
 * The Class Validator.
 *
 * @author Rishit
 * @ClassName "Validator"
 */
public class Validator {

    /**
     * Checks if is email valid.
     *
     * @param email the email
     * @return true, if is email valid
     */
    public static boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return email != null && email.matches(regex);
    }

    /**
     * Checks if is phone valid.
     *
     * @param phone the phone
     * @return true, if is phone valid
     */
    public static boolean isPhoneValid(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    /**
     * Checks if is aadhar valid.
     *
     * @param aadhar the aadhar
     * @return true, if is aadhar valid
     */
    public static boolean isAadharValid(String aadhar) {
        return aadhar != null && aadhar.matches("\\d{12}");
    }

    /**
     * Checks if is pan valid.
     *
     * @param pan the pan
     * @return true, if is pan valid
     */
    public static boolean isPanValid(String pan) {
        return pan != null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    }
}
