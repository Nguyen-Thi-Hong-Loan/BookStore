package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.config.PaypalPaymentIntent;
import com.example.bookstoreproject.config.PaypalPaymentMethod;
import com.example.bookstoreproject.dto.OrderPayPal;
import com.example.bookstoreproject.dto.Utility;
import com.example.bookstoreproject.entity.BillDetailEntity;
import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.globalData.DataCart;
import com.example.bookstoreproject.globalData.GlobalDataCart;
import com.example.bookstoreproject.services.BillService;
import com.example.bookstoreproject.services.PaypalService;
import com.example.bookstoreproject.services.UserService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.Date;
import java.util.List;

@Controller
public class PaypalController {

    @Autowired
    private PaypalService paypalService;
    @Autowired
    private UserService userService;

    @Autowired
    private BillService billService;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";
    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/paypal")
    public String homePayPal() {
        return "home";

    }

    @PostMapping("/pay")
    public String payment(HttpServletRequest request, Principal principal) {
        double totalPrice = GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum();

        List<DataCart> carts = GlobalDataCart.dataCarts;

        User user = (User) ((Authentication) principal).getPrincipal();
        UserEntity entity = userService.findByEmail(user.getUsername());

        System.out.println("EMAILLLLLL   " + entity.getEmail());
        billService.saveBill(entity, carts);

        String cancelUrl = Utility.getSiteURL(request) + "/" + CANCEL_URL;
        String successUrl = Utility.getSiteURL(request) + "/" + SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(
                    totalPrice,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for (Links links : payment.getLinks()) {
                if (links.getRel().equals("approval_url")) {
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
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
                             Principal principal,
                             RedirectAttributes redirAttrs) {

        try {
            User user = (User) ((Authentication) principal).getPrincipal();
            UserEntity entity = userService.findByEmail(user.getUsername());
            BillEntity billEntity = billService.findByUserEntity(entity);

            redirAttrs.addFlashAttribute("success", "Everything went just fine.");

            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                billEntity.setChecked(true);
                userService.save(entity);
                return "successPayPal";
            }

        } catch (PayPalRESTException exception) {
            System.out.println(exception.getMessage());
        }

        return "redirect:/paypal";
    }


}
