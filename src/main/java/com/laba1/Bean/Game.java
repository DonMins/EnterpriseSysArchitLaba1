package com.laba1.Bean;
import com.laba1.Dao.RatingDaoImpl;
import com.laba1.Dao.UserDaoImpl;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Класс реализующий логику игры
 *
 * @author  Maks
 * @version 1.0
 */

public class Game {

     public String genNumber() {
        final int MAX_NUMBER = 10;
        Integer[] randomNumbers = new Integer[MAX_NUMBER];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = i;
        }
        Collections.shuffle(Arrays.asList(randomNumbers));
        return String.valueOf(randomNumbers[0]) + randomNumbers[1] + randomNumbers[2] + randomNumbers[3];
    }

    public String result(String stringOfYouEnteredNumber, String login) {
        RatingDaoImpl ratingDao = new RatingDaoImpl();
        Rating tempRating = ratingDao.findByLogin(login);
        tempRating.setAllAttempt(tempRating.getAllAttempt() + 1);

        ratingDao.update(tempRating);
        UserDaoImpl userDao = new UserDaoImpl();
        String number = userDao.findByLogin(login).getYouNumber();

        ArrayList<Character> numberSymbol = new ArrayList<>();
        ArrayList<Character> strSymbol = new ArrayList<>();
        ArrayList<Character> l3;
        l3 = strSymbol;
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < 4; ++i) {
            numberSymbol.add(number.charAt(i));
            strSymbol.add(stringOfYouEnteredNumber.charAt(i));
            if (number.charAt(i) == stringOfYouEnteredNumber.charAt(i)) {
                bull++;
            }
        }
        l3.retainAll(numberSymbol);
        cow = l3.size() - bull;
        if (bull == 4) {
            tempRating.setCountgame(tempRating.getCountgame() + 1);
            ratingDao.update(tempRating);
            User user = userDao.findByLogin(login);
            user.setYouNumber(genNumber());
            System.out.println(user.getYouNumber());
            userDao.update(user);
            return stringOfYouEnteredNumber + " - " + bull + "Б" + cow + "K (число угадано) \n--" +
                    "-------------------------\nЯ загадал еще...";
        }
        return stringOfYouEnteredNumber + " - " + bull + "Б" + cow + "K";
    }

}
