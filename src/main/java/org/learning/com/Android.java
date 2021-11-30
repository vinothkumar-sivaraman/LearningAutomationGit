package org.learning.com;

public class Android extends Phone{

    @Override
    public void textMessage() {
        System.out.println("this is android text message");
    }

    @Override
    public void phoneCalls() {
        System.out.println("this is phone calls");
    }

    public static void main(String[] args) {
        Android obj = new Android();
        obj.phoneCalls();
        obj.textMessage();
        obj.display();
    }
}
