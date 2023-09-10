package com.CarSaleApi.app.controllers.api;

import com.CarSaleApi.app.dto.SellerDto;
import com.CarSaleApi.app.entity.Seller;
import com.CarSaleApi.app.services.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seller createSeller(@RequestBody SellerDto sellerDto){
        return sellerService.save(sellerDto);
    }
    @GetMapping
    public List< SellerDto > getAllSellers(){
        return sellerService.getAll();
    }
    @GetMapping("/{id}")
    public SellerDto getSellerById(@PathVariable Long id){
        return sellerService.getById(id);
    }
    @PatchMapping("/{id}")
    public SellerDto updatePriceCarById(@PathVariable Long id,
                                  @RequestParam String role,
                                  @RequestParam Integer age){

        return sellerService.updateById(id,role,age);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById(@PathVariable Long id){
        sellerService.deleteById(id);
    }

}
