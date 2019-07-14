package bowling;

public class Score {
    private int point;

    private Score(int point) {
        if (point > 10){
            throw new IllegalArgumentException("point는 10보다 클수 없습니다.");
        }
        this.point = point;
    }

    public static Score of(int point) {
        return new Score(point);
    }

    public boolean hasNext() {
        if (point == 10){
            return false;
        }
        return true;
    }

    public boolean isStrike() {
        if (point == 10){
            return true;
        }
        return false;
    }

    public int getPoint() {
        return point;
    }

    public boolean isGutter() {
        if (point == 0){
            return true;
        }
        return false;
    }

    public String printScore() {
        if (isGutter()){
            return "-";
        }
        return String.valueOf(point);
    }
}
