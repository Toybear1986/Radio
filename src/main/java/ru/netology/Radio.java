package ru.netology;

public class Radio {
  private int currentVolume = 5;
  private int maxVolume = 100;
  private int Mute = 0;
  private int currentStation = 2;
  private int maxStation;
  private int minStation = 0;
  private int quantityOfStations = 10;

  public int getCurrentVolume() { //Получаем текущую станцию
    return currentVolume;
  }

  protected void setCurrentVolume(int currentVolume) { //Разрешаем устанавливать громкость в пределах диапазона для тестов
    if (currentVolume < Mute) {
      return;
    }
    if (currentVolume > maxVolume) {
      return;
    }
    this.currentVolume = currentVolume;
  }

  protected void setMute() { //Разрешаем устанавливать минимальну громкость для тестов
    currentVolume = Mute;
  }

  protected void setMaxVolume() { //Разрешаем устанавливать максимальную громкость для тестов
    currentVolume = maxVolume;
  }

  public void increaseVolume() { //Увеличение громкости
    if (currentVolume < maxVolume) {
      currentVolume = currentVolume + 1;
    }
    setCurrentVolume(currentVolume);
  }

  public void decreaseVolume() { //Уменьшение громкости
    if (currentVolume > Mute) {
      currentVolume = currentVolume - 1;
    }
    setCurrentVolume(currentVolume);
  }

  public Radio(int quantityOfStations) {
    this.quantityOfStations = quantityOfStations;
    this.maxStation = quantityOfStations - 1;
    this.currentStation = getCurrentStation();
  }

  public Radio() {
    this.maxStation = quantityOfStations - 1;
    this.currentStation = getCurrentStation();
  }

  public int getMaxStation() {
    return maxStation;
  }

  public int getCurrentStation() { //Получаем текущую станцию
    return currentStation;
  }

  public void setCurrentStation(int currentStation) { //Устанавливаем нужную станцию в пределах диапазона для тестов
    if (currentStation < minStation) {
      return;
    }
    if (currentStation > maxStation) { //Максимум меняем на количество станций
      return;
    }
    this.currentStation = currentStation;
  }

  public void setMinStation() { // Устанавливаем миксимальную станцию для тестов
    currentStation = minStation;
  }

  public void setMaxStation() { // Устанавливаем минимальную станцию для тестов
    currentStation = maxStation;
  }

  public void nextStation() { //Переключаем на следующую станцию
    if (currentStation < maxStation) {
      currentStation = currentStation + 1;
    } else {
      setMinStation();
    }
    setCurrentStation(currentStation);
  }

  public void prevStation() { //Переключаем на предыдущую станцию
    if (currentStation > minStation) {
      currentStation = currentStation - 1;
    } else {
      setMaxStation();
    }
    setCurrentStation(currentStation);
  }
}