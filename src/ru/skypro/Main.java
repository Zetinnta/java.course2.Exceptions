package ru.skypro;

import ru.skypro.exceptions.WrongLoginOrPasswordException;
import ru.skypro.exceptions.WrongPasswordException;

public class Main {

    public static void main(String[] args) {
        String[] userData = {"java_skypro_Shatoshi", "plusUltra_1000", "plusUltra_1000"}; //login, password, confirmPassword
        checkUser(userData);
    }

    public static void checkUser(String[] data) {
        boolean congrats = true;
        String login = data[0];
        String password = data[1];
        String confirmPassword = data[2];
        try {
            checkUserData(login, password, confirmPassword);
        } catch (WrongLoginOrPasswordException exception) {
            System.out.println("Login/Password should only contain letters, numbers or underscores and also have less than (or even) 20 characters.");
            congrats = false;
        } catch (WrongPasswordException exception) {
            System.out.println("Passwords should match and only then you are can proceed.");
            congrats = false;
        } finally {
            System.out.println("Verification completed. Result: " + "'" + congrats + "'.");
        }
    }

    public static void checkUserData(String login, String password, String confirmPassword) throws WrongLoginOrPasswordException, WrongPasswordException {
        if (!(isValid(login) && login.length() >= 1 && login.length() <= 20)) {
            throw new WrongLoginOrPasswordException();
        }
        if (!(isValid(password) && password.length() >= 1 && password.length() <= 20)) {
            throw new WrongLoginOrPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    public static boolean isValid(String line) {
        if (line == null) {
            return false;
        }
        for (int i = 0; i < line.length(); i++) {
            if (!(Character.isLetterOrDigit(line.charAt(i)) || line.charAt(i) == '_')) {
                return false;
            }
        }
        return true;
    }
}
