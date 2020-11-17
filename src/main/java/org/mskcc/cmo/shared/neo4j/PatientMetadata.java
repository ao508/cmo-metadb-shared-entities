package org.mskcc.cmo.shared.neo4j;

import org.mskcc.cmo.shared.neo4j.SampleMetadataEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

/**
 *
 * @author ochoaa
 */
@Node("cmo_metadb_patient_metadata")
public class PatientMetadata implements Serializable {
    @Id @GeneratedValue(UUIDStringGenerator.class)
    private UUID metaDbUuid;
    private String investigatorPatientId;
    @Relationship(type="PX_TO_SP", direction=Direction.OUTGOING)
    private List<SampleMetadataEntity> sampleMetadataList;
    @Relationship(type="PX_TO_PX", direction=Direction.INCOMING)
    private List<Patient>  linkedPatientList;

    public PatientMetadata() {}

    public UUID getMetaDbUuid() {
        return metaDbUuid;
    }

    public void setMetaDbUuid(UUID metaDbUuid) {
        this.metaDbUuid = metaDbUuid;
    }

    public String getInvestigatorPatientId() {
        return investigatorPatientId;
    }

    public void setInvestigatorPatientId(String investigatorPatientId) {
        this.investigatorPatientId = investigatorPatientId;
    }

    public List<SampleMetadataEntity> getSampleMetadataList() {
        return sampleMetadataList;
    }

    public void setSampleMetadataList(List<SampleMetadataEntity> sampleMetadataList) {
        this.sampleMetadataList = sampleMetadataList;
    }

    public void linkSampleMetadata(SampleMetadataEntity sampleMetadata) {
        if (sampleMetadataList == null) {
            sampleMetadataList = new ArrayList<>();
        }
        sampleMetadataList.add(sampleMetadata);
    }

    public List<Patient> getLinkedPatientList() {
        return linkedPatientList;
    }

    public void setLinkedPatientList(List<Patient> linkedPatientList) {
        this.linkedPatientList = linkedPatientList;
    }

    public void linkPatient(Patient linkedPatient) {
        if (linkedPatientList == null) {
            linkedPatientList = new ArrayList<>();
        }
        linkedPatientList.add(linkedPatient);
    }

}
