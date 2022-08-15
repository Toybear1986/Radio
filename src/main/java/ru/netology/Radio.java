package ru.netology;

import lombok.*;

@Getter
@Setter

public class Radio {
  static int maxVolume = 100;
  static int Mute = 0;
  static int minStation = 0;
  private int currentStation;
  private int currentVolume;
  final int maxStation;
  public int quantityOfStations;

  public Radio(int currentVolume, int currentStation, int quantityOfStations) {
    maxStation = quantityOfStations - 1;
    this.currentVolume = currentVolume;
    this.currentStation = currentStation;
  }

  public void increaseVolume() { //Увеличение громкости
    if (currentVolume < maxVolume) {
      ++this.currentVolume;
    }
    setCurrentVolume(currentVolume);
  }

  public void decreaseVolume() { //Уменьшение громкости
    if (currentVolume > Mute) {
      --this.currentVolume;
    }
    setCurrentVolume(currentVolume);
  }

  public void nextStation() { //Переключаем на следующую станцию
    if (currentStation < maxStation) {
      ++this.currentStation;
    } else {
      setCurrentStation(minStation);
    }
    setCurrentStation(currentStation);
  }

  public void prevStation() { //Переключаем на предыдущую станцию
    if (currentStation > minStation) {
      --this.currentStation;
    } else {
      setCurrentStation(maxStation);
    }
    setCurrentStation(currentStation);
  }

  public void setCurrentStation(int currentStation) { //Устанавливаем нужную станцию в пределах диапазона для тестов
    if (currentStation < minStation) {
      return;
    }
    if (currentStation > maxStation) {
      return;
    }
    this.currentStation = currentStation;
  }
}