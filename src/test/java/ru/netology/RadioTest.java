package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

  @Test
  public void RadioShouldWorkProperly() {
    Radio all = new Radio(50, 5, 10);
    all.setQuantityOfStations(10); // Проверим корректность установки максимума при установке количества программ
    Assertions.assertEquals(all.getQuantityOfStations() - 1, all.getMaxStation());

    all.nextStation(); // Проверим корректность переключения на следующую станцию
    Assertions.assertEquals(6, all.getCurrentStation());

    all.prevStation(); // Проверим корректность переключения на предыдущую
    Assertions.assertEquals(5, all.getCurrentStation());

    all.setCurrentStation(-1); // Попробуем поставить станцию ниже минимума
    Assertions.assertEquals(5, all.getCurrentStation());

    all.setCurrentStation(0); //Проверим корректность переключения на предыдущую, если стоит минимальная
    all.prevStation();
    Assertions.assertEquals(9, all.getCurrentStation());

    all.setCurrentStation(all.getMaxStation()); //Проверим корректность переключения на следующую, если стоит максимальная
    all.nextStation();
    Assertions.assertEquals(0, all.getCurrentStation());

    all.setCurrentStation(10); // Попробуем поставить станцию выше максимума
    Assertions.assertEquals(0, all.getCurrentStation());

    all.increaseVolume(); // Попробуем увеличить громкость
    Assertions.assertEquals(51, all.getCurrentVolume());

    all.decreaseVolume(); // Попробуем уменшить громкость
    Assertions.assertEquals(50, all.getCurrentVolume());

    all.setCurrentVolume(100); //Пробуем поднять громкость выше максимума
    all.increaseVolume();
    Assertions.assertEquals(100, all.getCurrentVolume());

    all.setCurrentVolume(0); //Пробуем сделать громкость нише минимума
    all.decreaseVolume();
    Assertions.assertEquals(0, all.getCurrentVolume());
  }
}