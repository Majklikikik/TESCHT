package michaelstanek.tescht;

/**
 * Created by Michael on 08.04.2016.
 */
public class Field {
    private Ship ships[][];
    private int shipsSet[];//contains the number of ships of a certain size set
    private int MaxShips[];//Number of ships of a certain size you can set 0=length 5, 3=length 2
    private byte field[][];//Array, telling whether a cell is occupied by a ship
    private byte hitfield[][]; //Array, telling wether a cell has been hit and whether there was a ship

    public void setShip(int row, int column, int isVertical) {

    }

    public byte[][] getField() {
        return this.field;
    }

    private int max(int Array[]) {
        int a = Array[0];
        int i = 0;
        for (i = 0; i <= Array.length - 1; i++) if (Array[i] > a) a = Array[i];
        return a;
    }

    public byte[][] getHitfield() {
        return this.hitfield;
    }

    public Field(int MaxShips[]) {
        this.MaxShips=MaxShips;
        ships = new Ship[4][max(MaxShips)];
        //in the field: 0 means empty, 1 means occupied, 2 means not a valid field (=not in the period system)
        byte f[][] = {
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}
        };
        this.field = f;
        byte hf[][] = {// as field, but here 0 means not shot, 1 hit, 2 not valid, 3 miss
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}
        };
        this.hitfield = hf;
        this.shipsSet=new int[4];
        this.shipsSet[0]=0;
        this.shipsSet[1]=0;
        this.shipsSet[2]=0;
        this.shipsSet[3]=0;

    }
    public void setMaxShips(int MaxShips[]){
        this.ships = new Ship[4][max(MaxShips)];
    }
    public Field() {

        //in the field: 0 means empty, 1 means occupied, 2 means not a valid field (=not in the period system)
        byte f[][] = {
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}
        };
        this.field = f;
        byte hf[][] = {// as field, but here 0 means not shot, 1 hit, 2 not valid, 3 miss
                {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2}
        };
        this.hitfield = hf;
    }
    public boolean checklost(){
        if (!this.checkFilled()) return false;
        for (int i=0;i<=3;i++) for (int j=0; j<=shipsSet[i]-1;j++)
            if (!ships[i][j].isSunk()) return false;
        return true;
    }
    public boolean setShip(int length, int row, int column, boolean isVertical) {
        if ((field[row][column] == 2)|| ((isVertical) && (row + length > 9)) || ((!isVertical) && (column + length > 18)) || ((isVertical) && (field[row + length - 1][column] == 2)) || ((!isVertical) && (field[row][column + length - 1] == 2)) )
            return false;
        int i;
        int j;
        int k;
        {
            for (i = 0; i <= length - 1; i++)
                for (j = 0; j <= 3; j++)
                    for (k = 0; k <= shipsSet[j] - 1; k++) {
                        if (isVertical) {
                            if (ships[j][k].occupiedCheck(row + i, column)) return false;
                        } else {
                            if (ships[j][k].occupiedCheck(row, column + i)) return false;
                        }
                    }
        }
        ships[length - 2][shipsSet[length - 2]] = new Ship(length,row,column,isVertical);
        shipsSet[length - 2]++;
        for (i = 0; i <= length - 1; i++) {
            if (!isVertical) {
                field[row][column + i] = 1;
            } else {
                field[row + i][column] = 1;
            }
        }
        return true;
    }
    public boolean hit(int row, int column){
        if (this.field[row][column]!=1) return false;
        int i,j,k;
        for (j = 0; j <= 3; j++)
            for (k = 0; k <= shipsSet[j] - 1; k++) {
                if (ships[j][k].hitCheck(row, column)) {
                    // MAYBE SHOW SHIP SUNK ANIMATION HERE
                    return true;
                }
            }
        return false;
    }
    public byte getField(int row, int column){
        return this.field[row][column];
    }
    public int MaxShip()[]{ return this.MaxShips;}
    boolean checkFilled() {
        for (int i = 0; i <= 3; i++) if (shipsSet[i] != MaxShips[i])return false;
        return true;
    }
}
