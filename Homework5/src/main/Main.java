/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        switch(s){
            case "Integer":
                ArrayList<Integer> a=new ArrayList();
                for(int i=0;i<10;i++){
                    Integer x=sc.nextInt();
                    a.add(x);
                }
                System.out.println(min(a));
                System.out.println(max(a));
                break;
            case "Double":
                ArrayList<Double> ad=new ArrayList();
                for(int i=0;i<10;i++){
                    Double x=sc.nextDouble();
                    ad.add(x);
                }
                System.out.printf("%.3f\n",min(ad));
                System.out.printf("%.3f\n",max(ad));
                break;
            case "Character":
                ArrayList<Character> ac=new ArrayList();
                for(int i=0;i<10;i++){
                    String ss=sc.next();
                    ac.add(ss.charAt(0));
                }
                System.out.println(min(ac));
                System.out.println(max(ac));
                break;
            default:
                ArrayList<String> as=new ArrayList();
                for(int i=0;i<10;i++){
                    String ss=sc.next();
                    as.add(ss);
                }
                System.out.println(min(as));
                System.out.println(max(as));
                break;
        }
    }
    public static <E extends Comparable<E>> E min(ArrayList<E> list){
        E mn=list.get(0);
        for(int i=1;i<list.size();i++){
            if(mn.compareTo(list.get(i))>0){
                mn=list.get(i);
            }
        }
        return mn;
    }
    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E mx=list.get(0);
        for(int i=1;i<list.size();i++){
            if(mx.compareTo(list.get(i))<0){
                mx=list.get(i);
            }
        }
        return mx;
    }
}
