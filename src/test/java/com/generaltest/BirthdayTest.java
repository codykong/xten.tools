package com.generaltest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-11
 * Time: 下午4:07
 * To change this template use File | Settings | File Templates.
 */
public class BirthdayTest {

    public static void main(String[] args){

        String birth_s="2014-12-29";
        String[] birth_l=birth_s.split("-");

        Date now=new Date();
        String now_s=new SimpleDateFormat("yyyy-mm-dd").format(now);
        String[] now_l=now_s.split("-");

        int year;
        int month;
        int day;

        if(Integer.valueOf(now_l[1])>Integer.valueOf(birth_l[1])||(Integer.valueOf(now_l[1])==Integer.valueOf
                (birth_l[1])&&Integer.valueOf(now_l[2])>=Integer.valueOf(birth_l[2]))) {
                year= Integer.valueOf(now_l[0]);
        }else{
            year= Integer.valueOf(now_l[0])+1;
        }

        if(Integer.valueOf(birth_l[1])==2&&Integer.valueOf(birth_l[2])==29){
            int run=year%4;
            if(run!=0){
               month=3;
                day=1;
            }else {
                month=2;
                day=29;
            }
        }else{
            month=Integer.valueOf(birth_l[1]);
            day= Integer.valueOf(birth_l[2]);
        }
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

    }
}
