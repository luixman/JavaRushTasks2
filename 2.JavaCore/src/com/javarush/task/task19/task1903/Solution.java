package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }
    public static void main(String[] args) {


    }

    public static class IncomeDataAdapter implements Customer,Contact {
       private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String fullCountryName= null;

            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

            String phoneCode = "+"+String.valueOf(data.getCountryPhoneCode());
            StringBuilder phoneNumber = new StringBuilder(String.valueOf(data.getPhoneNumber()));
            while(phoneNumber.length()!=10){
                phoneNumber.insert(0, "0");
            }
            phoneNumber.insert(0,"(");
            phoneNumber.insert(4,")");
            phoneNumber.insert(8,"-");
            phoneNumber.insert(11,"-");

            return phoneCode+phoneNumber.toString();



            //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}