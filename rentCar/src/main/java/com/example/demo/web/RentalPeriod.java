package com.example.demo.web;

public class RentalPeriod {
    private String begin;
    private String end;

    public RentalPeriod() {}

    public RentalPeriod(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    public String getBegin() { return begin; }
    public void setBegin(String begin) { this.begin = begin; }

    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }
}
