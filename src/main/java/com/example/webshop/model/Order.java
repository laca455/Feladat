package com.example.webshop.model;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // A megrendelő
    @ManyToOne
    private User user;

    // A rendelésben szereplő tételek
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    // Fizetési módok, szállítási módok
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private ShippingMethod shippingMethod;

    // Szállítási költségek
    private double shippingCost;

    // Rendelés státusz
    private String status; // Kiszálításra vár esetleg Feldolgozás alatt van

    // Leadott megrendelés dátuma
    private LocalDateTime orderDate;
