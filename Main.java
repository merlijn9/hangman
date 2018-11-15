import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] guesses = {"school", "hangman", "magnetron", "laptop", "programmeren", "talen"};


        boolean aanHetSpelen = true;
        while (aanHetSpelen) {
            System.out.println("Welkom in hangman");
            char[] randomWoord = guesses[random.nextInt(guesses.length)].toCharArray(); //toCharArray = bijv. school --> s,c,h,o,o,l  random.nextInt(guesses.length)
            int amountOfGuesses = randomWoord.length;
            char[] aantalLetters = new char[amountOfGuesses]; //_ _ _ _

            for (int i = 0; i < aantalLetters.length; i++) {
                aantalLetters[i] = '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;

            while (amountOfGuesses <= 10 && amountOfGuesses > 0) {
                System.out.print("Geraden letters ");
                printArray(aantalLetters);
                System.out.printf("Je kan nog %d raden\n", amountOfGuesses);
                amountOfGuesses--;
                System.out.println("Vul een letter in");
                char input = scanner.nextLine().charAt(0); //neemt eerste character van letter of woord
                tries++;

                if (input == '-') {
                    aanHetSpelen = false;
                    wordIsGuessed = true;
                } else {
                    for (int i = 0; i < randomWoord.length; i++) {
                        if (randomWoord[i] == input) {
                            aantalLetters[i] = input;
                        }
                    }

                    if (isTheWordGuessed(aantalLetters)) {
                        wordIsGuessed = true;
                        System.out.println("Congratulations, you won!");
                    }
                }
            }

            if (!wordIsGuessed) System.out.println("Je hebt verloren :/");
            System.out.println("Nog een keertje? (ja/nee)");
            String anotherGame = scanner.nextLine();
            if (anotherGame.equals("nee")) aanHetSpelen = false;
            if (anotherGame.equals("ja")) aanHetSpelen = true;

        }


        System.out.println("Game over.");
    }



    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') return false;
        }
        return true;

    }
}