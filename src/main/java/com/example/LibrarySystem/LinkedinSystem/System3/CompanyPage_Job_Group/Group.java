package com.example.LibrarySystem.LinkedinSystem.System3.CompanyPage_Job_Group;

import com.example.LibrarySystem.LinkedinSystem.System3.DesignPatterns.Observer.Observer;
import com.example.LibrarySystem.LinkedinSystem.System3.DesignPatterns.Observer.Subject;
import com.example.LibrarySystem.LinkedinSystem.System3.Enums.GroupStatus;
import com.example.LibrarySystem.LinkedinSystem.System3.Person_Admin_User.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Group implements Subject {
    private int groupId;
    private String name;
    private String description;
    private int totalMembers;
    private List<User> members = new ArrayList<>();
    private GroupStatus status;
    private User createdBy;
    private List<Observer> subscribers = new ArrayList<>();

    public Group(int groupId, String name, String description) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.totalMembers = 0;
    }

    @Override
    public void attach(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public boolean updateDescription(String newDescription) {
        this.description = newDescription;
        notifyObservers("Group description updated");
        return true;
    }

    public boolean addMember(User user) {
        members.add(user);
        attach(user);
        totalMembers++;
        notifyObservers("New member joined: " + user.getName());
        return true;
    }

    public boolean removeMember(User user) {
        if (members.remove(user)) {
            detach(user);
            totalMembers--;
            return true;
        }
        return false;
    }

    public List<User> getAllMembers() {
        return new ArrayList<>(members);
    }

    public User getMemberById(int userId) {
        for (User user : members) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}
