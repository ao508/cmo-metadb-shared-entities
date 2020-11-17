package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
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
    private String linkedPatientName;
    private String linkedSystemName;
    @Relationship(type="PX_TO_PX", direction=Direction.OUTGOING)
    private PatientMetadata patientMetadata;

    public Patient() {}

    public Patient(String linkedPatientName, String linkedSystemName) {
        this.linkedPatientName = linkedPatientName;
        this.linkedSystemName = linkedSystemName;
    }

    public String getLinkedPatientName() {
        return linkedPatientName;
    }

    public void setLinkedPatientName(String linkedPatientName) {
        this.linkedPatientName = linkedPatientName;
    }

    public String getLinkedSystemName() {
        return linkedSystemName;
    }

    public void setLinkedSystemName(String linkedSystemName) {
        this.linkedSystemName = linkedSystemName;
    }

    public PatientMetadata getPatientMetadata() {
        return patientMetadata;
    }

    public void setPatientMetadata(PatientMetadata patientMetadata) {
        this.patientMetadata = patientMetadata;
    }

}
