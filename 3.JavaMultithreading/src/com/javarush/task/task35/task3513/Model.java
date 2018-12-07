package com.javarush.task.task35.task3513;

import java.util.*;

// будет содержать игровую логику и хранить игровое поле
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    //для реализации возврата хода
    private Stack<Integer> previousScores = new Stack<>();
    private Stack<Tile[][]> previousStates = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    // метод инициализации начального игрового поля с дефаулт доступом (в классе и внутри пакета)
    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 0;
    }

    // метод для заполнения случайной пустой плитки
    void addTile() {
        while (true) {
            // получаю список текущий пустых плиток
            List<Tile> listOfEmptyTiles = getEmptyTiles();
            // если список пустых плиток пуст, то метод вызван в неверном месте, завершаю его работу
            if (listOfEmptyTiles.isEmpty()) break;
            // случайный образом генерирую индекс плитки из списка
            int rndTileIndex = (int) ((Math.random() * listOfEmptyTiles.size()));
            Tile rndTile = listOfEmptyTiles.get(rndTileIndex);
            if (rndTile.value != 0) continue; // если выбранная плитка не пустая, то дострочно прекращаю круг
            // и начинаю следующий круг цикла
            rndTile.value = Math.random() < 0.9 ? 2 : 4; // назначаю значение выбранной плитке
            break; // если дошли сюда, то значение в плитке поменяли, прекращаю цикл
        }
    }

    // получение списка свободных плиток на игровом поле
    private List<Tile> getEmptyTiles() {
        List<Tile> list = new ArrayList<>();
        for (Tile[] tileArray : gameTiles) {
            for (Tile tile : tileArray) {
                if (tile.value == 0) {
                    list.add(tile);
                }
            }
        }
        return list;
    }

    // сжатие одного ряда влево
    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < 3; i++) {
            boolean needNextRound = false;
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    Tile tmp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = tmp;
                    needNextRound = true;
                    isChanged = true;
                }
            }
            if (!needNextRound) break;
        }
        return isChanged;
    }

    // сложение клеток
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int j = 0; j < 3; j++) {
            if (tiles[j].getValue() != 0 && tiles[j].getValue() == tiles[j + 1].getValue()) {
                tiles[j].setValue(tiles[j].getValue() * 2);
                tiles[j + 1].setValue(0);
                if (tiles[j].getValue() > maxTile) maxTile = tiles[j].getValue();
                score += tiles[j].getValue();
                isChanged = true;
            }
        }

        if (isChanged) {
            for (int j = 0; j < 3; j++) {
                if (tiles[j].getValue() == 0 && tiles[j + 1].getValue() != 0) {
                    Tile tmp = tiles[j];
                    tiles[j] = tiles[j + 1];
                    tiles[j + 1] = tmp;
                }
            }
        }
        return isChanged;
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            // используется | а не || что бы оба операнда отработали
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) isChanged = true;
        }
        if (isChanged) addTile();
        isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void down() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    private void rotate() {
        int len = FIELD_WIDTH;
        for (int k = 0; k < len / 2; k++) // outer layer
        {
            for (int j = k; j < len - 1 - k; j++) // left -> right
            {
                Tile tmp = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][len - 1 - k];
                gameTiles[j][len - 1 - k] = gameTiles[len - 1 - k][len - 1 - j];
                gameTiles[len - 1 - k][len - 1 - j] = gameTiles[len - 1 - j][k];
                gameTiles[len - 1 - j][k] = tmp;
            }
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    // проверка возможности хода
    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }

        for (int j = 0; j < gameTiles.length; j++) {
            for (int i = 1; i < gameTiles.length; i++) {
                if (gameTiles[i][j].value == gameTiles[i - 1][j].value)
                    return true;
            }
        }
        return false;
    }

    // сохраняет состояние в стек
    private void saveState(Tile[][] field) {
        // создаю массив для глубокого копирования размером с переданный параметром
        Tile[][] fieldToSave = new Tile[field.length][field[0].length];
        // циклом обхожу новый массив
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                // создаю новые объекты Tile для каждой ячейки, и значеним value
                // передаю туда анналогичное из массива переданного в параметре метода
                fieldToSave[i][j] = new Tile(field[i][j].getValue());
            }
        }
        previousStates.push(fieldToSave);
        int scoreToSave = score;
        previousScores.push(scoreToSave);
        isSaveNeeded = false;
    }

    // метод будет устанавливать текущее игровое состояние равным последнему находящемуся в стеках с помощью метода pop
    public void rollback() {
        // делаю проверки, что стеки не пусты прежде чем возращать значения
        if (!previousStates.isEmpty()) gameTiles = previousStates.pop();
        if (!previousScores.isEmpty()) score = previousScores.pop();
    }

    // метод генерирует ход в случайном направлении
    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    boolean hasBoardChanged() {
        Tile[][] prevState = previousStates.peek();
        int prevSum = 0;
        int currentSum = 0;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                prevSum += prevState[i][j].getValue();
                currentSum += gameTiles[i][j].getValue();
            }
        }
        return prevSum != currentSum;
    }

    MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        } else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    // реализация выбора эффективного хода из возможных
    public void autoMove() {
        // очередь с сортировкой в обратном порядке
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue(4, Collections.reverseOrder());
        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));
        Move move = queue.peek().getMove();
        move.move();
    }
}