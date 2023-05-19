import java.util.Random;

public class PasswordGenerator {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}\\|;:'\",.<>/?";

    public static String generatePassword(int length) {
        String password = "";
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHABET.length() + SPECIAL_CHARACTERS.length());
            password += (index < ALPHABET.length()) ? ALPHABET.charAt(index) : SPECIAL_CHARACTERS.charAt(index - ALPHABET.length());
        }

        return password;
    }

    public static void main(String[] args) {
        System.out.println("How long should the password be?");
        int length = Integer.parseInt(System.console().readLine());

        String password = generatePassword(length);
        System.out.println("Your password is: " + password);

        System.out.println("Would you like to generate another password? (y/n)");
        String answer = System.console().readLine();
        boolean generateAnotherPassword = answer.equals("y");

        while (generateAnotherPassword) {
            password = generatePassword(length);
            System.out.println("Your new password is: " + password);

            System.out.println("Would you like to generate another password? (y/n)");
            answer = System.console().readLine();
            generateAnotherPassword = answer.equals("y");
        }
    }
}
