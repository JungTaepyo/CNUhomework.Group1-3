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
        int money = 100; // 처음 돈 초기화
        int bet; // 베팅 금액
        boolean userWins; // 얼마나 이겼는지 확인

        System.out.println("블랙잭 게임을 시작합니다.");
        System.out.println(); // 구분

        String scannedToken;// 입력받은 string을 저장하는 변수

        while (true) { // 무한 반복문
            int userInput = -1; // 처음 input값 초기화
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

        if(isBackedup) {
            try {
                FileInputStream fis = new FileInputStream("BackupFile");
                ObjectInputStream ois = new ObjectInputStream(fis);
                backup = (Backup) ois.readObject();
                ois.close();
                fis.close();
                System.out.println("저장된 게임을 불러왔습니다.");
            } catch (Exception e) {
                System.out.println("에러발생 !");
                e.printStackTrace();
            }
            money = backup.storedMoney;
        }else{
            money = 100;
            }

        }
    }

    static boolean playBlackjack(Backup getBackup, boolean isBackuped) throws InputMismatchException {
        return true;
    }

}