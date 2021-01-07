package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

/**
 *
 * @author ochoaa
 */
@RelationshipEntity
public class PatientToSampleEntity implements Serializable {
    @Id @GeneratedValue
    private Long id;
    @StartNode
    private PatientMetadata patient;
    @EndNode
    private SampleManifestEntity sampleMetadata;

    public PatientToSampleEntity() {}

    public PatientMetadata getPatient() {
        return patient;
    }

    public void setPatient(PatientMetadata patient) {
        this.patient = patient;
    }

    public SampleManifestEntity getSampleMetadata() {
        return sampleMetadata;
    }

    public void setSampleMetadata(SampleManifestEntity sampleMetadata) {
        this.sampleMetadata = sampleMetadata;
    }

}
