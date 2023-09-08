package com.myfirstwebsocketapp.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

public record OrderDto(
       Long id,
       LocalDateTime dateOfSale,
       @JsonIgnoreProperties({"carShowroomDto"})
       CarDto carDto

)
{

}
