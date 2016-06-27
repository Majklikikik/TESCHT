package michaelstanek.tescht;

/**
 * Created by Michael on 08.04.2016.
 */
public class Ship {
    private boolean parthit[]; //ist ein jeweiliges Feld getroffen?
    private boolean sunk; //ist das schiff gesunken?
    private int row; //reihe des oberen Endpunktes
    private int column; //reihe des linken Endpunktes
    private boolean isVertical; //ist es vertikal? wenn false, ist es horizontal angeordnet.
    private int length;
    public Ship(int length, int row, int column, boolean isVertical){  //Konstruktor mit länge des schiffes, koordinaten eines Endpunktes
        this.parthit=new boolean[length];                                   // und boolean, obe es vertikal oder horizontal angeordnet ist
        int i;
        for (i=0;i<=length-1;i++) this.parthit[i]=false;
        this.row=row;
        this.column=column;
        this.sunk=false;
        this.isVertical=isVertical;
        this.length=length;
    }
    public boolean hitCheck(int row, int column){   //funktion, die versucht ein Schiff zu treffen
        int i;
        if (isVertical) {
            if (this.column==column) for (i=0;i<=this.length-1;i++){
                if (row==this.row+i) {
                    this.parthit[i]=true;
                    this.checkSunk();
                    return true;
                }
            }
        }
        else
        if (this.row==row) for (i=0;i<=this.length-1;i++){
            if (column==this.column+i) {
                this.parthit[i]=true;
                this.checkSunk();
                return true;
            }
        } return false;
    }
    public boolean occupiedCheck(int row, int column){
        int i;
        int j;
        for (j=-1;j<=1;j++){
            if (isVertical) {
                if (this.column==column+j) for (i=0;i<=this.length-1;i++){
                    return true;
                }
            }
            else
            if (this.row==row+j) for (i=0;i<=this.length-1;i++) {
                if (column == this.column + i) return true;
            }


        }
        if (isVertical){if ((this.column==column)&&((this.row-1==row)||(this.row+length==row))) return true;}else{
            if ((this.row==row)&&((this.column-1==column)||(this.column+length==column))) return true;
        }
        return false;
    }
    public void checkSunk(){int i;  //funktion, die aktualisiert, ob das Schiff versunken ist
        this.sunk=true;
        for (i=0;i<=length-1;i++)
            if (!this.parthit[i]) this.sunk=false;
    }
    public boolean isSunk(){ return this.sunk;}  //returned, ob das Schiff versunken ist
}