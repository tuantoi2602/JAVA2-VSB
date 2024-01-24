package project.java2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter 
@Setter // lombok
@NoArgsConstructor // lombok
@AllArgsConstructor // lombok
@Builder // lombok
@Entity // persistence
@Table(name = "products") // persistence
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;

}