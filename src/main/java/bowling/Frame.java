package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Score> scores;
    private int pitchingCount;

    private Frame(Score score) {
        scores = new ArrayList<>(2);
        scores.add(score);
        pitchingCount = 1;
    }

    public static Frame firstPitch(Score score) {
        return new Frame(score);
    }

    public void scoundPitch(Score score) {
        pitchingCount++;
        scores.add(score);
        if (scores.stream().mapToInt(Score::getPoint).sum() > 10){
            throw new IllegalArgumentException("한 프레임에 10점을 초과하는 점수를 가질수 없습니다. ");
        }
    }

    public boolean hasNext() {
        if (pitchingCount == 2) {
            return false;
        }

        return scores.get(0).hasNext();
    }

    public boolean isStrike() {
        if (pitchingCount == 2) {
            return false;
        }

        return scores.get(0).isStrike();
    }

    public boolean isSpare() {
        if (pitchingCount == 2 && scores.stream().mapToInt(Score::getPoint).sum() == 10) {
            return true;
        }
        return false;
    }

    public String getPrint() {
        if(isStrike()){
            return "X";
        }

        if (isSpare()){
            return scores.get(0).getPoint() + "|/";
        }

        if (pitchingCount == 1){
            return String.valueOf(scores.get(0).getPoint());
        }

        if (pitchingCount == 2){
            return scores.get(0).printScore() + "|" + scores.get(1).printScore();
        }
        throw new IllegalArgumentException("Error");
    }
}
