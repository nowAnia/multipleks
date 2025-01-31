import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schedule {
    HashMap<WeekDay, List<Event>> mapOfEvents;

    public Schedule() {
        mapOfEvents = new HashMap<>();
    }

    public void addEvent(Event event) {
        if (mapOfEvents.get(event.getDayOfWeek()) != null) {
            List<Event> currentEvents = mapOfEvents.get(event.getDayOfWeek());
            currentEvents.add(event);
            mapOfEvents.put(event.getDayOfWeek(), currentEvents);
        } else {
            mapOfEvents.put(event.getDayOfWeek(), new ArrayList<>());
            mapOfEvents.get(event.getDayOfWeek()).add(event);
        }

    }

    public void showSchedul() {
        if (mapOfEvents.get(WeekDay.MONDAY) != null) {
            System.out.println("Monday");
            for (Event event : mapOfEvents.get(WeekDay.MONDAY)) {
                System.out.println(event.toString());
            }
        }
        if (mapOfEvents.get(WeekDay.TUESDAY) != null) {
            System.out.println("Tuesday");
            for (Event event : mapOfEvents.get(WeekDay.TUESDAY)) {
                System.out.println(event.toString());
            }
        }
        if (mapOfEvents.get(WeekDay.WEDNESDAY) != null) {
            System.out.println("Wednesday");
            for (Event event : mapOfEvents.get(WeekDay.WEDNESDAY)) {
                    System.out.println(event.toString());
            }
        }
        if (mapOfEvents.get(WeekDay.THURSDAY) != null) {
            System.out.println("Thursday");
            for (Event event : mapOfEvents.get(WeekDay.THURSDAY)) {
                System.out.println(event.toString());
            }
        }
        if (mapOfEvents.get(WeekDay.FRIDAY) != null) {
            System.out.println("Friday");
            for (Event event : mapOfEvents.get(WeekDay.FRIDAY)) {
                System.out.println(event.toString());
            }
        }
        if (mapOfEvents.get(WeekDay.SATURDAY) != null) {
            System.out.println("Saturday");
            for (Event event : mapOfEvents.get(WeekDay.SATURDAY)) {
                System.out.println(event.toString());
            }
        }
        if (mapOfEvents.get(WeekDay.SUNDAY) != null) {
            System.out.println("Sunday");
            for (Event event : mapOfEvents.get(WeekDay.SUNDAY)) {
                System.out.println(event.toString());
            }
        }

    }

}
