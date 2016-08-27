package com.tonny.sort.test_1_1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonny on 2016/8/11.
 */
public class Test_1_1_21 {

    public static void main(String[] args) {

        List<Row> rows = new ArrayList<Row>();
        while (StdIn.hasNextLine()){
            String s = StdIn.readLine();
            String[] split = s.split(" ");
            String name = split[0];
            int score1 = Integer.parseInt(split[1]);
            int score2 = Integer.parseInt(split[2]);
            rows.add(new Row(name,score1,score2));
        }
        for (Row row : rows) {
            float per = row.getScore1()/row.getScore2();
            StdOut.printf("%-10s%-10d%-10d%-10.3f", row.getName(), row.getScore1(),row.getScore2(),per);
            StdOut.println();
        }
    }

    static class Row{
        private String name;
        private int score1;
        private int score2;

        public Row(String name, int score1, int score2) {
            this.name = name;
            this.score1 = score1;
            this.score2 = score2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore1() {
            return score1;
        }

        public void setScore1(int score1) {
            this.score1 = score1;
        }

        public int getScore2() {
            return score2;
        }

        public void setScore2(int score2) {
            this.score2 = score2;
        }
    }
}
