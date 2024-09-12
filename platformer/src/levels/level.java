package levels;

public class level {
    private int[][] lvldata;
    public level(int[][] lvldata) {
        this.lvldata = lvldata;

    }
    public int getspriteindex(int x, int y) {
        return lvldata[y][x];
    }
    public int[][] getLvldata() {
        return lvldata;
    }
}
