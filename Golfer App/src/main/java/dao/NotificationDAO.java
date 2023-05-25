package dao;

import model.Notification;

import java.util.List;

public interface NotificationDAO {
    Notification getNotificationById(int notificationId);
    List<Notification> getNotificationsByUserId(int userId);
    void addNotification(Notification notification);
    void updateNotification(Notification notification);
    void deleteNotification(Notification notification);
}
