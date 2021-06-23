package _06_Meeting_Scheduler;

import java.util.HashMap;

public class MeetingScheduler {
    /*
     * Your task is to code a method to find a meeting time for two people
     * given their schedules.
     * 
     * Code the method below so that it returns a Schedule object that contains
     * all the times during the week that are in BOTH people's schedules. The
     * Schedule class is included in this package.
     * 
     * Example:
     * person1 availability - Monday at 9, Tuesday at 14, and Friday 10
     * person2 availability - Tuesday at 14, Friday 8, and Monday at 9
     * The returned HashMap should contain: Tuesday 14 and Monday 9
     * 
     * The returned Schedule object represents the times both people are
     * available for a meeting.
     * 
     * Time availability is always at the top of the hour, so 9:30 is not valid
     * Time availability always represents 1 hour
     * Assume both schedules are in the same time zones
     */
    public static Schedule getMutualAvailability(Schedule person1, Schedule person2) {
        Schedule matching = new Schedule();
        
        if (person1.getSchedule().containsKey("Saturday") && person2.getSchedule().containsKey("Saturday")) {
        	for (int i = 0; i < person1.getSchedule().get("Saturday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Saturday").size(); j++) {
        			if (person1.getSchedule().get("Saturday").get(i) == person2.getSchedule().get("Saturday").get(j)) {
        				matching.addAvailability("Saturday", person1.getSchedule().get("Saturday").get(i));
        			}
        		}
        	}
        }
        
        if (person1.getSchedule().containsKey("Sunday") && person2.getSchedule().containsKey("Sunday")) {
        	for (int i = 0; i < person1.getSchedule().get("Sunday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Sunday").size(); j++) {
        			if (person1.getSchedule().get("Sunday").get(i) == person2.getSchedule().get("Sunday").get(j)) {
        				matching.addAvailability("Sunday", person1.getSchedule().get("Sunday").get(i));
        			}
        		}
        	}
        }
        
        if (person1.getSchedule().containsKey("Monday") && person2.getSchedule().containsKey("Monday")) {
        	for (int i = 0; i < person1.getSchedule().get("Monday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Monday").size(); j++) {
        			if (person1.getSchedule().get("Monday").get(i) == person2.getSchedule().get("Monday").get(j)) {
        				matching.addAvailability("Monday", person1.getSchedule().get("Monday").get(i));
        			}
        		}
        	}
        }
        
        if (person1.getSchedule().containsKey("Tuesday") && person2.getSchedule().containsKey("Tuesday")) {
        	for (int i = 0; i < person1.getSchedule().get("Tuesday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Tuesday").size(); j++) {
        			if (person1.getSchedule().get("Tuesday").get(i) == person2.getSchedule().get("Tuesday").get(j)) {
        				matching.addAvailability("Tuesday", person1.getSchedule().get("Tuesday").get(i));
        			}
        		}
        	}
        }
        
        if (person1.getSchedule().containsKey("Wednesday") && person2.getSchedule().containsKey("Wednesday")) {
        	for (int i = 0; i < person1.getSchedule().get("Wednesday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Wednesday").size(); j++) {
        			if (person1.getSchedule().get("Wednesday").get(i) == person2.getSchedule().get("Wednesday").get(j)) {
        				matching.addAvailability("Wednesday", person1.getSchedule().get("Wednesday").get(i));
        			}
        		}
        	}
        }
        
        if (person1.getSchedule().containsKey("Thursday") && person2.getSchedule().containsKey("Thursday")) {
        	for (int i = 0; i < person1.getSchedule().get("Thursday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Thursday").size(); j++) {
        			if (person1.getSchedule().get("Thursday").get(i) == person2.getSchedule().get("Thursday").get(j)) {
        				matching.addAvailability("Thursday", person1.getSchedule().get("Thursday").get(i));
        			}
        		}
        	}
        }
        
        if (person1.getSchedule().containsKey("Friday") && person2.getSchedule().containsKey("Friday")){
        	for (int i = 0; i < person1.getSchedule().get("Friday").size(); i++) {
        		for (int j = 0; j < person2.getSchedule().get("Friday").size(); j++) {
        			if (person1.getSchedule().get("Friday").get(i) == person2.getSchedule().get("Friday").get(j)) {
        				matching.addAvailability("Friday", person1.getSchedule().get("Friday").get(i));
        			}
        		}
        	}
        }
        
        return matching;
    }
}
