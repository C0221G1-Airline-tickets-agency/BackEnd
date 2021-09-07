package com.backend.airline_tickets_agency_management.controller.employee;

public class test {
    public static void main(String[] args) {
        String a = "abac";
        int num=0;
        String b;
        for(int i=1;i<= a.length();i++){
            for(int j=0;j<a.length();j++){
                if(j+i <= a.length()){
                    b = a.substring(j,j+i);
                    if(a.indexOf(b) == j ){
                        num++;
                    }
                }
            }
        }
        System.out.println(num);
    }

    public static int findLength(String a) {
        int count = 0;
        try {
            while (true) {
                a.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }


    public static int find() {
        String str = "abac";
        int count = 0;
        for (int i = 2; i <= str.length(); i++) {
            count += i;
        }
        return count;
    }
}
