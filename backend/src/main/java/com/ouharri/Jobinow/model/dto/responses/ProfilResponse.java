package com.ouharri.Jobinow.model.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ouharri.Jobinow.model.entities.Offre;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * DTO for representing a response related to {@link Offre}.
 * This DTO includes information such as the job title, description, location, degree, salary, status,
 * associated profiles, associated company, associated tags, and common response fields.
 *
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfilResponse extends AbstractResponse {
    @NotBlank(message = "Profile title cannot be blank")
    String title;

    String description;
}