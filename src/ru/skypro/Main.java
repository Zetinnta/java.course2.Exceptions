package ru.skypro;

import ru.skypro.exceptions.WrongLoginOrPasswordException;
import ru.skypro.exceptions.WrongPasswordException;

public class Main {

    public static void main(String[] args) {
        String login = "java_skypro_Shatoshi";
        String password = "plusUltra_1000";
        String confirmPassword = "plusUltra_1000";

        System.out.println(checkUser(login, password, confirmPassword));
    }

    public static boolean checkUser(String login, String password, String confirmPassword) {
        try {
            checkUserData(login, password, confirmPassword);
        } catch (WrongLoginOrPasswordException exception) {
            System.out.println("Login/Password should only contain letters, numbers or underscores and also have less than (or even) 20 characters.");
            return false;
        } catch (WrongPasswordException exception) {
            System.out.println("Passwords should match and only then you can proceed.");
            return false;
        } finally {
            System.out.println("Verification completed.");
        }
        return true;
    }

    public static void checkUserData(String login, String password, String confirmPassword) throws WrongLoginOrPasswordException, WrongPasswordException {
        if (!(isValid(login))) {
            throw new WrongLoginOrPasswordException();
        }
        if (!(isValid(password))) {
            throw new WrongLoginOrPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }

    public static boolean isValid(String line) {
        return (line != null && line.matches("[a-zA-Z0-9_]+") && line.length() >= 1 && line.length() <= 20);
    }
}

