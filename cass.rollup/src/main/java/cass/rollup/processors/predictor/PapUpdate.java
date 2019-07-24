package cass.rollup.processors.predictor;

import org.stjs.javascript.Array;

public class PapUpdate {

    private int index;
    private Array<Integer> visited;
    private double change;
    private boolean positive;

    public PapUpdate(int index, double change, boolean positive) {
        this.index = index;
        this.change = change;
        this.visited = new Array<Integer>();
        this.positive = positive;
    }

    public boolean hasVisited(int index) {
        for (int i=0;i<visited.$length();i++) {
            if (visited.$get(i).intValue() == index) return true;
        }
        return false;
    }

    public PapUpdate updateChild(int index, double change) {
        PapUpdate res = new PapUpdate(index, change, positive);
        res.setVisited(cloneVisited());
        res.getVisited().push(index);
        return res;
    }

    public String toString() {
        String sign = positive ? "+" : "-";
        return "<update "+index+" | "+sign+change+">";
    }

    public int compare(PapUpdate other){
        double diff = change - other.getChange();
        if (diff < 0) return 1;
        if (diff > 0) return -1;
        return 0;
    }

    private Array<Integer> cloneVisited() {
        Array<Integer> newVis = new Array<Integer>();
        //Integer newI;
        for (int i=0;i<visited.$length();i++) {
            //newI = new Integer(visited.$get(i));
            //newVis.push(newI);
            newVis.push(visited.$get(i));
        }
        return newVis;
    }

    public int getIndex() {return index;}
    public void setIndex(int index) {this.index = index;}

    public Array<Integer> getVisited() {return visited;}
    public void setVisited(Array<Integer> visited) {this.visited = visited;}

    public double getChange() {return change;}
    public void setChange(double change) {this.change = change;}

    public boolean getPositive() {return positive;}
    public void setPositive(boolean positive) {this.positive = positive;}
}
