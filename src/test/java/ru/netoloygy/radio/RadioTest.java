package ru.netoloygy.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RadioTest {
    @Test
    public void shouldSetRadioStationCorrect() {
        Radio radio = new Radio();
        for (int i = radio.getMinRadioStation(); i <= radio.getMaxRadioStation(); i++) {                      // тестируем диапазон каналов, покрывающий разрешенные значения
            radio.setCurrentRadioStation(i);
            int expected = i;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void shouldSetRadioStationUnderMin() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(radio.getMinRadioStation() - 2);               // если передаем текущий канал больше максимального, то текущему каналу присвается "0".
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetRadioStationOverMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(radio.getMaxRadioStation() + 2);               // если передаем текущий канал больше максимального, то текущему каналу присвается "0".
        int expected = 0;
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeNextRadioStation() {
        Radio radio = new Radio();
        for (int i = radio.getMinRadioStation(); i < radio.getMaxRadioStation(); i++) {                               // тестируем диапазон каналов, в котором не требуется перескакивать между крайними значениями каналов
            radio.setCurrentRadioStation(i);
            radio.nextRadioStation();
            int expected = i + 1;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);

        }
    }

    @Test
    public void shouldChangeNextRadioStationFromMaxStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(radio.getMaxRadioStation());     // Текущий канал макисмальный, при перелистывании на слудеющий канал переходим на минимальный канал = "0"
        radio.nextRadioStation();
        int expected = radio.getMinRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldChangePreviousRadioStation() {
        Radio radio = new Radio();
        for (int i = radio.getMaxRadioStation(); i > radio.getMinRadioStation(); i--) {                     // тестируем диапазон каналов, в котором не требуется перескакивать между крайними значениями каналов
            radio.setCurrentRadioStation(i);
            radio.previousRadioStation();
            int expected = i - 1;
            int actual = radio.getCurrentRadioStation();
            Assertions.assertEquals(expected, actual);

        }
    }

    @Test
    public void shouldChangePreviousRadioStationFromMinStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(radio.getMinRadioStation());                // Текущий канал минимальный, при перелистывании на предыдущий канал переходим на максимальный канал = "9"
        radio.previousRadioStation();
        int expected = radio.getMaxRadioStation();
        int actual = radio.getCurrentRadioStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentRadioStation() {
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        Assertions.assertEquals(expected, actual);

    }

    // VOLUME
    @Test
    public void shouldChangeVolumeUp() {
        Radio radio = new Radio();
        for (int i = 0; i < radio.getMaxVolume(); i++) {                               // Тестируем увеличение громкости от [минимума до макисмума)
            radio.setCurrentVolume(i);
            radio.volumeUp();
            int expected = i + 1;
            int actual = radio.getCurrentVolume();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void shouldChangeVolumeUpFromMaxVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMaxVolume());     // Текущя громкость макисмум, приувеличении громкости ничего не должно происходить
        radio.volumeUp();
        int expected = radio.getMaxVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChangeVolumeDown() {
        Radio radio = new Radio();
        for (int i = radio.getMaxVolume(); i > 0; i--) {                     // Тестируем уменьшение громкости от [максимума до минимума)
            radio.setCurrentVolume(i);
            radio.volumeDown();
            int expected = i - 1;
            int actual = radio.getCurrentVolume();
            Assertions.assertEquals(expected, actual);

        }
    }

    @Test
    public void shouldChangeVolumeDownFromMinVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(radio.getMinVolume());                // Текущий канал минимальный, при перелистывании на предыдущий канал переходим на максимальный канал = "9"
        radio.volumeDown();
        int expected = radio.getMinVolume();
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCurrentVolume() {
        Radio radio = new Radio();
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeUpperMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetVolumeDownMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-2);
        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}