package com.example.LibrarySystem.MeetingSchedulerSystem.Sytem2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
class User {
    private String name;
    private String email;
    private List<Notification> notifications;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.notifications = new ArrayList<>();
    }

    public void acceptInvitation(Notification invite) {
        System.out.println(name + " has accepted the invitation: " + invite.getContent());
        removeNotification(invite);
    }

    public void rejectInvitation(Notification invite) {
        System.out.println(name + " has rejected the invitation: " + invite.getContent());
        removeNotification(invite);
    }

    public void receiveNotification(Notification notification) {
        notifications.add(notification);
    }

    public void removeNotification(Notification notification) {
        notifications.remove(notification);
    }
}

@Getter
@Setter
class Interval {
    private Date startTime;
    private Date endTime;
}

@Getter
@Setter
class MeetingRoom {
    private int id;
    private int capacity;
    private boolean isAvailable;
    private List<Interval> bookedIntervals;

    public MeetingRoom(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.isAvailable = true;
        this.bookedIntervals = new ArrayList<>();
    }

    public boolean bookRoom(Interval interval) {
        if (!isAvailable || isIntervalOverlap(interval)) {
            return false; // Room is not available or interval overlaps with booked intervals
        }
        bookedIntervals.add(interval);
        return true; // Room successfully booked for the given interval
    }

    public boolean releaseRoom(Interval interval) {
        if (bookedIntervals.isEmpty() || !bookedIntervals.contains(interval)) {
            return false; // Room is not booked for the given interval
        }
        bookedIntervals.remove(interval);
        if (bookedIntervals.isEmpty()) {
            isAvailable = true; // Set room available if there are no more booked intervals
        }
        return true; // Room successfully released for the given interval
    }

    public boolean checkAvailability(Interval interval) {
        return isAvailable && !isIntervalOverlap(interval);
    }

    private boolean isIntervalOverlap(Interval interval) {
        for (Interval bookedInterval : bookedIntervals) {
            if (isOverlap(bookedInterval, interval)) {
                return true; // Interval overlaps with booked intervals
            }
        }
        return false; // Interval does not overlap with any booked intervals
    }

    private boolean isOverlap(Interval interval1, Interval interval2) {
        return interval1.getStartTime().before(interval2.getEndTime()) &&
                interval2.getStartTime().before(interval1.getEndTime());
    }

}

@Getter
@Setter
class Calendar {
    private List<Meeting> meetings;

    public Calendar() {
        this.meetings = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public void removeMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    public List<Meeting> getMeetingsForUser(User user) {
        List<Meeting> userMeetings = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.getParticipants().contains(user)) {
                userMeetings.add(meeting);
            }
        }
        return userMeetings;
    }
}

@Getter
@Setter
class Meeting {
    private int id;
    private int participantsCount;
    private List<User> participants;
    private Interval interval;
    private MeetingRoom room;
    private String subject;

    public Meeting(int id, Interval interval, MeetingRoom room, String subject) {
        this.id = id;
        this.participants = new ArrayList<>();
        this.interval = interval;
        this.room = room;
        this.subject = subject;
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {
        participants.remove(user);
    }

    public boolean isParticipant(User user) {
        return participants.contains(user);
    }

    public void addParticipants(List<User> users) {
        participants = users;
    }
}

@Getter
@Setter
class Notification {
    private int notificationId;
    private String content;
    private Date creationDate;

    public Notification(int notificationId, String content) {
        this.notificationId = notificationId;
        this.content = content;
        this.creationDate = new Date();
    }

    public boolean sendNotification(User user) {
        // You can implement this based on your notification mechanism (email, SMS,
        // etc.)
        System.out.println("Notification sent to " + user.getName() + ": " + content);
        user.receiveNotification(this); // Notify the user about the received notification
        return true; // Return true if notification sent successfully
    }

    public boolean cancelNotification(User user) {
        // You can implement this based on your notification mechanism (if applicable)
        System.out.println("Notification canceled for " + user.getName() + ": " + content);
        user.removeNotification(this); // Remove the notification from the user's list
        return true; // Return true if notification canceled successfully
    }
}

@Getter
@Setter
class MeetingScheduler {
    private static MeetingScheduler scheduler = null;
    // Scheduler is a singleton class that ensures it will have only one active
    // instance at a time
    private User organizer;
    private Calendar calendar;
    private List<MeetingRoom> rooms;

    private MeetingScheduler() {
        this.rooms = new ArrayList<>();
        this.calendar = new Calendar();
    }

    // Created a static method to access the singleton instance of Scheduler class
    public static MeetingScheduler getInstance() {
        if (scheduler == null) {
            scheduler = new MeetingScheduler();
        }
        return scheduler;
    }

    public boolean scheduleMeeting(List<User> users, Interval interval, String subject) {
        if (users.isEmpty() || interval == null || subject.isEmpty()) {
            return false; // Invalid input
        }

        MeetingRoom availableRoom = checkRoomsAvailability(users.size(), interval);
        if (availableRoom == null) {
            return false; // No available room for the given interval
        }
        Meeting meeting = new Meeting(calendar.getMeetings().size() + 1, interval, availableRoom, subject);
        meeting.addParticipants(users);
        calendar.addMeeting(meeting);
        availableRoom.bookRoom(interval);
        for (User user : users) {
            Notification notification = new Notification(1, "You have been invited to a meeting: " + subject);
            notification.sendNotification(user);
        }
        return true; // Meeting scheduled successfully
    }

    public boolean cancelMeeting(Meeting meeting) {
        if (meeting == null || !calendar.getMeetings().contains(meeting)) {
            return false; // Meeting not found or invalid meeting
        }
        calendar.removeMeeting(meeting);
        meeting.getRoom().releaseRoom(meeting.getInterval());
        return true; // Meeting canceled successfully
    }

    public boolean bookRoom(MeetingRoom room, int numberOfPersons, Interval interval) {
        return room.bookRoom(interval);
    }

    public boolean releaseRoom(MeetingRoom room, Interval interval) {
        return room.releaseRoom(interval);
    }

    public MeetingRoom checkRoomsAvailability(int numberOfPersons, Interval interval) {
        for (MeetingRoom room : rooms) {
            if (room.checkAvailability(interval) && room.getCapacity() >= numberOfPersons) {
                return room;
            }
        }
        return null; // No available room found
    }
}

public class MeetingSchedulerSystem {

}
