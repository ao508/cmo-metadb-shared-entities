package org.mskcc.cmo.shared.neo4j;

import java.io.Serializable;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;
/**
 * Node entity representing the linked sample entity from an external system.
 * @author ochoaa
 */
@Node("sample")
public class Sample implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String linkedSampleName;
    private String linkedSystemName;
    @Relationship(type="SP_TO_SP", direction=Direction.OUTGOING)
    private SampleMetadataEntity sampleMetadata;

    public Sample() {}

    public Sample(String linkedSampleName, String linkedSystemName) {
        this.linkedSampleName = linkedSampleName;
        this.linkedSystemName = linkedSystemName;
    }

    public String getLinkedSampleName() {
        return linkedSampleName;
    }

    public void setLinkedSampleName(String linkedSampleName) {
        this.linkedSampleName = linkedSampleName;
    }

    public String getLinkedSystemName() {
        return linkedSystemName;
    }

    public void setLinkedSystemName(String linkedSystemName) {
        this.linkedSystemName = linkedSystemName;
    }

    public SampleMetadataEntity getSampleMetadata() {
        return sampleMetadata;
    }

    public void setSampleMetadata(SampleMetadataEntity sampleMetadata) {
        this.sampleMetadata = sampleMetadata;
    }

}
