package com.example.applicationbusinesswardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float coat = 70; // пальто
    byte coatDiscount = 77; // скидка (в процентах)
    float hat = 25; // шляпа
    byte hatDiscount = 37;
    float businessCostume = 53; // деловой костюм
    byte businessCostumeDiscount = 44;
    float shirt = 19; // сорочка
    float shoes = 41; // туфли
    byte shoesDiscount = 32;
    float accountBalance = 312; // счёт пользователя

    // метод подсчёта стоимости серверного комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (coat * (100 - coatDiscount) + hat * (100 - hatDiscount)
                + businessCostume * (100 - businessCostumeDiscount) + shirt
                + shoes * (100 - shoesDiscount)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки серверного комплекта
    private boolean possibility() {
        if (calculation() <= accountBalance) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить товары для делового гардероба
            return accountBalance - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // заполнение экрана
        if (possibility()) { // если имеется возможность товары для делового гардероба
            possibilityOut.setText("Имеется достаточно средств для покупки товаров для делового гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " кредитов");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки товаров для делового гардероба");
            balanceOut.setText(" - ");
        }
    }
}