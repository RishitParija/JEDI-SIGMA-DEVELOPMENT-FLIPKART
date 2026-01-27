package com.flipfit.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 *
 * @author Shravya
 * @ClassName "UserNotFoundException"
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Instantiates a new user not found exception.
     *
     * @param message the message
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
