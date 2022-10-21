package com.webservicepizzariazeff.www.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

class PurchaseTest {

    private Purchase purchase;

    private static User user;

    private static Address address;

    private static List<PurchasedProduct> purchasedProducts;

    @BeforeAll
    static void setObjects() {

        user = User.UserBuilder.builder()
                .id(1L)
                .name("name")
                .username("username")
                .password("password")
                .authorities("ROLE_USER")
                .build();

        address = Address.AddressBuilder.builder()
                .id(1L)
                .user(user)
                .number("1")
                .road("road")
                .district("district")
                .city("city")
                .state("state")
                .build();

        purchasedProducts = List.of(
                PurchasedProduct.PurchasedProductBuilder.builder()
                        .id(1L)
                        .name("name1")
                        .purchase(Purchase.PurchaseBuilder.builder().id(1L).build())
                        .build(),
                PurchasedProduct.PurchasedProductBuilder.builder()
                        .id(2L)
                        .name("name2")
                        .purchase(Purchase.PurchaseBuilder.builder().id(1L).build())
                        .build(),
                PurchasedProduct.PurchasedProductBuilder.builder()
                        .id(3L)
                        .name("name3")
                        .purchase(Purchase.PurchaseBuilder.builder().id(1L).build())
                        .build()
        );
    }

    @BeforeEach
    void setPurchase() {

        this.purchase = Purchase.PurchaseBuilder.builder()
                .id(1L)
                .amount(new BigDecimal("1.0"))
                .dateAndTime("12/34/5678T12:34")
                .cardName("cardName")
                .isActive(true)
                .isFinished(true)
                .isDelivered(true)
                .isPaymentThroughTheWebsite(true)
                .user(user)
                .address(address)
                .purchasedProducts(purchasedProducts)
                .build();
    }

    @Test
    void getId() {

        Assertions.assertThat(this.purchase.getId())
                .isEqualTo(1L);
    }

    @Test
    void getAmount() {

        Assertions.assertThat(this.purchase.getAmount())
                .isEqualTo(new BigDecimal("1.0"));
    }

    @Test
    void getDateAndTime() {

        Assertions.assertThat(this.purchase.getDateAndTime())
                .isEqualTo("12/34/5678T12:34");
    }

    @Test
    void getCardName() {

        Assertions.assertThat(this.purchase.getCardName())
                .isEqualTo("cardName");
    }

    @Test
    void isActive() {

        Assertions.assertThat(this.purchase.isActive())
                .isTrue();
    }

    @Test
    void isFinished() {

        Assertions.assertThat(this.purchase.isFinished())
                .isTrue();
    }

    @Test
    void isDelivered() {

        Assertions.assertThat(this.purchase.isDelivered())
                .isTrue();
    }

    @Test
    void isPaymentThroughTheWebsite() {

        Assertions.assertThat(this.purchase.isPaymentThroughTheWebsite())
                .isTrue();
    }

    @Test
    void getUser() {

        Assertions.assertThat(this.purchase.getUser())
                .isEqualTo(user);
    }

    @Test
    void getAddress() {

        Assertions.assertThat(this.purchase.getAddress())
                .isEqualTo(address);
    }

    @Test
    void getPurchasedProducts() {

        Assertions.assertThat(this.purchase.getPurchasedProducts())
                .isEqualTo(purchasedProducts);
    }

    @Test
    void prePersist() {

        Purchase purchase2 = Purchase.PurchaseBuilder.builder().build();

        purchase2.prePersist();

        Assertions.assertThat(purchase2.isActive())
                .isTrue();

        Assertions.assertThat(purchase2.isFinished())
                .isFalse();

        Assertions.assertThat(purchase2.isDelivered())
                .isFalse();

        Assertions.assertThat(purchase2.getDateAndTime())
                .isEqualTo(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm")));
    }
}