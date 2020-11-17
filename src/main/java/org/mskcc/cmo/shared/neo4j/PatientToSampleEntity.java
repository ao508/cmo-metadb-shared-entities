package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import java.util.Collection;
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

public class PatientToSampleEntity implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private Collection<UUID> sampleUuidList;
//    @StartNode
    private PatientMetadata patient;
//    @EndNode
    private SampleMetadataEntity sampleMetadata;

    public PatientToSampleEntity() {}

    public Collection<UUID> getSampleUuidList() {
        return sampleUuidList;
    }

    public void setSampleUuidList(Collection<UUID> sampleUuidList) {
        this.sampleUuidList = sampleUuidList;
    }

    public PatientMetadata getPatient() {
        return patient;
    }

    public void setPatient(PatientMetadata patient) {
        this.patient = patient;
    }

    public SampleMetadataEntity getSampleMetadata() {
        return sampleMetadata;
    }

    public void setSampleMetadata(SampleMetadataEntity sampleMetadata) {
        this.sampleMetadata = sampleMetadata;
    }

}
