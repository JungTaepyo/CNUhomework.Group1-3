import org.codehaus.groovy.runtime.powerassert.SourceText;

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
            int userInput = -1;
            System.out.println("저장된 게임을 불러오시겠습니까?");
            System.out.println("새 게임시작(0), 불러오기(1)");
            scannedToken = scan.next();


            try {
                userInput = Integer.parseInt((scannedToken));
            } catch (NumberFormatException e) {
                // 입력받은 문자열이 정수가 아닌 경우
            }

            if (userInput != 0 && userInput != 1) {
                System.out.println("!Error: 0 또는 1을 입력 해야합니다. " + userInput);
                continue;
            } else {
                isBackedup = (userInput != 0);
                break;
            }
        }

        if(isBackedup){
            try{
                FileInputStream fis = new FileInputStream("BackupFile");
            }catch (Exception e) {

            }
                money = 100;
            }

        }
    }

    static boolean playBlackjack(Backup getBackup, boolean isBackuped) throws InputMismatchException {
        return true;
    }

}