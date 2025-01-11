package pojo;

//package javaPackageName;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;

@JsonIgnoreProperties(value = {"racketName"}, allowGetters = true)
public class SerializationDeserialization {

    /*Data members*/
    private String badmintonBrand;

    private String racketName;

    /*Getters and Setters*/
    public String getBadmintonBrand() {
        return badmintonBrand;
    }
    public void setBadmintonBrand(String badmintonBrand){
        this.badmintonBrand = badmintonBrand;
    }
    public String getRacketName() {
        return racketName;
    }
    public void setRacketName(String racketName) {
        this.racketName = racketName;
    }

    @Test
    public void Serialization_Deserialization() throws JsonProcessingException {

        /*Creating object of class*/
        SerializationDeserialization objpojo = new SerializationDeserialization();

        /*Set Values*/
        objpojo.setBadmintonBrand("Yonex");
        objpojo.setRacketName("Voltric 50 E-tune");

        /*Class Object -> String(JSON Object PAYLOAD)*/
        System.out.println("Serialization...");
        ObjectMapper objectMapper = new ObjectMapper();
        String objpojoJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objpojo);
        System.out.println(objpojoJson);

        /*String(JSON Object PAYLOAD) -> Class Object*/
        System.out.println("DeSerialization...");
        SerializationDeserialization objpojo2 = objectMapper.readValue(objpojoJson, SerializationDeserialization.class);
        System.out.println("Badminton Brand : "+objpojo2.getBadmintonBrand());
        System.out.println("Racket Name : "+objpojo2.getRacketName());
    }
}

