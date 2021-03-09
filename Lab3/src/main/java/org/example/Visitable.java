package org.example;
// interfata Visitable
public interface Visitable {
  LocalTime getOpeningTime();
  LocalTime getClosingTime();
    default LocalTime OpeningTime(){
        LocalTime open = LocalTime.of(9,30);
        return open;
    }
    default LocalTime ClosingTime(){
        LocalTime close = LocalTime.of(20,00);
        return close;
    }
    public static Duration getVisitingDuration(LocalTime close, LocalTime open)
    {

      return Duration.between(open,close);

    }
}
