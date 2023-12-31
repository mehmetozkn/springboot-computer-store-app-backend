package com.marketapp.MarketApp.controller;

import com.marketapp.MarketApp.dto.AddProductRequest;
import com.marketapp.MarketApp.dto.BasketProductDto;
import com.marketapp.MarketApp.service.BasketProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/operation")

public class BasketProductController {

    private final BasketProductService basketProductService;

    public BasketProductController(BasketProductService basketProductService) {
        this.basketProductService = basketProductService;
    }

    @PostMapping("/addProductToBasket")
    public ResponseEntity<BasketProductDto>
    addProductToBasket(@RequestBody AddProductRequest addProductRequest){
        return ResponseEntity.ok(basketProductService.addProduct(addProductRequest));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BasketProductDto> deleteProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(basketProductService.deleteBasketProduct(id));
    }
    @DeleteMapping("/deleteAll")
    public void clearBasket(){
         basketProductService.clearBasket();
    }

}
