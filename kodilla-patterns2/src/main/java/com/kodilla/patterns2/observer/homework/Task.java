package com.kodilla.patterns2.observer.homework;

public class Task {
    String signature;
    String content;

    public Task(String signature, String content) {
        this.signature = signature;
        this.content = content;
    }

    public String getSignature() {
        return signature;
    }

    public String getContent() {
        return content;
    }
}
