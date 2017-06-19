import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by user on 2017-06-19.
 */


public class Blackjack implements Serializable {

    public static void main(String[] args) {
        Backup backup = new Backup();// backup objects
        boolean isBackedup = false;// 저장된 게임인지 새로운 게임인지 저장
        Scanner scan = new Scanner(System.in);
        int money = 100; // Amount of money the user has.
        int bet; // Amount user bets on a game.
        boolean userWins; // Did the user win the game?

        System.out.println("블랙잭 게임을 시작합니다.");
        System.out.println();

        String scannedToken;// 입력받은 string을 저장하는 변수

        while (true) {
            System.out.println("You have " + money + " dollars.");
            do {

                // 예외처리: 사용자입력이 정수가 아닌 다른 type을 받는 경우

                while (true) {
                    System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
                    System.out.print("? ");
                    scannedToken = scan.next();// 사용자에게 문자열을 입력받음
                    try {
                        // 정수인 경우: 입력받은 문자열을 정수로 변환하여 bet에 저장하고 break
                        bet = Integer.parseInt(scannedToken);
                        break;
                    } catch (NumberFormatException e) {
                        // 입력받은 문자열이 정수가 아닌 경우
                        System.out.println("! Error: 입력이 잘못 되었습니다  (" + scannedToken + ")");
                    } finally {
                        System.out.println("! User input type has been checked");
                    }
                }

                if (bet < 0 || bet > money)
                    System.out.println("Your answer must be between 0 and " + money + '.');
            } while (bet < 0 || bet > money);
            if (bet == 0)
                break;
        }
    }

    static boolean playBlackjack(Backup getBackup, boolean isBackuped) throws InputMismatchException {
        return true;
    }

}