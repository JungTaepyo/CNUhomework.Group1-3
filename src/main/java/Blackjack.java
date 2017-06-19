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

        System.out.println("Welcome to the game of blackjack.");
        System.out.println();

        String scannedToken;// 입력받은 string을 저장하는 변수
        System.out.println("저장한 게임을 불러오겠습니까?");
        System.out.println("새 게임시작(0), 불러오기(1)");

        System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");

        System.out.println("! Error: 입력이 잘못 되었습니다 ");
        System.out.println("! 새로운 카드를 처음부터 재배포합니다");

        System.out.println();
        System.out.println("! Warning : You have reached maximum money to won");
        System.out.println();
        System.out.println("***********************************************");
        System.out.println("*! congratulation!! you have broke the dealer!!*");
        System.out.println("***********************************************");
        System.out.println();
        System.out.println("You leave with $" + Integer.MAX_VALUE + '.');

        while (true) {
            System.out.println("You have " + money + " dollars.");
            return;
        }

    } // end main()

    static boolean playBlackjack(Backup getBackup, boolean isBackuped) throws InputMismatchException {
        Deck deck = null;
        BlackjackHand dealerHand = null;
        BlackjackHand userHand = null;

        if(isBackuped){
            deck = getBackup.storedDeck;
            dealerHand = getBackup.storedDealerHand;
            userHand = getBackup.storedUserHand;
        }
        else{
            deck = new Deck();
            dealerHand = new BlackjackHand();
            userHand = new BlackjackHand();
        }
        return true;
    }

}