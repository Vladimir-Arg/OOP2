package ru.netoloygy.radio;
public class Radio {
    public int currentRadioStation;
    public int minRadioStation = 0;
    public int maxRadioStation = 9;
    public Radio(){

    }
    public Radio (int stationCount){
        maxRadioStation = stationCount -1;
    }
    public int getCurrentRadioStation() {
        return currentRadioStation;
    }
    public int getMaxRadioStation() {
        return maxRadioStation;
    }
//    public void setMaxRadioStation(int newMaxRadioStation){
//        if (newMaxRadioStation <=0) {
//            maxRadioStation = 9;
//        }
//        if (newMaxRadioStation > 0){
//            maxRadioStation = newMaxRadioStation-1;
//        }
//    }
    public void setCurrentRadioStation(int newCurrentRadioStation){
        if (newCurrentRadioStation < minRadioStation) {
            return;
        }
        if (newCurrentRadioStation > maxRadioStation) {
            return;
        }
        currentRadioStation = newCurrentRadioStation;
    }
    public void nextRadioStation(){
        if (currentRadioStation < maxRadioStation) {
            currentRadioStation++;
        }
        else {
            currentRadioStation = minRadioStation;
        }
    }
    public void previousRadioStation(){
        if (currentRadioStation > minRadioStation) {
            currentRadioStation--;
        }
        else  {
            currentRadioStation = maxRadioStation;
        }

    }
    public int minVolume = 0;
    public int maxVolume = 100;
    public int currentVolume;
    public int getCurrentVolume() {
        return currentVolume;
    }
    public void setCurrentVolume(int newCurrentVolume){
        if (newCurrentVolume < minVolume) {
            return;
        }
        if (newCurrentVolume > maxVolume) {
            return;
        }
        currentVolume = newCurrentVolume;
    }
    public void volumeUp (){
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
        else {
            currentVolume = currentVolume;
        }
    }
    public void volumeDown(){
        if (currentVolume > minVolume) {
            currentVolume--;
        }
        else {
            currentVolume = currentVolume;
        }
    }
}