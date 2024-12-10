package com.nutricion.nutricion.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String username;
    
    @JsonIgnore
    private String password;

    @JsonProperty
    public String getPassword(){
        return password;
    }

    @JsonProperty
    public void setPassword(String password){
        this.password = password;
    }   
}
