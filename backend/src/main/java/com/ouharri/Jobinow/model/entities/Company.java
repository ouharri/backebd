package com.ouharri.Jobinow.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

/**
 * Represents a company entity in the system.
 * This class includes information about a company such as its name, email, phone number, image URL,
 * address, recruiters, and manager.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 * @version 1.0
 */
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Company extends AbstractEntity {

    /**
     * The name of the company.
     */
    @NotBlank(message = "Company name cannot be blank")
    private String name;

    /**
     * The email address of the company.
     */
    @Email(message = "Email address must be valid")
    private String email;

    /**
     * The phone number of the company.
     */
    @Pattern(regexp = "\\d{10}", message = "Phone number must have exactly 10 digits")
    private String phoneNumber;

    /**
     * The URL to the company's image.
     */
    @URL(message = "Image URL must be valid")
    private String imageUrl;

    /**
     * The address of the company.
     */
    @Embedded
    private Address address = new Address();

    /**
     * The list of recruiters associated with the company.
     */
    @OneToMany(
            mappedBy = "recruitedCompanies",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "recruiter_company",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> recruiters;

    /**
     * The manager associated with the company.
     */
    @OneToOne(
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private User manager;
}