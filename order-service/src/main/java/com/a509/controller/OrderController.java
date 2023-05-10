package com.a509.controller;

import com.a509.dto.CancelRequestDto;
import com.a509.dto.CreateRequestDto;
import com.a509.dto.response.CancelResponseDto;
import com.a509.dto.response.OrderCreateResponseDto;
import com.a509.dto.response.OrderResponseDto;
import com.a509.dto.response.TokenResponseDto;
import com.a509.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
        @GetMapping
        public ResponseEntity<TokenResponseDto> publishToken() throws Exception {
            TokenResponseDto token = orderService.getTokenByBootPay();
            log.info("response entity value is : " + token.getToken());
            return ResponseEntity
                    .ok()
                    .body(token);
        }

        @GetMapping("/{nickName}")
        public ResponseEntity<List<OrderResponseDto>> findOrderList(
                @PathVariable("nickName") String nickName){
            List<OrderResponseDto> response = orderService.findOrders(nickName);
            return ResponseEntity
                    .ok()
                    .body(response);
        }

        @GetMapping("/{nickName}/{orderId}")
        public ResponseEntity<OrderResponseDto> findOrder(@PathVariable("nickName") String nickName, @PathVariable("orderId") long orderId) {
            OrderResponseDto response = orderService.findOrder(orderId);
            return ResponseEntity
                    .ok()
                    .body(response);
        }

        @PostMapping
        public ResponseEntity<OrderCreateResponseDto> createOrder(@RequestBody CreateRequestDto requestDto){
            orderService.createOrder(requestDto);
            OrderCreateResponseDto response = new OrderCreateResponseDto();
            return ResponseEntity
                    .ok()
                    .body(response);
        }

    @PostMapping("/test")
    public ResponseEntity<OrderCreateResponseDto> createOrderV2(@RequestBody CreateRequestDto requestDto){
        orderService.createOrderV2(requestDto);
        OrderCreateResponseDto response = new OrderCreateResponseDto();
        return ResponseEntity
                .ok()
                .body(response);
    }

        @DeleteMapping
        public ResponseEntity<CancelResponseDto> cancelOrder(@RequestBody CancelRequestDto requestDto){
            orderService.cancelOrder(requestDto);
            CancelResponseDto responseDto = new CancelResponseDto();
            return ResponseEntity
                    .ok()
                    .body(responseDto);
        }
}
