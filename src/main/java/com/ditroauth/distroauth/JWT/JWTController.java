package com.ditroauth.distroauth.JWT;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ditroauth.distroauth.JWT.Dto.JwtReqDto;

@RestController
@RequestMapping("/auth/v1/")
public class JWTController {

        private final JWTService jwtService;
   
        public JWTController(JWTService jwtService) {
                 this.jwtService = jwtService;
             }

    @GetMapping("/jwt")
    public ResponseEntity<Object> getJwt(@RequestBody JwtReqDto reqDto){
       String token = jwtService.generateToken(reqDto);

       return ResponseEntity.ok().header("Authorization", "Bearer " + token)
               .body("JWT Token generated successfully"); 
    }

}
