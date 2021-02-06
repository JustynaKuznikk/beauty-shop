package projects.beauty.shop.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "password")
@EqualsAndHashCode(of="username")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    private Boolean isActive = Boolean.FALSE;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();
}
