package lesson2.task1;

public enum Direction {
    RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);

    private final int zy;
    private final int zx;

    Direction(int zy, int zx) {
        this.zy = zy;
        this.zx = zx;
    }

    public int getZy() {
        return zy;
    }

    public int getZx() {
        return zx;
    }

    public static Direction nextDirection(Direction direction) {
        switch (direction) {
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case UP:
                return RIGHT;
            default:
                throw new IllegalArgumentException("Invalid enum param");
        }
    }
}
