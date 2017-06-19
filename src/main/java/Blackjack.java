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

        System.out.println();

        String scannedToken;// 입력받은 string을 저장하는 변수
        System.out.println(); // 구분

        while (true) { // 무한 반복문
            int userInput = -1; // 처음 input값 초기화
            System.out.println("저장된 게임을 불러오시겠습니까?");
            System.out.println("새 게임시작(0), 불러오기(1)");
            scannedToken = scan.next(); // Token 받아오기


            try {
                userInput = Integer.parseInt((scannedToken));
            } catch (NumberFormatException e) {
                // 입력받은 문자열이 정수가 아닌 경우
            }

            if (userInput != 0 && userInput != 1) { // 두 번째 if문
                System.out.println("!Error: 0 또는 1을 입력 해야합니다. " + userInput);
                continue; // 계속
            } else {
                isBackedup = (userInput != 0);
                break; // while문 탈출
            }
        }

        if (isBackedup) {
            try {
                FileInputStream fis = new FileInputStream("BackupFile"); //파일 불러오기
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
        } else {
            money = 100;
        }


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

            // 예외처리1
            while (true) {
                try {
                    backup.storedMoney = money;
                    userWins = playBlackjack(backup, isBackedup);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("! Error: 입력이 잘못 되었습니다 ");
                    System.out.println("! 새로운 카드를 처음부터 재배포합니다");
                }
            }
            //user가 이길시 예외처리
            if (userWins)
                try {
                    money = money + bet;
                    if (money < 0) {
                        throw new ArithmeticException();// throws ArithmeticException
                    }
                } catch (ArithmeticException e) {
                    System.out.println();
                    System.out.println("! Warning : You have reached maximum money to won");
                    System.out.println();
                    System.out.println("***********************************************");
                    System.out.println("*! congratulation!! you have broke the dealer!!*");
                    System.out.println("***********************************************");
                    System.out.println();
                    System.out.println("You leave with $" + Integer.MAX_VALUE + '.');
                    System.exit(0);
                }
            else
                money = money - bet;
            //백업 및 money 0일 때 종료
            backup.storedMoney = money;
            System.out.println();
            if (money == 0) {
                System.out.println("Looks like you've are out of money!");
                break;
            }
        }
        //조건 break시 최종 돈 출력
        System.out.println();
        System.out.println("You leave with $" + money + '.');

    }


    static boolean playBlackjack(Backup getBackup, boolean isBackuped) throws InputMismatchException {
        Deck deck;
        BlackjackHand dealerHand;
        BlackjackHand userHand;

        if(isBackuped){
            deck = getBackup.storedDeck;
            dealerHand = getBackup.storedDealerHand;
            userHand = getBackup.storedUserHand;
        }
        else{
            deck = new Deck();
            dealerHand = new BlackjackHand();
            userHand = new BlackjackHand();
            deck.shuffle();
        }
        DealCard(dealerHand,userHand,deck);

        if(dealerHand.getBlackjackValue() == 21){
            Blackjack_CardInfo(dealerHand,userHand);
            System.out.println("Dealer is BlackJack, Dealer win");
            return false;
        }
        if(userHand.getBlackjackValue() == 21){
            Blackjack_CardInfo(dealerHand,userHand);
            System.out.println("You are BlackJack, You win");
            return true;
        }

        while(true){
            Scanner scan = new Scanner(System.in);

            for(int i = 0; i < userHand.getCardCount(); i++)
                System.out.println(userHand.getCard(i) + "      ");

            System.out.println("Your total is "+userHand.getBlackjackValue());
            System.out.println();
            System.out.println("Dealer is showing the "+dealerHand.getCard(0));
            System.out.println();
            System.out.println("Hit (1), Stand(2) or Store & Quit(3) ? ");

            int userAction;

            do{
                userAction = scan.nextInt();
                if(userAction != 1 && userAction != 2 && userAction != 3){
                    System.out.println("Please respond 1, 2 or 3");
                }
            }while(userAction != 1 && userAction != 2 && userAction != 3);
            if (userAction == 3) {                  //if userAction ==3,
                getBackup.storedDealerHand = dealerHand;
                getBackup.storedUserHand = userHand;
                getBackup.storedDeck = deck;
                try {
                    FileOutputStream fos = new FileOutputStream("BackupFile");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(getBackup);
                    oos.close();
                    fos.close();
                    System.out.println("!알림: 게임이 저장되었습니다.");
                    System.out.println("저장된 당신의 돈  : $" + getBackup.storedMoney + '.');
                } catch (Exception e) {
                    System.out.println("!Fetal Error: File out failed");
                }
                System.exit(0);

            } else if (userAction == 2) {
                // Loop ends; user is done taking cards.
                break;
            }else { // userAction is 'H'. Give the user a card.
                // If the user goes over 21, the user loses.
                Card newCard = deck.dealCard();
                userHand.addCard(newCard);
                System.out.println();
                System.out.println("User hits.");
                System.out.println("Your card is the " + newCard);
                System.out.println("Your total is now " + userHand.getBlackjackValue());
                if (userHand.getBlackjackValue() > 21) {
                    System.out.println();
                    System.out.println("You busted by going over 21.  You lose.");
                    System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                    return false;
                }
            }
        }   //end while loop
        return true;
    }

    private static void DealCard(BlackjackHand dealerHand, BlackjackHand userHand,Deck deck) {
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
    }

    private static void Blackjack_CardInfo(BlackjackHand dealerHand, BlackjackHand userHand){
        System.out.println("Dealer has the "+ dealerHand.getCard(0) +" and the "+dealerHand.getCard(1));
        System.out.println("User has the "+ userHand.getCard(0) +" and the "+userHand.getCard(1));
    }
}
