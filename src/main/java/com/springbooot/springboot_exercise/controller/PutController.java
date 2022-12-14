package com.springbooot.springboot_exercise.controller;

import com.springbooot.springboot_exercise.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("api/v1/put-api")
public class PutController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String putExample() {
        return "Hello Post API";
    }

    @PutMapping(value = "/member")
    public String putMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach((map->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        }));
        return sb.toString();
    }
    @PutMapping(value = "/member2")
    public String putMember2(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> putMemberDto(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
