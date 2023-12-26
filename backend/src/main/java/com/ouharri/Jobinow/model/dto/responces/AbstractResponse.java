package com.ouharri.Jobinow.model.dto.responces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ouharri.Jobinow.model.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * DTO for {@link AbstractEntity}
 * @author <a href="mailto:ouharri.outman@gmail.com">ouharri</a>
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractResponse implements _Response {
    UUID id;
    Timestamp createdAt;
    Timestamp updatedAt;
    Long version;
}