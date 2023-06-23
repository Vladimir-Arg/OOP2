package ru.netoloygy.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {
    @Test
    public void shouldSetRadioStationCorrect() {
        for (int i = 0; i <= 9; i++) {                      // тестируем диапазон каналов, покрывающий разрешенные значения
            Radio radio = new Radio();
            radio.setCurrentRadioStation(i);
            int expected = i;
            int actual = radio.currentRadioStation;
            Assertions.assertEquals(expected, actual);
        }
    }
    @Test
    public void shouldSetRadioStationUnderMin() {
            Radio radio = new Radio();
            radio.setCurrentRadioStation(-2);               // если передаем текущий канал больше максимального, то текущему каналу присвается "0".
                int expected = 0;
                int actual = radio.currentRadioStation;
                Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetRadioStationOverMax() {
            Radio radio = new Radio();
            radio.setCurrentRadioStation(12);               // если передаем текущий канал больше максимального, то текущему каналу присвается "0".
            int expected = 0;
            int actual = radio.currentRadioStation;
            Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeNextRadioStation() {
        for (int i = 0; i < 9; i++) {                               // тестируем диапазон каналов, в котором не требуется перескакивать между крайними значениями каналов
            Radio radio = new Radio();
            radio.setCurrentRadioStation(i);
            radio.nextRadioStation();
            int expected = i+1;
            int actual = radio.currentRadioStation;
            Assertions.assertEquals(expected, actual);

        }
    }
    @Test
    public void shouldChangeNextRadioStationFromMaxStation() {
            Radio radio = new Radio();
            radio.setCurrentRadioStation(radio.maxRadioStation);     // Текущий канал макисмальный, при перелистывании на слудеющий канал переходим на минимальный канал = "0"
            radio.nextRadioStation();
            int expected = 0;
            int actual = radio.currentRadioStation;
            Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldChangePreviousRadioStation() {
        for (int i = 1; i <= 9; i++) {                     // тестируем диапазон каналов, в котором не требуется перескакивать между крайними значениями каналов
            Radio radio = new Radio();
            radio.setCurrentRadioStation(i);
            radio.previousRadioStation();
            int expected = i-1;
            int actual = radio.currentRadioStation;
            Assertions.assertEquals(expected, actual);

        }
    }
    @Test
    public void shouldChangePreviousRadioStationFromMinStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);                // Текущий канал минимальный, при перелистывании на предыдущий канал переходим на максимальный канал = "9"
        radio.previousRadioStation();
        int expected = 9;
        int actual = radio.currentRadioStation;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentRadioStation(){
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

    }


    // VOLUME
    @Test
    public void shouldChangeVolumeUp() {
        for (int i = 0; i < 100; i++) {                               // Тестируем увеличение громкости от [минимума до макисмума)
            Radio radio = new Radio();
            radio.setCurrentVolume(i);
            radio.volumeUp();
            int expected = i+1;
            int actual = radio.currentVolume;
            Assertions.assertEquals(expected, actual);
        }
    }
    @Test
    public void shouldChangeVolumeUpFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.maxVolume);     // Текущя громкость макисмум, приувеличении громкости ничего не должно происходить
        radio.volumeUp();
        int expected = radio.maxVolume;
        int actual = radio.currentVolume;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeVolumeDown() {
        for (int i = 100; i > 0; i--) {                     // Тестируем уменьшение громкости от [максимума до минимума)
            Radio radio = new Radio();
            radio.setCurrentVolume(i);
            radio.volumeDown();
            int expected = i-1;
            int actual = radio.currentVolume;
            Assertions.assertEquals(expected, actual);

        }
    }
    @Test
    public void shouldChangeVolumeDownFromMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.minVolume);                // Текущий канал минимальный, при перелистывании на предыдущий канал переходим на максимальный канал = "9"
        radio.volumeDown();
        int expected = radio.minVolume;
        int actual = radio.currentVolume;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentVolume(){
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeUpperMax(){
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldSetVolumeDownMin(){
        Radio radio = new Radio();
        radio.setCurrentVolume(-2);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }



}