/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex005;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author franz
 */
public class Measurement {
    private LocalDate datum;
    private LocalTime uhrzeit;
    private String kennzeichen;
    private int gemessen;
    private int erlaubt;
    private int uebertretung;

    public Measurement(LocalDate datum, LocalTime uhrzeit, String kennzeichen, int gemessen, int erlaubt)
    {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
        this.uebertretung = gemessen - erlaubt;
    }

    public LocalDate getDatum()
    {
        return datum;
    }

    public LocalTime getUhrzeit()
    {
        return uhrzeit;
    }

    public String getKennzeichen()
    {
        return kennzeichen;
    }

    public int getGemessen()
    {
        return gemessen;
    }

    public int getErlaubt()
    {
        return erlaubt;
    }

    public int getUebertretung()
    {
        return uebertretung;
    }
}
