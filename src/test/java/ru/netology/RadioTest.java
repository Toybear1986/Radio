package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

  @Test
  public void shouldIncreaseVolume() {
    Radio volume = new Radio();
    volume.increaseVolume();

    int expected = 6;
    int actual = volume.getCurrentVolume();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldDecreaseVolume() {
    Radio volume = new Radio();
    volume.decreaseVolume();

    int expected = 4;
    int actual = volume.getCurrentVolume();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldNotDecreaseVolumeIfZero() {
    Radio volume = new Radio();
    volume.setMute();
    volume.decreaseVolume();

    int expected = 0;
    int actual = volume.getCurrentVolume();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldNotIncreaseVolumeIfMax() {
    Radio volume = new Radio();
    volume.setMaxVolume();
    volume.increaseVolume();

    int expected = 10;
    int actual = volume.getCurrentVolume();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldNotSetVolumeAboveMax() {
    Radio volume = new Radio();
    volume.setCurrentVolume(11);

    int expected = 5;
    int actual = volume.getCurrentVolume();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldNotSetVolumeBelowMin() {
    Radio volume = new Radio();
    volume.setCurrentVolume(-1);

    int expected = 5;
    int actual = volume.getCurrentVolume();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldSwitchToNextStation() {
    Radio station = new Radio();
    station.nextStation();

    int expected = 3;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldSwitchToPrevStation() {
    Radio station = new Radio();
    station.prevStation();

    int expected = 1;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldSwitchToMaxIfMin() {
    Radio station = new Radio();
    station.setMinStation();
    station.prevStation();

    int expected = 9;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldSwitchToMinIfMax() {
    Radio station = new Radio();
    station.setMaxStation();
    station.nextStation();

    int expected = 0;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldNotSwitchIfNumberAboveMax() {
    Radio station = new Radio();
    station.setCurrentStation(10);

    int expected = 2;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldNotSwitchIfNumberBelowMin() {
    Radio station = new Radio();
    station.setCurrentStation(-1);

    int expected = 2;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void shouldSetCorrectStation() {
    Radio station = new Radio();
    station.setCurrentStation(5);

    int expected = 5;
    int actual = station.getCurrentStation();

    Assertions.assertEquals(expected, actual);
  }
}