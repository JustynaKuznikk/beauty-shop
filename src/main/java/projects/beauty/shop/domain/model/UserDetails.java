package projects.beauty.shop.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "password")
@EqualsAndHashCode(of="username")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private String street;
    private String postcode;
    private String firstName;
    private String lastName;
    private Integer homeNumber;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;
    @Column(insertable = false, updatable = false, name = "user_id")
    private Long userId;

}
