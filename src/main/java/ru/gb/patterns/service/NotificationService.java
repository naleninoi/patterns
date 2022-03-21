package ru.gb.patterns.service;

public interface NotificationService<T, E> {
    void subscribe(T subscriber, E event);
    void unsubscribe(T subscriber, E event);
    void notify(T subscriber, E event);
    void notifyAll(E event);
}
