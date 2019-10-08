package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();

    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field

//        List<UserMeal> mealsExceed = mealList.stream().filter((p) -> p.getDateTime().toLocalTime().isAfter(startTime)
//                && p.getDateTime().toLocalTime().isBefore(endTime) && p.getCalories() > caloriesPerDay ).collect(Collectors.toList());


        List<UserMealWithExceed> result = new ArrayList<>();

        for (UserMeal  user: mealList) {
            if(TimeUtil.isBetween(user.getDateTime().toLocalTime(),startTime,endTime))  {
                LocalDate nowDay = user.getDateTime().toLocalDate();
                int countCaloriesPerDay = mealList.stream().filter((p) -> p.getDateTime().toLocalDate().compareTo(nowDay) == 0)
                        .mapToInt(UserMeal::getCalories).sum();

                if(countCaloriesPerDay > caloriesPerDay){
                    result.add(new UserMealWithExceed(user.getDateTime(),user.getDescription(),user.getCalories(),true));
                }else {
                    result.add(new UserMealWithExceed(user.getDateTime(),user.getDescription(),user.getCalories(),false));
                }
            }
        }
        return result;
    }
}
