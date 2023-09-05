package com.supercoding.hanyipman.controller;

import com.supercoding.hanyipman.dto.cart.request.RegisterCartRequest;
import com.supercoding.hanyipman.dto.user.CustomUserDetail;
import com.supercoding.hanyipman.dto.vo.Response;
import com.supercoding.hanyipman.service.CartService;
import com.supercoding.hanyipman.utils.ApiUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@Slf4j
@Api(tags="장바구니 관리")
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @Operation(summary = "장바구니 등록", description = "사용자가 메뉴, 옵션을 담은 장바구니를 서버에 저장한다. 옵션에서 \"\"를 제거하고 실행해주세요")
    @PostMapping
    public Response<?> registerCart(@RequestBody RegisterCartRequest request,
                               @AuthenticationPrincipal CustomUserDetail userDetail){
        cartService.registerCart(userDetail.getUserId(), request);
        return ApiUtils.success(HttpStatus.CREATED, "장바구니에 성공적으로 담았습니다.", null);
    }
}
