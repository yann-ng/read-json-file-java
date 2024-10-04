package com.company;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {
        Object obj = new JSONParser().parse(new FileReader("src/com/company/certiLinker.json"));
        JSONObject jo = (JSONObject) obj;

        String fullName, placeOfBirth, dateOfBirth, gender;

        int x = 100000000;
        int maxId = jo.size();
        System.out.println(maxId);
        String[] allNames = new String[maxId];
        String[] allPobs = new String[maxId];
        String[] allDobs = new String[maxId];
        String[] allGenders = new String[maxId];

        for(int i=0;i<maxId;i++) {
            x+=1;
            String y = Integer.toString(x);
            Map id = ((Map) jo.get(y));
            Iterator<Map.Entry> looping = id.entrySet().iterator();
            while (looping.hasNext()) {

                fullName = id.get("Name_child").toString();
                gender = id.get("gender").toString();
                dateOfBirth = id.get("date_of_birth").toString();
                placeOfBirth = id.get("place_of_birth").toString();

                allNames[i] = fullName;
                allGenders[i] = gender;
                allPobs[i] = placeOfBirth;
                allDobs[i] = dateOfBirth;
                looping.next();

            }
        }

        for(String c: allNames) { System.out.println("The element is: " + c); }

        for (int c=0; c<4;c++){
            String variableName = "browsing" + Integer.toString(c);
            System.out.println("when 0");
        }
    }


    public void searchInFile() throws Exception{
        Object obj = new JSONParser().parse(new FileReader("src/com/company/certiLinker.json"));
        JSONObject jo = (JSONObject) obj;

        String fullName, PlaceOfBirth;
        char gender;
        String[] allNames;
        String[] allPobs;
        String[] allDobs;
        String[] allGenders;

        int x = 100000000;
        int maxId = jo.size();
        for(int i=1;i<=maxId;i++) {
            x+=1;
            String y = Integer.toString(x);
            Map id = ((Map) jo.get(y));
            Iterator<Map.Entry> looping = id.entrySet().iterator();
            while (looping.hasNext()) {
                String name = id.get("Name_child").toString();
                Map.Entry pair = looping.next();
                if(name.contains("chris".toUpperCase())){
                    //System.out.println(pair.getKey() + " : " + pair.getValue());
                    String sexe = id.get("gender").toString();
                    String dob = id.get("date_of_birth").toString();
                    String pob = id.get("place_of_birth").toString();
                    System.out.println("sexe: " + sexe + "\ndob: "+ dob + "\npob: " + pob);
                    break;

                }

                //System.out.println("yes that's all " + name);
                //Map.Entry pair = looping.next();
                //System.out.println(pair.getKey() + " : " + pair.getValue());
            }


        }
    }
}
