/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

/**
 *
 * @author truong
 */
public class CheckData {

    public boolean checkName(String a) {

        if (a.length() < 10) {
            return false;
        }
        return true;
    }

    public boolean checkEmail(String e) {
        String parttern = "^\\w{3,}@\\w{2,}(\\.[a-zA-Z]{2,3}){1,2}$";
        return e.matches(parttern);
    }

    public boolean checkNumberPhone(String s) {
        String parttern = "0[932]\\d{8}";
        return s.matches(parttern);
    }

    public boolean checkID(String ma) {
        String parttern = "^[HD]+[0-9]{5}$";
        return ma.matches(parttern);
    }

    public boolean checkDate(String date) {
        String partten = "^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$";
        return date.matches(partten);
    }

    public boolean checkStore(String s) {
        String parttern = "[MH]+[0-9]{3}";
        return s.matches(parttern);
    }

    public boolean CheckAmount(String math) {
        try {
            int a = Integer.parseInt(math);
            if (a < 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean CheckPrice(String math) {
        try {
            float a = Float.parseFloat(math);
            if (a < 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
