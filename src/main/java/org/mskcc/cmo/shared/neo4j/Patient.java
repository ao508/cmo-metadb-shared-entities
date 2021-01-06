package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

/**
 *
 * @author ochoaa
 */

@Node("patient")
public class Patient implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @Property("value")
    private String patientId;
    private String idSource;
    @Relationship(type = "PX_TO_PX", direction = Direction.OUTGOING)
    private PatientMetadata patientMetadata;

    public Patient() {}

    public Patient(String patientId, String idSource) {
        this.patientId = patientId;
        this.idSource = idSource;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getIdSource() {
        return idSource;
    }

    public void setIdSource(String idSource) {
        this.idSource = idSource;
    }

    public PatientMetadata getPatientMetadata() {
        return patientMetadata;
    }

    public void setPatientMetadata(PatientMetadata patientMetadata) {
        this.patientMetadata = patientMetadata;
    }

}
