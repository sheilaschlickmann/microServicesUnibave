package com.sheila.springproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientDTO {
	
 public @JsonProperty("Id") int Id;
 
 public @JsonProperty("Name")  String Name;
 
 public @JsonProperty("Address") String Address;
 
 public @JsonProperty("Fone") String Fone;
}
