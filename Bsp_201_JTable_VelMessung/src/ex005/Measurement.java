/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex005;

import java.time.LocalDateTime;

/**
 *
 * @author franz
 */
public class Measurement {
    private LocalDateTime ldt;
    private String kennzeichen;
    private int gemessen;
    private int erlaubt;

    public Measurement(LocalDateTime ldt, String kennzeichen, int gemessen, int erlaubt) {
        this.ldt = ldt;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public int getGemessen() {
        return gemessen;
    }

    public void setGemessen(int gemessen) {
        this.gemessen = gemessen;
    }

    public int getErlaubt() {
        return erlaubt;
    }

    public void setErlaubt(int erlaubt) {
        this.erlaubt = erlaubt;
    }
}
