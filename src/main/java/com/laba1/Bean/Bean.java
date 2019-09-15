package com.laba1.Bean;
import com.laba1.Entity.Rating;
import com.laba1.Entity.User;
import com.laba1.service.RatingService;
import com.laba1.service.UserService;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bean {
    private  String  message = "JavaBean компонент приветствует Вас!";

    private String genNumber() {
        final int MAX_NUMBER = 10;
        Integer[] randomNumbers = new Integer[MAX_NUMBER];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = i;
        }
        Collections.shuffle(Arrays.asList(randomNumbers));
        return String.valueOf(randomNumbers[0]) + randomNumbers[1] + randomNumbers[2] + randomNumbers[3];
    }

    private String result(String stringOfYouEnteredNumber, String login) {
        RatingService ratingService = new RatingService();
        Rating tempRating = ratingService.findByLogin(login);
        tempRating.setAllAttempt(tempRating.getAllAttempt() + 1); // increase the number of attempts
        // to guess in the database

        ratingService.save(tempRating);
        String number = genNumber();

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
            ratingService.save(tempRating);
            UserService userService = new UserService();
//            User user = userService.findByLogin(login);
//            user.setYouNumber(genNumber());
//            userService.save(user);
            return stringOfYouEnteredNumber + " - " + bull + "Б" + cow + "K (число угадано) \n---------------------------\nЯ загадал еще...";
        }
        return stringOfYouEnteredNumber + " - " + bull + "Б" + cow + "K";
    }
}
