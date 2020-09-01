package homework.riddle_game;

public class Main {
    public static void main(String[] args) {
        RiddleGame riddleGameForOlya = new RiddleGame(10, "Olya");
        RiddleGame riddleGameForKatya = new RiddleGame(10, "Katya");
        RiddleGame riddleGameForMasha = new RiddleGame(10, "Masha");

        riddleGameForOlya.play();
        riddleGameForKatya.play();
        riddleGameForMasha.play();

        RiddleGame.printResults();
    }
}
