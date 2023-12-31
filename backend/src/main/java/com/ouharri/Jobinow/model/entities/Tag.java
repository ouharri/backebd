package com.ouharri.Jobinow.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a tag entity in the system.
 * This class includes information about a tag such as its title, description, and associated job offers.
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
public class Tag extends AbstractEntity {

    /**
     * The title of the tag.
     */
    @NotBlank(message = "Tag title cannot be blank")
    private String title;

    /**
     * The description of the tag.
     */
    private String description;

    /**
     * The list of job offers associated with the tag.
     */
    @ManyToMany(
            targetEntity = Offre.class,
            mappedBy = "tags"
    )
    private List<Offre> offres = new ArrayList<>();
}