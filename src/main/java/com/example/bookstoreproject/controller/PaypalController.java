package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.OrderPayPal;
import com.example.bookstoreproject.dto.Utility;
import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.BillService;
import com.example.bookstoreproject.services.PaypalService;
import com.example.bookstoreproject.services.UserService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class PaypalController {

    @Autowired(required = true)
    private PaypalService service;
    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    public static final String SUCCESS_URL = "/pay/success";
    public static final String CANCEL_URL = "/pay/cancel";
    private double price = 0;

    @GetMapping("/paypal")
    public String homePayPal() {
        return "paypalHome";

    }


    @PostMapping("/pay")
    public String payment(@ModelAttribute("order") OrderPayPal order, HttpServletRequest request) {
        try {
            System.out.println("JAAAAAAAAAAAAAAAAAAAAAA  " + Utility.getSiteURL(request));

            Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(), Utility.getSiteURL(request) + CANCEL_URL,
                    Utility.getSiteURL(request) + SUCCESS_URL);
            price = order.getPrice();
            System.out.println("PRICE: PRICE PRICE PRICE PRICE \n" + order.getPrice());

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/paypal";
    }


    @GetMapping(value = CANCEL_URL)
    public String cancel(RedirectAttributes redirAttrs) {
        redirAttrs.addFlashAttribute("error", "The error XYZ occurred.");

        return "cancelPaypal";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId,
                             @RequestParam("PayerID") String payerId,
                             Principal principal, @ModelAttribute("user") UserEntity userEntity,
                             RedirectAttributes redirAttrs) {

        try {
            User user = (User) ((Authentication) principal).getPrincipal();
            UserEntity entity = userService.findByEmail(user.getUsername());
            BillEntity billEntity = billService.findByUserEntity(entity);

            redirAttrs.addFlashAttribute("success", "Everything went just fine.");

            Payment payment = service.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                billEntity.setTotalMoney(price);
                userService.save(entity);
                return "successPayPal";
            }

        } catch (PayPalRESTException exception) {
            System.out.println(exception.getMessage());
        }

        return "redirect:/paypal";
    }


}
