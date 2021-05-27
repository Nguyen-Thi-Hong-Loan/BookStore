package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.config.PaypalPaymentIntent;
import com.example.bookstoreproject.config.PaypalPaymentMethod;
import com.example.bookstoreproject.dto.Utility;
import com.example.bookstoreproject.entity.BillDetailEntity;
import com.example.bookstoreproject.entity.BillEntity;
import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.globalData.DataCart;
import com.example.bookstoreproject.globalData.GlobalDataCart;
import com.example.bookstoreproject.services.*;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private BillDetailService billDetailService;

    @Autowired
    private BookService bookService;


    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";
    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/paypal")
    public String homePayPal() {
        return "home";

    }

    @PostMapping("/pay")
    public String payment(HttpServletRequest request, Principal principal) {
        List<DataCart> carts = GlobalDataCart.dataCarts;
        double totalPrice = GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum();

        User user = (User) ((Authentication) principal).getPrincipal();
        UserEntity entity = userService.findByEmail(user.getUsername());

        System.out.println("EMAILLLLLL   " + entity.getEmail());

        BillEntity billEntity = new BillEntity();

        billEntity.setTotalMoney(totalPrice);
        billEntity.setUserEntity(entity);
        billService.save(billEntity);

        for (int i = 0; i < carts.size(); i++) {
            BillDetailEntity billDetailEntity = new BillDetailEntity();

            BookEntity bookEntity = bookService.findById(carts.get(i).getBook().getId()).orElse(null);
            billDetailEntity.setPrice(bookEntity.getPrice());
            billDetailEntity.setQuality(carts.get(i).getCount());
            billDetailEntity.setBook_id(bookEntity);
            billDetailEntity.setCreateDate(new Date());
            billDetailEntity.setBill_id(billEntity);

            billDetailService.save(billDetailEntity);

        }
        billEntity.setTotalMoney(totalPrice);
        billEntity.setUserEntity(entity);
        billEntity.setCreateDate(new Date());

        System.out.println("BILLLLL   " + billEntity.getTotalMoney());
        billService.save(billEntity);


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
            double totalPrice = GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum();

            User user = (User) ((Authentication) principal).getPrincipal();
            UserEntity entity = userService.findByEmail(user.getUsername());
            BillEntity billEntity = billService.findByUserEntityAndPrice(entity, totalPrice);

            redirAttrs.addFlashAttribute("success", "Everything went just fine.");

            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                billEntity.setChecked(true);
                userService.save(entity);

                GlobalDataCart.dataCarts.clear();


                return "successPayPal";
            }

        } catch (PayPalRESTException exception) {
            System.out.println(exception.getMessage());
        }

        return "redirect:/paypal";
    }


}
