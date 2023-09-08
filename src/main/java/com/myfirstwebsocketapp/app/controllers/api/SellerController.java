package com.myfirstwebsocketapp.app.controllers.api;

import com.myfirstwebsocketapp.app.entity.Seller;
import com.myfirstwebsocketapp.app.services.SellerService;
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
    public Seller createSeller(@RequestBody Seller seller){
        return sellerService.save(seller);
    }
    @GetMapping
    public List< Seller > getAllSellers(){
        return sellerService.getAll();
    }
    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable Long id){
        return sellerService.getById(id);
    }
    @PatchMapping("/{id}")
    public Seller updatePriceCarById(@PathVariable Long id,
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