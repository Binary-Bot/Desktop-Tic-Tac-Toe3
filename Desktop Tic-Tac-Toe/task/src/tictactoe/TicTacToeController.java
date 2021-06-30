package tictactoe;

public class TicTacToeController{
    private  TicTacToeView view;
    private TicTacToeModel model;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
    }
}
