import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date {
    boolean isLeapYear(int year){
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
   boolean isValidDate(int year, int month, int day) {
        if (year<=0 || month<=0 || day<=0 || month>12 || day>31)
            return false;
      else if( month==4|| month==6 || month==9 || month==11) {
               if (day > 30)
              return false;
      }
      else if (month==2 && isLeapYear(year)==true)
          if (day>29)
              return false;
          else if (month==2 && isLeapYear(year)==false)
              if (day>28)
                  return false;

    return true;
   }
    public enum DayOfWeek {
        SUNDAY("SUNDAY "),
        MONDAY("MONDAY"),
        TUESDAY("TUESDAY"),
        WEDNESDAY("WEDNESDAY"),
        THURSDAY("THURSDAY"),
        FRIDAY("FRIDAY"),
        SATURDAY("SATURDAY");

        private String title;

        DayOfWeek(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
    int getDayOfWeek(int year, int month, int day){
        if (month < 3)
        {
            month += 12;
            year--;
        }
        int  monthCode = (26 * (month + 1)) / 10;
        int  yearCode = (125 * year) / 100;
        return   (day + monthCode + yearCode - (year / 100) + (year / 400) - 1)% 7;


    }

         String toString(int year, int month, int day){
        String dayString="";
        String monthString = "";
             switch (getDayOfWeek(year,month, day)) {
            case 0:
                dayString = "Sunday";
                break;
            case 1:
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            case 4:
                dayString = "Thursday";
                break;
            case 5:
                dayString = "Friday";
                break;
            case 6:
                dayString = "Saturday";
                break;
            default:
                break;
        }
             switch (month) {
                 case 1:
                     monthString = "January";
                     break;
                 case 2:
                     monthString = "February";
                     break;
                 case 3:
                     monthString = "March";
                     break;
                 case 4:
                     monthString = "April";
                     break;
                 case 5:
                     monthString = "May";
                     break;
                 case 6:
                     monthString = "June";
                     break;
                 case 7:
                     monthString = "July";
                     break;
                 case 8:
                     monthString = "August";
                     break;
                 case 9:
                     monthString = "September";
                     break;
                 case 10:
                     monthString = "October";
                     break;
                 case 11:
                     monthString = "November";
                     break;
                 case 12:
                     monthString = "December";
                     break;
                 default:
                     break;
             }
        return dayString+" "+day+" "+monthString+" "+year;
         }

        int countDays(int year, int month, int day) {
           // int yearToday=(int)(System.currentTimeMillis()/1000/3600/24/365.25 +1970);
            
            LocalDate firstDate = LocalDate.now(); //
            LocalDate secondDate = LocalDate.of(year, month, day); //
            long daysBetween = ChronoUnit.DAYS.between( secondDate,firstDate);




           return (int)daysBetween;

        }
    // Вычисляет сколько дней прошло с данной даты по сегодняшнюю
        public static void main(String[] args) {
            Date date = new Date();
            System.out.println(date.toString(2020, 10, 23));

            System.out.println(date.countDays(2020,10,1));
        }
    }
