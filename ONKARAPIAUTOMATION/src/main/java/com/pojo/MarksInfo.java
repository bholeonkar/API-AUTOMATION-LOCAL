package com.pojo;

public class MarksInfo {

	
	private int marathi;
    private int english;

    public int getMarathi() {
        return marathi;
    }

    public MarksInfo(int marathi, int english) {
        this.marathi = marathi;
        this.english = english;
    }

    public void setMarathi(int marathi) {
        this.marathi = marathi;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
}
