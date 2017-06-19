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
                //베팅금액 정함
            } while (true);
        }
    }

    static boolean playBlackjack(Backup getBackup, boolean isBackuped) throws InputMismatchException {
        return true;
    }

}