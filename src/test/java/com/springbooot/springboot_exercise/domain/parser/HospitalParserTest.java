package com.springbooot.springboot_exercise.domain.parser;

import com.springbooot.springboot_exercise.domain.dto.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class HospitalParserTest {

    @Test
    @DisplayName("csv 1줄을 잘만드는지 test")
    void convertHospital(){
        String line1 = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\",";
        HospitalParser hp =new HospitalParser();
        Hospital hospital = hp.parse(line1);

        assertEquals(1, hospital.getId()); //0
        assertEquals("의원", hospital.getOpenServiceName());//1
        assertEquals(3620000,hospital.getOpenLocalGovernmentCode()); //3
        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber());//4
        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612 //5
        assertEquals(6, hospital.getBusinessStatus()); //7
        assertEquals(13, hospital.getBusinessStatusCode()); //9
        assertEquals("062-515-2875", hospital.getPhone());//15
        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress());//18
        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());//19
        assertEquals("효치과의원", hospital.getHospitalName());//21
        assertEquals("치과의원", hospital.getBusinessTypeName());//25
        assertEquals(1, hospital.getHealthcareProviderCount());//30
        assertEquals(0, hospital.getPatientRoomCount());//31
        assertEquals(0, hospital.getTotalNumberOfBeds());//32
        assertEquals(52.29f, hospital.getTotalAreaSize());//33

    }
}