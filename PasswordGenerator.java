import java.util.Random;

// Password Generator Logic
// Backend for the Generator
public class PasswordGenerator {
    // Character pools for the randomizations
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    // Random class
    private final Random random;

    // Constructor
    public PasswordGenerator() {
        random = new Random();
    }

    // Takes the length of the password to be generated and if the options provided
    // should be included
    public String generatePassword(int length, boolean includeUpperase, boolean includeLowercase,
            boolean includeNumbers, boolean includeSpecialSymbols) {

        // String Builder used for efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        String validCharacters = "";

        if (includeUpperase)
            validCharacters += UPPERCASE_CHARACTERS;
        if (includeLowercase)
            validCharacters += LOWERCASE_CHARACTERS;
        if (includeNumbers)
            validCharacters += NUMBERS;
        if (includeSpecialSymbols)
            validCharacters += SPECIAL_SYMBOLS;

        // To build the password
        for (int i = 0; i < length; i++) {

            // Random index from the pool of valid characters
            int randomIndex = random.nextInt(validCharacters.length());

            char randomChar = validCharacters.charAt(randomIndex);

            // Store char in passsword builder
            passwordBuilder.append(randomChar);
        }
        // Result is returned
        return passwordBuilder.toString();

    }

}
