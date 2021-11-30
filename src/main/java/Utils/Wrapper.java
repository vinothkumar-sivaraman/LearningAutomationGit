package Utils;

import java.io.IOException;

public class Wrapper {

    private void methodA() throws Exception{
        try{
            methodB();
        }
        catch(Exception e){
            System.out.println();
        }
    }

    private void methodB() throws Exception{
        try{
            methodC();
        }
        catch(RuntimeException e){
            System.out.println("1");
        }
        catch(Exception e){
            System.out.println("2");
        }
        catch(Throwable e){
            System.out.println("3");
        }
    }

    private void methodC() throws Exception{
        try{
            throw new IOException();
        }
        catch(RuntimeException e){
            System.out.println("4");
            throw e;
        }
    }


    public static void main(String[] args) throws Exception {
        Wrapper obj = new Wrapper();
        obj.methodA();
    }

}